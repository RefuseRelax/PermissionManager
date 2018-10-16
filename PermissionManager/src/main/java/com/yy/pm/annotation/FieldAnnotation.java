package com.yy.pm.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.yy.pm.enums.FiledType;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldAnnotation {

	//字段排序
	int index() default 0;
	
	//字段名称
	String filedName() default "";
	
	//字段类型
	FiledType filedType() default FiledType.VARCHAR;
	
	//字段类型长度
	long length() default 25;
	
	//字段注释
	String comment() default "";
	
	//是否为空，默认为空
	boolean isNull() default true;
	
	//是否唯一，默认不唯一
	boolean isUnique() default false;
	
	//是否为主键，默认不是
	boolean isPrimaryKey() default false;
	
	//是否主键自增，默认不是
	boolean isAutoIncreament() default false;
	
}
