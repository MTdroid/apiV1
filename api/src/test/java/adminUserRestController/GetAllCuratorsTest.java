package adminUserRestController;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kata.entity.adminUserRestController.Inactivation;
import ru.kata.entity.adminUserRestController.RoleTable;
import ru.kata.entity.adminUserRestController.UserTable;
import ru.kata.rest.PositiveRequestSpecification;
import ru.kata.steps.adminUserRestController.DataBaseStep;
import ru.kata.steps.adminUserRestController.GetAllCuratorsStep;
import ru.kata.utils.TestDataGenerator;

import java.util.List;

public class GetAllCuratorsTest {

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
    @DisplayName("Получение всех пользователей с ролью 'CURATOR'")
    @Description("Появляется список пользователей с ролью 'CURATOR', статус-код 200")
    public void getCurator() {

        role.setName("CURATOR");

        PositiveRequestSpecification.addUserResponse(avatarUrl,birthday,email,enabled,firstName,id,imageFromSlack,inactivation,isViewReport,lastName,password,role, 200);

        Integer userId = DataBaseStep.findUserByEmail(email,firstName,lastName);

        List<UserTable> UserTable = PositiveRequestSpecification.getAllCuratorsResponse(200);
        GetAllCuratorsStep.checkResponseBody(UserTable);

        DataBaseStep.findAllCurators(UserTable);
        DataBaseStep.deleteUser(userId);

    }
}
