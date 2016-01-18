package com.jmcshane.jstp.domain;

import com.jmcshane.jstp.parse.SectionParser;

public class Section {
	
	public Section(SectionParser parser, String sectionString) {
		this.parser = parser;
		this.sectionString = sectionString; 
	}

	private final SectionParser parser;
	
	private final String sectionString;

	public SectionParser getParser() {
		return parser;
	}

	public String getSectionString() {
		return sectionString;
	}
}
