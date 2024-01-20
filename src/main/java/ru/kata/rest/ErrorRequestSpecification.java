package ru.kata.rest;

import ru.kata.entity.adminUserRestController.Inactivation;
import ru.kata.entity.adminUserRestController.RoleTable;
import ru.kata.models.request.AddUserRequest;
import ru.kata.models.response.DeleteUserResponse;
import ru.kata.models.response.ErrorResponse;
import ru.kata.models.response.GetAddEditUserResponse;

import static io.restassured.RestAssured.given;
import static ru.kata.rest.PositiveRequestSpecification.requestSpecification;
import static ru.kata.rest.PositiveRequestSpecification.statusCode;

public class ErrorRequestSpecification {

    public static ErrorResponse addUserResponseErr (String avatarUrl, String birthday, String email, Boolean enabled , String firstName, Integer id, Boolean imageFromSlack, Inactivation inactivation, Boolean isViewReport , String lastName, String password, RoleTable role   , Integer code) {
        AddUserRequest user = new AddUserRequest(avatarUrl,birthday,email,enabled,firstName,id,imageFromSlack,inactivation,isViewReport,lastName,password,role);
        return given()
                .spec(requestSpecification())
                .body(user)
                .when()
                .post(Endpoint.saveUser)
                .then()
                .assertThat()
                .spec(statusCode(code))
                .extract().body().jsonPath().getObject("error", ErrorResponse.class);

    }
    public static ErrorResponse getUserResponseErr(Integer userId, Integer code) {

        return given()
                .spec(requestSpecification())
                .when()
                .get(Endpoint.getUser, userId)
                .then()
                .assertThat()
                .spec(statusCode(code))
                .extract().body().jsonPath().getObject("error", ErrorResponse.class);

    }
    public static ErrorResponse deleteUserResponseErr(Integer userId, Integer code) {

        return given()
                .spec(requestSpecification())
                .when()
                .delete(Endpoint.getUser, userId)
                .then()
                .assertThat()
                .spec(statusCode(code))
                .extract().body().jsonPath().getObject("error", ErrorResponse.class);

    }
    public static ErrorResponse editUserResponseErr(Integer id, String email, String password, String firstName , String lastName  , String birthday , Boolean enabled , RoleTable role , Boolean imageFromSlack , Boolean isViewReport , String avatarUrl , Inactivation inactivation, Integer code) {
        AddUserRequest user = new AddUserRequest(avatarUrl,birthday,email,enabled,firstName,id,imageFromSlack,inactivation,isViewReport,lastName,password,role);
        return given()
                .spec(requestSpecification())
                .body(user)
                .when()
                .put(Endpoint.editUser,id)
                .then()
                .assertThat()
                .spec(statusCode(code))
                .extract().body().jsonPath().getObject("error", ErrorResponse.class);
    }
}
