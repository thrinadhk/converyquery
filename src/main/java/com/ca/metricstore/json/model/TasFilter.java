package com.ca.metricstore.json.model;


public class TasFilter {
	private String op;
	private InputExternalTasFilter input;
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public InputExternalTasFilter getInput() {
		return input;
	}
	public void setInput(InputExternalTasFilter input) {
		this.input = input;
	}
	
	@Override
	public String toString() {
		return "TasFilter [op=" + op + ", input=" + input + ", toString()="
				+ super.toString() + "]";
	}
		
}
