package ru.kata.models.adminUserRestController.response;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
public class DeleteUserResponse {

    private Boolean success;
    private String data;
}
