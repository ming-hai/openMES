package com.messolution.openmes.dao.baseInfo.factoryModel;

import java.util.List;

import com.messolution.openmes.entitys.baseInfo.factoryModel.Enterprise;

public interface EnterpriseDao {

	public boolean saveOrUpdate(Enterprise enterprise);
	
	public Enterprise get(String Id);
	
	public List<Enterprise> get(String ...Ids);
	
	public boolean delete(String ...Ids);
	
	public List<Enterprise> findAll();
	
}
