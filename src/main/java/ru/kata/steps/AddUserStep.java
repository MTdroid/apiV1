package ru.kata.steps;

import ru.kata.entity.RoleTable;
import ru.kata.models.AdminUserRestController.addUser.AddUserRequest;
import ru.kata.models.AdminUserRestController.addUser.AddUserResponse;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AddUserStep {
     static AddUserResponse addUserResponses;

    public static void checkResponseBody(AddUserResponse addUserResponses, String firstName) {


        assertEquals(addUserResponses.getFirstName(), firstName);


        /*assertEquals(addUserResponses.get(0).getBirthday(), birthday);
        assertEquals(addUserResponses.get(0).getFirstName(), firstName);
        assertEquals(addUserResponses.get(0).getLastName(), lastName);
        assertEquals(addUserResponses.get(0).getEmail(), email);
        assertEquals(addUserResponses.getId(), id);
        assertNull(addUserResponses.getPassword());
        assertEquals(addUserResponses.getBirthday(), birthday);
        assertEquals(addUserResponses.getFirstName(), firstName);
        assertEquals(addUserResponses.getLastName(), lastName);*/




    }
}
