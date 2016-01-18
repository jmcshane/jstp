package com.jmcshane.jstp.parse.regex

import spock.lang.Specification
import spock.lang.Unroll

import com.jmcshane.jstp.parse.Parser

@Unroll
class RegexFormattedTextParserSpec extends Specification {

	def "#regex should parse #string to single key #value map"() {
		given: 'A regex expression and an output name'
			def key = "key"
			Parser tp = new RegexFormattedTextParser(regex, key)
		when: 'The parser parses a string input'
			def map = tp.parse(string)
		then: 'The resulting map has the appropriate key/value pair and size'
			map[key] == value
			map.size() == 1
		where: 'The given inputs are provided'
		regex          | string     || value
		"([^t]+)"      | "qrstuv"   || "qrs"
		'([abcdef]+)$' | "hahaggbc" || "bc"
		
	}
	
	def "#regex does not match #string so parse returns null"() {
		given: 'A parser is setup with a regex'
			Parser tp = new RegexFormattedTextParser(regex, "noop")
		when: 'The parser parses a string that it does not match'
			def map = tp.parse(string)
		then: 'The resulting map should be null'
			map == null
		where: 'The given inputs are provided'
		regex             |     string
		'([aef]+[ytyt])'    |     'yltt'
		'(hello)[tT][hH]' |     'hellTH'
	}
	
	def "multi-group regex #regex matches #string to three groups"() {
		given: 'A list of three groups and a regex three matching groups'
			def groups = ["f", "s", "t"]
			Parser tp = new RegexFormattedTextParser(regex, groups)
		when: 'The parser parses those groups'
			def map = tp.parse(string)
		then: 'The resulting map should have the three key/value pairs'
			map.size() == 3
			groups.each { 
				map.containsKey(it)
				map.get(it) == output.get(it)
			}
		where: 'The given inputs are provided'
			regex                        | string       | output
			'(a)(b)(cd[eE])'             | 'abcdE'      | ["f" : "a", "s" : "b", "t" : "cdE"]
			'(al|ph)(eh|HH)ab\\s(12[ac])' | 'phehab 12c' | ['f' : 'ph', 's' : 'eh', 't' : '12c']
	}
}
