package org.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    Page page;

    public LoginPage(Page page){
        this.page = page;
    }


    //Actions
    public void login(String username, String password){
        page.locator("#loginusername").fill(username);
        page.locator("#loginpassword").fill(password);
        page.locator("//button[text() = 'Log in']").click();
    }



}
