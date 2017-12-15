package com.chapter1.querydsl.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="sys_user")
@Data
public class SysUserEntity implements Serializable{
	
	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id" ,unique=true)
	private Long id;
	@Column(name="username")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="age")
	private Integer age;
	@Column(name="address")
	private String address;
	@Column(name="phone")
	private String phone;
}
