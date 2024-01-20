package adminUserRestController;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kata.entity.adminUserRestController.Inactivation;
import ru.kata.entity.adminUserRestController.RoleTable;
import ru.kata.models.response.GetAddEditUserResponse;
import ru.kata.models.response.GetAllCuratorsResponse;
import ru.kata.rest.PositiveRequestSpecification;
import ru.kata.steps.adminUserRestController.AddUserStep;
import ru.kata.steps.adminUserRestController.DataBaseStep;
import ru.kata.steps.adminUserRestController.GetAllCuratorsStep;
import ru.kata.utils.TestDataGenerator;

import java.util.List;

public class GetAllCuratorsTest {

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
    @DisplayName("Получение всех пользователей с ролью 'CURATOR'. Создано 1 куратор")
    @Description("РАБОТАЕТ")
    public void getCurator() {

        role.setName("CURATOR");

        GetAddEditUserResponse addUserResponse = PositiveRequestSpecification.addUserResponse(avatarUrl,birthday,email,enabled,firstName,id,imageFromSlack,inactivation,isViewReport,lastName,password,role, 200);
        AddUserStep.checkResponseBody(addUserResponse, firstName, role, email, lastName, birthday);

        List<GetAllCuratorsResponse> getAllCuratorsResponse = PositiveRequestSpecification.getAllCuratorsResponse(200);
        GetAllCuratorsStep.checkResponseBody(getAllCuratorsResponse,id,email,firstName,lastName);
        System.out.println(getAllCuratorsResponse);

        // Добавить удаление всех кураторов после теста
    }

    @Test
    @DisplayName("Получение всех пользователей с ролью 'CURATOR'. Создано 2 куратора")
    @Description("РАБОТАЕТ")
    public void getAllCurators() {

        role.setName("CURATOR");
        String secondCuratorEmail = "secondCuratorEmail@gmail.com";

PositiveRequestSpecification.addUserResponse(avatarUrl,birthday,email,enabled,firstName,id,imageFromSlack,inactivation,isViewReport,lastName,password,role, 200);
PositiveRequestSpecification.addUserResponse(avatarUrl,birthday,secondCuratorEmail,enabled,firstName,id,imageFromSlack,inactivation,isViewReport,lastName,password,role, 200);

        List<GetAllCuratorsResponse> getAllCuratorsResponse = PositiveRequestSpecification.getAllCuratorsResponse(200);
        GetAllCuratorsStep.checkResponseBody(getAllCuratorsResponse,id,email,firstName,lastName);

        System.out.println(getAllCuratorsResponse);

        // Добавить удаление всех кураторов после теста
    }

    @Test
    @DisplayName("Получение всех пользователей с ролью 'CURATOR'. Создано 2 куратора")
    @Description("РАБОТАЕТ")
    public void getZeroCurators() {


        List<GetAllCuratorsResponse> getAllCuratorsResponse = PositiveRequestSpecification.getAllCuratorsResponse(200);

        System.out.println(getAllCuratorsResponse);

        // Добавить удаление всех кураторов после теста
    }
}
