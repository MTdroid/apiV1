package ru.kata.steps.adminUserRestController;


import io.qameta.allure.Step;
import ru.kata.models.adminUserRestController.response.ErrorResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ErrorResponseStep {
    @Step("Проверка тела ответа")
    public static void checkResponse(ErrorResponse errorResponse, Integer errorCode, String errorMessage){

        assertEquals(errorResponse.getCode(), errorCode);
        assertTrue(errorResponse.getText().contains(errorMessage) );

    }
}
