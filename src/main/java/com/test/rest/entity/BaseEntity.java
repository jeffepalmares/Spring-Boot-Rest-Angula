package com.test.rest.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class BaseEntity implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1462325267809847324L;

	public abstract int getId() ;
	
	public abstract void setId(int id);
	
	
	
}
