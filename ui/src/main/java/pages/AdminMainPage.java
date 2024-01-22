package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AdminMainPage {
    public static SelenideElement AllUsersButton = $x("//a[@class='sidebar_navLink__Wx739'][text()='Все пользователи']");

}
