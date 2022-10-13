package com.activiti6.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.activiti6.po.UserCompanyAccount;

@Mapper
public interface UserCompanyAccountMapper {

    List<UserCompanyAccount> selectAll();

    List<UserCompanyAccount> getUserCompanyAccount(int id);

}