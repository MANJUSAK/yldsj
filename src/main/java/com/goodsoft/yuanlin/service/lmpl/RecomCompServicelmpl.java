package com.goodsoft.yuanlin.service.lmpl;

import com.goodsoft.yuanlin.domain.dao.RecomCompDao;
import com.goodsoft.yuanlin.domain.entity.recommend.RecomComp;
import com.goodsoft.yuanlin.service.RecomCompService;
import com.goodsoft.yuanlin.util.DomainNameUtil;
import com.goodsoft.yuanlin.util.resultentity.Result;
import com.goodsoft.yuanlin.util.resultentity.Status;
import com.goodsoft.yuanlin.util.resultentity.StatusEnum;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * function 企业推荐业务接口实现类
 * Created by 严彬荣 on 2017/8/14.
 */
@SuppressWarnings("ALL")
@Service
public class RecomCompServicelmpl implements RecomCompService {
    @Resource
    private RecomCompDao dao;
    //实例化服务器域名工具类
    private DomainNameUtil domainName = DomainNameUtil.getInstance();
    //实例化日志管理工具类
    private Logger logger = Logger.getLogger(RecomCompServicelmpl.class);

    /**
     * 查询企业推荐业务接口方法
     *
     * @param request http请求
     * @param page    页码
     * @param var     工作流项目名
     * @param <T>     泛型
     * @return 查询结果
     * @throws Exception
     */
    @Override
    public <T> T queryRecomService(HttpServletRequest request, String page, String var) {
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
        arg *= 20;
        //将page转换为int start
        try {
            List<RecomComp> data = this.dao.queryRecomCompDao(arg);
            if (data.size() > 0) {
                List<String> path = new ArrayList<String>();
                String http = this.domainName.getServerDomainName(request).toString();
                StringBuilder sb = new StringBuilder();
                for (int i = 0, length = data.size(); i < length; ++i) {
                    List<String> url = this.dao.queryRecomCompFileDao(data.get(i).getId());
                    if (url.size() > 0) {
                        for (int j = 0, lth = url.size(); j < lth; ++j) {
                            sb.append(http);
                            sb.append("/");
                            sb.append(var);
                            sb.append("/download.do?id=");
                            sb.append(url.get(j));
                            path.add(sb.toString());
                            sb.delete(0, sb.length());
                        }
                    }
                    data.get(i).setPicture(path);
                }
                return (T) new Result(0, data);
            } else {
                return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            this.logger.error(e);
            return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }
    }
}
