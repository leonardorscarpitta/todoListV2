package io.github.leonardorscarpitta.simplify.controllers;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.HashMap;

public class ManageHttpStatus {
    public static HashMap<String,Object> manage(HttpStatus status, String message) {
        HashMap<String,Object> response = new HashMap<>();
        response.put("status", status.value());
        response.put("message", message);
        response.put("timestamp", LocalDateTime.now());
        return response;
    }
}
