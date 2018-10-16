/**
 * 
 */
package com.yy.pm.util;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


/**
 * @author zk
 *
 */
public class ClassUtil {
	

	    /**
	     * ��ð���������е�class
	     *
	     * @param
	     *
	     * @return List��������class��ʵ��
	     */

	    public static List<Class<?>> getClasssFromPackage(String packageName) {
	        List<Class<?>> clazzs = new ArrayList<Class<?>>();
	        // �Ƿ�ѭ�������Ӱ�
	        boolean recursive = true;
	        // ������Ӧ��·������
	        String packageDirName = packageName.replace('.', '/');
	        Enumeration<URL> dirs;

	        try {
	            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
	            while (dirs.hasMoreElements()) {

	                URL url = dirs.nextElement();
	                String protocol = url.getProtocol();

	                if ("file".equals(protocol)) {
	                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
	                    findClassInPackageByFile(packageName, filePath, recursive, clazzs);
	                }
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return clazzs;
	    }

	    /**
	     * ��package��Ӧ��·�����ҵ����е�class
	     */
	    public static void findClassInPackageByFile(String packageName, String filePath, final boolean recursive,
	                                                List<Class<?>> clazzs) {
	        File dir = new File(filePath);
	        if (!dir.exists() || !dir.isDirectory()) {
	            return;
	        }
	        // �ڸ�����Ŀ¼���ҵ����е��ļ������ҽ�����������
	        File[] dirFiles = dir.listFiles(new FileFilter() {

	            public boolean accept(File file) {
	                boolean acceptDir = recursive && file.isDirectory();// ����dirĿ¼
	                boolean acceptClass = file.getName().endsWith("class");// ����class�ļ�
	                return acceptDir || acceptClass;
	            }
	        });

	        for (File file : dirFiles) {
	            if (file.isDirectory()) {
	                findClassInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, clazzs);
	            } else {
	                String className = file.getName().substring(0, file.getName().length() - 6);
	                try {
	                    clazzs.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + "." + className));
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	}