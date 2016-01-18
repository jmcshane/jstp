package com.jmcshane.jstp.parse.logback;

import java.util.Map;

import com.jmcshane.jstp.parse.Formatter;
import com.jmcshane.jstp.parse.Parser;

public class LogbackFormattedTextParser implements Parser {

	private final Formatter formatter;
	
	public LogbackFormattedTextParser(String formatString) {
		this.formatter = new LogbackFormatter();
		this.formatter.setFormatString(formatString);
	}
	
	@Override
	public Map<String, String> parse(String input) {
		return null;
	}

}
