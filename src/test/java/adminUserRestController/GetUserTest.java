package adminUserRestController;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kata.entity.adminUserRestController.Inactivation;
import ru.kata.entity.adminUserRestController.RoleTable;
import ru.kata.models.response.DeleteUserResponse;
import ru.kata.models.response.ErrorResponse;
import ru.kata.models.response.GetAddEditUserResponse;
import ru.kata.rest.ErrorRequestSpecification;
import ru.kata.rest.PositiveRequestSpecification;
import ru.kata.steps.adminUserRestController.*;
import ru.kata.utils.TestDataGenerator;

public class GetUserTest {

    String email = TestDataGenerator.generateEmail();
    String password = "password";
    String firstName = "pfdsfass";
    String lastName = "pfdsfass";
    String birthday = TestDataGenerator.generateDate();
    Integer id = 1;
    Boolean enabled = true;
    Boolean isViewReport = true;
    Boolean imageFromSlack = null;
    String avatarUrl = null;
    Inactivation inactivation = new Inactivation();
    RoleTable role = new RoleTable();

    @Test
    @DisplayName("ПDSADDSADS")
    @Epic("API тесты")
    @Story("Позитивные тесты")
    public void getUserById() {

        role.setName("PAY_STUDENT");
        GetAddEditUserResponse addUserResponse = PositiveRequestSpecification.addUserResponse(avatarUrl,birthday,email,enabled,firstName,id,imageFromSlack,inactivation,isViewReport,lastName,password,role, 200);
        AddUserStep.checkResponseBody(addUserResponse, firstName, role,email,lastName,birthday);

        Integer userId = DataBaseStep.findUserByEmail(email,firstName,lastName);


        DeleteUserResponse deleteUserResponse = PositiveRequestSpecification.deleteUserResponse(userId, 200);
        DeleteUserStep.checkResponseBody(deleteUserResponse);
        DeleteUserResponse deleteUserResponse2 = PositiveRequestSpecification.deleteUserResponse(userId, 200);
        DeleteUserStep.checkResponseBody(deleteUserResponse);

        /*GetAddEditUserResponse getUserResponse = PositiveRequestSpecification.getUserResponse(userId, 200);
        GetUserStep.checkResponseBody(getUserResponse);

        DataBaseStep.findUserById(userId);*/

    }
    @Test
    @DisplayName("ПDSADDSADS")
    @Epic("API тесты")
    @Story("Позитивные тесты")
    public void getNotExistUserById() {

        ErrorResponse getUserResponse = ErrorRequestSpecification.getUserResponseErr(99999, 200);
        ErrorResponseStep.checkResponse(getUserResponse,400,"По переданному id пользователь не найден");

    }
    @Test
    @DisplayName("ПDSADDSADS")
    @Epic("API тесты")
    @Story("Позитивные тесты")
    public void getUserWithZeroId() {


        ErrorResponse getUserResponse = ErrorRequestSpecification.getUserResponseErr(0, 200);
        ErrorResponseStep.checkResponse(getUserResponse,400,"getById.id: должно быть больше 0");

    }
}
