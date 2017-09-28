package com.goodsoft.yuanlin.temporary;

import com.goodsoft.yuanlin.util.resultentity.Status;
import org.springframework.web.multipart.MultipartFile;

/**
 * function 法人库数据导入接口类
 * Created by 法人库 on 2017/9/28.
 */
public interface TemporaryService {

    public Status temporaryService(MultipartFile[] files);
}
