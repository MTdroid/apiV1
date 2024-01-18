package ru.kata.rest;

import lombok.Data;

@Data
public class Endpoint {

    public static final String saveUser = "/api/admin/user";
    public static final String getUser = "/api/admin/user/{id}";
    public static final String editUser = "/api/admin/user/{id}";
    public static final String deleteUser = "/api/admin/user/{id}";
    public static final String getAllCurators = "/api/admin/user/curators";

    public static final String getJwtToken = "https://admin-aqaj.kata.academy/token";
}