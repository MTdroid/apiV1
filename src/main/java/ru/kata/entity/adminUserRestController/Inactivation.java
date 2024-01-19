package ru.kata.entity.adminUserRestController;

import lombok.Data;

@Data
public class Inactivation {
    public Boolean inactive;
    public String reason;
}
