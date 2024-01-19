package ru.kata.models.adminUserRestController.getAllCurators;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAllCuratorsResponse {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String avatarUrl;

}
