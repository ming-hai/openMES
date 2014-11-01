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
 * @create_time :2014年10月31日 上午12:25:05
 * @author : panzhichun
 * @mail : mmcpanzhichun@gmail.com
 */
@Entity
@Table(name="storegeUnit")
public class StorageUnit extends IEntity {

	private static final long serialVersionUID = -4250641933389930737L;
    
	private String name;
	
	private String description;
	
	private StorageZone storageZone;

	@Column(name="storegeUnitName",length=16)
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
	@JoinColumn(name="storageZone_Id")
	public StorageZone getStorageZone() {
		return storageZone;
	}

	public void setStorageZone(StorageZone storageZone) {
		this.storageZone = storageZone;
	} 
}
