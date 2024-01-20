package adminUserRestController;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.kata.entity.adminUserRestController.Inactivation;
import ru.kata.entity.adminUserRestController.RoleTable;
import ru.kata.models.response.ErrorResponse;
import ru.kata.models.response.GetAddEditUserResponse;
import ru.kata.rest.ErrorRequestSpecification;
import ru.kata.rest.PositiveRequestSpecification;
import ru.kata.steps.adminUserRestController.AddUserStep;
import ru.kata.steps.adminUserRestController.DataBaseStep;
import ru.kata.steps.adminUserRestController.ErrorResponseStep;
import ru.kata.utils.TestDataGenerator;

import java.util.stream.Stream;

public class AddUserTest {

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
    @DisplayName("Добавление нового пользователя")
    @Description("РАБОТАЕТ")
    public void saveUser() {

        role.setName("STUDENT");

        GetAddEditUserResponse addUserResponse = PositiveRequestSpecification.addUserResponse(avatarUrl,birthday,email,enabled,firstName,id,imageFromSlack,inactivation,isViewReport,lastName,password,role, 200);
        AddUserStep.checkResponseBody(addUserResponse, firstName, role, email, lastName, birthday);

        DataBaseStep.findUserByEmail(email,firstName,lastName);

    }

    @Test
    @DisplayName("Добавление нового пользователя")
    @Description("РАБОТАЕТ")
    public void saveUserWithDuplicateEmail() {

        role.setName("STUDENT");
        String duplicateEmail = email;

        PositiveRequestSpecification.addUserResponse(avatarUrl,birthday,email,enabled,firstName,id,imageFromSlack,inactivation,isViewReport,lastName,password,role, 200);

        ErrorResponse addUser2 = ErrorRequestSpecification.addUserResponseErr(avatarUrl,birthday,duplicateEmail,enabled,firstName,id,imageFromSlack,inactivation,isViewReport,lastName,password,role, 200);
        ErrorResponseStep.checkResponse(addUser2,400,"Веденный email уже зарегистрированн на EWP");

    }

    @Test
    @DisplayName("Добавление нового пользователя")
    @Description("РАБОТАЕТ")
    public void saveUserWithInvalidRole() {


        role.setName("MARAT");

        ErrorResponse addUser = ErrorRequestSpecification.addUserResponseErr(avatarUrl,birthday,email,enabled,firstName,id,imageFromSlack,inactivation,isViewReport,lastName,password,role, 200);
        ErrorResponseStep.checkResponse(addUser,500,"JSON parse error: Cannot deserialize value of type `education.web.platform.enums.RoleNameEnum");


    }

    @Test
    @DisplayName("Добавление нового пользователя")
    @Description("РАБОТАЕТ")
    public void saveUserWithInvalidDateFormat() {

        role.setName("ADMIN");

        String invalidBirthday = "11-11-2011";

        ErrorResponse addUser = ErrorRequestSpecification.addUserResponseErr(avatarUrl,invalidBirthday,email,enabled,firstName,id,imageFromSlack,inactivation,isViewReport,lastName,password,role, 200);
        ErrorResponseStep.checkResponse(addUser,500,"JSON parse error: Cannot deserialize value of type `java.time.LocalDate`");

    }

    @ParameterizedTest
    @MethodSource("passwordArgs")
    @DisplayName("Добавление нового пользователя")
    @Description("РАБОТАЕТ")
    public void saveUserWithInvalidPasswordLength(String invalidPass) {

        role.setName("CURATOR");

        ErrorResponse addUser = ErrorRequestSpecification.addUserResponseErr(avatarUrl,birthday,email,enabled,firstName,id,imageFromSlack,inactivation,isViewReport,lastName,invalidPass,role, 200);
        ErrorResponseStep.checkResponse(addUser,400,"Длина пароля: 6-30 символов");

    }
    static Stream<String> passwordArgs() {
        return Stream.of(TestDataGenerator.generateData(1),TestDataGenerator.generateData(31));
    }
}
