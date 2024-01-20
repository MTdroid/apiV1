package ru.kata.steps.adminUserRestController;

import ru.kata.models.response.ErrorResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ErrorResponseStep {
    public static void checkResponse(ErrorResponse errorResponse, Integer errorCode, String errorMessage){
        assertEquals(errorResponse.getCode(), errorCode);
        assertTrue(errorResponse.getText().contains(errorMessage) );
    }
}
