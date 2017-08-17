package com.goodsoft.yuanlin.service.lmpl;

import com.goodsoft.yuanlin.domain.dao.FileDao;
import com.goodsoft.yuanlin.domain.dao.ProjectManageDao;
import com.goodsoft.yuanlin.domain.dao.UserDao;
import com.goodsoft.yuanlin.domain.entity.file.FileData;
import com.goodsoft.yuanlin.domain.entity.project.*;
import com.goodsoft.yuanlin.service.FileService;
import com.goodsoft.yuanlin.service.ProjectManageService;
import com.goodsoft.yuanlin.util.DomainNameUtil;
import com.goodsoft.yuanlin.util.UUIDUtil;
import com.goodsoft.yuanlin.util.resultentity.Result;
import com.goodsoft.yuanlin.util.resultentity.Status;
import com.goodsoft.yuanlin.util.resultentity.StatusEnum;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * function 项目管理业务接口实现类
 * Created by 严彬荣 on 2017/8/15.
 */
@SuppressWarnings("ALL")
@Service
public class ProjectManageServicelmpl implements ProjectManageService {

    @Resource
    private ProjectManageDao dao;
    @Resource
    private FileService fileService;
    @Resource
    private FileDao fileDao;
    @Resource
    private UserDao userDao;
    //实例化服务器域名工具类
    private DomainNameUtil domainName = DomainNameUtil.getInstance();
    //实例化日志管理工具类
    private Logger logger = Logger.getLogger(RecomCompServicelmpl.class);
    //实例化UUID工具类
    private UUIDUtil uuid = UUIDUtil.getInstance();

    @Override
    public <T> T queryProjectDataService(HttpServletRequest request, String deptId, String uid, String type, String page) {
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
                String str = this.userDao.queryDeptLevelByIdDao(deptId);
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
        switch (type) {
            //项目信息
            case "xmxx":
                List<Project> pro = null;
                try {
                    pro = this.dao.queryProjectDao(uid, deptId, arg);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                if (pro.size() > 0) {
                    return (T) new Result(0, pro);
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
                //变更管理
            case "bggl":
                List<Alteration> al = null;
                try {
                    al = this.dao.queryAlterationDao(uid, deptId, arg);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                int s = al.size();
                if (s > 0) {
                    String http = this.domainName.getServerDomainName(request).toString();
                    for (int i = 0; i < s; ++i) {
                        List<String> url = new ArrayList<String>();
                        List<FileData> path = null;
                        try {
                            path = this.fileDao.queryFileDao(al.get(i).getFilesId());
                            int p = path.size();
                            if (p > 0) {
                                for (int j = 0; j < p; ++j) {
                                    url.add(http + path.get(j).getPath());
                                }
                                al.get(i).setPicture(url);
                            }
                        } catch (Exception e) {
                            this.logger.error(e);
                            System.out.println(e.toString());
                        }
                    }
                    return (T) new Result(0, al);
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
                //工序报验
            case "gxby":
                List<Checkout> ch = null;
                try {
                    ch = this.dao.queryCheckoutDao(uid, deptId, arg);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                int c = ch.size();
                if (c > 0) {
                    String http = this.domainName.getServerDomainName(request).toString();
                    for (int i = 0; i < c; ++i) {
                        List<String> url = new ArrayList<String>();
                        List<FileData> path = null;
                        try {
                            path = this.fileDao.queryFileDao(ch.get(i).getFilesId());
                            int p = path.size();
                            if (p > 0) {
                                for (int j = 0; j < p; ++j) {
                                    url.add(http + path.get(j).getPath());
                                }
                                ch.get(i).setPicture(url);
                            }
                        } catch (Exception e) {
                            this.logger.error(e);
                            System.out.println(e.toString());
                        }
                    }
                    return (T) new Result(0, ch);
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
                //施工日志
            case "sgrz":
                List<ConsLog> con = null;
                try {
                    con = this.dao.queryConsLogDao(uid, deptId, arg);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                if (con.size() > 0) {
                    return (T) new Result(0, con);
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
                //施工安全日志
            case "sgaqrz":
                List<ConsSafetyLog> consa = null;
                try {
                    consa = this.dao.queryConsSafetyLogDao(uid, deptId, arg);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                if (consa.size() > 0) {
                    return (T) new Result(0, consa);
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
                //进度申报
            case "jdsb":
                List<Declaration> dec = null;
                try {
                    dec = this.dao.queryDeclarationDao(uid, deptId, arg);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                int d = dec.size();
                if (d > 0) {
                    String http = this.domainName.getServerDomainName(request).toString();
                    for (int i = 0; i < d; ++i) {
                        List<String> url = new ArrayList<String>();
                        List<FileData> path = null;
                        try {
                            path = this.fileDao.queryFileDao(dec.get(i).getFilesId());
                            int p = path.size();
                            if (p > 0) {
                                for (int j = 0; j < p; ++j) {
                                    url.add(http + path.get(j).getPath());
                                }
                                dec.get(i).setPicture(url);
                            }
                        } catch (Exception e) {
                            this.logger.error(e);
                            System.out.println(e.toString());
                        }
                    }
                    return (T) new Result(0, dec);
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
                //设备信息
            case "sbxx":
                List<Equipment> eq = null;
                try {
                    eq = this.dao.queryEquipmentDao(uid, deptId, arg);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                if (eq.size() > 0) {
                    return (T) new Result(0, eq);
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
                //竣工验收
            case "jgys":
                List<Finalaccept> fin = null;
                try {
                    fin = this.dao.queryFinalacceptDao(uid, deptId, arg);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                int f = fin.size();
                if (f > 0) {
                    String http = this.domainName.getServerDomainName(request).toString();
                    for (int i = 0; i < f; ++i) {
                        List<String> url = new ArrayList<String>();
                        List<FileData> path = null;
                        try {
                            path = this.fileDao.queryFileDao(fin.get(i).getFilesId());
                            int p = path.size();
                            if (p > 0) {
                                for (int j = 0; j < p; ++j) {
                                    url.add(http + path.get(j).getPath());
                                }
                                fin.get(i).setPicture(url);
                            }
                        } catch (Exception e) {
                            this.logger.error(e);
                            System.out.println(e.toString());
                        }
                    }
                    return (T) new Result(0, fin);
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
                //会审结果
            case "hsjg":
                List<HsResult> hs = null;
                try {
                    hs = this.dao.queryHsResultDao(uid, deptId, arg);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                int h = hs.size();
                if (h > 0) {
                    String http = this.domainName.getServerDomainName(request).toString();
                    for (int i = 0; i < h; ++i) {
                        List<String> url = new ArrayList<String>();
                        List<FileData> path = null;
                        try {
                            path = this.fileDao.queryFileDao(hs.get(i).getFilesId());
                            int p = path.size();
                            if (p > 0) {
                                for (int j = 0; j < p; ++j) {
                                    url.add(http + path.get(j).getPath());
                                }
                                hs.get(i).setPicture(url);
                            }
                        } catch (Exception e) {
                            this.logger.error(e);
                            System.out.println(e.toString());
                        }
                    }
                    return (T) new Result(0, hs);
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
                //开工报告
            case "kgbg":
                List<KgReport> kg = null;
                try {
                    kg = this.dao.queryKgReportDao(uid, deptId, arg);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                int k = kg.size();
                if (k > 0) {
                    String http = this.domainName.getServerDomainName(request).toString();
                    for (int i = 0; i < k; ++i) {
                        List<FileData> path = null;
                        try {
                            path = this.fileDao.queryFileDao(kg.get(i).getFilesId());
                            int p = path.size();
                            if (p > 0) {
                                kg.get(i).setDocument(http + path.get(0).getPath());
                            }
                        } catch (Exception e) {
                            this.logger.error(e);
                            System.out.println(e.toString());
                        }
                    }
                    return (T) new Result(0, kg);
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
                //我的轨迹
            case "wdgj":
                List<Mylocus> my = null;
                try {
                    my = this.dao.queryMylocusDao(uid, deptId, arg);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                if (my.size() > 0) {
                    return (T) new Result(0, my);
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
                //现场勘察
            case "xckc":
                List<Prospect> pros = null;
                try {
                    pros = this.dao.queryProspectDao(uid, deptId, arg);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                int ps = pros.size();
                if (ps > 0) {
                    String http = this.domainName.getServerDomainName(request).toString();
                    for (int i = 0; i < ps; ++i) {
                        List<String> url = new ArrayList<String>();
                        List<FileData> path = null;
                        try {
                            path = this.fileDao.queryFileDao(pros.get(i).getFilesId());
                            int p = path.size();
                            if (p > 0) {
                                for (int j = 0; j < p; ++j) {
                                    url.add(http + path.get(j).getPath());
                                }
                                pros.get(i).setPicture(url);
                            }
                        } catch (Exception e) {
                            this.logger.error(e);
                            System.out.println(e.toString());
                        }
                    }
                    return (T) new Result(0, pros);
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
                //项目结算
            case "xmjs":
                List<Settlement> set = null;
                try {
                    set = this.dao.querySettlementDao(uid, deptId, arg);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                int se = set.size();
                if (se > 0) {
                    String http = this.domainName.getServerDomainName(request).toString();
                    for (int i = 0; i < se; ++i) {
                        List<String> url = new ArrayList<String>();
                        List<FileData> path = null;
                        try {
                            path = this.fileDao.queryFileDao(set.get(i).getFilesId());
                            int p = path.size();
                            if (p > 0) {
                                for (int j = 0; j < p; ++j) {
                                    url.add(http + path.get(j).getPath());
                                }
                                set.get(i).setPicture(url);
                            }
                        } catch (Exception e) {
                            this.logger.error(e);
                            System.out.println(e.toString());
                        }
                    }
                    return (T) new Result(0, set);
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
                //施工人员
            case "sgry":
                List<SgPersonnel> sgper = null;
                try {
                    sgper = this.dao.querySgPersonnelDao(uid, deptId, arg);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                if (sgper.size() > 0) {
                    return (T) new Result(0, sgper);
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
                //监理日志
            case "jlrz":
                List<Suplog> suplog = null;
                try {
                    suplog = this.dao.querySuplogDao(uid, deptId, arg);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                if (suplog.size() > 0) {
                    return (T) new Result(0, suplog);
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
                //供货商
            case "ghs":
                List<Supplier> sup = null;
                try {
                    sup = this.dao.querySupplierDao(uid, deptId, arg);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                int su = sup.size();
                if (su > 0) {
                    String http = this.domainName.getServerDomainName(request).toString();
                    for (int i = 0; i < su; ++i) {
                        List<String> url = new ArrayList<String>();
                        List<FileData> path = null;
                        try {
                            path = this.fileDao.queryFileDao(sup.get(i).getFilesId());
                            int p = path.size();
                            if (p > 0) {
                                for (int j = 0; j < p; ++j) {
                                    url.add(http + path.get(j).getPath());
                                }
                                sup.get(i).setPicture(url);
                            }
                        } catch (Exception e) {
                            this.logger.error(e);
                            System.out.println(e.toString());
                        }
                    }
                    return (T) new Result(0, sup);
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
                //技术交底
            case "jsjd":
                List<Technology> tec = null;
                try {
                    tec = this.dao.queryTechnologyDao(uid, deptId, arg);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                int te = tec.size();
                if (te > 0) {
                    String http = this.domainName.getServerDomainName(request).toString();
                    for (int i = 0; i < te; ++i) {
                        List<String> url = new ArrayList<String>();
                        List<FileData> path = null;
                        try {
                            path = this.fileDao.queryFileDao(tec.get(i).getFilesId());
                            int p = path.size();
                            if (p > 0) {
                                for (int j = 0; j < p; ++j) {
                                    url.add(http + path.get(j).getPath());
                                }
                                tec.get(i).setPicture(url);
                            }
                        } catch (Exception e) {
                            this.logger.error(e);
                            System.out.println(e.toString());
                        }
                    }
                    return (T) new Result(0, tec);
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
                //施工钱包
            case "sgqb":
                List<SgWallet> wa = null;
                try {
                    wa = this.dao.querySgWalletDao(uid, deptId, arg);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                if (wa.size() > 0) {
                    return (T) new Result(0, wa);
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
            default:
                return (T) new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
        }
    }

    @Override
    public Status addProjectDataService(HttpServletRequest request, MultipartFile[] files, Object msg, String type) {
        switch (type) {
            //变更管理
            case "bggl":
                Alteration al = (Alteration) msg;
                al.setFilesId(this.uuid.getUUID().toString());
                int al1 = this.fileService.fileUploadService(files, request, "project", al.getFilesId());
                switch (al1) {
                    case 604:
                        return new Status(StatusEnum.NO_FILE.getCODE(), StatusEnum.NO_FILE.getEXPLAIN());
                    case 603:
                        return new Status(StatusEnum.FILE_FORMAT.getCODE(), StatusEnum.FILE_FORMAT.getEXPLAIN());
                    case 601:
                        return new Status(StatusEnum.FILE_SIZE.getCODE(), StatusEnum.FILE_SIZE.getEXPLAIN());
                    case 600:
                        return new Status(StatusEnum.FILE_UPLOAD.getCODE(), StatusEnum.FILE_UPLOAD.getEXPLAIN());
                }
                al.setId(getUUID());
                al.setTime(getDate());
                try {
                    this.dao.addAlterationDao(al);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                //工序报验
            case "gxby":
                Checkout ch = (Checkout) msg;
                ch.setFilesId(this.uuid.getUUID().toString());
                int ch1 = this.fileService.fileUploadService(files, request, "project", ch.getFilesId());
                switch (ch1) {
                    case 604:
                        return new Status(StatusEnum.NO_FILE.getCODE(), StatusEnum.NO_FILE.getEXPLAIN());
                    case 603:
                        return new Status(StatusEnum.FILE_FORMAT.getCODE(), StatusEnum.FILE_FORMAT.getEXPLAIN());
                    case 601:
                        return new Status(StatusEnum.FILE_SIZE.getCODE(), StatusEnum.FILE_SIZE.getEXPLAIN());
                    case 600:
                        return new Status(StatusEnum.FILE_UPLOAD.getCODE(), StatusEnum.FILE_UPLOAD.getEXPLAIN());
                }
                ch.setDate(getDate());
                ch.setId(getUUID());
                try {
                    this.dao.addCheckoutDao(ch);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                //进度申报
            case "jdsb":
                Declaration dec = (Declaration) msg;
                dec.setFilesId(this.uuid.getUUID().toString());
                int dec1 = this.fileService.fileUploadService(files, request, "project", dec.getFilesId());
                switch (dec1) {
                    case 604:
                        return new Status(StatusEnum.NO_FILE.getCODE(), StatusEnum.NO_FILE.getEXPLAIN());
                    case 603:
                        return new Status(StatusEnum.FILE_FORMAT.getCODE(), StatusEnum.FILE_FORMAT.getEXPLAIN());
                    case 601:
                        return new Status(StatusEnum.FILE_SIZE.getCODE(), StatusEnum.FILE_SIZE.getEXPLAIN());
                    case 600:
                        return new Status(StatusEnum.FILE_UPLOAD.getCODE(), StatusEnum.FILE_UPLOAD.getEXPLAIN());
                }
                dec.setDate(getDate());
                dec.setId(getUUID());
                try {
                    this.dao.addDeclarationDao(dec);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                //竣工验收
            case "jgys":
                Finalaccept fin = (Finalaccept) msg;
                fin.setFilesId(this.uuid.getUUID().toString());
                int fin1 = this.fileService.fileUploadService(files, request, "project", fin.getFilesId());
                switch (fin1) {
                    case 604:
                        return new Status(StatusEnum.NO_FILE.getCODE(), StatusEnum.NO_FILE.getEXPLAIN());
                    case 603:
                        return new Status(StatusEnum.FILE_FORMAT.getCODE(), StatusEnum.FILE_FORMAT.getEXPLAIN());
                    case 601:
                        return new Status(StatusEnum.FILE_SIZE.getCODE(), StatusEnum.FILE_SIZE.getEXPLAIN());
                    case 600:
                        return new Status(StatusEnum.FILE_UPLOAD.getCODE(), StatusEnum.FILE_UPLOAD.getEXPLAIN());
                }
                fin.setId(getUUID());
                try {
                    this.dao.addFinalacceptDao(fin);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                //会审结果
            case "hsjg":
                HsResult hs = (HsResult) msg;
                hs.setFilesId(this.uuid.getUUID().toString());
                int hs1 = this.fileService.fileUploadService(files, request, "project", hs.getFilesId());
                switch (hs1) {
                    case 604:
                        return new Status(StatusEnum.NO_FILE.getCODE(), StatusEnum.NO_FILE.getEXPLAIN());
                    case 603:
                        return new Status(StatusEnum.FILE_FORMAT.getCODE(), StatusEnum.FILE_FORMAT.getEXPLAIN());
                    case 601:
                        return new Status(StatusEnum.FILE_SIZE.getCODE(), StatusEnum.FILE_SIZE.getEXPLAIN());
                    case 600:
                        return new Status(StatusEnum.FILE_UPLOAD.getCODE(), StatusEnum.FILE_UPLOAD.getEXPLAIN());
                }
                hs.setId(getUUID());
                try {
                    this.dao.addHsResultDao(hs);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                //开工报告
            case "kgbg":
                KgReport kg = (KgReport) msg;
                kg.setFilesId(this.uuid.getUUID().toString());
                int kg1 = this.fileService.fileUploadService(files, request, "document", kg.getFilesId());
                switch (kg1) {
                    case 604:
                        return new Status(StatusEnum.NO_FILE.getCODE(), StatusEnum.NO_FILE.getEXPLAIN());
                    case 603:
                        return new Status(StatusEnum.FILE_FORMAT.getCODE(), StatusEnum.FILE_FORMAT.getEXPLAIN());
                    case 601:
                        return new Status(StatusEnum.FILE_SIZE.getCODE(), StatusEnum.FILE_SIZE.getEXPLAIN());
                    case 600:
                        return new Status(StatusEnum.FILE_UPLOAD.getCODE(), StatusEnum.FILE_UPLOAD.getEXPLAIN());
                }
                kg.setId(getUUID());
                try {
                    this.dao.addKgReportDao(kg);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                //现场勘察
            case "xckc":
                Prospect pro = (Prospect) msg;
                pro.setFilesId(this.uuid.getUUID().toString());
                int pro1 = this.fileService.fileUploadService(files, request, "project", pro.getFilesId());
                switch (pro1) {
                    case 604:
                        return new Status(StatusEnum.NO_FILE.getCODE(), StatusEnum.NO_FILE.getEXPLAIN());
                    case 603:
                        return new Status(StatusEnum.FILE_FORMAT.getCODE(), StatusEnum.FILE_FORMAT.getEXPLAIN());
                    case 601:
                        return new Status(StatusEnum.FILE_SIZE.getCODE(), StatusEnum.FILE_SIZE.getEXPLAIN());
                    case 600:
                        return new Status(StatusEnum.FILE_UPLOAD.getCODE(), StatusEnum.FILE_UPLOAD.getEXPLAIN());
                }
                pro.setId(getUUID());
                try {
                    this.dao.addProspectDao(pro);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                //项目结算
            case "xmjs":
                Settlement set = (Settlement) msg;
                set.setFilesId(this.uuid.getUUID().toString());
                int set1 = this.fileService.fileUploadService(files, request, "project", set.getFilesId());
                switch (set1) {
                    case 604:
                        return new Status(StatusEnum.NO_FILE.getCODE(), StatusEnum.NO_FILE.getEXPLAIN());
                    case 603:
                        return new Status(StatusEnum.FILE_FORMAT.getCODE(), StatusEnum.FILE_FORMAT.getEXPLAIN());
                    case 601:
                        return new Status(StatusEnum.FILE_SIZE.getCODE(), StatusEnum.FILE_SIZE.getEXPLAIN());
                    case 600:
                        return new Status(StatusEnum.FILE_UPLOAD.getCODE(), StatusEnum.FILE_UPLOAD.getEXPLAIN());
                }
                set.setId(getUUID());
                set.setDate(getDate());
                try {
                    this.dao.addSettlementDao(set);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                //供货商
            case "ghs":
                Supplier sup = (Supplier) msg;
                sup.setFilesId(this.uuid.getUUID().toString());
                int sup1 = this.fileService.fileUploadService(files, request, "project", sup.getFilesId());
                switch (sup1) {
                    case 604:
                        return new Status(StatusEnum.NO_FILE.getCODE(), StatusEnum.NO_FILE.getEXPLAIN());
                    case 603:
                        return new Status(StatusEnum.FILE_FORMAT.getCODE(), StatusEnum.FILE_FORMAT.getEXPLAIN());
                    case 601:
                        return new Status(StatusEnum.FILE_SIZE.getCODE(), StatusEnum.FILE_SIZE.getEXPLAIN());
                    case 600:
                        return new Status(StatusEnum.FILE_UPLOAD.getCODE(), StatusEnum.FILE_UPLOAD.getEXPLAIN());
                }
                sup.setId(getUUID());
                try {
                    this.dao.addSupplierDao(sup);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                //技术交底
            case "jsjd":
                Technology te = (Technology) msg;
                te.setFilesId(this.uuid.getUUID().toString());
                int te1 = this.fileService.fileUploadService(files, request, "project", te.getFilesId());
                switch (te1) {
                    case 604:
                        return new Status(StatusEnum.NO_FILE.getCODE(), StatusEnum.NO_FILE.getEXPLAIN());
                    case 603:
                        return new Status(StatusEnum.FILE_FORMAT.getCODE(), StatusEnum.FILE_FORMAT.getEXPLAIN());
                    case 601:
                        return new Status(StatusEnum.FILE_SIZE.getCODE(), StatusEnum.FILE_SIZE.getEXPLAIN());
                    case 600:
                        return new Status(StatusEnum.FILE_UPLOAD.getCODE(), StatusEnum.FILE_UPLOAD.getEXPLAIN());
                }
                te.setId(getUUID());
                try {
                    this.dao.addTechnologyDao(te);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
            default:
                return new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
        }
    }

    @Override
    public Status addProjectDataService(Object msg, String type) {
        switch (type) {
            //项目信息
            case "xmxx":
                Project pro = (Project) msg;
                pro.setId(getUUID());
                try {
                    this.dao.addProjectDao(pro);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                //施工日志
            case "sgrz":
                ConsLog con = (ConsLog) msg;
                con.setDate(getDate());
                con.setId(getUUID());
                try {
                    this.dao.addConsLogDao(con);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                //施工安全日志
            case "sgaqrz":
                ConsSafetyLog sonsaf = (ConsSafetyLog) msg;
                sonsaf.setDate(getDate());
                sonsaf.setId(getUUID());
                try {
                    this.dao.addConsSafetyLogDao(sonsaf);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                //设备信息
            case "sbxx":
                Equipment eq = (Equipment) msg;
                eq.setId(getUUID());
                try {
                    this.dao.addEquipmentDao((Equipment) msg);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                //我的轨迹
            case "wdgj":
                Mylocus loc = (Mylocus) msg;
                loc.setDate(getDate());
                loc.setId(getUUID());
                try {
                    this.dao.addMylocusDao(loc);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                //施工人员
            case "sgry":
                SgPersonnel sg = (SgPersonnel) msg;
                sg.setId(getUUID());
                try {
                    this.dao.addSgPersonnelDao(sg);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                //监理日志
            case "jlrz":
                Suplog sup = (Suplog) msg;
                sup.setDate(getDate());
                sup.setId(getUUID());
                try {
                    this.dao.addSuplogDao(sup);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                //施工钱包
            case "sgqb":
                SgWallet wa = (SgWallet) msg;
                wa.setDate(getDate());
                wa.setId(getUUID());
                try {
                    this.dao.addSgWalletDao(wa);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
            default:
                return new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
        }
    }


    private String getDate() {
        return new StringBuilder(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date())).toString();
    }

    private String getUUID() {
        return this.uuid.getUUID().toString();
    }
}
