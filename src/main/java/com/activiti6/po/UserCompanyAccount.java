package com.activiti6.po;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;

import org.activiti.engine.task.Task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("ユーザーcompanyaccount情報")
public class UserCompanyAccount implements Serializable {
    @ApiModelProperty("id")
    int id;

    @ApiModelProperty("process_instance_id")
	String process_instance_id;

    @ApiModelProperty("company_name")
    @NotBlank(message = "会社名は必須項目です")
    String company_name;

    @ApiModelProperty("bank_name")
    @NotBlank(message = "銀行名は必須項目です")
    String bank_name;

    @ApiModelProperty("account")
    String account;
    @ApiModelProperty("account_number")
    String account_number;
    @ApiModelProperty("user_id")
	String user_id;
	@ApiModelProperty("apply_time")
	String apply_time;
	@ApiModelProperty("manager_check_time")
	String manager_check_time;
	@ApiModelProperty("superManager_check_time")
	String superManager_check_time;
	@ApiModelProperty("remarks")
	String remarks;
    Task task;

    public int getId() {
        return id;
    }

    public String getProcess_instance_id() { return process_instance_id; }
	public void setProcess_instance_id(String process_instance_id) { this.process_instance_id = process_instance_id; }

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

    public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getApply_time() {
		return apply_time;
	}
	public void setApply_time(String apply_time) {
		this.apply_time = apply_time;
	}

	public String getManager_check_time() {
		return manager_check_time;
	}
	public void setManager_check_time(String manager_check_time) { this.manager_check_time = manager_check_time; }

	public String getSuperManager_check_time() {
		return superManager_check_time;
	}
	public void setSuperManager_check_time(String superManager_check_time) { this.superManager_check_time = superManager_check_time; }

	public String getRemarks() { return remarks; }
	public void setRemarks(String remarks) { this.remarks = remarks; }
}
