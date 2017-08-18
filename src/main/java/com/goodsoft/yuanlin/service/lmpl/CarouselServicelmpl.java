package com.goodsoft.yuanlin.service.lmpl;

import com.goodsoft.yuanlin.domain.dao.CarouselDao;
import com.goodsoft.yuanlin.domain.entity.carousel.Carousel;
import com.goodsoft.yuanlin.service.CarouselService;
import com.goodsoft.yuanlin.util.DomainNameUtil;
import com.goodsoft.yuanlin.util.resultentity.Result;
import com.goodsoft.yuanlin.util.resultentity.Status;
import com.goodsoft.yuanlin.util.resultentity.StatusEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    //实例化服务器域名工具类
    private DomainNameUtil domainName = DomainNameUtil.getInstance();

    @Override
    public <T> T queryCarouselService(HttpServletRequest request, String var) {
        Carousel data = null;
        try {
            data = this.dao.queryCarouselDao();
        } catch (Exception e) {
            System.out.println(e.toString());
            return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }
        if (data != null) {
            List<String> url = this.dao.queryCarouselByIdDao(data.getId());
            int u = url.size();
            if (u > 0) {
                List<String> path = new ArrayList<String>();
                /*StringBuilder sb = new StringBuilder(this.domainName.getServerDomainName(request).toString());*/
                StringBuilder sb = new StringBuilder("http://172.16.0.8");
                sb.append("/");
                sb.append(var);
                sb.append("/download.do?id=");
                for (int i = 0; i < u; ++i) {
                    path.add(sb.toString() + url.get(i));
                }
                data.setPicture(path);
            }
            return (T) new Result(0, data);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }
}
