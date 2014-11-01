/**Copyright (c) 2014 Vincent-Poon**/
package com.messolution.openmes.entitys.baseInfo.factoryModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.messolution.opemmes.hibernate.common.IEntity;

/**
 * 
 * @declaration:
 * @project : openmes-plugin-baseInfomation
 * @package : com.messolution.openmes.entitys.baseInfo.factoryModel
 * @create_time :2014年10月31日 上午12:11:45
 * @author : panzhichun
 * @mail : mmcpanzhichun@gmail.com
 */
@Entity
@Table(name="bi_fm_productionUnit")
public class ProductionUnit extends IEntity {

	private static final long serialVersionUID = 6195557878582766971L;

    private String name;
	
	private String description;
	
	private Area area;

	@Column(name="productionUnitName",length=16)
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
	@JoinColumn(name="area_Id")
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	} 
}
