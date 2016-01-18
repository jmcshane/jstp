package com.jmcshane.jstp.parse.regex

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class NamedGroupRegexFormattedTextParserSpec extends Specification {

	def "named group matcher provides one #regex group name for #string"() {
		given: 'A named group parser initialized with a regular expression'
			def parser = new NamedGroupRegexFormattedTextParser(regex,["foo"])
		when: 'The parser parses an appropriate string with a match'
			def map = parser.parse(string)
		then: 'The resulting map has the appropriate key/value pair'
			map.size() == 1
			map.get('foo') == match
		where: 'The given inputs are provided'
		regex                         | string                | match
		';(?<foo>\\d{6});'            | ';12345;765432;1234;' | '765432'
		'\\s12\\s(?<foo>[a-zA-Z]{5})' | '12 12 TestsStopHere' | 'Tests'    
	}
}
