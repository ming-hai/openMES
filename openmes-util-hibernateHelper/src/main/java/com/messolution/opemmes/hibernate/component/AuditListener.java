package com.messolution.opemmes.hibernate.component;


import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.event.spi.SaveOrUpdateEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.messolution.opemmes.hibernate.common.IEntity;
import com.messolution.opemmes.hibernate.constants.HibernateConstants;

/**
 * 在自动为entity添加审计信息的Hibernate EventListener.
 * @declaration:在hibernate执行saveOrUpdate()时,自动为AuditableEntity的子类添加审计信息.
 * @project : openmes-util-hibernateHelper
 * @package : com.messolution.opemmes.hibernata.component
 * @create_time : 2014年10月25日下午9:56:09
 * @author : panzhichun
 * @mail : mmcpanzhichun@gmail.com
 */

@Component
public class AuditListener implements SaveOrUpdateEventListener {

	
	
	private static final long serialVersionUID = -6809111211130380975L;
	private static Logger logger = LoggerFactory.getLogger(AuditListener.class);
	
	/**
	 * 
	 * @declaration:
	 * @enclosing_method: onSaveOrUpdate
	 * @param event
	 * @throws HibernateException
	 * @author:panzhichun
	 * @creat_time:2014年10月25日下午9:56:20
	 * @throws
	 */
	public void onSaveOrUpdate(SaveOrUpdateEvent event)throws HibernateException {
		String creator_Id = "11111111111111111111111111111111";
		String modifier_Id = "22222222222222222222222222222222";
		Object object = event.getObject();
		
		 if (object instanceof IEntity) {
			IEntity entity = (IEntity) object;

			/**
			 * 如果实体id为""字符串，则设置id为空
			 */
			if(entity.getId() == null || entity.getId().equals("")){
				entity.setId(null);
			}
			/**
			 * 判断实体的id是否为空
			 */
			if (entity.getId() == null) {
				// 创建新对象
				entity.setCreation_time(new Timestamp(System.currentTimeMillis()));
				entity.setCreator_Id(creator_Id);
				entity.setDb_status(HibernateConstants.ACTIVE);
			} else {
				// 修改旧对象
				entity.setLast_modified_time(new Timestamp(System
						.currentTimeMillis()));
				entity.setLast_modifier_Id(modifier_Id);

				logger.info("{}对象(ID:{}) 被 {} 在 {} 修改",
						new Object[] { event.getObject(), entity.getId(),
						modifier_Id, new Date() });
			}
		 }
	}

}
