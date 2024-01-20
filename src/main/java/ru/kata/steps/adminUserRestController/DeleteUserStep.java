package ru.kata.steps.adminUserRestController;

import ru.kata.models.response.DeleteUserResponse;
import ru.kata.models.response.GetAddEditUserResponse;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class DeleteUserStep {
    public static void checkResponseBody(DeleteUserResponse deleteUserResponse) {

        assertThat(deleteUserResponse.getData()).isEqualTo(null);
        assertThat(deleteUserResponse.getSuccess()).isEqualTo(true);

    }
}
