package com.jmcshane.jstp.parse;

public interface Formatter {
	
	void setFormatString(String format);
	
	CharType getCharType(char next);
}
