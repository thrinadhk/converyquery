package com.ca.metricstore.json.model;


public class QuerySpecifier {
	private String op;
	private SourceNamesSpecifier sourceNameSpecifier;
	private AttributeNameSpecifier attributeNameSpecifier;
	
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public SourceNamesSpecifier getSourceNameSpecifier() {
		return sourceNameSpecifier;
	}
	public void setSourceNameSpecifier(SourceNamesSpecifier sourceNameSpecifier) {
		this.sourceNameSpecifier = sourceNameSpecifier;
	}
	public AttributeNameSpecifier getAttributeNameSpecifier() {
		return attributeNameSpecifier;
	}
	public void setAttributeNameSpecifier(
			AttributeNameSpecifier attributeNameSpecifier) {
		this.attributeNameSpecifier = attributeNameSpecifier;
	}
	@Override
	public String toString() {
		return "QuerySpecifier [op=" + op + ", sourceNameSpecifier="
				+ sourceNameSpecifier + ", attributeNameSpecifier="
				+ attributeNameSpecifier + ", toString()=" + super.toString()
				+ "]";
	}
	
}
