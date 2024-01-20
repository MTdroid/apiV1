package ru.kata.steps.adminUserRestController;

import org.assertj.core.api.Java6Assertions;
import ru.kata.models.response.GetAllCuratorsResponse;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetAllCuratorsStep {

    public static void checkResponseBody(List<GetAllCuratorsResponse> getAllCuratorsResponses, Integer id, String email, String firstName, String lastName) {
        assertThat(getAllCuratorsResponses).isNotNull();
        assertThat(getAllCuratorsResponses.get(0).getId()).isEqualTo(id);
        assertThat(getAllCuratorsResponses.get(0).getFirstName()).isEqualTo(firstName);
        assertThat(getAllCuratorsResponses.get(0).getLastName()).isEqualTo(lastName);
        assertThat(getAllCuratorsResponses.get(0).getEmail()).isEqualTo(lastName);





}
}
