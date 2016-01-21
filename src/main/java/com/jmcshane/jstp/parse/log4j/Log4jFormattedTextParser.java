package com.jmcshane.jstp.parse.log4j;

import com.jmcshane.jstp.factories.Log4jParserSectionFactory;
import com.jmcshane.jstp.parse.AbstractTextParser;

public class Log4jFormattedTextParser extends AbstractTextParser {
	
	public Log4jFormattedTextParser(String pattern) {
		super(pattern, new Log4jParserSectionFactory());
	}
}
