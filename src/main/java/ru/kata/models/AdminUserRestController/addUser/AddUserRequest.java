package ru.kata.models.AdminUserRestController.addUser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.kata.entity.RoleTable;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class AddUserRequest {



    private String birthday;
    private String email;
    private String firstName;
    private String lastName;
    private String password;

    private RoleTable role;

}
