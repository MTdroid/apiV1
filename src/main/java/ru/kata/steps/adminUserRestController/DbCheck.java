package ru.kata.steps.adminUserRestController;

import org.assertj.core.api.Assertions;
import ru.kata.entity.adminUserRestController.UserTable;
import ru.kata.models.adminUserRestController.deleteUserById.DeleteUserResponse;
import ru.kata.repositoryClasses.adminUserRestController.UserRepository;

import java.util.List;

public class DbCheck {
    static UserRepository userRepository = new UserRepository();
    public static void  getAllUsers() {
        List<UserTable> userTables = UserRepository.findAll();
        Assertions.assertThat(userTables).isNotEmpty();
        System.out.println(userTables);
    }
    public static void  getAllCurators() {
        List<UserTable> userTables = UserRepository.findAllCurators();
        Assertions.assertThat(userTables).isNotEmpty();
        System.out.println(userTables);
    }
    public static void  findUser(Integer id) {
        List<UserTable> userTables= UserRepository.findUser(id);
        Assertions.assertThat(userTables).isNotEmpty();
        System.out.println(userTables);
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
