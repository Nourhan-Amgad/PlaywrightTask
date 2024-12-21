package org.utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class BrowserFactory {
    public static Browser browser;
    public static Browser getBrowser(String browserName){
        Playwright playwright = Playwright.create();
        if(browserName.equalsIgnoreCase("chrome")){
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        }
        if(browserName.equalsIgnoreCase("firefox")){
            browser = playwright.firefox().launch();
        }

        return browser;
    }
}
