package com.chapter1.querydsl.dao;

import org.springframework.stereotype.Repository;

import com.chapter1.querydsl.base.BaseDao;
import com.chapter1.querydsl.entity.OrderEntity;

@Repository
public interface OrderDao extends BaseDao<OrderEntity> {


}
