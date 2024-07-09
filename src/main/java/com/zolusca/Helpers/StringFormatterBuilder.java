package com.zolusca.Helpers;

import java.util.Formatter;

public class StringFormatterBuilder {
    public static  String createFormattedString (String message,Object... argument){
        return new Formatter().format(message,argument).toString();
    }
}
