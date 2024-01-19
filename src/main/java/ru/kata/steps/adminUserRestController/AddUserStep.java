package ru.kata.steps.adminUserRestController;

import ru.kata.entity.adminUserRestController.RoleTable;
import ru.kata.models.adminUserRestController.addUser.AddUserResponse;

import static org.junit.jupiter.api.Assertions.*;

public class AddUserStep {
     static AddUserResponse addUserResponses;

    public static void checkResponseBody(AddUserResponse addUserResponses, String firstName, RoleTable role) {

        assertEquals(firstName, addUserResponses.getFirstName());
        assertEquals(addUserResponses.getRole().getName(), role.getName());





    }
}
