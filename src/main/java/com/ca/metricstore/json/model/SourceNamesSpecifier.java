package com.ca.metricstore.json.model;

import java.util.Arrays;

public class SourceNamesSpecifier {
	private String op;
	private String[] names;
	
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String[] getNames() {
		return names;
	}
	public void setNames(String[] names) {
		this.names = names;
	}
	@Override
	public String toString() {
		return "SourceNamesSpecifier [op=" + op + ", names="
				+ Arrays.toString(names) + ", toString()=" + super.toString()
				+ "]";
	}
	
}
