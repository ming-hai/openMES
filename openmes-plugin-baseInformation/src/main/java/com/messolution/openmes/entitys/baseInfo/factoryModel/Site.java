package com.messolution.openmes.entitys.baseInfo.factoryModel;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.messolution.opemmes.hibernate.common.IEntity;

/**
 * 
 * @declaration:
 * @project : openmes-plugin-baseInfomation
 * @package : com.messolution.openmes.baseInfo.entitys.factoryModel
 * @create_time : 2014年10月25日下午10:41:26
 * @author : panzhichun
 * @mail : mmcpanzhichun@gmail.com
 */

@Entity
@Table(name="bi_fm_site")
public class Site extends IEntity{
	
	private static final long serialVersionUID = 4021701324957286840L;

	private String name;
	
	private String description;

	
	private Enterprise enterprise;
	
	private Set<Area> areas;
	
	

	@Column(name="siteName",length=16)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length=64)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
   
	@ManyToOne
	@JoinColumn(name="enterprise_Id")
	public Enterprise getEnterprise() {
		return enterprise;
	}

	
	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	@OneToMany(mappedBy="site")
	@Cascade({CascadeType.SAVE_UPDATE})
	public Set<Area> getAreas() {
		return areas;
	}

	public void setAreas(Set<Area> areas) {
		this.areas = areas;
	}
	
	
}
