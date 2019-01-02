package com.ca.metricstore.lexer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 
 * @author kumko01
 *
 */
public enum Token {

    COMMA (","),

    OPEN_BRACKET ("\\{"),
    CLOSE_BRACKET ("\\}"),
    EQUAL ("="),


    STRING ("\"[^\"]+\""),
    IDENTIFIER ("\\w+");    

    private final Pattern pattern;

    Token(String regex) {
        pattern = Pattern.compile("^" + regex);
    }

    int endOfMatch(String s) {
        Matcher m = pattern.matcher(s);

        if (m.find()) {
            return m.end();
        }

        return -1;
    }
}