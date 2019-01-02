package com.ca.metricstore.json.model;

import java.util.Arrays;

public class ExpressionsTasFilter {
	private String name;
	private String[] values;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getValues() {
		return values;
	}
	public void setValues(String[] values) {
		this.values = values;
	}
	
	@Override
	public String toString() {
		return "ExpressionsTasFilter [name=" + name + ", values="
				+ Arrays.toString(values) + ", toString()=" + super.toString()
				+ "]";
	}	
}
