package ru.kata.models.AdminUserRestController.getUserById;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.kata.entity.RoleTable;
import ru.kata.entity.UserTable;

import javax.management.relation.Role;
import javax.xml.bind.annotation.XmlElement;
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
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
