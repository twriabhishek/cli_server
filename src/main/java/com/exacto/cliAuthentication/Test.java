package com.exacto.cliAuthentication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Test test = new Test();
		String phoneno = "<2262749626>";
		String val = test.extractPhoneNumber(phoneno);
		System.out.print(val);

	}

	private String extractPhoneNumber(String callingDeviceIdentifier) {
		String phoneNumberRegex = "<\\+(.*?)>"; // Updated regex to match only digits in the brackets
		//String phoneNumberRegex = "<0-9>"; // Updated regex to match only digits in the brackets
		// String regexPattern = "\\d+";
		Pattern pattern = Pattern.compile(phoneNumberRegex);
		Matcher matcher = pattern.matcher(callingDeviceIdentifier);
		if (matcher.find()) {
			return matcher.group(1);
		}else
		{
			callingDeviceIdentifier = callingDeviceIdentifier.replaceAll("\\<", "").replaceAll("\\>","");

			return callingDeviceIdentifier;
			
		}
		//return null;

	}
}
