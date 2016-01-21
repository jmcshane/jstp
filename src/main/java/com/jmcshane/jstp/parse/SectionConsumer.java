package com.jmcshane.jstp.parse;

import java.util.Map;
import java.util.Stack;

public interface SectionConsumer {

	Map<String,String> consume(Stack<ParserSection> stack, String pattern);
}
