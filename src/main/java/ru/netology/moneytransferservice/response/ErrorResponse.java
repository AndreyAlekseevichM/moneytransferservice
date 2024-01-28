package ru.netology.moneytransferservice.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String message;
    private int id;
}