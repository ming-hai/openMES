/**
 * SiteDao.java
 * com.messolution.openmes.dao.baseInfo.factoryModel
 * 2014年10月29日 : 2014年10月29日
 * author:panzhichun
 * email:mmcpanzhichun@gmail.com
 */
package com.messolution.openmes.dao.baseInfo.factoryModel;

import java.util.List;

import com.messolution.openmes.entitys.baseInfo.factoryModel.Site;

/**
 * 
 * @declaration:
 * @project : openmes-plugin-baseInfomation
 * @package : com.messolution.openmes.dao.baseInfo.factoryModel
 * @create_time :2014年10月29日 下午9:06:45
 * @author : panzhichun
 * @mail : mmcpanzhichun@gmail.com
 */
public interface SiteDao {

    public boolean saveOrUpdate(Site site);
	
	public Site get(String Id);
	
	public List<Site> get(String ...Ids);
	
	public boolean delete(String ...Ids);
	
	public List<Site> findAll();
	
}
