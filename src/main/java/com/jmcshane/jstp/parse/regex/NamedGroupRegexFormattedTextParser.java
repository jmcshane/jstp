package com.jmcshane.jstp.parse.regex;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class NamedGroupRegexFormattedTextParser extends RegexFormattedTextParser{
	
	public NamedGroupRegexFormattedTextParser(String regex,
			List<String> groupNames) {
		super(regex, groupNames);
	}
	
	public NamedGroupRegexFormattedTextParser(String regex, String... groupNames) {
		super(regex, groupNames);
	}

	@Override
	public Map<String, String> parse(String input) {
		Matcher matcher = regex.matcher(input);
		if (matcher.find()) {
			return orderedGroupNames
				.stream()
				.map(n -> new AbstractMap.SimpleEntry<String,String>(n, matcher.group(n)))
				.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
		}
		return null;
	}
}
