package com.chapter1.querydsl.Qbean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.chapter1.querydsl.entity.SysUserEntity;
import com.querydsl.core.types.dsl.*;
import com.querydsl.core.types.PathMetadata;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;


/**
 * QSysUserEntity is a Querydsl query type for SysUserEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSysUserEntity extends EntityPathBase<SysUserEntity> {

    private static final long serialVersionUID = -1738977844L;

    public static final QSysUserEntity sysUserEntity = new QSysUserEntity("sysUserEntity");

    public final StringPath address = createString("address");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final StringPath userName = createString("userName");

    public QSysUserEntity(String variable) {
        super(SysUserEntity.class, forVariable(variable));
    }

    public QSysUserEntity(Path<? extends SysUserEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSysUserEntity(PathMetadata metadata) {
        super(SysUserEntity.class, metadata);
    }

}

