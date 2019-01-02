package com.ca.metricstore.json.model;

import java.util.Arrays;

public class InputExternalTasFilter {
	private String op;
	private InputTasFilter[] input;
	
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public InputTasFilter[] getInputs() {
		return input;
	}
	public void setInputs(InputTasFilter[] input) {
		this.input = input;
	}
	@Override
	public String toString() {
		return "InputExternalTasFilter [op=" + op + ", input="
				+ Arrays.toString(input) + ", toString()=" + super.toString()
				+ "]";
	}
}
