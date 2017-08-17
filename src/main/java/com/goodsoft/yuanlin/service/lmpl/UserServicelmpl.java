package com.goodsoft.yuanlin.service.lmpl;

import com.goodsoft.yuanlin.domain.dao.FileDao;
import com.goodsoft.yuanlin.domain.dao.UserDao;
import com.goodsoft.yuanlin.domain.entity.file.FileData;
import com.goodsoft.yuanlin.domain.entity.user.SignIn;
import com.goodsoft.yuanlin.domain.entity.user.User;
import com.goodsoft.yuanlin.service.FileService;
import com.goodsoft.yuanlin.service.UserService;
import com.goodsoft.yuanlin.util.AuthCodeUtil;
import com.goodsoft.yuanlin.util.DomainNameUtil;
import com.goodsoft.yuanlin.util.GetIP;
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
    //实例化获取用户ip工具类
    private GetIP getIP = GetIP.getInstance();
    //实例化验证码工具类
    private AuthCodeUtil authCode = AuthCodeUtil.getInstance();

    /**
     * 用户授权业务实现方法
     *
     * @param request http请求,
     *                userName 用户名
     *                passWord 密码
     *                userCode 用户验证码
     * @return 用户授权结果
     */
    @Override
    public <T> T queryUserService(HttpServletRequest request, String userName, String passWord, String userCode) {
        //获取用户验证码所产生的ip
        String ip = this.getIP.getIP(request);
        //匹配用户验证码
        if (ip == null || this.authCode.map.get(ip) == null || !(this.authCode.map.get(ip).equals(userCode))) {
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
                if ("".equals(userInfo.getDeptId())) {
                    userInfo.setDeptId(this.dao.queryDeptIdByUidDao(userInfo.getUid()));
                }
            } catch (Exception e) {
                System.out.println(e.toString());
                this.logger.error(e);
                return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
            }
            //用户登录成功后清除该用户验证码
            this.authCode.map.remove(ip);
            return (T) new Result(0, userInfo);
        } else {
            return (T) new Status(StatusEnum.CHECKUSER.getCODE(), StatusEnum.CHECKUSER.getEXPLAIN());
        }
    }

    /**
     * 查询用户签到数据业务接口方法
     *
     * @param uid 用户编号，
     *            deptId 企业id，
     *            page 页数。
     * @return 查询结果
     */
    @Override
    public <T> T querySignInService(String uid, String deptId, String page) {
        if (page == null) {
            return (T) new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
        }
        if (uid == null || "".equals(uid)) {
            if (deptId == null || "".equals(deptId)) {
                return (T) new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
            }
        }
        int arg = 0;
        try {
            arg = Integer.parseInt(page);
        } catch (NumberFormatException e) {
            this.logger.error(e);
            return (T) new Status(StatusEnum.NO_PRAM.getCODE(), StatusEnum.NO_PRAM.getEXPLAIN());
        }
        if (arg < 0) {
            arg = 0;
        }
        arg *= 20;
        try {
            //获取用户权限（具有管理员权限查看企业数据）
            if (deptId != null && !("".equals(deptId))) {
                String str = this.dao.queryDeptLevelByIdDao(deptId);
                if (str == null) {
                    return (T) new Status(StatusEnum.NO_RIGHTS.getCODE(), StatusEnum.NO_RIGHTS.getEXPLAIN());
                } else {
                    int var = Integer.parseInt(str);
                    if (var > 2) {
                        return (T) new Status(StatusEnum.NO_RIGHTS.getCODE(), StatusEnum.NO_RIGHTS.getEXPLAIN());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            this.logger.error(e);
            return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }
        List<SignIn> data = null;
        try {
            data = this.dao.querySignInDao(uid, deptId, arg);
        } catch (Exception e) {
            System.out.println(e.toString());
            this.logger.error(e);
            return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }
        if (data.size() > 0) {
            return (T) new Result(0, data);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 用户签到业务方法
     *
     * @param msg 签到信息
     * @return 签到结果
     */
    @Override
    public Status signInService(SignIn msg) {
        try {
            msg.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
            this.dao.signInDao(msg);
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        } catch (Exception e) {
            System.out.println(e.toString());
            this.logger.error(e);
            return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }
    }


    /**
     * 增加用户业务实现方法
     *
     * @param request http请求,
     *                msg 用户信息
     *                files 用户文件
     *                userCode 用户验证码
     * @return 增加用户结果
     */
    @Override
    @Transactional
    public Status addUserService(MultipartFile[] files, HttpServletRequest request, User msg, String userCode) {
        //获取用户验证码所产生的ip
        String ip = this.getIP.getIP(request);
        //匹配用户验证码
        if (ip == null || this.authCode.map.get(ip) == null || !(this.authCode.map.get(ip).equals(userCode))) {
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
            String deptId = this.dao.queryDeptByNameDao(msg.getCompanyName());
            msg.setDeptId(deptId);
            msg.setUid(this.uuid.getUUID().toString());
            msg.setPassWord(DESEDE.encryptIt(msg.getPassWord()));
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            msg.setDate(date);
            this.dao.addUserDao(msg);
            this.dao.addDeptDao(this.uuid.getUUID().toString(), msg.getUid(), deptId, date);
            //增加用户成功后清除该用户验证码
            this.authCode.map.remove(ip);
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        } catch (Exception e) {
            System.out.println(e.toString());
            this.logger.error(e);
            return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }
    }
}
