/**
 * AreaCategory.java
 * com.messolution.openmes.dao.baseInfo.factoryModel
 * 2014年10月29日 : 2014年10月29日
 * author:panzhichun
 * email:mmcpanzhichun@gmail.com
 */
package com.messolution.openmes.dao.baseInfo.factoryModel;

import java.util.List;

import com.messolution.openmes.entitys.baseInfo.factoryModel.Area;
import com.messolution.openmes.entitys.baseInfo.factoryModel.AreaCategory;

/**
 * 
 * @declaration:
 * @project : openmes-plugin-baseInfomation
 * @package : com.messolution.openmes.dao.baseInfo.factoryModel
 * @create_time :2014年10月29日 下午9:35:44
 * @author : panzhichun
 * @mail : mmcpanzhichun@gmail.com
 */
public interface AreaCategoryDao {
	  
	public boolean saveOrUpdate(AreaCategory areaCategory);
	
	public AreaCategory get(String Id);
	
	public List<AreaCategory> get(String ...Ids);
	
	public boolean delete(String ...Ids);
	
	public List<AreaCategory> findAll();
}
