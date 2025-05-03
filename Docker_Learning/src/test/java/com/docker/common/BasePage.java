package com.docker.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
// Abstract page
public abstract class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    public BasePage(WebDriver driver){
        this.driver =  driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

    /**
     * "Before you interact with any element or method on the page,
     * first confirm that you're actually on that page, and it has loaded successfully."
     * @return
     */
    public abstract boolean isAtExpectedPage();
}
