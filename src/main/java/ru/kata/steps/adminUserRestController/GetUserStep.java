package ru.kata.steps.adminUserRestController;

import ru.kata.models.adminUserRestController.addUser.AddUserResponse;
import ru.kata.models.adminUserRestController.getUserById.GetUserResponse;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetUserStep {
  public static void checkResponseBody(AddUserResponse addUserResponse) {
        assertThat(addUserResponse).isNotNull();

    }
}
