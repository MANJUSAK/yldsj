package com.goodsoft.yuanlin.service.lmpl;

import com.goodsoft.yuanlin.domain.dao.FileDao;
import com.goodsoft.yuanlin.domain.dao.TradeManageDao;
import com.goodsoft.yuanlin.domain.entity.file.FileData;
import com.goodsoft.yuanlin.domain.entity.trade.*;
import com.goodsoft.yuanlin.service.FileService;
import com.goodsoft.yuanlin.service.TradeManageService;
import com.goodsoft.yuanlin.util.DeleteFileUtil;
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
 * function 行业协会业务接口实现类
 * Created by 严彬荣 on 2017/8/21.
 * version v1.0
 */
@SuppressWarnings("ALL")
@Service
public class TradeManageServicelmpl implements TradeManageService {

    @Resource
    private TradeManageDao dao;
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
    //实例化文件删除工具类
    private DeleteFileUtil deleteFile = DeleteFileUtil.getInstance();

    /**
     * 行业协会数据查询（含文件）
     *
     * @param request http请求，
     * @param type    查询类型（协会培训等），
     * @param date    日期，
     * @param tp      查询数据类型（施工员等），
     * @param keyWord 关键字，
     * @param page    页码。
     * @return 查询结果
     * @throws Exception
     */
    @Override
    public <T> T queryTradeService(HttpServletRequest request, String type, String date, String tp, String keyWord, String page) {
        if (page == null || "".equals(page)) {
            return (T) new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
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
        switch (type) {
            //协会培训
            case "xhpx":
                List<TrainsInfo> data = null;
                try {
                    data = this.dao.queryTrainInfoDao(date, tp, keyWord, arg);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                int t = data.size();
                if (t > 0) {
                    String http = this.domainName.getServerDomainName(request).toString();
                    StringBuilder sb = new StringBuilder();
                    try {
                        for (int i = 0; i < t; ++i) {
                            List<FileData> url = this.fileDao.queryFileDao(data.get(i).getFilesId());
                            List<String> path = new ArrayList<String>();
                            int u = url.size();
                            if (u > 0) {
                                for (int j = 0; j < u; ++j) {
                                    sb.append(http);
                                    sb.append(url.get(j).getPath());
                                    path.add(sb.toString());
                                    sb.delete(0, sb.length());
                                }
                            }
                            data.get(i).setTrainFile(path);
                        }
                        return (T) new Result(0, data);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
            default:
                return (T) new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
        }
    }

    /**
     * 行业协会数据查询（无文件）
     *
     * @param request http请求，
     * @param type    查询类型（协会培训等），
     * @param date    日期，
     * @param tp      查询数据类型（施工员等），
     * @param keyWord 关键字，
     * @param year    年份，
     * @param comp    企业，
     * @param member  会员属性（0为会员），
     * @param page    页码。
     * @return 查询结果
     * @throws Exception
     */
    @Override
    public <T> T queryTradeService(String type, String date, String tp, String comp, String year, String keyWord, String page, String member) {
        if (page == null || "".equals(page)) {
            return (T) new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
        }
        //将page转换为数据 start
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
        //将page转换为数据 end
        //根据类型查询数据 start
        switch (type) {
            //会费数据 start
            case "hf":
                List<Dues> due = null;
                try {
                    due = this.dao.queryDuesDao(arg);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                if (due.size() > 0) {
                    return (T) new Result(0, due);
                }
                return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
            //会费数据 end
            //会员会费数据 start
            case "hyhf":
                if (member == null || "".equals(member)) {
                    return (T) new Status(StatusEnum.NO_PRAM.getCODE(), StatusEnum.NO_PRAM.getEXPLAIN());
                }
                int mb = 1;
                try {
                    mb = Integer.parseInt(member);
                } catch (NumberFormatException e) {
                    this.logger.error(e);
                    return (T) new Status(StatusEnum.NO_PRAM.getCODE(), StatusEnum.NO_PRAM.getEXPLAIN());
                }
                if (mb != 0) {
                    return (T) new Status(StatusEnum.NO_RIGHTS.getCODE(), StatusEnum.NO_RIGHTS.getEXPLAIN());
                }
                List<Dues> mber = null;
                try {
                    mber = this.dao.queryMberDuesDao(date, keyWord, arg);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                if (mber.size() > 0) {
                    return (T) new Result(0, mber);
                }
                return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
            //会员会费数据 end
            //动态资讯数据 start
            case "dtzx":
                List<Information> info = null;
                try {
                    info = this.dao.queryInformationDao(date, tp, keyWord, arg);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                if (info.size() > 0) {
                    return (T) new Result(0, info);
                }
                return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
            //动态资讯数据 end
            //优质工程数据 start
            case "yzgc":
                List<QualEngin> qua = null;
                try {
                    qua = this.dao.queryQualEnginDao(date, comp, year, keyWord, arg);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                if (qua.size() > 0) {
                    return (T) new Result(0, qua);
                }
                return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
            //优质工程数据 end
            //联系协会数据 start
            case "lxxh":
                List<Contact> con = null;
                try {
                    con = this.dao.queryContactDao(date, arg);
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                if (con.size() > 0) {
                    return (T) new Result(0, con);
                }
                return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
            //联系协会数据 end
            default:
                return (T) new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
        }
        //根据类型查询数据 start
    }


    /**
     * 行业协会数据添加（含文件）
     *
     * @param files    文件，
     * @param fileType 文件类型（文档/图片），
     * @param type     添加数据类型（协会培训等），
     * @param msg      添加数据
     * @return 添加结果
     * @throws Exception
     */
    @Override
    @Transactional
    public Status addTradeService(MultipartFile[] files, String fileType, String type, Object msg) {
        //根据类型添加数据 start
        switch (type) {
            //协会培训添加 start
            case "xhpx":
                TrainsInfo var = (TrainsInfo) msg;
                var.setFilesId(this.uuid.getUUID().toString());
                int arg = this.fileService.fileUploadService(files, fileType, var.getFilesId());
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
                    this.dao.addTrainInfoDao(var);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                //协会培训添加 end
            default:
                return new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
        }
        //根据类型添加数据 end
    }

    /**
     * 行业协会数据添加（无文件）
     *
     * @param type 添加数据类型（协会培训等），
     * @param msg  添加数据
     * @return 添加结果
     * @throws Exception
     */
    @Override
    @Transactional
    public Status addTradeService(String type, Object msg) {
        //根据类型添加数据 start
        switch (type) {
            //会费添加 start
            case "hf":
                Dues due = (Dues) msg;
                try {
                    this.dao.addDuesDao(due);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                //会费添加 end
                //动态资讯添加 start
            case "dtzx":
                Information info = (Information) msg;
                info.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                try {
                    this.dao.addInformationDao(info);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                //动态资讯添加 end
                //优质工程添加 start
            case "yzgc":
                QualEngin qua = (QualEngin) msg;
                try {
                    this.dao.addQualEngineeringDao(qua);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                //优质工程添加 end
                //联系协会添加 start
            case "lxxh":
                Contact con = (Contact) msg;
                Date date = new Date();
                con.setDate(new SimpleDateFormat("yyyy-MM-dd").format(date));
                con.setTime(new SimpleDateFormat("HH:mm:ss").format(date));
                try {
                    this.dao.addContactDao(con);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }
                //联系协会添加 end
            default:
                return new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
        }
        //根据类型添加数据 end
    }

    /**
     * 删除行业协会数据业务方法（有文件）
     *
     * @param type 删除数据类型（如：协会培训数据）
     * @param id   数据id
     * @return 删除结果
     */
    @Override
    @Transactional
    public Status deleteTradeService(String type, String[] id) {
        //删除行业协会数据 start
        switch (type) {
            //删除协会培训数据 start
            case "xhpx":
                try {
                    for (int i = 0, len = id.length; i < len; ++i) {
                        //获取数据文件
                        List<FileData> fileData = this.fileDao.queryFileDao(id[i]);
                        //删除硬盘上的文件
                        this.deleteFile.deleteFile(fileData);
                    }
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
                try {
                    //删除数据
                    this.dao.deleteTrainInfoDao(id);
                    //删除数据库文件数据
                    this.fileDao.deleteFileDao(id);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                //删除协会培训数据 end
            default:
                return new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
        }
        //删除行业协会数据 start
    }

    /**
     * 删除行业协会数据业务方法（无文件）
     *
     * @param type 删除数据类型（如：动态资讯数据）
     * @param id   数据id
     * @return 删除结果
     */
    @Override
    @Transactional
    public Status deleteTradeService(String type, int[] id) {
        //删除行业协会数据 start
        switch (type) {
            //删除会费数据 stat
            case "hf":
                try {
                    this.dao.deleteDuesDao(id);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                //删除会费数据 end
                //删除动态资讯数据 stat
            case "dtzx":
                try {
                    this.dao.deleteInformationDao(id);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                //删除动态资讯数据 end
                //删除优质工程数据 stat
            case "yzgc":
                try {
                    this.dao.deleteQualEngineeringDao(id);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e);
                    System.out.println(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
                //删除优质工程数据 end
            default:
                return new Status(StatusEnum.NO_URL.getCODE(), StatusEnum.NO_URL.getEXPLAIN());
        }
        //删除行业协会数据 end
    }
}
