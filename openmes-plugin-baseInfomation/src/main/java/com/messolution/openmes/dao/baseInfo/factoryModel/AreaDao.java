/**
 * AreaDao.java
 * com.messolution.openmes.dao.baseInfo.factoryModel
 * 2014年10月29日 : 2014年10月29日
 * author:panzhichun
 * email:mmcpanzhichun@gmail.com
 */
package com.messolution.openmes.dao.baseInfo.factoryModel;

import java.util.List;

import com.messolution.openmes.entitys.baseInfo.factoryModel.Area;

/**
 * 
 * @declaration:
 * @project : openmes-plugin-baseInfomation
 * @package : com.messolution.openmes.dao.baseInfo.factoryModel
 * @create_time :2014年10月29日 下午9:16:44
 * @author : panzhichun
 * @mail : mmcpanzhichun@gmail.com
 */
public interface AreaDao {
    
	public boolean saveOrUpdate(Area area);
	
	public Area get(String Id);
	
	public List<Area> get(String ...Ids);
	
	public boolean delete(String ...Ids);
	
	public List<Area> findAll();
}
