/**
 * AreaDaoImpl.java
 * com.messolution.openmes.dao.baseInfo.factoryModel.Impl
 * 2014年10月29日 : 2014年10月29日
 * author:panzhichun
 * email:mmcpanzhichun@gmail.com
 */
package com.messolution.openmes.dao.baseInfo.factoryModel.Impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.googlecode.genericdao.search.Search;
import com.messolution.opemmes.hibernate.component.AuditBaseDao;
import com.messolution.opemmes.hibernate.constants.HibernateConstants;
import com.messolution.openmes.dao.baseInfo.factoryModel.AreaDao;
import com.messolution.openmes.entitys.baseInfo.factoryModel.Area;

/**
 * 
 * @declaration:
 * @project : openmes-plugin-baseInfomation
 * @package : com.messolution.openmes.dao.baseInfo.factoryModel.Impl
 * @create_time :2014年10月29日 下午9:23:20
 * @author : panzhichun
 * @mail : mmcpanzhichun@gmail.com
 */
@Component("areaDao")
public class AreaDaoImpl extends AuditBaseDao<Area, String> implements AreaDao {

	
	public boolean saveOrUpdate(Area area) {
		try{
			_saveOrUpdate(area);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	public Area get(String Id) {
		
		return find(Id);
	}

	
	public List<Area> get(String... Ids) {
		
		return Arrays.asList(find(Ids));
	}

	
	public boolean delete(String... Ids) {
		
		return logicDelete(Ids);
	}

	
	public List<Area> findAll() {
		
		return search(new Search().addFilterEqual("db_status", HibernateConstants.ACTIVE));
	}

}
