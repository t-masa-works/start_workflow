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
    String companyName;
    @ApiModelProperty("bank_name")
    String bankName;
    @ApiModelProperty("account")
    String account;
    @ApiModelProperty("account_number")
    String accountNumber;
    Task task;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setIAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
