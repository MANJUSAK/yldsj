package com.goodsoft.yuanlin.service.lmpl;

import com.goodsoft.yuanlin.domain.dao.FileDao;
import com.goodsoft.yuanlin.domain.dao.UserDao;
import com.goodsoft.yuanlin.domain.entity.user.Corporation;
import com.goodsoft.yuanlin.domain.entity.user.Employees;
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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * function 用户管理业务接口实现类
 * Created by 严彬荣 on 2017/8/10.
 * version v1.0
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
     * @param request  http请求,
     * @param userName 用户名
     * @param passWord 密码
     * @param userCode 用户验证码
     * @return 用户授权结果
     * @throws Exception
     */
    @Override
    public <T> T queryUserService(HttpServletRequest request, String userName, String passWord, String userCode) {
        //判断请求为PC端还是app端 start
        switch (userCode) {
            case "noUserCode":
                break;
            default:
                //获取系统验证码
                String pcCode = (String) request.getSession().getAttribute("pcCode");
                //匹配用户验证码
                if (pcCode == null || !pcCode.equals(userCode)) {
                    return (T) new Status(StatusEnum.CHECKCODE.getCODE(), StatusEnum.CHECKCODE.getEXPLAIN());
                }
                break;
        }
        //判断请求为PC端还是app端 end
        //密码解密
        String pwd = DESEDE.encryptIt(passWord);
        //匹配用户信息
        User userInfo = null;
        try {
            userInfo = this.dao.queryUserDao(userName, pwd);
        } catch (Exception e) {
            System.out.println(e.toString());
            this.logger.error(e);
            return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }
        if (userInfo != null) {
            //用户登录成功后清除该用户验证码
            request.getSession().removeAttribute("pcCode");
            return (T) new Result(0, userInfo);
        } else {
            return (T) new Status(StatusEnum.CHECKUSER.getCODE(), StatusEnum.CHECKUSER.getEXPLAIN());
        }
    }

    /**
     * 查询用户签到数据业务接口方法
     *
     * @param uid  用户编号，
     * @param dept 企业，
     * @param page 页数。
     * @return 查询结果
     * @throws Exception
     */
    @Override
    public <T> T querySignInService(String uid, String dept, String dep, String comp, String page, String lev) {
        if (page == null || "".equals(page)) {
            return (T) new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
        }
        //如果未获取到用户则获取部门信息 start
        if (uid == null || "".equals(uid)) {
            //获取部门信息及部门等级
            if (dept == null || "".equals(dept) || comp == null || "".equals(comp) || lev == null || "".equals(lev)) {
                return (T) new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
            }
        }
        //如果未获取到用户则获取部门信息 end
        //将page转换为int start
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
        //将page转换为int start
        try {
            //获取用户权限（具有管理员权限查看企业数据）
            if (dept != null && !("".equals(dept))) {
                int v = 10;
                if (lev != null && !("".equals(lev))) {
                    try {
                        v = Integer.parseInt(lev);
                    } catch (NumberFormatException e) {
                        this.logger.error(e);
                        return (T) new Status(StatusEnum.NO_PRAM.getCODE(), StatusEnum.NO_PRAM.getEXPLAIN());
                    }
                } else {
                    return (T) new Status(StatusEnum.NO_PRAM.getCODE(), StatusEnum.NO_PRAM.getEXPLAIN());
                }
                //人事部可查处数据
                if (!("人事部".equals(dept)) && v > 2 || v < 2) {
                    return (T) new Status(StatusEnum.NO_RIGHTS.getCODE(), StatusEnum.NO_RIGHTS.getEXPLAIN());
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            this.logger.error(e);
            return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }
        List<SignIn> data = null;
        try {
            data = this.dao.querySignInDao(uid, dep, comp, arg);
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
     * 人才库数据查询
     *
     * @param tp   查询类型（法人库等）
     * @param page 页码
     * @param <T>  泛型
     * @return 查询结果
     * @throws Exception
     */
    @Override
    public <T> T queryTalentPoolService(String tp, String page) {
        if (page == null || "".equals(page)) {
            return (T) new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
        }
        //将page转换为int start
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
        //将page转换为int start
        //根据类型查询数据 start
        switch (tp) {
            //查询法人库数据 start
            case "frk":
                List<Corporation> cor = null;
                try {
                    cor = this.dao.queryCorporationDao(arg);
                } catch (Exception e) {
                    System.out.println(e.toString());
                    this.logger.error(e);
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                if (cor.size() > 0) {
                    return (T) new Result(0, cor);
                }
                return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
            //查询法人库数据 end
            //查询从业人员库数据 start
            case "cyryk":
                List<Employees> emp = null;
                try {
                    emp = this.dao.queryEmployeesDao(arg);
                } catch (Exception e) {
                    System.out.println(e.toString());
                    this.logger.error(e);
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                if (emp.size() > 0) {
                    return (T) new Result(0, emp);
                }
                return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
            //查询从业人员库数据 start
            default:
                return (T) new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
        }
        //根据类型添加数据 start
    }

    /**
     * 用户签到业务方法
     *
     * @param msg 签到信息
     * @return 签到结果
     * @throws Exception
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
}
