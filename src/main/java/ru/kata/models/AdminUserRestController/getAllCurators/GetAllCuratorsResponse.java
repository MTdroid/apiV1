package ru.kata.models.AdminUserRestController.getAllCurators;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
