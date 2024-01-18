package ru.kata.rest;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import ru.kata.entity.RoleTable;
import ru.kata.entity.UserTable;
import ru.kata.models.AdminUserRestController.addUser.AddUserRequest;
import ru.kata.models.AdminUserRestController.addUser.AddUserResponse;
import ru.kata.models.AdminUserRestController.deleteUserById.DeleteUserResponse;
import ru.kata.models.AdminUserRestController.editUserById.EditUserRequest;
import ru.kata.models.AdminUserRestController.editUserById.EditUserResponse;
import ru.kata.models.AdminUserRestController.getAllCurators.GetAllCuratorsResponse;
import ru.kata.models.AdminUserRestController.getUserById.GetUserResponse;

import static io.restassured.RestAssured.given;


public class PositiveRequestSpecification {


    public static RequestSpecification requestSpecification() {

        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://admin-aqaj.kata.academy")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build().header("Authorization","Bearer " +"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbjFAbWFpbC5ydSIsInNjb3BlcyI6IkFETUlOIiwiaWF0IjoxNzA1NTgwMDc2LCJleHAiOjE3MDU1OTgwNzZ9.cJcodXSUlfylinlHAuxVm4wnJ5Z9GGedKieRavrk6nE");

    }
    public static String setToken() {
        JwtToken jwtToken = new JwtToken("admin1@mail.ru","admin", false);
        return given().contentType(ContentType.JSON)
                .body(jwtToken)
                .when()
                .get(Endpoint.getJwtToken)
                .then()
                .extract().jsonPath().get("jwtToken");
    }
    public static ResponseSpecification statusCode(Integer code) {
        ResponseSpecBuilder builder = new ResponseSpecBuilder()
                .expectStatusCode(code);
        return builder.build();
    }
    public static GetUserResponse getUserResponse(Integer userId, Integer code) {

        return given()
                .spec(requestSpecification())
                .when()
                .get(Endpoint.getUser, userId)
                .then()
                .assertThat()
                .spec(statusCode(code))
                .extract().as(GetUserResponse.class);

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

    public static AddUserResponse addUserResponse(String birthday, String email, String firstName, String lastName, String password,RoleTable role, Integer code) {
        AddUserRequest user = new AddUserRequest(birthday,email,firstName,lastName,password, role);
        return given()
                .spec(requestSpecification())
                .body(user)
                .when()
                .post(Endpoint.saveUser)
                .then()
                .assertThat()
                .spec(statusCode(code))
                .extract().as(AddUserResponse.class);
    }
    public static EditUserResponse editUserResponse(Long id, String email,String password,  String firstName, String lastName, String birthday,  RoleTable role, Integer code) {
        EditUserRequest user = new EditUserRequest(id,email,password,firstName,lastName,birthday, role);
        return given()
                .spec(requestSpecification())
                .body(user)
                .when()
                .put(Endpoint.editUser,id)
                .then()
                .assertThat()
                .spec(statusCode(code))
                .extract().as(EditUserResponse.class);
    }
    public static GetAllCuratorsResponse getAllCuratorsResponse(Integer code) {

        return given()
                .spec(requestSpecification())
                .when()
                .get(Endpoint.getAllCurators)
                .then()
                .assertThat()
                .spec(statusCode(code))
                .extract().as(GetAllCuratorsResponse.class);

    }


/*


    public static List<AuthorGetAllBooksXMLResponse> authorGetAllBooksXMLResponse(int authorId, Integer code) {
        AuthorGetAllBooksXMLRequest author = new AuthorGetAllBooksXMLRequest();
        author.setId(authorId);

        return given()
                .spec(requestSpecificationXML())
                .body(author)
                .when()
                .post(Endpoint.authorGetAllBooksXML)
                .then()
                .assertThat()
                .spec(statusCode(code))
                .extract().xmlPath().getList("", AuthorGetAllBooksXMLResponse.class);
    }

    public static BooksSaveResponse booksSaveResponse(String bookTitle, Long authorId, Integer code) {
        AuthorForBookSave author = new AuthorForBookSave(authorId);
        BooksSaveRequest book = new BooksSaveRequest(bookTitle, author);
        return given()
                .spec(requestSpecification())
                .body(book)
                .when()
                .post(Endpoint.booksSave)
                .then()
                .assertThat()
                .spec(statusCode(code))
                .extract().as(BooksSaveResponse.class);
    }*/
}


