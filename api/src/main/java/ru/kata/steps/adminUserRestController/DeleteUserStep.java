package ru.kata.steps.adminUserRestController;


import io.qameta.allure.Step;
import ru.kata.models.adminUserRestController.response.DeleteUserResponse;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class DeleteUserStep {
    @Step("Проверка тела ответа")
    public static void checkResponseBody(DeleteUserResponse deleteUserResponse) {

        assertThat(deleteUserResponse.getData()).isEqualTo(null);
        assertThat(deleteUserResponse.getSuccess()).isEqualTo(true);

    }
}
