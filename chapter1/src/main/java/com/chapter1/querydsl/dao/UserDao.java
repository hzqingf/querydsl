package com.chapter1.querydsl.dao;

import org.springframework.stereotype.Repository;

import com.chapter1.querydsl.base.BaseDao;
import com.chapter1.querydsl.entity.SysUserEntity;

@Repository
public interface UserDao extends BaseDao<SysUserEntity> {


}
