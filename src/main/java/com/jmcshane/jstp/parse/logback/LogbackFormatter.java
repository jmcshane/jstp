package com.jmcshane.jstp.parse.logback;

import java.util.List;

import com.jmcshane.jstp.domain.Section;
import com.jmcshane.jstp.parse.CharType;
import com.jmcshane.jstp.parse.Formatter;

public class LogbackFormatter implements Formatter {
	
	private String format;
	private List<Section> sections;

	@Override
	public void setFormatString(String format) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CharType getCharType(char next) {
		// TODO Auto-generated method stub
		return null;
	}

}
