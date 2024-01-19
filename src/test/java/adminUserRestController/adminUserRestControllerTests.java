package adminUserRestController;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import ru.kata.entity.adminUserRestController.Inactivation;
import ru.kata.entity.adminUserRestController.RoleTable;
import ru.kata.models.adminUserRestController.addUser.AddUserResponse;

import ru.kata.models.adminUserRestController.deleteUserById.DeleteUserResponse;
import ru.kata.models.adminUserRestController.getAllCurators.GetAllCuratorsResponse;
import ru.kata.rest.PositiveRequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kata.steps.adminUserRestController.AddUserStep;
import ru.kata.steps.adminUserRestController.DbCheck;
import ru.kata.steps.adminUserRestController.GetUserStep;
import ru.kata.utils.TestDataGenerator;

import java.util.List;


public class adminUserRestControllerTests {
    @Test
    @DisplayName("Получение данных пользователя")
    @Epic("API тесты")
    @Story("Позитивные тесты")
    public void getUserById() {

        AddUserResponse addUserResponse = PositiveRequestSpecification.getUserResponse(8, 200);
        GetUserStep.checkResponseBody(addUserResponse);
        System.out.println(addUserResponse);
        DbCheck.findUser(1);


    }

    @Test
    @DisplayName("Удаление пользователя")
    @Epic("API тесты")
    @Story("РАБОТАЕТ, добавить степы")
    public void deleteUser() {

        DeleteUserResponse deleteUserResponse = PositiveRequestSpecification.deleteUserResponse(555, 200);
        System.out.println(deleteUserResponse);
    }

    @Test
    @DisplayName("Добавление нового пользователя")
    @Description("РАБОТАЕТ")
    public void saveUser() {


        String email = TestDataGenerator.generateEmail();
        String password = "password";
        String firstName = "pfdsfass";
        String lastName = "pfdsfass";
        String birthday = TestDataGenerator.generateDate();
        Integer id = null;
        Boolean enabled = true;
        Boolean isViewReport = true;
        Boolean imageFromSlack = null;
        String avatarUrl = null;

        Inactivation inactivation = new Inactivation();
        inactivation.setInactive(true);
        inactivation.setReason("NEED_CHANGE_PASSWORD");
        RoleTable role = new RoleTable();
        role.setName("PAY_STUDENT");

        AddUserResponse addUserResponse = PositiveRequestSpecification.addUserResponse(id, email, password, firstName, lastName, birthday, enabled, role, imageFromSlack, isViewReport, avatarUrl, inactivation, 200);
        AddUserStep.checkResponseBody(addUserResponse, firstName, role);


    }

    @Test
    @DisplayName("Редактирование данных пользователя")
    @Description("РАБОТАЕТ, В спеках add user")
    public void editUser() {


        Integer id = 556;
        String email = TestDataGenerator.generateEmail();
        String password = "password";
        String firstName = "pfdsfass";
        String lastName = "pfdsfass";
        String birthday = TestDataGenerator.generateDate();
        Boolean enabled = true;
        Boolean isViewReport = true;
        Boolean imageFromSlack = null;
        String avatarUrl = null;

        Inactivation inactivation = new Inactivation();
        inactivation.setInactive(true);
        inactivation.setReason("NEED_CHANGE_PASSWORD");
        RoleTable role = new RoleTable();
        role.setName("PAY_STUDENT");


        AddUserResponse addUserResponse = PositiveRequestSpecification.editUserResponse(id, email, password, firstName, lastName, birthday, enabled, role, imageFromSlack, isViewReport, avatarUrl, inactivation, 200);
        AddUserStep.checkResponseBody(addUserResponse, firstName, role);
        System.out.println(addUserResponse);

    }

    @Test
    @DisplayName("Получение всех пользователей с ролью 'CURATOR'")
    @Description("РАБОТАЕТ")
    public void getAllCurators() {


        List<GetAllCuratorsResponse> getAllCuratorsResponse = PositiveRequestSpecification.getAllCuratorsResponse(200);
        System.out.println(getAllCuratorsResponse);
    }

}


