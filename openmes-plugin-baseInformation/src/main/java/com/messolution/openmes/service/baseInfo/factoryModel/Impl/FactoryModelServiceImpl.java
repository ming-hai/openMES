package com.messolution.openmes.service.baseInfo.factoryModel.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.googlecode.genericdao.dao.hibernate.GeneralDAOImpl;
import com.messolution.openmes.dao.baseInfo.factoryModel.AreaCategoryDao;
import com.messolution.openmes.dao.baseInfo.factoryModel.AreaDao;
import com.messolution.openmes.dao.baseInfo.factoryModel.EnterpriseDao;
import com.messolution.openmes.dao.baseInfo.factoryModel.SiteDao;
import com.messolution.openmes.entitys.baseInfo.factoryModel.Area;
import com.messolution.openmes.entitys.baseInfo.factoryModel.AreaCategory;
import com.messolution.openmes.entitys.baseInfo.factoryModel.Enterprise;
import com.messolution.openmes.entitys.baseInfo.factoryModel.Site;
import com.messolution.openmes.service.baseInfo.factoryModel.IFactoryModelService;

@Component("factoryModelService")
public class FactoryModelServiceImpl extends GeneralDAOImpl implements IFactoryModelService {

	@Autowired
	private EnterpriseDao enterpriseDao;
	
	@Autowired
	private SiteDao siteDao;
	
	@Autowired
	private AreaDao areaDao;
	
	@Autowired
	private AreaCategoryDao areaCategoryDao;
	
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

	public boolean saveOrUpdateSite(Site site) {
		
		return siteDao.saveOrUpdate(site);
	}

	public Site getSite(String Id) {
		return siteDao.get(Id);
	}

	public List<Site> getSite(String... Ids) {
		
		return siteDao.get(Ids);
	}

	public List<Site> findAllSite() {
	
		return siteDao.findAll();
	}

	public boolean deleteSite(String... Ids) {
		
		return siteDao.delete(Ids);
	}

	public boolean saveOrUpdateArea(Area area) {
		
		return areaDao.saveOrUpdate(area);
	}

	public Area getArea(String Id) {
		return areaDao.get(Id);
	}

	public List<Area> getArea(String... Ids) {
		return areaDao.get(Ids);
	}

	public List<Area> findAllArea() {
		return areaDao.findAll();
	}

	public boolean deleteArea(String... Ids) {
		return areaDao.delete(Ids);
	}

	public boolean saveOrUpdateAreaCategory(AreaCategory areaCategory) {
		
		return areaCategoryDao.saveOrUpdate(areaCategory);
	}

	public AreaCategory getAreaCategory(String Id) {
		
		return areaCategoryDao.get(Id);
	}

	public List<AreaCategory> getAreaCategory(String... Ids) {
		
		return areaCategoryDao.get(Ids);
	}

	public List<AreaCategory> findAllAreaCategory() {
		
		return areaCategoryDao.findAll();
	}

	public boolean deleteAreaCategory(String... Ids) {
		
		return areaCategoryDao.delete(Ids);
	}
	
	
	

}
