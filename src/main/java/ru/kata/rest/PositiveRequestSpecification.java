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
import ru.kata.models.adminUserRestController.addUser.AddUserRequest;
import ru.kata.models.adminUserRestController.addUser.AddUserResponse;
import ru.kata.models.adminUserRestController.deleteUserById.DeleteUserResponse;
import ru.kata.models.adminUserRestController.getAllCurators.GetAllCuratorsResponse;
import ru.kata.rest.token.Root;

import java.util.List;

import static io.restassured.RestAssured.given;


public class PositiveRequestSpecification {


    public static RequestSpecification requestSpecification() {

        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://admin-aqaj.kata.academy/")
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


    public static AddUserResponse getUserResponse(Integer userId, Integer code) {

        return given()
                .spec(requestSpecification())
                .when()
                .get(Endpoint.getUser, userId)
                .then()
                .assertThat()
                .spec(statusCode(code))
                .extract().body().jsonPath().getObject("data",AddUserResponse.class);

    }

    public static DeleteUserResponse deleteUserResponse(Integer userId, Integer code) {

        return given()
                .spec(requestSpecification())
                .when()
                .delete(Endpoint.getUser, userId)
                .then()
                .assertThat()
                .spec(statusCode(code))
                .extract().as(DeleteUserResponse.class);

    }

    public static AddUserResponse addUserResponse(Integer id, String email, String password, String firstName , String lastName  , String birthday , Boolean enabled , RoleTable role , Boolean imageFromSlack , Boolean isViewReport , String avatarUrl , Inactivation inactivation, Integer code) {
        AddUserRequest user = new AddUserRequest( id,  email,  password, firstName , lastName  , birthday , enabled, role , imageFromSlack , isViewReport , avatarUrl, inactivation);
        return given()
                .spec(requestSpecification())
                .body(user)
                .when()
                .post(Endpoint.saveUser)
                .then()
                .assertThat()
                .spec(statusCode(code))
                .extract().body().jsonPath().getObject("data",AddUserResponse.class);
    }

    public static AddUserResponse editUserResponse(Integer id, String email, String password, String firstName , String lastName  , String birthday , Boolean enabled , RoleTable role , Boolean imageFromSlack , Boolean isViewReport , String avatarUrl , Inactivation inactivation, Integer code) {
        AddUserRequest user = new AddUserRequest( id,  email,  password, firstName , lastName  , birthday , enabled, role , imageFromSlack , isViewReport , avatarUrl, inactivation);
        return given()
                .spec(requestSpecification())
                .body(user)
                .when()
                .put(Endpoint.editUser,id)
                .then()
                .assertThat()
                .spec(statusCode(code))
                .extract().body().jsonPath().getObject("data",AddUserResponse.class);
    }


    public static List<GetAllCuratorsResponse> getAllCuratorsResponse(Integer code) {

        return given()
                .spec(requestSpecification())
                .when()
                .get(Endpoint.getAllCurators)
                .then()
                .assertThat()
                .spec(statusCode(code))
                .extract().body().jsonPath().getList("data",GetAllCuratorsResponse.class);

    }

}


