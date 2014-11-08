package com.messolution.openmes.service.baseInfo.factoryModel.Impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.googlecode.genericdao.dao.hibernate.GeneralDAOImpl;
import com.messolution.openmes.dao.baseInfo.factoryModel.AreaCategoryDao;
import com.messolution.openmes.dao.baseInfo.factoryModel.AreaDao;
import com.messolution.openmes.dao.baseInfo.factoryModel.EnterpriseDao;
import com.messolution.openmes.dao.baseInfo.factoryModel.SiteDao;
import com.messolution.openmes.dojo.dataModel.DojoTree;
import com.messolution.openmes.dojo.dataModel.DojoTreeItem;
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
	
	
	public DojoTree getFactoryModelTree(){	
		 DojoTree dojoTree = new DojoTree();
		 
		 List<DojoTreeItem> factoryRootItem = new ArrayList<DojoTreeItem>();
		 /** enterprise root **/
		 DojoTreeItem enterpriseRoot = new DojoTreeItem();
		 enterpriseRoot.setId("enterprise");
		 enterpriseRoot.setLabel("Enterpirses");
		 enterpriseRoot.setChildren(getEnterpriseItems());
		 factoryRootItem.add(enterpriseRoot);
		 
		 /** site root **/
		 DojoTreeItem siteRoot = new DojoTreeItem();
		 siteRoot.setId("site");
		 siteRoot.setLabel("Sites");
		 siteRoot.setChildren(getSiteItems());
		 factoryRootItem.add(siteRoot);
		 
		 /** site root **/
		 DojoTreeItem areaRoot = new DojoTreeItem();
		 areaRoot.setId("area");
		 areaRoot.setLabel("Area");
		 areaRoot.setChildren(getAreaItems());
		 factoryRootItem.add(areaRoot);
		 
		 
		 
		 dojoTree.getRootItem().setChildren(factoryRootItem);
		 return dojoTree;
	}
	
	private List<DojoTreeItem> getEnterpriseItems(){
        List<Enterprise> enterprises = enterpriseDao.findAll();
        List<DojoTreeItem> enterpriseItems = new ArrayList<DojoTreeItem>();
		for(Enterprise e:enterprises){
			DojoTreeItem Item = new DojoTreeItem();
			Item.setId(e.getId());
			Item.setLabel(e.getName());
			Item.setIcon("ocpIconCalendar");
			Item.setChildren(null);
			enterpriseItems.add(Item);
		}
		return enterpriseItems;
	}
	
	private List<DojoTreeItem> getSiteItems(){
        List<Site> sites = siteDao.findAll();
        List<DojoTreeItem> siteItems = new ArrayList<DojoTreeItem>();
		for(Site s:sites){
			DojoTreeItem Item = new DojoTreeItem();
			Item.setId(s.getId());
			Item.setLabel(s.getName());
			Item.setIcon("ocpIconCalendar");
			Item.setChildren(null);
			siteItems.add(Item);
		}
		return siteItems;
	}
	
	private List<DojoTreeItem> getAreaItems(){
        List<Area> areas = areaDao.findAll();
        List<DojoTreeItem> areaItems = new ArrayList<DojoTreeItem>();
		for(Area a:areas){
			DojoTreeItem Item = new DojoTreeItem();
			Item.setId(a.getId());
			Item.setLabel(a.getName());
			Item.setIcon("ocpIconCalendar");
			Item.setChildren(null);
			areaItems.add(Item);
		}
		return areaItems;
	}
	

}
