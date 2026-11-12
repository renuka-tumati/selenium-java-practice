package com.interview.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;
    private final By username = By.id("username");
    private final By password = By.id("password");
    private final By submit = By.id("loginButton");

    public LoginPage(WebDriver driver) { this.driver = driver; }
    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(submit).click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(d ->
    d.findElement(By.id("dashboard")).isDisplayed()
        || !d.findElement(By.id("loginError")).getText().isBlank());
    }
    public String errorText() { return driver.findElement(By.id("loginError")).getText(); }
}
