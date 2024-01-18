import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kata.entity.UserTable;
import ru.kata.repositoryClasses.UserRepository;
import ru.kata.steps.DbCheck;

import java.awt.print.Book;
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
