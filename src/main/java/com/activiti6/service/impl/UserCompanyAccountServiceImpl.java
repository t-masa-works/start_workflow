package com.activiti6.service.impl;

import com.activiti6.mapper.UserCompanyAccountMapper;
import com.activiti6.po.UserCompanyAccount;
import com.activiti6.po.UserRegisterInfo;
import com.activiti6.service.UserCompanyAccountService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Slf4j
public class UserCompanyAccountServiceImpl implements UserCompanyAccountService {
    @Autowired
    UserCompanyAccountMapper userCompanyAccountMapper;
    @Autowired
	IdentityService identityservice;
	@Autowired
	RuntimeService runtimeservice;
    
    /**
     * Description: 查询分类
     * 
     * @date 2022/1/5
     * @author taimi
     * @param
     * @return
     * @throws
     */

    @Override
    public ProcessInstance startWorkflow(UserCompanyAccount userCompanyAccount, String userid, Map<String, Object> variables) {
		userCompanyAccount.setApply_time(new Date().toString());
		userCompanyAccount.setUser_id(userid);
		userCompanyAccountMapper.save(userCompanyAccount);
		String businesskey=String.valueOf(userCompanyAccount.getId());// user_register_info テーブルの主キーをビジネスキーとして使用して、ビジネス データとプロセス データを接続します
		identityservice.setAuthenticatedUserId(userid);
		ProcessInstance instance=runtimeservice.startProcessInstanceByKey("userregiste",businesskey,variables);
		System.out.println(businesskey);
		String instanceid=instance.getId();
		userCompanyAccount.setProcess_instance_id(instanceid);
		userCompanyAccountMapper.updateByPrimaryKey(userCompanyAccount);
		return instance;
	}

    @Override
    public List<UserCompanyAccount> getUserCompanyAccount(int id) {

        List<UserCompanyAccount> userCompanyAccounts = userCompanyAccountMapper.getUserCompanyAccount(id);

        return userCompanyAccounts;

    }
}