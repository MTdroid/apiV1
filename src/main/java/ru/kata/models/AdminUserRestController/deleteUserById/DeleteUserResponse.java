package ru.kata.models.AdminUserRestController.deleteUserById;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
public class DeleteUserResponse {

private boolean success;
private String data;
}
