package io.github.leonardorscarpitta.simplify.controller.util;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ManageHttpStatus {

    public static Map<String,Object> manage(HttpStatus status, String message) {
        return Map.of(
                "status", status.value(),
                "message", message,
                "timestamp", LocalDateTime.now()
        );
    }
}
