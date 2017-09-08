package com.goodsoft.yuanlin.service.lmpl;

import com.goodsoft.yuanlin.domain.dao.DemandReleaseDao;
import com.goodsoft.yuanlin.domain.dao.FileDao;
import com.goodsoft.yuanlin.domain.entity.demand.Bid;
import com.goodsoft.yuanlin.domain.entity.demand.Equipment;
import com.goodsoft.yuanlin.domain.entity.demand.Recruit;
import com.goodsoft.yuanlin.domain.entity.demand.Seedling;
import com.goodsoft.yuanlin.domain.entity.file.FileData;
import com.goodsoft.yuanlin.service.DemandReleaseService;
import com.goodsoft.yuanlin.service.FileService;
import com.goodsoft.yuanlin.util.DomainNameUtil;
import com.goodsoft.yuanlin.util.UUIDUtil;
import com.goodsoft.yuanlin.util.resultentity.Result;
import com.goodsoft.yuanlin.util.resultentity.Status;
import com.goodsoft.yuanlin.util.resultentity.StatusEnum;
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
 * function 需求发布业务接口实现类
 * Created by 严彬荣 on 2017/8/4.
 * version v1.0
 */
@SuppressWarnings("ALL")
@Service
public class DemandReleaseServicelmpl implements DemandReleaseService {
    @Resource
    private DemandReleaseDao dao;
    @Resource
    private FileService fileService;
    @Resource
    private FileDao fileDao;
    //实例化日志管理工具类
    private Logger logger = Logger.getLogger(DemandReleaseServicelmpl.class);
    //实例化UUID工具类
    private UUIDUtil uuid = UUIDUtil.getInstance();
    //实例化服务器域名地址工具类
    private DomainNameUtil domainName = DomainNameUtil.getInstance();

    /**
     * 查询需求发布数据
     *
     * @param keyWord    标题内容，
     * @param type       查询什么的数据（招标，苗木等），
     * @param request    http请求（用以文件展示），
     * @param uid        用户编号，
     * @param date       发布日期，
     * @param breed      苗木品种，
     * @param tp         人员招聘类型（招聘 1/求职 2）
     * @param characters 招聘性质（全职 1/兼职 2）
     * @param sub        苗木品种二级类型
     * @return 查询结果
     * @throws Exception
     */
    @Override
    public <T> T queryReleaseData(String keyWord, String comp, String uid, String type, HttpServletRequest request, String date, String breed, String tp, String characters, String sub, String page) {
        //判断page start
        if (page == null || page == "") {
            return (T) new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
        }
        //end

        //将page转化为数字 start
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
        //end
        //根据类型查询相关数据 start
        switch (type) {
            //查询招标数据 start
            case "bid":
                List<Bid> bid = null;
                try {
                    bid = this.dao.queryBidDao(keyWord, comp, uid, date, arg);
                } catch (Exception e) {
                    System.out.println(e.toString());
                    this.logger.error(e);
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                if (bid.size() > 0) {
                    return (T) new Result(0, bid);
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
                //查询招标数据 end
                //查询人才招聘数据 start
            case "recruit":
                List<Recruit> rec = null;
                try {
                    rec = this.dao.queryRecruitDao(keyWord, comp, uid, tp, characters, date, arg);
                } catch (Exception e) {
                    System.out.println(e.toString());
                    this.logger.error(e);
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                if (rec.size() > 0) {
                    return (T) new Result(0, rec);
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
                //查询人才招聘数据 end
                //查询设备租赁数据 start
            case "equipment":
                List<Equipment> equ = null;
                try {
                    equ = this.dao.queryEquipmentDao(keyWord, comp, uid, date, arg);
                } catch (Exception e) {
                    System.out.println(e.toString());
                    this.logger.error(e);
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                int eu = equ.size();
                if (eu > 0) {
                    //获取服务器域名地址
                    String var = this.domainName.getServerDomainName(request).toString();
                    StringBuilder sb = new StringBuilder();
                    try {
                        for (int i = 0; i < eu; ++i) {
                            //查询数据对应的图片信息
                            List<FileData> path = this.fileDao.queryFileDao(equ.get(i).getFilesId());
                            int p = path.size();
                            if (p > 0) {
                                //封装域名地址以及图片相对路径
                                List url = new ArrayList();
                                for (int j = 0; j < p; ++j) {
                                    sb.append(var);
                                    sb.append(path.get(j).getPath());
                                    url.add(sb.toString());
                                    sb.delete(0, sb.length());
                                }
                                //将图片完整地址封装到数据中
                                equ.get(i).setPicture(url);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.toString());
                        this.logger.error(e);
                    }
                    return (T) new Result(0, equ);
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
                //查询设备租赁数据 end
                //查询苗木信息数据 start
            case "seedling":
                List<Seedling> seed = null;
                try {
                    seed = this.dao.querySeedlingDao(keyWord, comp, uid, breed, sub, date, arg);
                } catch (Exception e) {
                    System.out.println(e.toString());
                    this.logger.error(e);
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                int s = seed.size();
                if (s > 0) {
                    //获取服务器域名地址
                    String var = this.domainName.getServerDomainName(request).toString();
                    StringBuilder sb = new StringBuilder();
                    try {
                        for (int i = 0; i < s; ++i) {
                            //查询数据对应的图片信息
                            List<FileData> path = this.fileDao.queryFileDao(seed.get(i).getFilesId());
                            int p = path.size();
                            if (p > 0) {
                                //封装域名地址以及图片相对路径
                                List url = new ArrayList();
                                for (int j = 0; j < p; ++j) {
                                    sb.append(var);
                                    sb.append(path.get(j).getPath());
                                    url.add(sb.toString());
                                    sb.delete(0, sb.length());
                                }
                                //将图片完整地址封装到数据中
                                seed.get(i).setPicture(url);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.toString());
                        this.logger.error(e);
                    }
                    return (T) new Result(0, seed);
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
                //查询苗木信息数据 end
            default:
                return (T) new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
        }
        //根据类型查询相关数据 end
    }

    /**
     * 需求发布数据录入（有文件）
     *
     * @param files 文件，
     * @param msg   发布数据，
     * @param type  发布什么的数据（招标、苗木等），
     * @return 录入结果
     * @throws Exception
     */
    @Override
    @Transactional
    public Status releaseDataService(MultipartFile[] files, Object msg, String type) {
        //根据类型添加数据 start
        switch (type) {
            //添加苗木信息 start
            case "seedling":
                Seedling var = (Seedling) msg;
                var.setFilesId(this.uuid.getUUID().toString());
                int arg = this.fileService.fileUploadService(files, type, var.getFilesId());
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
                Date date = new Date();
                var.setDate(new SimpleDateFormat("yyyy-MM-dd").format(date));
                var.setTime(new SimpleDateFormat("HH:mm:ss").format(date));
                try {
                    this.dao.saveSeedlingDao(var);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    e.printStackTrace();
                    return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                //添加苗木信息 end
                //添加设备租赁 start
            case "equipment":
                Equipment var1 = (Equipment) msg;
                var1.setFilesId(this.uuid.getUUID().toString());
                int arg1 = this.fileService.fileUploadService(files, type, var1.getFilesId());
                switch (arg1) {
                    case 604:
                        return new Status(StatusEnum.NO_FILE.getCODE(), StatusEnum.NO_FILE.getEXPLAIN());
                    case 603:
                        return new Status(StatusEnum.FILE_FORMAT.getCODE(), StatusEnum.FILE_FORMAT.getEXPLAIN());
                    case 601:
                        return new Status(StatusEnum.FILE_SIZE.getCODE(), StatusEnum.FILE_SIZE.getEXPLAIN());
                    case 600:
                        return new Status(StatusEnum.FILE_UPLOAD.getCODE(), StatusEnum.FILE_UPLOAD.getEXPLAIN());
                }
                Date date1 = new Date();
                var1.setDate(new SimpleDateFormat("yyyy-MM-dd").format(date1));
                var1.setTime(new SimpleDateFormat("HH:mm:ss").format(date1));
                try {
                    this.dao.saveEquipmentDao(var1);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    e.printStackTrace();
                    return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                //添加设备租赁 end
            default:
                return new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
        }
        //根据类型添加数据 start
    }

    /**
     * 需求发布数据录入（无文件）
     *
     * @param msg  发布数据，
     * @param type 发布什么的数据（招标、苗木等），
     * @return 录入结果
     * @throws Exception
     */
    @Override
    @Transactional
    public Status releaseDataService(Object msg, String type) {
        //根据类型添加数据 start
        switch (type) {
            //添加招标信息 start
            case "bid":
                Bid var = (Bid) msg;
                Date date = new Date();
                var.setDate(new SimpleDateFormat("yyyy-MM-dd").format(date));
                var.setTime(new SimpleDateFormat("HH:mm:ss").format(date));
                try {
                    this.dao.saveBidDao(var);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    e.printStackTrace();
                    return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                //添加招标信息 end
                //添加人才招聘 start
            case "recruit":
                Recruit var1 = (Recruit) msg;
                Date date1 = new Date();
                var1.setDate(new SimpleDateFormat("yyyy-MM-dd").format(date1));
                var1.setTime(new SimpleDateFormat("HH:mm:ss").format(date1));
                try {
                    this.dao.saveRecruitDao(var1);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    e.printStackTrace();
                    return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                //添加人才招聘 end
            default:
                return new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
        }
        //根据类型添加数据 end
    }

    /**
     * 需求发布数据删除业务处理
     *
     * @param id   删除数据编号，
     * @param type 删除类型（苗木、设备租赁等）。
     * @return 删除结果
     * @throws Exception
     */
    @Override
    @Transactional
    public Status deleteReleaseDataService(int[] id, String type) {
        //根据类型删除数据 start
        switch (type) {
            //删除设备租赁数据 start
            case "equipment":
                try {
                    this.dao.updateEquipmentDao(id);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
            //删除设备租赁数据 end
            //删除苗木信息数据 start
            case "seedling":
                try {
                    this.dao.updateSeedlingDao(id);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
            //删除苗木信息数据 end
            //删除招标信息数据 start
            case "bid":
                try {
                    this.dao.updateBidDao(id);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
            //删除招标信息数据 end
            //删除人才招聘数据 start
            case "recruit":
                try {
                    this.dao.updateRecruitDao(id);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
            //删除人才招聘数据 end
            default:
                return new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
        }
        //根据类型删除数据 end
    }
}
