/**Copyright (c) 2014 Vincent-Poon**/
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
 * @package : com.messolution.openmes.entitys.baseInfo.factoryModel
 * @create_time :2014年10月31日 上午12:13:30
 * @author : panzhichun
 * @mail : mmcpanzhichun@gmail.com
 */
@Entity
@Table(name="bi_fm_productionLine")
public class ProductionLine extends IEntity {


	private static final long serialVersionUID = 5310808004838326432L;

    private String name;
	
	private String description;
	
	private Set<WorkCell> workCells;
	
	private Area area;

	@Column(name="productionLineName",length=16)
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

	@OneToMany(mappedBy="productionLine")
	@Cascade({CascadeType.SAVE_UPDATE})
	public Set<WorkCell> getWorkCells() {
		return workCells;
	}

	public void setWorkCells(Set<WorkCell> workCells) {
		this.workCells = workCells;
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
