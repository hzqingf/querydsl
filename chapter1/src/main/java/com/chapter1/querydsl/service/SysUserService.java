package com.chapter1.querydsl.service;

import java.util.List;

import com.chapter1.querydsl.entity.SysUserEntity;


public interface SysUserService {
	
	public List<SysUserEntity> queryAll();
	
	public SysUserEntity queryOne(Long id);
	
	public void updateUser(SysUserEntity user);
	
	public void deleteUser(Long id);

}
