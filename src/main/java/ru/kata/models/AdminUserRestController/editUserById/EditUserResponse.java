package ru.kata.models.AdminUserRestController.editUserById;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ru.kata.entity.RoleTable;
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class EditUserResponse {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String birthday;
    private boolean enabled;
    private RoleTable role;
    private boolean imageFromSlack;
    private boolean isViewReport;
    private String avatarUrl;
    private Object inactivation;
}
