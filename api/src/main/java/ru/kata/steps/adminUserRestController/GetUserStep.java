package ru.kata.steps.adminUserRestController;

import io.qameta.allure.Step;
import ru.kata.models.adminUserRestController.response.GetAddEditUserResponse;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class GetUserStep {
    @Step("Проверка тела ответа")
  public static void checkResponseBody(GetAddEditUserResponse getUserResponse,int id) {

        assertThat(getUserResponse).isNotNull();
        assertThat(getUserResponse.getId()).isEqualTo(id);

    }
}
