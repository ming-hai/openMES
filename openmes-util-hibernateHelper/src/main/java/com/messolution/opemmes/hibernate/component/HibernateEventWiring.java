package com.messolution.opemmes.hibernate.component;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.hibernate.event.internal.DefaultSaveOrUpdateEventListener;
import org.hibernate.event.service.spi.EventListenerGroup;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.event.spi.SaveOrUpdateEventListener;
import org.hibernate.internal.SessionFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 注册Hibernate Event Listener
 * @declaration:
 * @project : openmes-util-hibernateHelper
 * @package : com.messolution.opemmes.hibernata.component
 * @create_time : 2014年10月25日下午10:16:12
 * @author : panzhichun
 * @mail : mmcpanzhichun@gmail.com
 */
@Component
public class HibernateEventWiring {

    private static final Logger logger = LoggerFactory.getLogger(HibernateEventWiring.class);  
	
	private SessionFactory sessionFactory;
	
	private AuditListener auditListener;

	
	@PostConstruct
    public void registerListeners() {
        final EventListenerRegistry registry = ((SessionFactoryImpl) sessionFactory).getServiceRegistry().getService(
        EventListenerRegistry.class);
     
        EventListenerGroup<SaveOrUpdateEventListener> registeredListeners = registry.getEventListenerGroup(EventType.SAVE_UPDATE);
		registeredListeners.clear(); 
		registeredListeners.appendListener(auditListener); 
		registeredListeners.appendListener(new DefaultSaveOrUpdateEventListener());
		logger.info("register hibernate listener : {} operation : [insert, update]", auditListener.getClass().getName()); 


    }
	
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

    @Autowired
	public void setAuditListener(AuditListener auditListener) {
		this.auditListener = auditListener;
	}
}
