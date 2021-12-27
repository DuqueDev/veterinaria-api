package com.veterinaria.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.util.StringUtils;

public class VetValidator {

	public static boolean isAlpha(String str) {
		return str.matches("[a-zA-Z]+");
	}

	public static boolean isGreater(String str, int length) {
		return str.length() > length;
	}

	public static boolean isMinor(String str, int length) {
		return str.length() < length;
	}

	public static String toCapitalize(String str) {
		return StringUtils.capitalize(str);
	}

}
