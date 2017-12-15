package com.chapter1.querydsl.base;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.querydsl.jpa.impl.JPAQueryFactory;


@Component
public class QueryFactory {

	@Autowired
	private EntityManager entityManager;
	
	private JPAQueryFactory queryFactory;
	
	@PostConstruct
	public JPAQueryFactory initFactory(){
		queryFactory = new JPAQueryFactory(entityManager);
		return queryFactory;
	}
}
