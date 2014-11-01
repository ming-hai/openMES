package com.messolution.openmes.entitys.baseInfo.factoryModel;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.messolution.opemmes.hibernate.common.IEntity;

/**
 * 
 * 
 * @declaration:
 * @project : openmes-plugin-baseInfomation
 * @package : com.messolution.openmes.entitys.baseInfo.factoryModel
 * @create_time :2014年10月29日 下午8:03:52
 * @author : panzhichun
 * @mail : mmcpanzhichun@gmail.com
 */
@Entity
@Table(name="bi_fm_areaCategory")
public class AreaCategory extends IEntity {

	private static final long serialVersionUID = 2782790653385772807L;
	
	private String name;

	
	@Column(name="areaCategoryName",length=16)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
