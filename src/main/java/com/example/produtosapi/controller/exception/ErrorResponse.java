package com.example.produtosapi.controller.exception;

import java.time.Instant;

public record ErrorResponse(String message, Instant timestamp, Integer status, String path) {

}
