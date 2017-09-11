package com.goodsoft.yuanlin.util;

import com.goodsoft.yuanlin.domain.entity.demand.SeedlingOffer;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * function Excel表格工具类
 * Created by 严彬荣 on 2017/9/4.
 * version v1.0
 */
@SuppressWarnings("ALL")
public class ExcelUtil {
    /**
     * 创建ExcelUtil类的单例（详情见本包下UUIDUtil类） start
     **/
    private volatile static ExcelUtil instance;

    private ExcelUtil() {
    }

    public static ExcelUtil getInstance() {
        if (instance == null) {
            synchronized (ExcelUtil.class) {
                if (instance == null)
                    instance = new ExcelUtil();
            }
        }
        return instance;
    }

    /**
     * 读取excel
     *
     * @param path   文件路径
     * @param fileId 文件编号
     * @return 读取数据
     * @throws Exception
     */
    public List<List<SeedlingOffer>> readExcel(String path, String fileId) throws Exception {
        //获取文件 start
        File file = new File(path);
        FileInputStream is = new FileInputStream(file);
        //获取文件 end
        //读取excel start
        XSSFWorkbook wb;
        try {
            wb = new XSSFWorkbook(is);
            //读取excel end
            return getSheetExcel(wb, fileId);
        } finally {
            is.close();
        }
    }


    /**
     * 读取excel表
     *
     * @param fileId 文件编号
     * @param wb     读取到的表格
     * @return 读取数据
     */
    private List<List<SeedlingOffer>> getSheetExcel(XSSFWorkbook wb, String fileId) {
        List<List<SeedlingOffer>> list = new ArrayList<>();
        //读取表格数 start
        int st = wb.getNumberOfSheets();
        //遍历excel表格数
        for (int i = 0; i < st; ++i) {
            XSSFSheet sheet = wb.getSheetAt(i);
            if (sheet != null) {
                List<SeedlingOffer> soList = getRowExcel(sheet, fileId);
                list.add(soList);
            }
        }
        //读取表格数 end
        return list;
    }

    /**
     * 读取表格数据
     *
     * @param fileId 文件编号
     * @param sheet  读取的表
     * @return 读取数据
     */
    private List<SeedlingOffer> getRowExcel(XSSFSheet sheet, String fileId) {
        //初始化集合存放读取表格数据
        List<SeedlingOffer> list = new ArrayList<SeedlingOffer>();
        XSSFRow row;
        XSSFCell cell;
        //读取表格中的数据 start
        int rowCount = sheet.getLastRowNum();
        //遍历行
        for (int i = sheet.getFirstRowNum() + 1; i < rowCount; ++i) {
            //实例化读取文件内容实体
            SeedlingOffer so = new SeedlingOffer();
            row = sheet.getRow(i);
            //判断读取行是否为空且是否为最后一行
            if (row != null && i != rowCount) {
                //遍历列
                for (int j = row.getFirstCellNum() + 1, cellCount = row.getLastCellNum(); j < cellCount; ++j) {
                    cell = row.getCell(j);
                    if (cell != null && cell.getCellType() != XSSFCell.CELL_TYPE_BLANK) {
                        so.setFileId(fileId);
                        switch (j) {
                            case 1:
                                try {
                                    so.setMaterial(cell.getStringCellValue());
                                } catch (Exception e) {
                                    so.setMaterial(String.valueOf(cell.getNumericCellValue()));
                                }
                                break;
                            case 2:
                                try {
                                    so.setSpecification(cell.getStringCellValue());
                                } catch (Exception e) {
                                    so.setSpecification(String.valueOf(cell.getNumericCellValue()));
                                }
                                break;
                            case 3:
                                try {
                                    so.setUnit(cell.getStringCellValue());
                                } catch (Exception e) {
                                    so.setUnit(String.valueOf(cell.getNumericCellValue()));
                                }
                                break;
                            case 4:
                                try {
                                    so.setPrice(cell.getNumericCellValue());
                                } catch (Exception e) {
                                    so.setPrice(0.00);
                                }
                                break;
                            case 5:
                                try {
                                    so.setTypes(cell.getStringCellValue());
                                } catch (Exception e) {
                                    so.setTypes(String.valueOf(cell.getNumericCellValue()));
                                }
                                break;
                            case 6:
                                try {
                                    so.setDate(new SimpleDateFormat("yyyy-MM-dd").format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())));
                                } catch (Exception e) {
                                    so.setDate(cell.getStringCellValue());
                                }
                                break;
                            case 7:
                                try {
                                    so.setComment(cell.getStringCellValue());
                                } catch (Exception e) {
                                    so.setComment(String.valueOf(cell.getNumericCellValue()));
                                }
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
            if (so.getMaterial() != null && so.getPrice() != 0.0 && so.getTypes() != null) {
                list.add(so);
            }
        }
        //读取表格中的数据 end
        return list;
    }
}
