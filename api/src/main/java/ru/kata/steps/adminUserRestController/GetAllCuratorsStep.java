package ru.kata.steps.adminUserRestController;


import ru.kata.entity.adminUserRestController.UserTable;
import ru.kata.models.adminUserRestController.response.GetAddEditUserResponse;
import ru.kata.rest.PositiveRequestSpecification;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GetAllCuratorsStep {

    public static void checkResponseBody(List<UserTable> getAllCuratorsResponses) {

        for (UserTable curator : getAllCuratorsResponses) {
            GetAddEditUserResponse getUserResponse = PositiveRequestSpecification.getUserResponse(curator.getId(), 200);
            assertThat(getUserResponse.getRole().getName()).isEqualTo("CURATOR");
        }
}
}
