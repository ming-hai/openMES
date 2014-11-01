/**
 * AreaCategoryDaoImpl.java
 * com.messolution.openmes.dao.baseInfo.factoryModel.Impl
 * 2014年10月29日 : 2014年10月29日
 * author:panzhichun
 * email:mmcpanzhichun@gmail.com
 */
package com.messolution.openmes.dao.baseInfo.factoryModel.Impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.messolution.opemmes.hibernate.component.AuditBaseDao;
import com.messolution.openmes.dao.baseInfo.factoryModel.AreaCategoryDao;
import com.messolution.openmes.entitys.baseInfo.factoryModel.Area;
import com.messolution.openmes.entitys.baseInfo.factoryModel.AreaCategory;

/**
 * 
 * @declaration:
 * @project : openmes-plugin-baseInfomation
 * @package : com.messolution.openmes.dao.baseInfo.factoryModel.Impl
 * @create_time :2014年10月29日 下午9:36:58
 * @author : panzhichun
 * @mail : mmcpanzhichun@gmail.com
 */
@Component("areaCategoryDao")
public class AreaCategoryDaoImpl extends AuditBaseDao<AreaCategory, String> implements
		AreaCategoryDao {

	public boolean saveOrUpdate(AreaCategory areaCategory) {
		try{
			_saveOrUpdate(areaCategory);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public AreaCategory get(String Id) {
		
		return find(Id);
	}

	public List<AreaCategory> get(String... Ids) {
		
		return Arrays.asList(find(Ids));
	}

	public boolean delete(String... Ids) {
		return logicDelete(Ids);
	}

	public List<AreaCategory> findAll() {
		return super.findAll();
	}

}
