package ru.skillbox.saver.validator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WordValidator {

    @Value("${validation.length}")
    private Long validLength;

    public boolean isValid(String word) {
        return !word.isEmpty() && word.length() < validLength;
    }

}
