package com.messolution.openmes.openmes_plugin_baseInfomation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.messolution.openmes.entitys.baseInfo.factoryModel.Enterprise;
import com.messolution.openmes.entitys.baseInfo.factoryModel.Site;
import com.messolution.openmes.service.baseInfo.factoryModel.IFactoryModelService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class FactoryModelServiceTest extends  AbstractJUnit4SpringContextTests{

	@Autowired
	public IFactoryModelService factoryModelService;
	
    
	@Test
	public void saveOrUpdateEnterprisetest(){
		Enterprise e = new Enterprise();
		e.setId("4028b481494bbf8601494bbf89840000");
		e.setName("openMES");
		e.setDescription("中文3");
		Site s = new Site();
		s.setName("site2");
		s.setDescription("haha2221");
		s.setEnterprise(e);
		Set<Site> ss = new HashSet<Site>();
		ss.add(s);
		
		e.setSites(ss);
		
		factoryModelService.saveOrUpdateEnterprise(e);
	}
	
	@Test
	public void findAllEnterprise(){
		List<Enterprise> EnterpriseList =factoryModelService.findAllEnterprise();
		for(Enterprise e:EnterpriseList){
			System.out.println("id="+e.getId()+" name="+e.getName());
		}
	}
	
	@Test
	public void getEnterprise(){
		List<Enterprise> EnterpriseList = factoryModelService.getEnterprise("4028b481494bbf8601494bbf89840000","4028b481494bc07a01494bc07cd50000");
		for(Enterprise e:EnterpriseList){
			System.out.println("id="+e.getId()+" name="+e.getName());
		}
	}
}
