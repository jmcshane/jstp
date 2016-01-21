package com.jmcshane.jstp.parse;

import java.util.Map;
import java.util.Stack;

import com.jmcshane.jstp.factories.ParserSectionFactory;

public abstract class AbstractTextParser implements FormattedTextParser {
	
	protected String pattern;
	protected Stack<ParserSection> stack;
	protected SectionConsumer consumer;
	
	public AbstractTextParser(String pattern, ParserSectionFactory sectionFactory) {
		this.pattern = pattern;
		this.stack = sectionFactory.initialize(pattern);
		this.consumer = null;
	}
	
	public String getPattern() {
		return pattern;
	}
	
	@Override
	public Map<String,String> parse(String input) {
		return consumer.consume(this.stack, input);
	}
}
