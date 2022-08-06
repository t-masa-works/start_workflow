package com.activiti6.service;

import org.springframework.web.multipart.MultipartFile;

public interface PhotoService {

    /**
     * 根据bpmn文件导入增加模型
     *
     * @param file 上传的文件
     * @return 增加的模型信息
     */
    Boolean importPhoto(MultipartFile file);

}