package com.activiti6.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.activiti6.bpmn.builder.ImageBpmnModelUtils;
import com.activiti6.bpmn.builder.ImageGenerator;
import com.activiti6.constant.ProcessConstants;
import com.activiti6.exception.ProcessException;
import com.activiti6.service.PhotoService;
import lombok.extern.slf4j.Slf4j;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.GraphicInfo;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 流程定义管理Service组件
 * 
 * @author lhj
 */
@Service
@Slf4j
public class PhotoServiceImpl implements PhotoService {

    @Resource
    private RepositoryService repositoryService;

    @Resource
    private ObjectMapper objectMapper;

    /**
     * 根据bpmn文件导入增加模型
     *
     * @param file 上传的文件
     * @return 增加的模型信息
     */
    @Override
    public Boolean importPhoto(MultipartFile file) {
        try {
            // 新增模型数据并增加模型的xml和图片
            String filename = file.getOriginalFilename();
            InputStream is = file.getInputStream();
            asFile(is);
            return true;
        } catch (Exception e) {
            log.error("文件解释出错，请检查文件是否为bpmn2.0标准格式", e);
            throw new ProcessException("文件解释出错，请检查文件是否为bpmn2.0标准格式");
        }
    }

    public static File asFile(InputStream inputStream) throws IOException {
        File tmp = File.createTempFile("lzq", ".tmp", new File("C:\\"));
        OutputStream os = new FileOutputStream(tmp);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        return tmp;
    }

    /**
     * 更新model并更新model对应的资源文件(json和png)
     *
     * @param model     模型对象
     * @param bpmnModel 模型的bpmnModel对象
     * @param jsonNode  模型的json数据
     * @throws IOException
     */

    public void updateModelAndSource(Model model, BpmnModel bpmnModel, JsonNode jsonNode) throws IOException {
        repositoryService.saveModel(model);
        byte[] result = null;
        // 保存流程模型的资源(即json数据保存到act_ge_bytearray表)
        this.repositoryService.addModelEditorSource(model.getId(),
                jsonNode.toString().getBytes(ProcessConstants.COMMON_CHARACTER_ENCODING_UTF_8));
        // 将图片的大小进行缩小
        double scaleFactor = 1.0;
        GraphicInfo diagramInfo = ImageBpmnModelUtils.calculateDiagramSize(bpmnModel);
        if (diagramInfo.getWidth() > 300f) {
            scaleFactor = diagramInfo.getWidth() / 300f;
            ImageBpmnModelUtils.scaleDiagram(bpmnModel, scaleFactor);
        }
        // 按比例生成图片资源
        BufferedImage modelImage = ImageGenerator.createImage(bpmnModel, scaleFactor);
        if (modelImage != null) {
            result = ImageGenerator.createByteArrayForImage(modelImage, "png");
        }
        // 保存图片资源到act_ge_bytearray表
        if (result != null && result.length > 0) {
            this.repositoryService.addModelEditorSourceExtra(model.getId(), result);
        }
    }

}
