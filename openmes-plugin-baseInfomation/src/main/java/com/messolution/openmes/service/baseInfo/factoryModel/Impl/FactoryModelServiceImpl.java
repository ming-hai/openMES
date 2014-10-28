package com.messolution.openmes.service.baseInfo.factoryModel.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.googlecode.genericdao.dao.hibernate.GeneralDAOImpl;
import com.messolution.openmes.dao.baseInfo.factoryModel.EnterpriseDao;
import com.messolution.openmes.entitys.baseInfo.factoryModel.Enterprise;
import com.messolution.openmes.service.baseInfo.factoryModel.IFactoryModelService;

@Component("factoryModelService")
public class FactoryModelServiceImpl extends GeneralDAOImpl implements IFactoryModelService {

	@Autowired
	private EnterpriseDao enterpriseDao;
	
	public boolean saveOrUpdateEnterprise(Enterprise enterprise) {
		
		return enterpriseDao.saveOrUpdate(enterprise);
	}

	public Enterprise getEnterprise(String Id) {
	
		return enterpriseDao.get(Id);
	}

	public List<Enterprise> getEnterprise(String... Ids) {
		
		return enterpriseDao.get(Ids);
	}

	public List<Enterprise> findAllEnterprise() {
		
		return enterpriseDao.findAll();
	}

	public boolean deleteEnterprise(String... Ids) {
		
		return enterpriseDao.delete(Ids);
	}
	
	
	

}
