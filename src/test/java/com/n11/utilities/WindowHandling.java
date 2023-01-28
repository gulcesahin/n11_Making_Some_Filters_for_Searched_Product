package com.n11.utilities;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class WindowHandling {

    public void switchPage(WebDriver driver, int windowsId) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(windowsId));
    }

    public void switchTab(WebDriver driver, int tabNo) {
        switchPage(driver, tabNo);
    }
}
