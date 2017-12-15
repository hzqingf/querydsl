package com.chapter1.querydsl.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="t_order")
@Data
public class OrderEntity implements Serializable {
	
	private static final Long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id",unique=true)
	private Long id;
	@Column(name="user_id")
	private Long userId;
	@Column(name="order_name")
	private String orderName;
	@Column(name="order_num")
	private Integer ordereNum;
	@Column(name="order_type")
	private Integer orderType;
	@Column(name="order_details")
	private String orderDetails;
	


}
