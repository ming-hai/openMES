/**Copyright (c) 2014 Vincent-Poon**/
package com.messolution.openmes.entitys.baseInfo.factoryModel;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @create_time :2014年10月31日 上午12:19:16
 * @author : panzhichun
 * @mail : mmcpanzhichun@gmail.com
 */
@Entity
@Table(name="bi_fm_storageZone")
public class StorageZone extends IEntity {

	private static final long serialVersionUID = -7533364839604452691L;

    private String name;
	
	private String description;
	
	private Set<StorageUnit> StorageUnits;

	@Column(name="storageZoneName",length=16)
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

	@OneToMany(mappedBy="storageZone")
	@Cascade({CascadeType.SAVE_UPDATE})
	public Set<StorageUnit> getStorageUnits() {
		return StorageUnits;
	}

	public void setStorageUnits(Set<StorageUnit> storageUnits) {
		StorageUnits = storageUnits;
	} 
}
