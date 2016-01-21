package com.jmcshane.jstp.parse

import java.util.regex.Pattern

class PrefixOptions {

	def List<Pattern> options;
	
	def addOption(String regex) {
		options << Pattern.compile(regex)
	}
	
	def boolean isMatch(String input) {
		return options.any {
			it.matcher(input).matches()
		}
	}
}
