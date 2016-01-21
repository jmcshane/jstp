package com.jmcshane.jstp.parse.logback;

import com.jmcshane.jstp.factories.Log4jParserSectionFactory;
import com.jmcshane.jstp.parse.AbstractTextParser;

public class LogbackFormattedTextParser extends AbstractTextParser {

	public LogbackFormattedTextParser(String pattern) {
		super(pattern, new Log4jParserSectionFactory());
	}

}
