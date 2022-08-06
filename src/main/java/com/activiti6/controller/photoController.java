package com.activiti6.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

// import com.alibaba.fastjson.JSON;
import com.activiti6.pagemodel.Process;
import com.activiti6.exception.ProcessException;
import com.activiti6.pagemodel.DataGrid;
import com.activiti6.pagemodel.HistoryProcess;
import com.activiti6.pagemodel.LeaveTask;
import com.activiti6.pagemodel.MSG;
import com.activiti6.pagemodel.RunningProcess;
import com.activiti6.po.LeaveApply;
import com.activiti6.po.Permission;
import com.activiti6.po.Role;
import com.activiti6.po.Role_permission;
import com.activiti6.po.User;
import com.activiti6.po.User_role;
import com.activiti6.service.LeaveService;
import com.activiti6.service.ProcessDefineService;
import com.activiti6.service.SystemService;
import com.activiti6.service.PhotoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "请假流程接口")
@Controller
public class photoController {
	@Autowired
	RepositoryService rep;
	@Autowired
	RuntimeService runservice;
	@Autowired
	FormService formservice;
	@Autowired
	IdentityService identityservice;
	@Autowired
	LeaveService leaveservice;
	@Autowired
	TaskService taskservice;
	@Autowired
	HistoryService histiryservice;
	@Autowired
	SystemService systemservice;
	@Autowired
	private PhotoService photoService;

	@RequestMapping(value = "/importPhoto", method = RequestMethod.POST)
	public void importPhoto(@RequestParam MultipartFile uploadfile, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			photoService.importPhoto(uploadfile);
			response.sendRedirect("/user/upload_user_certificate");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/uploadPhoto", method = RequestMethod.POST)
	public String uploadPhoto(@RequestParam MultipartFile uploadfile,
			HttpServletRequest request) {
		try {
			MultipartFile file = uploadfile;
			String filename = file.getOriginalFilename();
			InputStream is = file.getInputStream();
			rep.createDeployment().addInputStream(filename, is).deploy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "system_manager/process_list/index";
	}

}