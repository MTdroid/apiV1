package adminUserRestController;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kata.entity.adminUserRestController.UserTable;
import ru.kata.repositoryClasses.adminUserRestController.UserRepository;
import ru.kata.steps.adminUserRestController.DbCheck;

import java.util.List;

public class db {
    static UserRepository userRepository = new UserRepository();
    @Test
    @DisplayName("Получение данных пользователя")
    @Epic("API тесты")
    @Story("Позитивные тесты")
    public static void  compareBookPositive() {
        List<UserTable> userTables = UserRepository.findAll();
        DbCheck.getAllUsers();
    }
}
