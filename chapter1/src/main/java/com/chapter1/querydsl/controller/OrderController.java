package com.chapter1.querydsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chapter1.querydsl.entity.OrderEntity;
import com.chapter1.querydsl.service.OrderService;
import com.chapter1.querydsl.vo.UserOrderVO;



@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	
	@RequestMapping(value="/getList/{id}")
	public List<OrderEntity> getList(@PathVariable("id") Long id){
		return orderService.queryOrderList(id);
	}
	
	
	@RequestMapping(value="/getItem/{id}")
	public List<UserOrderVO> getItem(@PathVariable("id") Long id){
		return orderService.queryItem(id);
	}
}
