package com.yy.pm.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.yy.pm.enums.FiledType;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldAnnotation {

	//�ֶ�����
	int index() default 0;
	
	//�ֶ�����
	String filedName() default "";
	
	//�ֶ�����
	FiledType filedType() default FiledType.VARCHAR;
	
	//�ֶ����ͳ���
	long length() default 25;
	
	//�ֶ�ע��
	String comment() default "";
	
	//�Ƿ�Ϊ�գ�Ĭ��Ϊ��
	boolean isNull() default true;
	
	//�Ƿ�Ψһ��Ĭ�ϲ�Ψһ
	boolean isUnique() default false;
	
	//�Ƿ�Ϊ������Ĭ�ϲ���
	boolean isPrimaryKey() default false;
	
	//�Ƿ�����������Ĭ�ϲ���
	boolean isAutoIncreament() default false;
	
}
