package ru.kata.steps.adminUserRestController;

import org.assertj.core.api.Assertions;
import ru.kata.entity.adminUserRestController.UserTable;
import ru.kata.models.response.DeleteUserResponse;
import ru.kata.repositoryClasses.adminUserRestController.UserRepository;

import java.util.List;

public class DataBaseStep {
    static UserRepository userRepository = new UserRepository();
    public static void  getAllUsers() {
        List<UserTable> userTables = UserRepository.findAll();
        Assertions.assertThat(userTables).isNotEmpty();
        System.out.println(userTables);
    }
    public static void  deleteAllCurators() {
        UserRepository.deleteAllCurators("Curator");

    }
    public static void  findAllCurators() {
        List<UserTable> userTables = UserRepository.findAllCurators();
        Assertions.assertThat(userTables).isNotEmpty();
        System.out.println(userTables);
    }
    public static void  findUserById(Integer id) {
        List<UserTable> userTables= UserRepository.findUser(id);
        Assertions.assertThat(userTables).isNotEmpty();
        Assertions.assertThat(userTables.get(0).getId()).isEqualTo(id);

    }
    public static Integer  findUserByEmail(String email,String firstName, String lastName) {
        List<UserTable> userTables= UserRepository.findUserByEmail(email);

        Assertions.assertThat(userTables.get(0).getEmail()).isEqualTo(email);
        Assertions.assertThat(userTables.get(0).getFirstName()).isEqualTo(firstName);
        Assertions.assertThat(userTables.get(0).getLastName()).isEqualTo(lastName);

        return userTables.get(0).getId();

    }

    public static void  SaveUser(Integer id) {
        List<UserTable> userTables= UserRepository.findUser(id);
        Assertions.assertThat(userTables).isNotEmpty();
        System.out.println(userTables);
    }
    public static void  deleteUser(Integer id) {
        List<DeleteUserResponse> userTables= UserRepository.deleteUser(id);
        System.out.println(userTables +"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");


    }
    public static void  deleteUserv2(Integer id) {
        UserRepository.deleteUserV2(id);

    }
    public static void  addUser(String birthday, String email, String firstName, String lastName, String password, String role) {
        UserRepository.addUser(birthday, email, firstName, lastName, password, role);

    }

}
