package com.ca.metricstore.json.model;

import java.util.Arrays;

public class InputTasFilter {
	private String op;
	private ExpressionsTasFilter[] expressions;
	
	
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public ExpressionsTasFilter[] getExpressions() {
		return expressions;
	}
	public void setExpressions(ExpressionsTasFilter[] expressions) {
		this.expressions = expressions;
	}
	@Override
	public String toString() {
		return "InputTasFilter [op=" + op + ", expressions="
				+ Arrays.toString(expressions) + ", toString()="
				+ super.toString() + "]";
	}
	
}
