package ru.kata.rest;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import ru.kata.entity.adminUserRestController.Inactivation;
import ru.kata.entity.adminUserRestController.RoleTable;
import ru.kata.entity.adminUserRestController.UserTable;
import ru.kata.models.adminUserRestController.request.AddUserRequest;
import ru.kata.models.adminUserRestController.response.DeleteUserResponse;
import ru.kata.models.adminUserRestController.response.GetAddEditUserResponse;
import ru.kata.rest.token.JwtToken;
import ru.kata.rest.token.Root;

import java.util.List;

import static io.restassured.RestAssured.given;


public class PositiveRequestSpecification {


    public static RequestSpecification requestSpecification() {

        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://admin-aqaj.kata.academy")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build().header("Authorization","Bearer " +setToken().getData().getToken());

    }

    public static Root setToken() {
        JwtToken jwtToken = new JwtToken("admin1@mail.ru","admin", false);
        return given().contentType(ContentType.JSON)
                .body(jwtToken)
                .when()
                .post(Endpoint.getJwtToken)
                .then().log().all()
                .extract().as(Root.class);
    }


    public static ResponseSpecification statusCode(Integer code) {
        ResponseSpecBuilder builder = new ResponseSpecBuilder()
                .expectStatusCode(code);
        return builder.build();
    }


    public static GetAddEditUserResponse getUserResponse(Integer userId, Integer code) {

        return given()
                .spec(requestSpecification())
                .when()
                .get(Endpoint.getDeleteEditUser, userId)
                .then()
                .assertThat()
                .spec(statusCode(code))
                .extract().body().jsonPath().getObject("data", GetAddEditUserResponse.class);

    }

    public static DeleteUserResponse deleteUserResponse(Integer userId, Integer code) {

        return given()
                .spec(requestSpecification())
                .when()
                .delete(Endpoint.getDeleteEditUser, userId)
                .then()
                .assertThat()
                .spec(statusCode(code))
                .extract().as(DeleteUserResponse.class);

    }

    public static GetAddEditUserResponse addUserResponse(String avatarUrl, String birthday, String email, Boolean enabled , String firstName, Integer id, Boolean imageFromSlack, Inactivation inactivation, Boolean isViewReport , String lastName, String password, RoleTable role   , Integer code) {
        AddUserRequest user = new AddUserRequest(avatarUrl,birthday,email,enabled,firstName,id,imageFromSlack,inactivation,isViewReport,lastName,password,role);
        return given()
                .spec(requestSpecification())
                .body(user)
                .when()
                .post(Endpoint.saveUser)
                .then()
                .assertThat()
                .spec(statusCode(code))
                .extract().body().jsonPath().getObject("data", GetAddEditUserResponse.class);
    }

    public static GetAddEditUserResponse editUserResponse(Integer id, String email, String password, String firstName , String lastName  , String birthday , Boolean enabled , RoleTable role , Boolean imageFromSlack , Boolean isViewReport , String avatarUrl , Inactivation inactivation, Integer code) {
        AddUserRequest user = new AddUserRequest(avatarUrl,birthday,email,enabled,firstName,id,imageFromSlack,inactivation,isViewReport,lastName,password,role);
        return given()
                .spec(requestSpecification())
                .body(user)
                .when()
                .put(Endpoint.getDeleteEditUser,id)
                .then()
                .assertThat()
                .spec(statusCode(code))
                .extract().body().jsonPath().getObject("data", GetAddEditUserResponse.class);
    }


    public static List<UserTable> getAllCuratorsResponse(Integer code) {

        return given()
                .spec(requestSpecification())
                .when()
                .get(Endpoint.getAllCurators)
                .then()
                .assertThat()
                .spec(statusCode(code))
                .extract().body().jsonPath().getList("data", UserTable.class);

    }

}


