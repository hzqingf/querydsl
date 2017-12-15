package com.chapter1.querydsl.Qbean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.chapter1.querydsl.entity.OrderEntity;
import com.querydsl.core.types.dsl.*;
import com.querydsl.core.types.PathMetadata;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;


/**
 * QOrderEntity is a Querydsl query type for OrderEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrderEntity extends EntityPathBase<OrderEntity> {

    private static final long serialVersionUID = 389377186L;

    public static final QOrderEntity orderEntity = new QOrderEntity("orderEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath orderDetails = createString("orderDetails");

    public final NumberPath<Integer> ordereNum = createNumber("ordereNum", Integer.class);

    public final StringPath orderName = createString("orderName");

    public final NumberPath<Integer> orderType = createNumber("orderType", Integer.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QOrderEntity(String variable) {
        super(OrderEntity.class, forVariable(variable));
    }

    public QOrderEntity(Path<? extends OrderEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrderEntity(PathMetadata metadata) {
        super(OrderEntity.class, metadata);
    }

}

