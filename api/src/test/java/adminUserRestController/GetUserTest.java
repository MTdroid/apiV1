package adminUserRestController;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kata.entity.adminUserRestController.Inactivation;
import ru.kata.entity.adminUserRestController.RoleTable;
import ru.kata.models.adminUserRestController.response.DeleteUserResponse;
import ru.kata.models.adminUserRestController.response.ErrorResponse;
import ru.kata.models.adminUserRestController.response.GetAddEditUserResponse;
import ru.kata.rest.ErrorRequestSpecification;
import ru.kata.rest.PositiveRequestSpecification;
import ru.kata.steps.adminUserRestController.*;
import ru.kata.utils.TestDataGenerator;

public class GetUserTest {

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
    @DisplayName("Получение существующего пользователя")
    @Description("Данные пользователя появляются, статус-код 200")
    public void getUserById() {

        role.setName("PAY_STUDENT");

        PositiveRequestSpecification.addUserResponse(avatarUrl, birthday, email, enabled, firstName, id, imageFromSlack, inactivation, isViewReport, lastName, password, role, 200);

        Integer userId = DataBaseStep.findUserByEmail(email, firstName, lastName);

        GetAddEditUserResponse getUserResponse = PositiveRequestSpecification.getUserResponse(userId, 200);
        GetUserStep.checkResponseBody(getUserResponse,userId);

        DataBaseStep.findUserById(userId);

    }

    @Test
    @DisplayName("Получение несуществующего пользователя")
    @Description("Данные пользователя не появляются, статус-код 400 появляется сообщение:По переданному id пользователь не найден")
    public void getNotExistUserById() {

        ErrorResponse getUserResponse = ErrorRequestSpecification.getUserResponseErr(99999, 200);
        ErrorResponseStep.checkResponse(getUserResponse, 400, "По переданному id пользователь не найден");

    }

    @Test
    @DisplayName("Получение пользователя с id - 0")
    @Description("Данные пользователя не появляются, статус-код 400 появляется сообщение:getById.id: должно быть больше 0")
    public void getUserWithZeroId() {

        ErrorResponse getUserResponse = ErrorRequestSpecification.getUserResponseErr(0, 200);
        ErrorResponseStep.checkResponse(getUserResponse, 400, "getById.id: должно быть больше 0");

    }
}
