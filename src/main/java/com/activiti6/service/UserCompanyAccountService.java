package com.activiti6.service;

// javaのMap型やList型を使用する場合に必要
import java.util.List;
import java.util.Map;

import com.activiti6.po.UserCompanyAccount;
// ProcessInstanceを使用したい場合必要なActiveエンジンのランタイム
import org.activiti.engine.runtime.ProcessInstance;

public interface UserCompanyAccountService {
  public ProcessInstance startWorkflow(UserCompanyAccount userCompanyAccount,String id, Map<String, Object> variables);
        /**
         * 查询首页分类
         * 
         * @return
         */

  public List<UserCompanyAccount> getUserCompanyAccount(int id);
}
