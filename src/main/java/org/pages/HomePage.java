package org.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static org.testng.Assert.assertEquals;

public class HomePage {
    Page page;

    public HomePage(Page page){
        this.page = page;
    }

    //Locators


    //Actions
    public void openSignUpForm(){
        Locator signUpBtnLocator = page.locator("#signin2");
        signUpBtnLocator.click();
    }

    public void openLoginForm(){
        page.locator("#login2").click();
    }

    public Boolean isLogoutLinkExist(){
        Locator logoutLink = page.locator("#logout2");
        page.waitForSelector("#logout2",new Page.WaitForSelectorOptions().setTimeout(100000));
        return logoutLink.isVisible();
    }

    public void logout(){
        page.locator("#logout2").click();
    }

    public Boolean islogininkExist(){
        Locator logoutLink = page.locator("#login2");
        page.waitForSelector("#login2",new Page.WaitForSelectorOptions().setTimeout(10000));
        return logoutLink.isVisible();
    }


}
