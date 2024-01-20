package ru.kata.steps.adminUserRestController;

import ru.kata.entity.adminUserRestController.RoleTable;
import ru.kata.models.response.GetAddEditUserResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditUserStep {
    public static void checkResponseBody(GetAddEditUserResponse editUserResponse, String firstName, String email, String lastName, String birthday) {

        assertEquals(firstName, editUserResponse.getFirstName());
        assertEquals(editUserResponse.getEmail(), email);
        assertEquals(editUserResponse.getLastName(), lastName);
        assertEquals(editUserResponse.getBirthday(), birthday);
    }
}
