import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AdminMainPage;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class AddNewUser {
    @BeforeEach
    public void openWb() {

        Selenide.open("https://admin-aqaj.kata.academy/login");
        Selenide.sleep(300);
    }
    @Feature("Поиск товара")
    @Story("Поиск товара - iPhone 13")
    @Severity(SeverityLevel.MINOR)
    @Description("Присутствует текст Iphone 13, первый фильтр - iphone 13, применен фильтр - По популярности, у первого устройства из списка бренд - Apple\n")
    @Owner("Marat Tagirov")
    @DisplayName("Тест-кейс 1: Работа с поисковой строкой")
    @Test
    public void searchLine() {

        LoginPage.email.click();
        LoginPage.email.sendKeys("admin1@mail.ru");
        LoginPage.password.click();
        LoginPage.password.sendKeys("admin");
        LoginPage.loginButton.click();
        AdminMainPage.AllUsersButton.shouldBe(visible,enabled).click();
        Selenide.sleep(222);

        // ассерт на то что открылась страница https://admin-aqaj.kata.academy/admin/users/new_student
        // клик на все полз, клик на добав полз

    }

}
