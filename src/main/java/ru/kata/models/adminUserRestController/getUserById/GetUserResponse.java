package ru.kata.models.adminUserRestController.getUserById;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.kata.entity.adminUserRestController.RoleTable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@EqualsAndHashCode
public class GetUserResponse {

    private int id;
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
