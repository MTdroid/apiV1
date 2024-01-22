package adminUserRestController;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.kata.entity.adminUserRestController.Inactivation;
import ru.kata.entity.adminUserRestController.RoleTable;
import ru.kata.models.adminUserRestController.response.DeleteUserResponse;
import ru.kata.models.adminUserRestController.response.ErrorResponse;
import ru.kata.models.adminUserRestController.response.GetAddEditUserResponse;
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
    String password = TestDataGenerator.generateData(7);
    String firstName = TestDataGenerator.generateData(7);
    String lastName = TestDataGenerator.generateData(7);
    String birthday = TestDataGenerator.generateDate();
    Integer id = null;
    Boolean enabled = true;
    Boolean isViewReport = true;
    Boolean imageFromSlack = null;
    String avatarUrl = null;
    Inactivation inactivation = new Inactivation();
    RoleTable role = new RoleTable();

    @Test
    @DisplayName("Удаление существующего пользователя")
    @Description("Пользователь удаляется, статус-код 200, в теле ответа отображается success: true, data: null" )
    public void deleteUser() {

        role.setName("STUDENT");
        PositiveRequestSpecification.addUserResponse(avatarUrl,birthday,email,enabled,firstName,id,imageFromSlack,inactivation,isViewReport,lastName,password,role, 200);

        Integer userId = DataBaseStep.findUserByEmail(email,firstName,lastName);

        DeleteUserResponse deleteUserResponse = PositiveRequestSpecification.deleteUserResponse(userId, 200);
        DeleteUserStep.checkResponseBody(deleteUserResponse);
        DataBaseStep.deleteUser(userId);

    }

    @ParameterizedTest
    @MethodSource("idArgs")
    @DisplayName("Удаление несуществующего пользователя")
    @Description("Пользователь не удаляется, статус-код 400, появляется сообщение: Пользователь с указанным id не найден")
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
