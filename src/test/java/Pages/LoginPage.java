package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@placeholder='Username']")
    private WebElement enterName;

    @FindBy(xpath = "//*[@placeholder='Password']")
    private WebElement enterPassword;

    @FindBy(xpath = "//*[text()=' Login ']")
    private WebElement clickLogin;

    public void fillForm(String name, String password) {
        enterName.sendKeys(name);
        enterPassword.sendKeys(password);
        clickLogin.click();

    }
}
