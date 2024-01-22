package adminUserRestController;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.kata.entity.adminUserRestController.Inactivation;
import ru.kata.entity.adminUserRestController.RoleTable;
import ru.kata.models.adminUserRestController.response.ErrorResponse;
import ru.kata.models.adminUserRestController.response.GetAddEditUserResponse;
import ru.kata.rest.ErrorRequestSpecification;
import ru.kata.rest.PositiveRequestSpecification;
import ru.kata.steps.adminUserRestController.AddUserStep;
import ru.kata.steps.adminUserRestController.DataBaseStep;
import ru.kata.steps.adminUserRestController.EditUserStep;
import ru.kata.steps.adminUserRestController.ErrorResponseStep;
import ru.kata.utils.TestDataGenerator;

import java.util.stream.Stream;

public class EditUserTest {
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
    @DisplayName("Редактирование данных существующего пользователя")
    @Description("Данные пользователя изменяются,статус-код 200, в теле ответа отображаются измененные данные пользователя")
    public void editUser() {
        String editBirthday = "10.10.2010";
        String editFirstName = "editFirstName";
        String editLastName = "editLastName";
        String editPass = "editPass";
        String editEmail = TestDataGenerator.generateEmail();

        role.setName("PAY_STUDENT");
        PositiveRequestSpecification.addUserResponse(avatarUrl, birthday, email, enabled, firstName, id, imageFromSlack, inactivation, isViewReport, lastName, password, role, 200);

        Integer userId = DataBaseStep.findUserByEmail(email, firstName, lastName);

        GetAddEditUserResponse editUserResponse = PositiveRequestSpecification.editUserResponse(userId, editEmail, editPass, editFirstName, editLastName, editBirthday, enabled, role, imageFromSlack, isViewReport, avatarUrl, inactivation, 200);
        EditUserStep.checkResponseBody(editUserResponse, editFirstName, editEmail, editLastName, editBirthday);

    }

    @ParameterizedTest
    @MethodSource("idArgs")
    @DisplayName("Редактирование данных несуществующего пользователя")
    @Description("Данные пользователя не изменяются,статус-код 400, появляется сообщение:Пользователя с переданным id не существует")
    public void editNotExistUser(int invalidId) {

        ErrorResponse editUserResponse = ErrorRequestSpecification.editUserResponseErr(invalidId, email, password, firstName, lastName, birthday, enabled, role, imageFromSlack, isViewReport, avatarUrl, inactivation, 200);
        ErrorResponseStep.checkResponse(editUserResponse, 400, "Пользователя с переданным id не существует");

    }

    static Stream<Integer> idArgs() {
        return Stream.of(0, 9999);
    }

    @Test
    @DisplayName("Изменение роли существующего пользователя")
    @Description("Данные пользователя не изменяются,статус-код 400, появляется сообщение:Запрещено изменять роль")
    public void editUserRole() {
        role.setName("PAY_STUDENT");
        PositiveRequestSpecification.addUserResponse(avatarUrl, birthday, email, enabled, firstName, id, imageFromSlack, inactivation, isViewReport, lastName, password, role, 200);

        Integer userId = DataBaseStep.findUserByEmail(email, firstName, lastName);
        role.setName("ADMIN");

        ErrorResponse editUserResponse = ErrorRequestSpecification.editUserResponseErr(userId, email, password, firstName, lastName, birthday, enabled, role, imageFromSlack, isViewReport, avatarUrl, inactivation, 200);
        ErrorResponseStep.checkResponse(editUserResponse, 400, "Запрещено изменять роль");

    }
}

