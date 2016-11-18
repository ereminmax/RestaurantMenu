package com.maxeremin.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Максим on 18.11.2016.
 */
public class SearchValidator {
    private Pattern pattern;
    private Matcher matcher;

    private static final String SEARCH_PATTERN = "([а-яА-Я]+\\s*)+";

    public SearchValidator() {
        pattern = Pattern.compile(SEARCH_PATTERN);
    }

    public boolean validate(String target) {
        matcher = pattern.matcher(target);
        return matcher.matches();
    }
}
