package com.chapter1.querydsl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chapter1.querydsl.base.QueryFactory;
import com.chapter1.querydsl.dao.UserDao;
import com.chapter1.querydsl.Qbean.QSysUserEntity;
import com.chapter1.querydsl.entity.SysUserEntity;
import com.chapter1.querydsl.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	QueryFactory queryFactory;
	
	@Autowired
	UserDao userDao;
	
	QSysUserEntity qs = QSysUserEntity.sysUserEntity;
	
	
	
	@Override
	public List<SysUserEntity> queryAll() {
		return queryFactory.initFactory()
							.selectFrom(qs)    //查询源
							.orderBy(qs.id.desc())
							.fetch();    //返回结果集
	}
	
	
	public SysUserEntity queryOne(Long id){
		
		//下面三种方法效果相同,只能用于单表
		
//		return queryFactory.initFactory()
//				.selectFrom(qs)
//				.where(qs.id.eq(id))
//				.fetchOne();
		
//		return userDao.findOne(qs.id.eq(id));
		
		return userDao.findOne(id);
	}


	@Transactional
	public void updateUser(SysUserEntity user) {
		//两种方法
		
//		userDao.save(user);
		
		
		queryFactory.initFactory()
		.update(qs)
		.set(qs.userName, user.getUserName())
		.set(qs.age, user.getAge())
		.where(qs.id.eq(user.getId()))
		.execute();
	}


	@Transactional
	public void deleteUser(Long id) {
//		userDao.delete(id);
		
		queryFactory.initFactory()
		.delete(qs)
		.where(qs.id.eq(id))
		.execute();
	}

}
