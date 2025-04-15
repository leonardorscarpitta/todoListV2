package io.github.leonardorscarpitta.simplify.utils.domain;

public class ExceptionHandling {
    public static <T> Boolean checkForNan(T value) {
        String convertedValue = (String) value;

        for (int i = 0; i < convertedValue.length(); i++) {
            boolean notNumber = !Character.isDigit(convertedValue.charAt(i));
            if (notNumber) {
                return false;
            }
        }

        return true;
    }
}
