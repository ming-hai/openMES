package com.messolution.openmes.service.baseInfo.factoryModel;

import java.util.List;

import com.messolution.openmes.entitys.baseInfo.factoryModel.Area;
import com.messolution.openmes.entitys.baseInfo.factoryModel.AreaCategory;
import com.messolution.openmes.entitys.baseInfo.factoryModel.Enterprise;
import com.messolution.openmes.entitys.baseInfo.factoryModel.Site;


public interface IFactoryModelService {

    public boolean saveOrUpdateEnterprise(Enterprise enterprise);
    
    public Enterprise getEnterprise(String Id);
    
    public List<Enterprise> getEnterprise(String ...Ids);
    
    public List<Enterprise> findAllEnterprise();
    
    public boolean deleteEnterprise(String ...Ids);
    
    public boolean saveOrUpdateSite(Site site);
    
    public Site getSite(String Id);
    
    public List<Site> getSite(String ...Ids);
    
    public List<Site> findAllSite();
    
    public boolean deleteSite(String ...Ids);
    
    public boolean saveOrUpdateArea(Area area);
    
    public Area getArea(String Id);
    
    public List<Area> getArea(String ...Ids);
    
    public List<Area> findAllArea();
    
    public boolean deleteArea(String ...Ids);
    
   public boolean saveOrUpdateAreaCategory(AreaCategory areaCategory);
    
    public AreaCategory getAreaCategory(String Id);
    
    public List<AreaCategory> getAreaCategory(String ...Ids);
    
    public List<AreaCategory> findAllAreaCategory();
    
    public boolean deleteAreaCategory(String ...Ids);
    
    
}
