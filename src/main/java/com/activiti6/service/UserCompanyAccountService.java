package com.activiti6.service;

import java.util.List;

import com.activiti6.po.UserCompanyAccount;

public interface UserCompanyAccountService {

        /**
         * 查询首页分类
         * 
         * @return
         */

        List<UserCompanyAccount> getUserCompanyAccount(int id);
}
