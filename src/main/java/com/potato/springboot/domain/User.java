package com.potato.springboot.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 当使用Entity注解时，注意需要指定主键@id
 * @author Tim
 *
 */
@Entity
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
