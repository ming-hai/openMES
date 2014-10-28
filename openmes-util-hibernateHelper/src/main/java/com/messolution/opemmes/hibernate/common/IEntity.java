package com.messolution.opemmes.hibernate.common;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
/**
 * 
 * @declaration:
 * @project : openmes-util-hibernateHelper
 * @package : com.messolution.opemmes.hibernata.common
 * @create_time : 2014年10月19日下午3:51:45
 * @author : panzhichun
 * @mail : mmcpanzhichun@gmail.com
 */
@MappedSuperclass
public abstract class IEntity implements Serializable {

	private static final long serialVersionUID = 1634385017394750229L;

	private String Id;
	
	private String creator_Id;
	
	private Date creation_time;
	
	private String last_modifier_Id;
	
	private Date last_modified_time;
	
	private int db_status;

	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(columnDefinition = "CHAR(32)")
	@Id	
	public String getId() {
		return Id;
	}
   
	
	public void setId(String id) {
		Id = id;
	}
    
	@Column(length=32)
	public String getCreator_Id() {
		return creator_Id;
	}
	

	public void setCreator_Id(String creator_Id) {
		this.creator_Id = creator_Id;
	}
    
	@Column(length=32)
	public String getLast_modifier_Id() {
		return last_modifier_Id;
	}

	public void setLast_modifier_Id(String last_modifier_Id) {
		this.last_modifier_Id = last_modifier_Id;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreation_time() {
		return creation_time;
	}

	public void setCreation_time(Date creation_time) {
		this.creation_time = creation_time;
	}
    

	@Temporal(TemporalType.TIMESTAMP)
	public Date getLast_modified_time() {
		return last_modified_time;
	}

	public void setLast_modified_time(Date last_modified_time) {
		this.last_modified_time = last_modified_time;
	}

	public int getDb_status() {
		return db_status;
	}

	public void setDb_status(int db_status) {
		this.db_status = db_status;
	}

}
