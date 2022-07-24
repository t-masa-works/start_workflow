package com.activiti6.service;

import com.activiti6.po.UserRegisterInfo;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.List;
import java.util.Map;


public interface UserRegisterService {
	public ProcessInstance startWorkflow(UserRegisterInfo userRegisterInfo,String userid,Map<String,Object> variables);
	public List<UserRegisterInfo> getpagedepttask(String userid,int firstrow,int rowcount);
	public int getalldepttask(String userid);
	public UserRegisterInfo getUserRegisterInfo(int id);
	public List<UserRegisterInfo> getpagehrtask(String userid,int firstrow,int rowcount);
	public int getallhrtask(String userid);
	public List<UserRegisterInfo> getpageXJtask(String userid,int firstrow,int rowcount);
	public int getallXJtask(String userid);
	public List<UserRegisterInfo> getpageupdateapplytask(String userid,int firstrow,int rowcount);
	public int getallupdateapplytask(String userid);
	public void completereportback(String taskid, String realstart_time, String realend_time);
	public void updatecomplete(String taskid, UserRegisterInfo userRegisterInfo,String reappply);
	public List<String> getHighLightedFlows(ProcessDefinitionEntity deployedProcessDefinition,List<HistoricActivityInstance> historicActivityInstances);
}
