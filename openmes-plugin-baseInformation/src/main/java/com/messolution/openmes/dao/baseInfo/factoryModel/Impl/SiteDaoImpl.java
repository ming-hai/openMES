/**
 * SiteDaoImpl.java
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
import com.messolution.openmes.dao.baseInfo.factoryModel.SiteDao;
import com.messolution.openmes.entitys.baseInfo.factoryModel.Site;

/**
 * 
 * @declaration:
 * @project : openmes-plugin-baseInfomation
 * @package : com.messolution.openmes.dao.baseInfo.factoryModel.Impl
 * @create_time :2014年10月29日 下午9:08:09
 * @author : panzhichun
 * @mail : mmcpanzhichun@gmail.com
 */
@Component("siteDao")
public class SiteDaoImpl extends AuditBaseDao<Site, String> implements SiteDao {


	public boolean saveOrUpdate(Site site) {
		try{
			_saveOrUpdate(site);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}


	public Site get(String Id) {
		return find(Id);
	}


	public List<Site> get(String... Ids) {
	
		return Arrays.asList(find(Ids));
	}


	public boolean delete(String... Ids) {
		return logicDelete(Ids);
	}


	public List<Site> findAll() {
		return search(new Search().addFilterEqual("db_status", HibernateConstants.ACTIVE));
	}

}
