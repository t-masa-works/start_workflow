
package com.activiti6.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.activiti6.po.UserCompanyAccount;
import com.activiti6.service.LeaveService;
import com.activiti6.service.SystemService;
import com.activiti6.service.UserCompanyAccountService;

@Controller
public class UserCompanyAccountController {
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
	UserCompanyAccountService userCompanyAccountService;

	@RequestMapping(value = "/user/input_money/show_company_account", method = RequestMethod.GET)
	public String showCompanyAccount() {
		return "/user/show_company_account/index";
	}

	@RequestMapping(value = "/show_company_account", method = RequestMethod.POST)
	@ResponseBody
	public List<UserCompanyAccount> userCompanyAccountService(HttpSession session) {

		String userid = (String) session.getAttribute("username");

		int uid = systemservice.getUidByusername(userid);

		List<UserCompanyAccount> userCompanyAccounts = userCompanyAccountService.getUserCompanyAccount(uid);

		return userCompanyAccounts;

	}

}