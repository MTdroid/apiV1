import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import ru.kata.entity.RoleTable;
import ru.kata.models.AdminUserRestController.addUser.AddUserRequest;
import ru.kata.models.AdminUserRestController.addUser.AddUserResponse;

import ru.kata.models.AdminUserRestController.deleteUserById.DeleteUserResponse;
import ru.kata.models.AdminUserRestController.editUserById.EditUserResponse;
import ru.kata.models.AdminUserRestController.getAllCurators.GetAllCuratorsResponse;
import ru.kata.models.AdminUserRestController.getUserById.GetUserResponse;
import ru.kata.rest.PositiveRequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kata.steps.AddUserStep;
import ru.kata.steps.DbCheck;


public class adminUserRestControllerTests {
 @Test
    @DisplayName("Получение данных пользователя")
    @Epic("API тесты")
    @Story("Позитивные тесты")
    public void getUserById() {

        /*GetUserResponse getUserResponse = PositiveRequestSpecification.getUserResponse(5,200);*/
     /*DbCheck.getAllUsers();*/
     /*DbCheck.findUser(1);*/
     /*DbCheck.deleteUser(800);*/
     DbCheck.getAllUsers();
    }
    @Test
    @DisplayName("Удаление пользователя")
    @Epic("API тесты")
    @Story("Позитивные тесты")
    public void deleteUser() {

        DeleteUserResponse deleteUserResponse = PositiveRequestSpecification.deleteUserResponse(800,200);
    }

    @Test
    @DisplayName("Добавление нового пользователя")
    @Description("Позитивный тест. Должен добавиться автор с уникальным id")
    public void saveUser() {


         String birthday="11.02.1992";
         Long id=null;
         String email ="LLLLdddsdsf2ft@mail.ru";
         String firstName ="marat";
         String lastName ="lastn";
         String pass ="pfdsfass";
        RoleTable roleTable =new RoleTable();
        roleTable.setRoleName("STUDENT");



        AddUserResponse addUserResponse = PositiveRequestSpecification.addUserResponse(birthday,email,firstName,lastName,pass,roleTable,200);
        System.out.println( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + addUserResponse + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        AddUserStep.checkResponseBody(addUserResponse,firstName);


        }
    @Test
    @DisplayName("Редактирование данных пользователя")
    @Description("Позитивный тест. Должен добавиться автор с уникальным id")
    public void editUser() {


        String birthday="11.02.1992";
        String email ="maaaarr2adafdsasddt2t@mail.ru";
        String firstName ="marat";
        String lastName ="lastn";
        String pass ="dassdads";
        RoleTable roleTable =new RoleTable();
        roleTable.setRoleName("CURATOR");
        Long id = 800L;



        EditUserResponse editUserResponse = PositiveRequestSpecification.editUserResponse(id,email,pass,firstName,lastName,birthday,roleTable,200);


    }
    @Test
    @DisplayName("Получение всех пользователей с ролью 'CURATOR'")
    @Description("Позитивный тест. Должен добавиться автор с уникальным id")
    public void getAllCurators() {


        GetAllCuratorsResponse getAllCuratorsResponse = PositiveRequestSpecification.getAllCuratorsResponse(200);


    }
    @Test
    @DisplayName("Добавление пользователя")
    @Description("Позитивный тест. Должен добавиться автор с уникальным id")
    public void addUser() {

        String birthday="11.02.1992";
        Long id=null;
        String email ="LLLLddddsdssf2ft@mail.ru";
        String firstName ="marat";
        String lastName ="lastn";
        String pass ="pfdsfass";
        RoleTable roleTable =new RoleTable();
        roleTable.setRoleName("Curator");

        DbCheck.addUser(birthday,email,firstName,lastName,pass,roleTable.getName());
    }
    }


