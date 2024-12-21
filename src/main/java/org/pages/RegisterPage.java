package org.pages;

import com.microsoft.playwright.Page;

public class RegisterPage {
    Page page;

    public RegisterPage(Page page){
        this.page = page;
    }


    //Actions
    public void registerUser(String username, String password){
        page.locator("#sign-username").fill(username);
        page.locator("#sign-password").fill(password);
        page.locator("//button[text() = 'Sign up']").click();
    }

}
