package com.messolution.openmes.dao.baseInfo.factoryModel.Impl;

import java.util.Arrays;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.messolution.opemmes.hibernate.component.AuditBaseDao;
import com.messolution.openmes.dao.baseInfo.factoryModel.EnterpriseDao;
import com.messolution.openmes.entitys.baseInfo.factoryModel.Enterprise;
/**
 * 
 * @declaration:
 * @project : openmes-plugin-baseInfomation
 * @package : com.messolution.openmes.baseInfo.dao.factoryModel.Impl
 * @create_time : 2014年10月26日下午3:17:22
 * @author : panzhichun
 * @mail : mmcpanzhichun@gmail.com
 */

@Component("enterpriseDao")
public class EnterpriseDaoImpl extends AuditBaseDao<Enterprise, String > implements EnterpriseDao {

	public boolean saveOrUpdate(Enterprise enterprise) {
		try{
			_saveOrUpdate(enterprise);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Enterprise get(String Id) {
		return find(Id);
	}

	public List<Enterprise> get(String... Ids) {
		return Arrays.asList(find(Ids)) ;
	}

	public boolean delete(String... Ids) {
		return logicDelete(Ids);
	}

	public List<Enterprise> findAll(){
		return super.findAll();
	}
	
	
	


    

}
