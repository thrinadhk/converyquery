package com.ca.metricstore.json.model;

public class AttributeNameSpecifier {
	private String op;
	private String pattern;
	
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	@Override
	public String toString() {
		return "AttributeNameSpecifier [op=" + op + ", pattern=" + pattern
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
