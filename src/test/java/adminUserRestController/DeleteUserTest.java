package adminUserRestController;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.kata.entity.adminUserRestController.Inactivation;
import ru.kata.entity.adminUserRestController.RoleTable;
import ru.kata.models.response.DeleteUserResponse;
import ru.kata.models.response.ErrorResponse;
import ru.kata.models.response.GetAddEditUserResponse;
import ru.kata.rest.ErrorRequestSpecification;
import ru.kata.rest.PositiveRequestSpecification;
import ru.kata.steps.adminUserRestController.AddUserStep;
import ru.kata.steps.adminUserRestController.DataBaseStep;
import ru.kata.steps.adminUserRestController.DeleteUserStep;
import ru.kata.steps.adminUserRestController.ErrorResponseStep;
import ru.kata.utils.TestDataGenerator;

import java.util.stream.Stream;

public class DeleteUserTest {
    String email = TestDataGenerator.generateEmail();
    String password = "password";
    String firstName = "pfdsfass";
    String lastName = "pfdsfass";
    String birthday = TestDataGenerator.generateDate();
    Integer id = 0;
    Boolean enabled = true;
    Boolean isViewReport = true;
    Boolean imageFromSlack = null;
    String avatarUrl = null;
    Inactivation inactivation = new Inactivation();
    RoleTable role = new RoleTable();

    @Test
    @DisplayName("Удаление существующего пользователя")
    @Epic("API тесты")
    @Story("РАБОТАЕТ, добавить степы")
    public void deleteUser() {


         role.setName("STUDENT");
        GetAddEditUserResponse addUserResponse = PositiveRequestSpecification.addUserResponse(avatarUrl,birthday,email,enabled,firstName,id,imageFromSlack,inactivation,isViewReport,lastName,password,role, 200);
        AddUserStep.checkResponseBody(addUserResponse, firstName, role,email,lastName,birthday);

        Integer userId = DataBaseStep.findUserByEmail(email,firstName,lastName);

        DeleteUserResponse deleteUserResponse = PositiveRequestSpecification.deleteUserResponse(userId, 200);
        DeleteUserStep.checkResponseBody(deleteUserResponse);



    }


    @ParameterizedTest
    @MethodSource("idArgs")
    @DisplayName("Удаление несуществующего пользователя")
    @Epic("API тесты")
    @Story("РАБОТАЕТ, добавить степы")
    public void deleteNonExistUser(int invalidId) {

        ErrorResponse deleteUserResponse = ErrorRequestSpecification.deleteUserResponseErr(invalidId, 200);
        ErrorResponseStep.checkResponse(deleteUserResponse,400,"Пользователь с указанным id не найден");
    }

    static Stream<Integer> idArgs() {
        return Stream.of(0,99999);
    }
}
