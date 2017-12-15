package com.chapter1.querydsl.service;

import java.util.List;

import com.chapter1.querydsl.entity.OrderEntity;
import com.chapter1.querydsl.vo.UserOrderVO;



public interface OrderService {
	
	public List<OrderEntity> queryOrderList(Long id);
	
	public List<UserOrderVO> queryItem(Long id);

}
