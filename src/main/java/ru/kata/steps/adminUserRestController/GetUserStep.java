package ru.kata.steps.adminUserRestController;

import ru.kata.models.response.GetAddEditUserResponse;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetUserStep {
  public static void checkResponseBody(GetAddEditUserResponse getUserResponse) {
        assertThat(getUserResponse).isNotNull();
        assertThat(getUserResponse);

    }
}
