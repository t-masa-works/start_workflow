package com.activiti6.controller;

import com.activiti6.pagemodel.Process;
import com.activiti6.pagemodel.*;
import com.activiti6.po.*;
import com.activiti6.service.LeaveService;
import com.activiti6.service.SystemService;
import com.activiti6.service.UserRegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.*;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "请假流程接口")
@Controller
public class userRegisterController {
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
	UserRegisterService userRegisterService;

	@RequestMapping(value = "/inputInfo", method = RequestMethod.GET)
	public String inputInfo() {
		return "user/input_infor/index";
	}

	@RequestMapping(value = "/startUserRegister", method = RequestMethod.POST)
	@ResponseBody
	public MSG start_user_register(UserRegisterInfo userRegisterInfo, HttpSession session) {
		String userid = (String) session.getAttribute("username");
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("applyuserid", userid);
		ProcessInstance ins = userRegisterService.startWorkflow(userRegisterInfo, userid, variables);
		System.out.println("user register is started. ID:" + ins.getId());
		return new MSG("sucess");
	}

}
