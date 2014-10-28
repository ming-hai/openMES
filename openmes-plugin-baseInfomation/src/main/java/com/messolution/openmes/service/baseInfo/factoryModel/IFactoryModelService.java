package com.messolution.openmes.service.baseInfo.factoryModel;

import java.util.List;

import com.messolution.openmes.entitys.baseInfo.factoryModel.Enterprise;


public interface IFactoryModelService {

    public boolean saveOrUpdateEnterprise(Enterprise enterprise);
    
    public Enterprise getEnterprise(String Id);
    
    public List<Enterprise> getEnterprise(String ...Ids);
    
    public List<Enterprise> findAllEnterprise();
    
    public boolean deleteEnterprise(String ...Ids);
}
