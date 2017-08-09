package com.goodsoft.yuanlin.service.lmpl;

import com.goodsoft.yuanlin.dao.DemandReleaseDao;
import com.goodsoft.yuanlin.dao.FileDao;
import com.goodsoft.yuanlin.entity.*;
import com.goodsoft.yuanlin.service.DemandReleaseService;
import com.goodsoft.yuanlin.service.FileService;
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
 * function 需求发布业务接口实现类
 * Created by 严彬荣 on 2017/8/4.
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
     * @param keyWord 标题内容，
     *                type 查询什么的数据（招标，苗木等），
     *                request http请求（用以文件展示），
     *                uid 用户编号，
     *                date 发布日期，
     *                breed 苗木品种，
     *                tp 人员招聘类型（招聘 1/求职 2）
     *                characters 招聘性质（全职 1/兼职 2）
     *                sub 苗木品种二级类型
     * @return 查询结果
     */
    @Override
    public <T> T queryReleaseData(String keyWord, String uid, String type, HttpServletRequest request, String date, String breed, String tp, String characters, String sub, int page) {
        page *= 20;
        switch (type) {
            case "bid":
                List<Bid> data = null;
                try {
                    data = this.dao.queryBidDao(keyWord, uid, date, page);
                } catch (Exception e) {
                    System.out.println(e.toString());
                    this.logger.error(e);
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                if (data.size() > 0) {
                    return (T) new Result(0, data);
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
            case "recruit":
                List<Recruit> data1 = null;
                try {
                    data1 = this.dao.queryRecruitDao(keyWord, uid, tp, characters, date, page);
                } catch (Exception e) {
                    System.out.println(e.toString());
                    this.logger.error(e);
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                if (data1.size() > 0) {
                    return (T) new Result(0, data1);
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
            case "equipment":
                List<Equipment> data2 = null;
                try {
                    data2 = this.dao.queryEquipmentDao(keyWord, uid, date, page);
                } catch (Exception e) {
                    System.out.println(e.toString());
                    this.logger.error(e);
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                int i = data2.size();
                if (i > 0) {
                    //获取服务器域名地址
                    String var = this.domainName.getServerDomainName(request).toString();
                    try {
                        for (int j = 0; j < i; ++j) {
                            //查询数据对应的图片信息
                            List<FileData> path = this.fileDao.queryFileDao(data2.get(j).getFilesId());
                            int k = path.size();
                            if (k > 0) {
                                //封装域名地址以及图片相对路径
                                List url = new ArrayList();
                                //初始化时不清除集合减少不必要的性能消耗
                                if (j > 0) {
                                    url.clear();
                                }
                                for (int g = 0; g < k; ++g) {
                                    url.add(var + path.get(g).getPath());
                                }
                                //将图片完整地址封装到数据中
                                data2.get(j).setPicture(url);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.toString());
                        this.logger.error(e);
                    }
                    return (T) new Result(0, data2);
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
            case "seedling":
                List<Seedling> data3 = null;
                try {
                    data3 = this.dao.querySeedlingDao(keyWord, uid, breed, sub, date, page);
                } catch (Exception e) {
                    System.out.println(e.toString());
                    this.logger.error(e);
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                if (data3.size() > 0) {
                    int s = data3.size();
                    if (s > 0) {
                        //获取服务器域名地址
                        String var = this.domainName.getServerDomainName(request).toString();
                        try {
                            for (int j = 0; j < s; ++j) {
                                //查询数据对应的图片信息
                                List<FileData> path = this.fileDao.queryFileDao(data3.get(j).getFilesId());
                                int k = path.size();
                                if (k > 0) {
                                    //封装域名地址以及图片相对路径
                                    List url = new ArrayList();
                                    //初始化时不清除集合减少不必要的性能消耗
                                    if (j > 0) {
                                        url.clear();
                                    }
                                    for (int g = 0; g < k; ++g) {
                                        url.add(var + path.get(g).getPath());
                                    }
                                    //将图片完整地址封装到数据中
                                    data3.get(j).setPicture(url);
                                }
                            }
                        } catch (Exception e) {
                            System.out.println(e.toString());
                            this.logger.error(e);
                        }
                        return (T) new Result(0, data3);
                    }
                } else {
                    return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
                }
            default:
                return (T) new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
        }
    }

    /**
     * 需求发布数据录入（有文件）
     *
     * @param files 文件，
     *              request http请求（用以文件上传），
     *              msg 发布数据，
     *              type 发布什么的数据（招标、苗木等），
     * @return 录入结果
     */
    @Override
    public Status releaseDataService(MultipartFile[] files, HttpServletRequest request, Object msg, String type) {
        switch (type) {
            case "seedling":
                Seedling var = (Seedling) msg;
                var.setFilesId(this.uuid.getUUID().toString());
                int arg = this.fileService.fileUploadService(files, request, type, var.getFilesId());
                if (arg == 604) {
                    return new Status(StatusEnum.NO_FILE.getCODE(), StatusEnum.NO_FILE.getEXPLAIN());
                } else if (arg == 603) {
                    return new Status(StatusEnum.FILE_FORMAT.getCODE(), StatusEnum.FILE_FORMAT.getEXPLAIN());
                } else if (arg == 601) {
                    return new Status(StatusEnum.FILE_SIZE.getCODE(), StatusEnum.FILE_SIZE.getEXPLAIN());
                } else if (arg == 600) {
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
            case "equipment":
                Equipment var1 = (Equipment) msg;
                var1.setFilesId(this.uuid.getUUID().toString());
                int arg1 = this.fileService.fileUploadService(files, request, type, var1.getFilesId());
                if (arg1 == 604) {
                    return new Status(StatusEnum.NO_FILE.getCODE(), StatusEnum.NO_FILE.getEXPLAIN());
                } else if (arg1 == 603) {
                    return new Status(StatusEnum.FILE_FORMAT.getCODE(), StatusEnum.FILE_FORMAT.getEXPLAIN());
                } else if (arg1 == 601) {
                    return new Status(StatusEnum.FILE_SIZE.getCODE(), StatusEnum.FILE_SIZE.getEXPLAIN());
                } else if (arg1 == 600) {
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
            default:
                return new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
        }
    }

    /**
     * 需求发布数据录入（无文件）
     *
     * @param msg 发布数据，
     *            type 发布什么的数据（招标、苗木等），
     * @return 录入结果
     */
    @Override
    public Status releaseDataService(Object msg, String type) {
        switch (type) {
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
            default:
                return new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
        }
    }

    /**
     * 需求发布数据删除业务处理
     *
     * @param id 删除数据编号，
     *           type 删除类型（苗木、设备租赁等）。
     * @return 删除结果
     */
    @Override
    public Status deleteReleaseDataService(int[] id, String type) {
        switch (type) {
            case "equipment":
                try {
                    this.dao.updateEquipmentDao(id);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
            case "seedling":
                try {
                    this.dao.updateSeedlingDao(id);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
            case "bid":
                try {
                    this.dao.updateBidDao(id);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
            case "recruit":
                try {
                    this.dao.updateRecruitDao(id);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
            default:
                return new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
        }
    }
}
