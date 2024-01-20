package ru.kata.steps.adminUserRestController;

import ru.kata.entity.adminUserRestController.RoleTable;
import ru.kata.models.response.GetAddEditUserResponse;

import static org.junit.jupiter.api.Assertions.*;

public class AddUserStep {

    public static void checkResponseBody(GetAddEditUserResponse addUserResponses, String firstName, RoleTable role, String email, String lastName, String birthday) {

        assertEquals(firstName, addUserResponses.getFirstName());
        assertEquals(addUserResponses.getEmail(), email);
        assertEquals(addUserResponses.getRole().getName(), role.getName());
        assertEquals(addUserResponses.getLastName(), lastName);
        assertEquals(addUserResponses.getBirthday(), birthday);
    }
}
