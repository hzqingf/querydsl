package com.chapter1.querydsl.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chapter1.querydsl.Qbean.QOrderEntity;
import com.chapter1.querydsl.Qbean.QSysUserEntity;
import com.chapter1.querydsl.base.QueryFactory;
import com.chapter1.querydsl.dao.OrderDao;
import com.chapter1.querydsl.entity.OrderEntity;
import com.chapter1.querydsl.service.OrderService;
import com.chapter1.querydsl.vo.UserOrderVO;
import com.querydsl.core.types.Projections;


@Service
public class OrderServiceImpl implements OrderService{
	
	
	@Autowired
	private QueryFactory queryFactory;
	
	@Autowired
	private OrderDao orderDao;
	
    QOrderEntity qorder = QOrderEntity.orderEntity;
    
    QSysUserEntity quser = QSysUserEntity.sysUserEntity;
    
	/**
	 * 关联查询，但是只返回一张表的字段
	 */

	@Override
	public List<OrderEntity> queryOrderList(Long id) {
		
		return queryFactory.initFactory()
						.select(qorder)
						.from(qorder,quser)
						.where(
									qorder.userId.eq(quser.id)
									.and(quser.id.eq(id))
									//这里可以写and
								)
						 .fetch();
	}
	
	
	
	/**
	 * 关联查询，但是只返回两张表中的部分字段
	 */
	public List<UserOrderVO> queryItem(Long id){
		/** 这种方法是querydsl查询
		return queryFactory.initFactory()
				           .select(
				        		   Projections.bean(
					        		   UserOrderVO.class,
					        		   quser.userName,
					        		   quser.password,
					        		   qorder.orderName.as("rname"),    //当字段名与新的vo中不同时，用as使之对应
					        		   qorder.ordereNum.as("rnum")
				        		   )
				        	)
				        	.from(quser,qorder)
				        	.where(quser.id.eq(qorder.userId).and(quser.id.eq(id)))
				        	.fetch();
				        	
				        	*/
		
		
		//如下方法是通过java8 lamhda特性进行的
		/**
		 * t只能获取select内存在的字段，如果select内为一个实体对象，t无法获取指定字段的值。
		 */
		return queryFactory.initFactory()
				          .select(
				        		  	quser.userName,
				        		  	quser.password,
				        		  	qorder.orderName,
				        		  	qorder.ordereNum
				        		  
				        		  )
				           .from(quser,qorder)
				           .where(quser.id.eq(qorder.userId).and(quser.id.eq(id)))
				           .fetch()
				           .stream()
				           .map(t -> {
				        	   UserOrderVO v = new UserOrderVO();
				        	   v.setUserName(t.get(quser.userName));
				        	   v.setPassword(t.get(quser.password));
				        	   v.setRname(t.get(qorder.orderName));
				        	   v.setRnum(t.get(qorder.ordereNum));
				        	   return v;
				           })
				          .collect(Collectors.toList());
				        	
	}

}
