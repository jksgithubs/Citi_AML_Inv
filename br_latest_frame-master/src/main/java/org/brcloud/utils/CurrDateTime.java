package org.brcloud.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrDateTime {
	public static String GetDateTime() {		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Current Date, Time = "+dtf.format(now)); //2016/11/16 12:08:43
		String sendStr = dtf.format(now).toString().substring(8, 10)+dtf.format(now).toString().substring(11, 13)+dtf.format(now).toString().substring(14, 16);
		
		//return String.parseLong(DataFromDB.Properties("hardWait"));
		return sendStr;
	}
}