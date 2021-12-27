package com.veterinaria.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

	public static Date strToDate(String str) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String dateToStr(Date indate) {
		String dateString = null;
		SimpleDateFormat sdfr = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		/*
		 * you can also use DateFormat reference instead of SimpleDateFormat like this:
		 * DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
		 */
		try {
			dateString = sdfr.format(indate);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return dateString;
	}
	
	public static Date strToOnlyDate(String date2) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static String dateOnlyToStr(Date indate) {
		String dateString = null;
		SimpleDateFormat sdfr = new SimpleDateFormat("yyyy-MM-dd");
	
		try {
			dateString = sdfr.format(indate);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return dateString;
	}

}
