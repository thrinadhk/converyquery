package com.ca.metricstore.lexer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Parser {
	
	private ArrayList<String> tokenList = new ArrayList<String>();
	private ArrayList<String> lexemaList = new ArrayList<String>();
	private Map<String, Integer> oprators = new HashMap<String, Integer>();
	private Lexer lexer;
	
	public Parser(String query) {
		lexer = new Lexer(query);
	}
	
	public void parse() throws Exception {
		String currentToken = lexer.currentToken().name();
		String currentLexema = lexer.currentLexema();
		if (!"IDENTIFIER".equalsIgnoreCase(currentToken)) {
			throw new Exception("Query should start with an identifier.");
		}
		tokenList.add("metric type");
		lexemaList.add(currentLexema);
		lexer.moveAhead();
		while (!lexer.hasReachedEnd()) {
			
			currentToken = lexer.currentToken().name();
			currentLexema = lexer.currentLexema();
			if ("IDENTIFIER".equalsIgnoreCase(currentToken)) {
				tokenList.add(currentLexema);
			} else if ("STRING".equalsIgnoreCase(currentToken)) {
				lexemaList.add(currentLexema);
			} else {
				Integer optrCount = oprators.get(currentToken);
				if (optrCount == null) {
					oprators.put(currentToken, 1);
				} else {
					oprators.put(currentToken, ++optrCount);
				}
			}
            //System.out.printf("%-18s %s\n", lexer.currentToken(), lexer.currentLexema());
            lexer.moveAhead();
        }
		validateQuery();
	}
	
	private void validateQuery() throws Exception {
		System.out.println("Pawan" + oprators);
		if (!lexer.isSuccessful()) {
			throw new Exception(lexer.errorMessage());
		}
		if ((oprators.get(Token.OPEN_BRACKET.name()) == null || oprators.get(Token.OPEN_BRACKET.name()) != 1) 
				|| (oprators.get(Token.CLOSE_BRACKET.name()) == null || oprators.get(Token.CLOSE_BRACKET.name()) != 1)) {
			throw new Exception("Query not properly formed");
		}
		
		if ((oprators.get(Token.EQUAL.name()) != null && oprators.get(Token.COMMA.name()) == null) ||
				(oprators.get(Token.EQUAL.name()) == null && oprators.get(Token.COMMA.name()) != null) ||	
				oprators.get(Token.EQUAL.name())  != (oprators.get(Token.COMMA.name()) + 1) ) {
			throw new Exception("Invalid number of identifiers and strings");
		}
		
		
		if (tokenList.size() != lexemaList.size()) {
			throw new Exception("Identifiers not matching with strings");
		}
		
	}

	public ArrayList<String> getTokenList() {
		return tokenList;
	}

	public void setTokenList(ArrayList<String> tokenList) {
		this.tokenList = tokenList;
	}

	public ArrayList<String> getLexemaList() {
		return lexemaList;
	}

	public void setLexemaList(ArrayList<String> lexemaList) {
		this.lexemaList = lexemaList;
	}
	
	

}
