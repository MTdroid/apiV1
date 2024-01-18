package ru.kata.models.AdminUserRestController.deleteUserById;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeleteUserRequest {

    private String id;
}
