package ru.kata.models.AdminUserRestController.editUserById;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.kata.entity.RoleTable;
@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EditUserRequest {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String birthday;

    private RoleTable role;

    /*private boolean enabled;

    private boolean imageFromSlack;
    private boolean isViewReport;
    private String avatarUrl;
    private Object inactivation;*/
}
