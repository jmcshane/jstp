package com.jmcshane.jstp.parse.regex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jmcshane.jstp.parse.Parser;

public class RegexFormattedTextParser implements Parser {

	protected final Pattern regex;
	
	protected final List<String> orderedGroupNames;
	
	public RegexFormattedTextParser(String regex, String... orderedGroupNames) {
		this(regex, Arrays.asList(orderedGroupNames));
	}
	
	public RegexFormattedTextParser(String regex, List<String> orderedGroupNames) {
		this.regex = Pattern.compile(regex);
		this.orderedGroupNames = orderedGroupNames;
	}

	@Override
	public Map<String, String> parse(String input) {
		Matcher matcher = regex.matcher(input);
		if (matcher.find()) {
			if (matcher.groupCount() < orderedGroupNames.size()) {
				return null;
			}
			Map<String,String> outputMap = new HashMap<>();
			for (int i = 0; i < orderedGroupNames.size(); i++) {
				outputMap.put(orderedGroupNames.get(i), matcher.group(i + 1));
			}
			return outputMap;
		}
		return null;
	}
}
