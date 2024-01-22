package adminUserRestController;

import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
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
import ru.kata.steps.adminUserRestController.ErrorResponseStep;
import ru.kata.utils.TestDataGenerator;

import javax.validation.constraints.Negative;
import java.util.stream.Stream;

public class AddUserTest {

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
    @DisplayName("Добавление нового пользователя")
    @Description("Пользователь сохраняется, статус-код 200, в теле ответа отображаются данные сохраненного пользователя")
    public void saveUser() {

        role.setName("STUDENT");

        GetAddEditUserResponse addUserResponse = PositiveRequestSpecification.addUserResponse(avatarUrl,birthday,email,enabled,firstName,id,imageFromSlack,inactivation,isViewReport,lastName,password,role, 200);
        AddUserStep.checkResponseBody(addUserResponse, firstName, role, email, lastName, birthday);

        DataBaseStep.findUserByEmail(email,firstName,lastName);

    }

    @Test
    @Negative
    @DisplayName("Добавление нового пользователя c email ранее зарегистрированным в базе")
    @Description("Пользователь не сохраняется, статус-код 400, появляется сообщение: Веденный email уже зарегистрированн на EWP")
    public void saveUserWithDuplicateEmail() {

        role.setName("PAY_STUDENT");
        String duplicateEmail = email;

        PositiveRequestSpecification.addUserResponse(avatarUrl,birthday,email,enabled,firstName,id,imageFromSlack,inactivation,isViewReport,lastName,password,role, 200);

        ErrorResponse addUser2 = ErrorRequestSpecification.addUserResponseErr(avatarUrl,birthday,duplicateEmail,enabled,firstName,id,imageFromSlack,inactivation,isViewReport,lastName,password,role, 200);
        ErrorResponseStep.checkResponse(addUser2,400,"Веденный email уже зарегистрированн на EWP");

    }

    @Test
    @DisplayName("Добавление нового пользователя c невалидным значением роли")
    @Description("Пользователь не сохраняется, статус-код 500, появляется сообщение: JSON parse error")
    public void saveUserWithInvalidRole() {

        role.setName("MARAT");

        ErrorResponse addUser = ErrorRequestSpecification.addUserResponseErr(avatarUrl,birthday,email,enabled,firstName,id,imageFromSlack,inactivation,isViewReport,lastName,password,role, 200);
        ErrorResponseStep.checkResponse(addUser,500,"JSON parse error: Cannot deserialize value of type `education.web.platform.enums.RoleNameEnum");


    }

    @Test
    @DisplayName("Добавление нового пользователя с невалидным форматом даты в поле birthday")
    @Description("Пользователь не сохраняется, статус-код 500, появляется сообщение:JSON parse error")
    public void saveUserWithInvalidDateFormat() {

        role.setName("ADMIN");

        String invalidBirthday = "11-11-2011";

        ErrorResponse addUser = ErrorRequestSpecification.addUserResponseErr(avatarUrl,invalidBirthday,email,enabled,firstName,id,imageFromSlack,inactivation,isViewReport,lastName,password,role, 200);
        ErrorResponseStep.checkResponse(addUser,500,"JSON parse error: Cannot deserialize value of type `java.time.LocalDate`");

    }

    @ParameterizedTest
    @MethodSource("passwordArgs")
    @DisplayName("Добавление нового пользователя c паролем 6< и >30 символов")
    @Description("Пользователь не сохраняется, статус-код 400, появляется сообщение:Длина пароля: 6-30 символов")
    public void saveUserWithInvalidPasswordLength(String invalidPass) {

        role.setName("CURATOR");

        ErrorResponse addUser = ErrorRequestSpecification.addUserResponseErr(avatarUrl,birthday,email,enabled,firstName,id,imageFromSlack,inactivation,isViewReport,lastName,invalidPass,role, 200);
        ErrorResponseStep.checkResponse(addUser,400,"Длина пароля: 6-30 символов");

    }
    static Stream<String> passwordArgs() {
        return Stream.of(TestDataGenerator.generateData(1),TestDataGenerator.generateData(31));
    }
}
