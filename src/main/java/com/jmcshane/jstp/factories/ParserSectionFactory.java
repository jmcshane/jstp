package com.jmcshane.jstp.factories;

import java.util.Stack;

import com.jmcshane.jstp.parse.ParserSection;

public interface ParserSectionFactory {
	Stack<ParserSection> initialize(String pattern);
}
