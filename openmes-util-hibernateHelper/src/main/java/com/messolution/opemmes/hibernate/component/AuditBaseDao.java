package com.messolution.opemmes.hibernate.component;

import java.io.Serializable;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.messolution.opemmes.hibernate.common.IEntity;
import com.messolution.opemmes.hibernate.constants.HibernateConstants;

public class AuditBaseDao<T, ID extends Serializable>  extends  GenericDAOImpl<T, ID>{

	/**
	 * 逻辑删除关键字为 ids 中的对象
	 *  a tombstoned object possesses an db_status attribute that's set to HibernateConstants.DELETED
	 * @param ids
	 */
	public boolean logicDelete(String... ids) {
		if (null == ids) return false;
		try {
			for (String id : ids) {
				T t =  _get(persistentClass,(ID)id);
				if (!(t instanceof IEntity)) continue; 
				IEntity obj = (IEntity) t;
				obj.setDb_status(HibernateConstants.DELETED);
				save( (T) obj );
			}
		} catch (Exception e) {
			e.printStackTrace();
		    return false;
		}
		return true;
	}
	

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	

}
