package ru.kata.models.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.kata.entity.adminUserRestController.Inactivation;
import ru.kata.entity.adminUserRestController.RoleTable;


@Data
@AllArgsConstructor


public class AddUserRequest {


    private String avatarUrl;
    private String birthday;
    private String email;
    private Boolean enabled;
    private String firstName;
    private Integer id;
    private Boolean imageFromSlack;
    private Inactivation inactivation;
    private Boolean isViewReport;
    private String lastName;
    private String password;
    private RoleTable role;






}
