package ru.kata.models.AdminUserRestController.addUser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.kata.entity.RoleTable;
import ru.kata.entity.UserTable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode
public class AddUserResponse {



    private Long id;
    private String birthday;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private RoleTable role;
}
