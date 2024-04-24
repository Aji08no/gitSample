package Tests;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Login {
    public WebDriver driver;
//
//    @BeforeTest
//    public void openBrowser(){
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//
//    }
//
//
////    @Test()
////    public void login(String name,String password){
////        LoginPage page=new LoginPage(driver);
////        page.fillForm(name,password);
////    }
//
    @BeforeMethod
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, boolean validCredentials) {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Enter username and password
        LoginPage page=new LoginPage(driver);
        page.fillForm(username,password);


        // Check if the login was successful or not based on validCredentials
        if (validCredentials) {
            Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login failed for valid credentials");
            System.out.println("Login failed for valid credentials");
        } else {
            Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Login succeeded for invalid credentials");
            System.out.println("Login succeeded for invalid credentials");
        }
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][]{
                {"Admin", "admin123", true},
                {"invalidUsername", "validPassword", false},
                {"validUsername", "invalidPassword", false},
                {"invalidUsername", "invalidPassword", false}
        };
    }
//    String[][] data= {
//            {"dimin","admin"},
//            {"adimin","adimin"},
//            {"Admin","admin123"},
//            {"aji","aj"},
//    };
//    @DataProvider(name="ajith")
//    public String[][] firstsecond(){
//        return data;
//    }
//    @BeforeMethod
//    public void start(){
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//    }
//
//    @Test(dataProvider = "ajith")
//    public void second(String uname,String upassword) throws Exception {
//
//
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//
//        driver.findElement(By.name("username")).sendKeys(uname, Keys.TAB,upassword,Keys.TAB,Keys.TAB.ENTER);
//        Thread.sleep(3000);
//        driver.quit();
//    }


    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }


}
