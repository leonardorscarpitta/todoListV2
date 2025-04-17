package io.github.leonardorscarpitta.simplify.utils.domain;

import io.github.leonardorscarpitta.simplify.utils.exceptions.InvalidValue;

public class ExceptionHandling {
    public static <T> void checkForNan(T value) {
        String convertedValue = String.valueOf(value);

        if (convertedValue == null) {
            throw new InvalidValue("O valor não pode ser nulo!");
        }

        for (int i = 0; i < convertedValue.length(); i++) {
            boolean notNumber = !Character.isDigit(convertedValue.charAt(i));
            if (notNumber) {
                throw new InvalidValue("O valor passado deve ser um número!");
            }
        }
    }
}
