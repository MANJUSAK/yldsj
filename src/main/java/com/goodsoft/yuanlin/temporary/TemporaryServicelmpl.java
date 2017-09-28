package com.goodsoft.yuanlin.temporary;

import com.goodsoft.yuanlin.domain.dao.FileDao;
import com.goodsoft.yuanlin.domain.dao.TemporaryDao;
import com.goodsoft.yuanlin.domain.entity.file.FileData;
import com.goodsoft.yuanlin.domain.entity.user.Corporation;
import com.goodsoft.yuanlin.service.FileService;
import com.goodsoft.yuanlin.util.UUIDUtil;
import com.goodsoft.yuanlin.util.resultentity.Status;
import com.goodsoft.yuanlin.util.resultentity.StatusEnum;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * function 法人库数据导入接口实现类
 * Created by 法人库 on 2017/9/28.
 */
@SuppressWarnings("ALL")
@Service
public class TemporaryServicelmpl implements TemporaryService {
    @Resource
    private TemporaryDao dao;
    @Resource
    private FileService fileService;
    @Resource
    private FileDao fileDao;
    //实例化UUID工具类
    private UUIDUtil uuid = UUIDUtil.getInstance();
    private ExcelUtil excelUtil = ExcelUtil.getInstance();
    private Object str = "";

    @Override
    public Status temporaryService(MultipartFile[] files) {
        //设置文件编号
        String uuid = this.uuid.getUUID().toString();
        //文件上传
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
            //获取上传文件路径
            FileData file = this.fileDao.queryFileOneDao(uuid);
            StringBuilder sb = new StringBuilder(file.getBases());
            sb.append(file.getPath());
            //获取上传excel文件数据
            List<List<Object>> list = this.excelUtil.readExcel(sb.toString(), uuid);
            List<Corporation> data = getExcelData(list);
            int len = getExcelDataAnalysis(data);
            if (len > 0) {
                this.dao.temporaryDao(data);
            } else {
                return new Status(StatusEnum.NO_EXCEL_DATA.getCODE(), StatusEnum.NO_EXCEL_DATA.getEXPLAIN());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
        }
        return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
    }

    private List<Corporation> getExcelData(List<List<Object>> list) {
        List<Corporation> corData = new ArrayList<Corporation>();
        for (int i = 0, len = list.size(); i < len; ++i) {
            List<Object> data = list.get(i);
            Corporation cor = new Corporation();
            int d = data.size();
            for (int j = 0; j < d; ++j) {
                this.str = data.get(j);
                switch (j) {
                    case 0:
                        cor.setId((String) this.str);
                        break;
                    case 1:
                        cor.setCompany((String) this.str);
                        break;
                    case 2:
                        cor.setNature((String) this.str);
                        break;
                    case 3:
                        String price = String.valueOf(this.str);
                        cor.setRegisterCap(price);
                        break;
                    case 4:
                        cor.setCompanyIntro((String) this.str);
                        break;
                    case 5:
                        cor.setDetailAddress((String) this.str);
                        break;
                    case 6:
                        cor.setRegisterAddress((String) this.str);
                        break;
                    default:
                        break;
                }
            }
            corData.add(cor);
        }
        return corData;
    }

    private int getExcelDataAnalysis(List<Corporation> list) {
        int len = list.size();
        for (int i = 0; i < len; ++i) {
            if (list.get(i).getCompany() == "") {
                list.remove(i);
                --i;
                len = list.size();
            }
        }
        return len;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TemporaryServicelmpl)) return false;
        TemporaryServicelmpl that = (TemporaryServicelmpl) o;
        return Objects.equals(str, that.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str);
    }
}
