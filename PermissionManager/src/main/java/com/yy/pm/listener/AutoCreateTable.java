/**
 * 
 */
package com.yy.pm.listener;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.yy.pm.annotation.FieldAnnotation;
import com.yy.pm.annotation.TableAnnotaion;
import com.yy.pm.enums.FiledType;
import com.yy.pm.util.ClassUtil;
import com.yy.pm.util.JDBCManager;

/**
 * @author zk
 *
 */
public class AutoCreateTable implements ServletContextListener{

	//��ȡ���������ݣ��ж��Ƿ���Ҫ�½���
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		Boolean isCreateTable = Boolean.parseBoolean(sce.getServletContext().getInitParameter("isAutoCreateTable"));
		if(isCreateTable){
			String packageName = sce.getServletContext().getInitParameter("packageName");
			ClassLoader(packageName);
		}	
	}
	
	public boolean isAxistTable(String packageName){
		String sql = "select 1 from " + packageName;
		JDBCManager jdbc = new JDBCManager();
		boolean isAxist = jdbc.isTabAxist(sql);
		jdbc.close();
        return isAxist;
		//ClassLoader(packageName);
	}
	
	public void ClassLoader(String packageName){
		//StringBuilder str = new StringBuilder();
		List<Class<?>> clazzs = ClassUtil.getClasssFromPackage(packageName);
		for(Class<?> clazz : clazzs){
			boolean isAnnotationPresent = clazz.isAnnotationPresent(TableAnnotaion.class);
			if(isAnnotationPresent){
				TableAnnotaion tabanno = clazz.getAnnotation(TableAnnotaion.class);
				boolean isAxist = isAxistTable(tabanno.tableName());
				if(!isAxist){
				  getSql(clazz,tabanno.tableName());
				}
			}
		}
	}
	
	public void getSql(Class clazz,String tableName){
		StringBuilder str = new StringBuilder("create table "+tableName+"(");
		Field[] fs = clazz.getDeclaredFields();
		Map<Integer,Field> mfs = new TreeMap<Integer, Field>();
		for(Field f : fs){
			boolean isField = f.isAnnotationPresent(FieldAnnotation.class);
			if(isField){
				FieldAnnotation fno = f.getAnnotation(FieldAnnotation.class);
				int i = fno.index();
				mfs.put(i, f);
			}
		}		
		Iterator<Entry<Integer, Field>> iter = mfs.entrySet().iterator();
		while(iter.hasNext()){
			Entry<Integer,Field> en = iter.next();
			Field fi = en.getValue();
			FieldAnnotation fin = fi.getAnnotation(FieldAnnotation.class);
			String fielName = fin.filedName();
			FiledType ft = fin.filedType();
			Long length = fin.length();
			String comment = fin.comment();
			boolean isAutoIncreament = fin.isAutoIncreament();
			boolean isNull = fin.isNull();
			boolean isPrimaryKey =  fin.isPrimaryKey();
			boolean isUnique =  fin.isUnique();
			str.append(fielName+" "+ft);
			if(!FiledType.DATETIME.equals(ft)){
				str.append("("+length+") ");
			}
			if(isPrimaryKey){
				str.append(" primary key ");
			}else if(isUnique){
				str.append(" Unique ");
				if(!isNull){
					str.append(" not null ");
				}
			}
			if(isAutoIncreament){
				str.append(" auto_increment ");
			}
			str.append(" comment '"+comment+"',");		
		}
		String sql = str.substring(0, str.length()-1)+")";
		System.out.println(sql);
		JDBCManager jdbc = new JDBCManager();
		jdbc.isTabAxist(sql);
		jdbc.close();
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//ServletContextListener.super.contextDestroyed(sce);
	}
}
