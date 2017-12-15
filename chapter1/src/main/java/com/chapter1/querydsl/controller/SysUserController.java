package com.chapter1.querydsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chapter1.querydsl.entity.SysUserEntity;
import com.chapter1.querydsl.service.SysUserService;


@RestController
public class SysUserController {

	
	@Autowired
	private SysUserService sysUserService;
	
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public List<SysUserEntity> getAll(){
		return sysUserService.queryAll();
	}
	
	
	@RequestMapping(value="/getByOne/{id}",method=RequestMethod.GET)
	public SysUserEntity getByOne(@PathVariable("id") Long id){
		return sysUserService.queryOne(id);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public void updateUser(@RequestBody SysUserEntity user){
		sysUserService.updateUser(user);
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") Long id){
		sysUserService.deleteUser(id);
	}

}
