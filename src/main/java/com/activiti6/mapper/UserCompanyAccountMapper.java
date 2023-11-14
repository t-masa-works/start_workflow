package com.activiti6.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.activiti6.po.UserCompanyAccount;

@Mapper
public interface UserCompanyAccountMapper {
    // 新規登録するために必要な記述
    void save(UserCompanyAccount userCompanyAccount);
    // データベース内の全てのレコードを取得するメソッド
    List<UserCompanyAccount> selectAll();
    // データベース内の指定されたIDに基づいて、一意の単一レコードを取得
    List<UserCompanyAccount> getUserCompanyAccount(int id);
    // 指定されたレコードをデータベースで更新するメソッド
    int updateByPrimaryKey(UserCompanyAccount record);
}