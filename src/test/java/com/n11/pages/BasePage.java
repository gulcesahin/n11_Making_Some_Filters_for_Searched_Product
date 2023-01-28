package com.n11.pages;

import com.n11.utilities.ConfigReader;
import com.n11.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage() {PageFactory.initElements(Driver.get(), this);}

    WebDriver driver= Driver.get();

    @FindBy(id = "searchData")
    public WebElement searchBar;

    @FindBy(className = "searchBtn")
    public WebElement searchBtn;

    public void goToTheUrl() throws InterruptedException {
        driver.get(ConfigReader.get("url"));
        Thread.sleep(5000);
        Assert.assertEquals(ConfigReader.get("url"),driver.getCurrentUrl());
    }

    public void searchProduct(String product){
        searchBar.sendKeys(product);
        searchBtn.click();
    }
}
