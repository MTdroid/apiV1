package ru.kata.steps.adminUserRestController;


import io.qameta.allure.Step;
import ru.kata.models.adminUserRestController.response.GetAddEditUserResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditUserStep {
    @Step("Проверка тела ответа")
    public static void checkResponseBody(GetAddEditUserResponse editUserResponse, String firstName, String email, String lastName, String birthday) {

        assertEquals(firstName, editUserResponse.getFirstName());
        assertEquals(editUserResponse.getEmail(), email);
        assertEquals(editUserResponse.getLastName(), lastName);
        assertEquals(editUserResponse.getBirthday(), birthday);

    }
}
