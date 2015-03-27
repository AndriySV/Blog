package com.as.blog.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		String string = "one\ntwo";
		
		Pattern pattern = Pattern.compile("\n");
		Matcher matcher = pattern.matcher(string);
		
		 matcher.replaceAll("AAA");
		
		
		System.out.println( matcher.replaceAll("<p></p>"));
	}
	
}
