package com.example.demo.util;

public class ValidationUtil {
	public static boolean validateRequiredField(String fieldName, String fieldVal, boolean isRequired ) throws ValidationException{
		if(isRequired && isEmptyString(fieldVal)) {
			throw new ValidationException(ValidationInterface.MISSING_REQUIRED_FIELDS + ":" + fieldName);
		}else {
			return true;
		}
	}
	
	public static boolean isEmptyString(String s) {
		if(s == null || s.length() == 0) return true;
		else return false;
	}
}
