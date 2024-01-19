package ru.kata.models.adminUserRestController.editUserById;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ru.kata.entity.adminUserRestController.RoleTable;
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class EditUserResponse {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String birthday;
    private Boolean enabled;
    private RoleTable role;
    private Boolean imageFromSlack;
    private Boolean isViewReport;
    private String avatarUrl;
    private Object inactivation;
}
