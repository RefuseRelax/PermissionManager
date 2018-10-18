/**
 * 
 */
package com.yy.pm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zk
 *
 */
public class DateUtil {
	
	private static String format = "yyyy-MM-dd HH:mm:ss";

	public static String dateToRoutineStringFormat(Date date){
		SimpleDateFormat d = new SimpleDateFormat(format);
		if(null==date){
			return null;
		}
		String dt = d.format(date);
		return dt;
	}
}
