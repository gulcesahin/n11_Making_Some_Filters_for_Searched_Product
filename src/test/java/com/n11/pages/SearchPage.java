package com.n11.pages;

import com.n11.utilities.Commons;
import com.n11.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class SearchPage extends BasePage {

    static WebDriver driver = Driver.get();

    @FindBy(className = "resultText")
    public WebElement resultText;

    @FindBy(className = "efilli-layout-n11")
    public List<WebElement> shadowHosts;

    @FindBy(xpath = "(//input[@class='brand-checkbox']/following-sibling::span)[2]")
    public WebElement secBrandCheckBox;

    @FindBy(xpath = "//div[@data-value='REVIEWS']")
    public WebElement reviewsOpt;

    @FindBy(xpath = "(//span[text()='ÜCRETSİZ KARGO'])[1]")
    public WebElement freeShippingText;

    @FindBy(css = ".selectedText")
    public WebElement sortByComNum;

    @FindBy(xpath = "//span[text()='Ücretsiz Kargo']")
    public WebElement freeShippingCheckBox;

    public void closeCookies(){

        if(!shadowHosts.isEmpty()){
            WebElement shadowHost = driver.findElement(By.className("efilli-layout-n11"));
            SearchContext shadowRoot = shadowHost.getShadowRoot();
            WebElement acceptCookiesBtn = shadowRoot.findElement(By.className("banner__accept-button"));
            acceptCookiesBtn.click();
        }
    }

    public void setFilter(){
        WebDriverWait wait= new WebDriverWait(Driver.get(), Duration.ofSeconds(3));
        Commons.hover(secBrandCheckBox);
        secBrandCheckBox.click();
        wait.until(ExpectedConditions.visibilityOf(sortByComNum));
        sortByComNum.click();
        reviewsOpt.click();
        //Waits until that wanted elements are clickable
        wait.until(ExpectedConditions.elementToBeClickable(freeShippingCheckBox));
        Commons.hover(freeShippingCheckBox);
        freeShippingCheckBox.click();
    }

    public void checkSearchedProductIsCorrect(){
        Assert.assertTrue(resultText.getText().contains("Telefon"));
    }

    public void checkFiltersAreOkay(){
        Assert.assertTrue(freeShippingText.getText().contains("ÜCRETSİZ"));
    }

}
