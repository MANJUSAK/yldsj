package com.goodsoft.yuanlin.service.servicelmpl;

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
    //实例化UUID工具类
    private UUIDUtil uuid = UUIDUtil.getInstance();
    //实例化服务器域名地址工具类
    private DomainNameUtil domainName = DomainNameUtil.getInstance();

    /**
     * 查询需求发布数据
     *
     * @param type 查询什么的数据（招标，苗木等），
     *             request http请求（用以文件展示），
     *             uid 用户编号，
     *             date 发布日期，
     *             breed 苗木品种，
     *             tp 人员招聘类型（招聘 1/求职 2）
     *             characters 招聘性质（全职 1/兼职 2）
     *             sub 苗木品种二级类型
     * @return 查询结果
     */
    @Override
    public <T> T queryReleaseData(String uid, String type, HttpServletRequest request, String date, String breed, String tp, String characters, String sub, int page) {
        page *= 20;
        if ("bid".equals(type)) {
            List<Bid> data = this.dao.queryBidDao(uid, date, page);
            if (data.size() > 0) {
                return (T) new Result(0, data);
            }
        } else if ("equipment".equals(type)) {
            List<Equipment> data = this.dao.queryEquipmentDao(uid, date, page);
            int i = data.size();
            if (i > 0) {
                //获取服务器域名地址
                String var = this.domainName.getServerDomainName(request).toString();
                for (int j = 0; j < i; ++j) {
                    //查询数据对应的图片信息
                    List<FileData> path = this.fileDao.queryFileDao(data.get(j).getFilesId());
                    int k = path.size();
                    if (k > 0) {
                        List url = new ArrayList();
                        //封装域名地址以及图片相对路径
                        url.clear();
                        for (int g = 0; g < k; ++g) {
                            url.add(var + path.get(g).getPath());
                        }
                        //将图片完整地址封装到数据中
                        data.get(j).setPicture(url);
                    }
                }
                return (T) new Result(0, data);
            }
        } else if ("recruit".equals(type)) {
            List<Recruit> data = this.dao.queryRecruitDao(uid, tp, characters, date, page);
            if (data.size() > 0) {
                return (T) new Result(0, data);
            }
        } else if ("seedling".equals(type)) {
            List<Seedling> data = this.dao.querySeedlingDao(uid, breed, sub, date, page);
            if (data.size() > 0) {
                int i = data.size();
                if (i > 0) {
                    //获取服务器域名地址
                    String var = this.domainName.getServerDomainName(request).toString();
                    for (int j = 0; j < i; ++j) {
                        //查询数据对应的图片信息
                        List<FileData> path = this.fileDao.queryFileDao(data.get(j).getFilesId());
                        int k = path.size();
                        if (k > 0) {
                            List url = new ArrayList();
                            //封装域名地址以及图片相对路径
                            url.clear();
                            for (int g = 0; g < k; ++g) {
                                url.add(var + path.get(g).getPath());
                            }
                            //将图片完整地址封装到数据中
                            data.get(j).setPicture(url);
                        }
                    }
                    return (T) new Result(0, data);
                }
            }
        } else {
            return (T) new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
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
        if ("seedling".equals(type)) {
            Seedling var = (Seedling) msg;
            var.setFilesId(this.uuid.getUUID().toString());
            int arg = this.fileService.fileUploadService(files, request, type, var.getFilesId());
            if (arg == 604) {
                return new Status(StatusEnum.NO_FILE.getCODE(), StatusEnum.NO_FILE.getEXPLAIN());
            } else if (arg == 603) {
                return new Status(StatusEnum.FILE_FORMAT.getCODE(), StatusEnum.FILE_FORMAT.getEXPLAIN());
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
        } else if ("equipment".equals(type)) {
            Equipment var = (Equipment) msg;
            var.setFilesId(this.uuid.getUUID().toString());
            int arg = this.fileService.fileUploadService(files, request, type, var.getFilesId());
            if (arg == 604) {
                return new Status(StatusEnum.NO_FILE.getCODE(), StatusEnum.NO_FILE.getEXPLAIN());
            } else if (arg == 603) {
                return new Status(StatusEnum.FILE_FORMAT.getCODE(), StatusEnum.FILE_FORMAT.getEXPLAIN());
            } else if (arg == 600) {
                return new Status(StatusEnum.FILE_UPLOAD.getCODE(), StatusEnum.FILE_UPLOAD.getEXPLAIN());
            }
            Date date = new Date();
            var.setDate(new SimpleDateFormat("yyyy-MM-dd").format(date));
            var.setTime(new SimpleDateFormat("HH:mm:ss").format(date));
            try {
                this.dao.saveEquipmentDao(var);
                return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
            } catch (Exception e) {
                e.printStackTrace();
                return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
            }
        } else {
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
        if ("bid".equals(type)) {
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
        } else if ("recruit".equals(type)) {
            Recruit var = (Recruit) msg;
            Date date = new Date();
            var.setDate(new SimpleDateFormat("yyyy-MM-dd").format(date));
            var.setTime(new SimpleDateFormat("HH:mm:ss").format(date));
            try {
                this.dao.saveRecruitDao(var);
                return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
            } catch (Exception e) {
                e.printStackTrace();
                return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
            }
        } else {
            return new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
        }
    }
}
