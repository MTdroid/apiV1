package ru.kata.steps.adminUserRestController;

import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import ru.kata.entity.adminUserRestController.UserTable;
import ru.kata.repositoryClasses.adminUserRestController.UserRepository;

import java.util.List;

public class DataBaseStep {

    @Step("Сравнение ответа бд с результатом запроса")
    public static void  findAllCurators( List<UserTable> curators) {
        List<UserTable> userTables = UserRepository.findAllCurators();
        Assertions.assertThat(userTables.size()).isEqualTo(curators.size());
        Assertions.assertThat(userTables.get(0).getId()).isEqualTo(curators.get(0).getId());
    }
    @Step("Сравнение ответа бд с результатом запроса")
    public static void  findUserById(Integer id) {
        List<UserTable> userTables= UserRepository.findUser(id);
        Assertions.assertThat(userTables).isNotEmpty();
        Assertions.assertThat(userTables.get(0).getId()).isEqualTo(id);

    }
    @Step("Нахождение пользователя по email и сравнение ответа бд с результатом запроса")
    public static Integer  findUserByEmail(String email,String firstName, String lastName) {
        List<UserTable> userTables= UserRepository.findUserByEmail(email);

        Assertions.assertThat(userTables.get(0).getEmail()).isEqualTo(email);
        Assertions.assertThat(userTables.get(0).getFirstName()).isEqualTo(firstName);
        Assertions.assertThat(userTables.get(0).getLastName()).isEqualTo(lastName);

        return userTables.get(0).getId();

    }
    public static void  getAllUsers() {
        List<UserTable> userTables = UserRepository.findAll();
        Assertions.assertThat(userTables).isNotEmpty();
        System.out.println(userTables);
    }
    public static void  deleteAllCurators() {
        UserRepository.deleteAllCurators("Curator");
    }

    public static void  SaveUser(Integer id) {
        List<UserTable> userTables= UserRepository.findUser(id);
        Assertions.assertThat(userTables).isNotEmpty();
        System.out.println(userTables);
    }

    public static void  deleteUser(Integer id) {
        UserRepository.deleteUser(id);

    }
    public static void  deleteReq(Integer id) {
        UserRepository.deleteReq2(id);
        UserRepository.deleteReq1(id);
        UserRepository.deleteReq(id);
    }
    public static void  addUser(String birthday, String email, String firstName, String lastName, String password, String role) {
        UserRepository.addUser(birthday, email, firstName, lastName, password, role);

    }

}
