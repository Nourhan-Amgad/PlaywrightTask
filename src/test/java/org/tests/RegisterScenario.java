package org.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import org.pages.HomePage;
import org.pages.LoginPage;
import org.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.utils.BrowserFactory;
import org.utils.JsonFileManager;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterScenario {

    Page page;
    HomePage homePage;
    RegisterPage registerPage;
    LoginPage loginPage;
    JsonFileManager jsonFileManager;
    String username;
    String password;

    @Test
    public void registerUserWithVaildData() {
        String currentTime = new SimpleDateFormat("ddMMyyyyHHmmssSSS").format(new Date());
        username = jsonFileManager.getTestData("username")+currentTime;
        password = jsonFileManager.getTestData("password");
        homePage.openSignUpForm();
        registerPage.registerUser(username, password);
    }

    @Test(dependsOnMethods = "registerUserWithVaildData")
    public void LoginWithValidCredentials() {
        homePage.openLoginForm();
        loginPage.login(username,password);
        Assert.assertTrue(homePage.isLogoutLinkExist());
    }

    @Test(dependsOnMethods = "LoginWithValidCredentials")
    public void logoutSuccessfully(){
        homePage.logout();
        Assert.assertTrue(homePage.islogininkExist());
    }

    @BeforeClass
    public void setUp() {
        jsonFileManager = new JsonFileManager("src\\test\\java\\org\\testData\\userRegisterTestData.json");
        Browser browser = BrowserFactory.getBrowser(jsonFileManager.getTestData("browser"));
        page = browser.newPage();
        page.navigate("https://www.demoblaze.com/");
        homePage = new HomePage(page);
        registerPage = new RegisterPage(page);
        loginPage = new LoginPage(page);
    }

    @AfterClass
    public void tearDown() {
        page.close();
    }
}
