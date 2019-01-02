package com.ca.metricstore.lexer;

import org.junit.jupiter.api.Test;

public class TestLexer {
	
	Lexer lexer = new Lexer("src/test/resources/sample.txt");
	
	@Test
	public void testLexer() {
		while (!lexer.hasReachedEnd()) {
            System.out.printf("%-18s %s\n", lexer.currentToken(), lexer.currentLexema());
            lexer.moveAhead();
        }

        if (lexer.isSuccessful()) {
            System.out.println("Ok! :D");
        } else {
            System.out.println(lexer.errorMessage());
        }
	}

}
