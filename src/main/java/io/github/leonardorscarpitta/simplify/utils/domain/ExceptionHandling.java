package io.github.leonardorscarpitta.simplify.utils.domain;

import io.github.leonardorscarpitta.simplify.utils.exceptions.InvalidValue;

public class ExceptionHandling {
    public static <T> void checkForNan(T value) {
        String convertedValue = (String) value;

        for (int i = 0; i < convertedValue.length(); i++) {
            boolean notNumber = !Character.isDigit(convertedValue.charAt(i));
            if (notNumber) {
                System.out.printf("Dígito: %s", i);
                throw new InvalidValue("O valor passado deve ser um número!");
            }
        }
    }
}
