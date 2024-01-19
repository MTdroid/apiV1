package ru.kata.models.adminUserRestController.addUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.kata.entity.adminUserRestController.Inactivation;
import ru.kata.entity.adminUserRestController.RoleTable;


@Data
@AllArgsConstructor


public class AddUserRequest {

    private Integer id;
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
    private Inactivation inactivation;


}
