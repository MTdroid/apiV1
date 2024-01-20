package ru.kata.entity.adminUserRestController;

import lombok.Data;

@Data
public class Inactivation {
    public Boolean inactive = true;
    public String reason = "NEED_CHANGE_PASSWORD";
}
