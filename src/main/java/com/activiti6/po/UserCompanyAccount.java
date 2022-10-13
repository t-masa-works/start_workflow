package com.activiti6.po;

import java.io.Serializable;

import org.activiti.engine.task.Task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("ユーザーcompanyaccount情報")
public class UserCompanyAccount implements Serializable {
    @ApiModelProperty("id")
    int id;
    @ApiModelProperty("company_name")
    String company_name;
    @ApiModelProperty("bank_name")
    String bank_name;
    @ApiModelProperty("account")
    String account;
    @ApiModelProperty("account_number")
    String account_number;
    Task task;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setIAccount_number(String account_number) {
        this.account_number = account_number;
    }
}
