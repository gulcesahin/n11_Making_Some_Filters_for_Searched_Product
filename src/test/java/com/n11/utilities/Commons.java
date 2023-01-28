package com.n11.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class Commons {

    static WebDriver driver= Driver.get();

    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(element).perform();
    }

    public static void switchTab(int tabNo) {
        new WindowHandling().switchTab(driver, tabNo);
    }
}