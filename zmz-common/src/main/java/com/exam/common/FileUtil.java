package com.exam.common;

public class FileUtil {
	 public static String ext(String filename) {
	        int index = filename.lastIndexOf(".");

	        if (index == -1) {
	            return null;
	        }
	        String result = filename.substring(index + 1);
	        return result;
	    }

}
