package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    public static SelenideElement email = $x("//input[@class='login_input__3uYbd'][@id='email']");
    public static SelenideElement password = $x("//input[@class='login_input__3uYbd'][@id='password']");
    public static SelenideElement loginButton = $x("//button[@class='login_button__eBAwl']");


}
