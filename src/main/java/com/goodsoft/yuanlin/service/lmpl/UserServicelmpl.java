package com.goodsoft.yuanlin.service.lmpl;

import com.goodsoft.yuanlin.domain.dao.FileDao;
import com.goodsoft.yuanlin.domain.dao.UserDao;
import com.goodsoft.yuanlin.domain.entity.file.FileData;
import com.goodsoft.yuanlin.domain.entity.user.User;
import com.goodsoft.yuanlin.service.FileService;
import com.goodsoft.yuanlin.service.UserService;
import com.goodsoft.yuanlin.util.DomainNameUtil;
import com.goodsoft.yuanlin.util.UUIDUtil;
import com.goodsoft.yuanlin.util.resultentity.Result;
import com.goodsoft.yuanlin.util.resultentity.Status;
import com.goodsoft.yuanlin.util.resultentity.StatusEnum;
import com.horizon.util.encrypt.DESEDE;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * function 用户管理业务接口实现类
 * Created by 严彬荣 on 2017/8/10.
 */
@SuppressWarnings("ALL")
@Service
public class UserServicelmpl implements UserService {

    @Resource
    private UserDao dao;
    @Resource
    private FileDao fileDao;
    @Resource
    private FileService fileService;
    //实例化服务器域名地址工具类
    private DomainNameUtil domainName = DomainNameUtil.getInstance();
    //实例化UUID工具类
    private UUIDUtil uuid = UUIDUtil.getInstance();
    //实例化日志管理
    private Logger logger = Logger.getLogger(UserServicelmpl.class);

    @Override
    public <T> T queryUserService(HttpServletRequest request, String userName, String passWord, String userCode) {
        //获取系统验证码
        List<String> pcCode = (List<String>) request.getSession().getAttribute("pcCode");
        //匹配用户验证码
        if (pcCode == null || !pcCode.contains(userCode)) {
            return (T) new Status(StatusEnum.CHECKCODE.getCODE(), StatusEnum.CHECKCODE.getEXPLAIN());
        }
        //密码解密
        String pwd = DESEDE.encryptIt(passWord);
        //匹配用户信息
        User userInfo = null;
        try {
            userInfo = this.dao.queryUserDao(userName, pwd);
        } catch (Exception e) {
            System.out.println(e.toString());
            this.logger.error(e);

        }
        if (userInfo != null) {
            //获取用户文件
            List<FileData> path = null;
            try {
                path = this.fileDao.queryFileDao(userInfo.getFilesId());
                if (path.size() > 0) {
                    //获取服务器域名
                    String url = this.domainName.getServerDomainName(request).toString();
                    List<String> var = new ArrayList<String>();
                    for (int i = 0, length = path.size(); i < length; ++i) {
                        var.add(url + path.get(i).getPath());
                    }
                    //封装用户文件到用户信息
                    userInfo.setPicture(var);
                }
            } catch (Exception e) {
                System.out.println(e.toString());
                this.logger.error(e);
                return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
            }
            return (T) new Result(0, userInfo);
        } else {
            return (T) new Status(StatusEnum.CHECKUSER.getCODE(), StatusEnum.CHECKUSER.getEXPLAIN());
        }
    }

    @Override
    @Transactional
    public Status addUserService(MultipartFile[] files, HttpServletRequest request, User msg, String userCode) {
        //获取系统验证码
        List<String> pcCode = (List<String>) request.getSession().getAttribute("pcCode");
        //匹配用户验证码
        if (pcCode == null || !pcCode.contains(userCode)) {
            return new Status(StatusEnum.CHECKCODE.getCODE(), StatusEnum.CHECKCODE.getEXPLAIN());
        }
        try {
            int num = this.dao.queryUserByNameDao(msg.getUserName());
            if (num > 0) {
                return new Status(StatusEnum.USERNAME.getCODE(), StatusEnum.USERNAME.getEXPLAIN());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            this.logger.error(e);
            return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }
        msg.setFilesId(this.uuid.getUUID().toString());
        int arg = this.fileService.fileUploadService(files, request, "user", msg.getFilesId());
        switch (arg) {
            case 604:
                return new Status(StatusEnum.NO_FILE.getCODE(), StatusEnum.NO_FILE.getEXPLAIN());
            case 603:
                return new Status(StatusEnum.FILE_FORMAT.getCODE(), StatusEnum.FILE_FORMAT.getEXPLAIN());
            case 601:
                return new Status(StatusEnum.FILE_SIZE.getCODE(), StatusEnum.FILE_SIZE.getEXPLAIN());
            case 600:
                return new Status(StatusEnum.FILE_UPLOAD.getCODE(), StatusEnum.FILE_UPLOAD.getEXPLAIN());
        }
        try {
            String deptId = this.dao.queryDeptByIdDao(msg.getCompanyName());
            msg.setDeptId(deptId);
            msg.setUid(this.uuid.getUUID().toString());
            msg.setPassWord(DESEDE.encryptIt(msg.getPassWord()));
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            msg.setDate(date);
            this.dao.addUserDao(msg);
            this.dao.addDeptDao(this.uuid.getUUID().toString(), msg.getUid(), deptId, date);
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        } catch (Exception e) {
            System.out.println(e.toString());
            this.logger.error(e);
            return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }
    }
}
