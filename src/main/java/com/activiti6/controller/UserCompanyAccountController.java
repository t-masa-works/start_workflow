package com.activiti6.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.activiti6.pagemodel.DataGrid;
import com.activiti6.pagemodel.MSG;
import com.activiti6.po.UserCompanyAccount;
import com.activiti6.po.UserRegisterInfo;
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

	// @PostMapping(value = "/user/input_money/confirm_money_input", params="validated")
	// public ResponseEntity<String> addUserCompanyAccount(@Valid @RequestBody UserCompanyAccount userCompanyAccount
	// ,BindingResult bindingResult) {
	// 		if (bindingResult.hasErrors()) {
	// 		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("必須項目が未記入です");
	// 		}
	// 		return ResponseEntity.ok("Success");
	// }


	@RequestMapping(value = "/user/input_money/show_company_account", method = RequestMethod.GET)
	public String showCompanyAccount() {
		return "/user/input_money/show_company_account";
	}

	@RequestMapping(value = "/user/input_money/confirm_money_input", method = RequestMethod.GET)
	public String confirmMoneyInput() {
		return "/user/input_money/confirm_money_input";
	}

	//startcompanyRegisterに送られたPOSTリクエストをこのメソッドで処理する
	@RequestMapping(value = "/startCompanyRegister", method = RequestMethod.POST)
	// シリアライズして送信するアノテーション
	@ResponseBody
	public MSG start_company_register(@Valid UserCompanyAccount userCompanyAccount, BindingResult bindingResult, HttpSession session) {
		System.out.println("Start of start_company_register method");
		
		if (bindingResult.hasErrors()) {
			System.out.println("Validation");
			return new MSG("failure");
			}
			
		String userid = (String) session.getAttribute("username");
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("applyuserid", userid);
		ProcessInstance ins = userCompanyAccountService.startWorkflow(userCompanyAccount, userid, variables);
		System.out.println("user registerThe method startWorkflow(UserCompanyAccount, String, Map< is started. ID:" + ins.getId());
		System.out.println("non Validation");
		return new MSG("success");
	}


	@RequestMapping(value = "/show_company_account", produces = {
		"application/json;charset=UTF-8" }, method = RequestMethod.POST)
	@ResponseBody
	public DataGrid<UserCompanyAccount> userCompanyAccountService(HttpSession session, @RequestParam("current") int current,
	@RequestParam("rowCount") int rowCount) {
		DataGrid<UserCompanyAccount> grid = new DataGrid<UserCompanyAccount>();
		grid.setRowCount(rowCount);
		grid.setCurrent(current);
		grid.setTotal(0);
		grid.setRows(new ArrayList<UserCompanyAccount>());
		String userid = (String) session.getAttribute("username");
		int uid = systemservice.getUidByusername(userid);
		List<UserCompanyAccount> userCompanyAccounts = userCompanyAccountService.getUserCompanyAccount(uid);
		
		grid.setRowCount(rowCount);
		grid.setCurrent(current);
		grid.setTotal(userCompanyAccounts.size());
		grid.setRows(userCompanyAccounts);
		return grid;
	}

}