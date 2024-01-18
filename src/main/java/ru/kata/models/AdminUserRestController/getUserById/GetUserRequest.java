package ru.kata.models.AdminUserRestController.getUserById;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetUserRequest {
    private String id;

}
