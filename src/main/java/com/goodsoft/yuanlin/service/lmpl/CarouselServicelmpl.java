package com.goodsoft.yuanlin.service.lmpl;

import com.goodsoft.yuanlin.domain.dao.CarouselDao;
import com.goodsoft.yuanlin.domain.dao.FileDao;
import com.goodsoft.yuanlin.domain.entity.carousel.Carousel;
import com.goodsoft.yuanlin.domain.entity.file.FileData;
import com.goodsoft.yuanlin.service.CarouselService;
import com.goodsoft.yuanlin.service.FileService;
import com.goodsoft.yuanlin.util.DomainNameUtil;
import com.goodsoft.yuanlin.util.UUIDUtil;
import com.goodsoft.yuanlin.util.resultentity.Result;
import com.goodsoft.yuanlin.util.resultentity.Status;
import com.goodsoft.yuanlin.util.resultentity.StatusEnum;
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
 * function 轮播图业务接口类
 * Created by 严彬荣 on 2017/8/18.
 */
@SuppressWarnings("ALL")
@Service
public class CarouselServicelmpl implements CarouselService {

    @Resource
    private CarouselDao dao;
    @Resource
    private FileDao fileDao;
    @Resource
    private FileService fileService;
    //实例化服务器域名工具类
    private DomainNameUtil domainName = DomainNameUtil.getInstance();
    //实例化UUID工具类
    private UUIDUtil uuid = UUIDUtil.getInstance();

    /**
     * function 查询轮播图业务接口类
     *
     * @param http http请求
     * @return 查询数据
     * @throws Exception
     */
    @Override
    public <T> T queryCarouselService(HttpServletRequest request) {
        Carousel data = null;
        try {
            data = this.dao.queryCarouselDao();
        } catch (Exception e) {
            System.out.println(e.toString());
            return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }
        if (data != null) {
            List<FileData> url = null;
            try {
                url = this.fileDao.queryFileDao(data.getFilesId());
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            int u = url.size();
            if (u > 0) {
                List<String> path = new ArrayList<String>();
                String http = this.domainName.getServerDomainName(request).toString();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < u; ++i) {
                    sb.append(http);
                    sb.append(url.get(i).getPath());
                    path.add(sb.toString());
                    sb.delete(0, sb.length());
                }
                data.setPicture(path);
            }
            return (T) new Result(0, data);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * function 添加轮播图业务方法
     *
     * @param http  http请求
     * @param files 上传文件
     * @param msg   数据
     * @return 添加结果
     * @throws Exception
     */
    @Override
    @Transactional
    public Status addCarouselService(HttpServletRequest request, MultipartFile[] files, Carousel msg) {
        msg.setFilesId(this.uuid.getUUID().toString());
        int arg = this.fileService.fileUploadService(files, request, "carousel", msg.getFilesId());
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
        msg.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        try {
            this.dao.addCarouselDao(msg);
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        } catch (Exception e) {
            System.out.println(e.toString());
            return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }
    }
}
