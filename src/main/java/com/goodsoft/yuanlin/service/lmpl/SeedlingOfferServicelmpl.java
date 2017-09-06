package com.goodsoft.yuanlin.service.lmpl;

import com.goodsoft.yuanlin.domain.dao.FileDao;
import com.goodsoft.yuanlin.domain.dao.SeedlingOfferDao;
import com.goodsoft.yuanlin.domain.entity.demand.SeedlingOffer;
import com.goodsoft.yuanlin.domain.entity.file.FileData;
import com.goodsoft.yuanlin.service.FileService;
import com.goodsoft.yuanlin.service.SeedlingOfferService;
import com.goodsoft.yuanlin.util.ExcelUtil;
import com.goodsoft.yuanlin.util.UUIDUtil;
import com.goodsoft.yuanlin.util.resultentity.Result;
import com.goodsoft.yuanlin.util.resultentity.Status;
import com.goodsoft.yuanlin.util.resultentity.StatusEnum;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * function 苗木参考报价业务接口实现类
 * Created by 严彬荣 on 2017/9/4.
 * version v1.0
 */
@SuppressWarnings("ALL")
@Service
public class SeedlingOfferServicelmpl implements SeedlingOfferService {

    @Resource
    private SeedlingOfferDao dao;
    @Resource
    private FileService fileService;
    @Resource
    private FileDao fileDao;
    //实例化日志管理工具类
    private Logger logger = Logger.getLogger(DemandReleaseServicelmpl.class);
    //实例化UUID工具类
    private UUIDUtil uuid = UUIDUtil.getInstance();
    //实例化excel工具类
    private ExcelUtil excelUtil = ExcelUtil.getInstance();

    @Override
    public <T> T querySeedlingOfferService(String price, String mate, String tp, String spf, String date, String page) {
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
        List<SeedlingOffer> data = null;
        try {
            data = this.dao.querySeedlingOfferDao(price, mate, tp, spf, date, arg);
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
    }

    @Override
    public Status addSeedlingOfferService(MultipartFile[] files) {
        String uuid = this.uuid.getUUID().toString();
        int arg = this.fileService.fileUploadService(files, "excel", uuid);
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
            List<FileData> file = this.fileDao.queryFileDao(uuid);
            StringBuilder sb = new StringBuilder(file.get(0).getBases());
            sb.append(file.get(0).getPath());
            List<List<SeedlingOffer>> list = this.excelUtil.readExcel(sb.toString(), uuid);
            for (int i = 0, len = list.size(); i < len; ++i) {
                List<SeedlingOffer> msg = list.get(i);
                if (msg.size() > 0) {
                    this.dao.addSeedlingOfferDao(msg);
                } else {
                    if (list.get(0).size() == 0) {
                        return new Status(StatusEnum.NO_EXCEL_DATA.getCODE(), StatusEnum.NO_EXCEL_DATA.getEXPLAIN());
                    }
                }
            }
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        } catch (Exception e) {
            System.out.println(e.toString());
            this.logger.error(e);
            return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }
    }
}
