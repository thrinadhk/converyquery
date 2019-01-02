package com.ca.metricstore.lexer;

import org.junit.jupiter.api.Test;

public class TestParse {
	
	Parser parser = new Parser("src/test/resources/sample.txt");
	
	@Test
	public void testParserPositive() {
		try {
			parser.parse();
			System.out.println(parser.getLexemaList());
			System.out.println(parser.getTokenList());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestParserByNotClosingBrace(){
		
	}
	
	@Test
	public void TestParserByNotClosingString(){
		
	}
	
	@Test
	public void TestParserByNotHavingMetricType(){
		
	}

}
