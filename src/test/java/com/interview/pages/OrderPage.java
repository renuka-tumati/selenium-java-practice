package com.interview.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderPage {
    private final WebDriver driver;
    public OrderPage(WebDriver driver) { this.driver = driver; }
    public String welcomeText() { return driver.findElement(By.id("welcome")).getText(); }
    public void openOrderForm() { driver.findElement(By.id("newOrder")).click(); }
    public void createOrder(String product, int quantity) {
        new Select(driver.findElement(By.id("product"))).selectByValue(product);
        driver.findElement(By.id("quantity")).clear();
        driver.findElement(By.id("quantity")).sendKeys(String.valueOf(quantity));
        driver.findElement(By.id("submitOrder")).click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(d -> !d.findElement(By.id("orderSuccess")).getText().trim().isEmpty()
                || !d.findElement(By.id("orderError")).getText().trim().isEmpty());

    }
    public String successText() { return driver.findElement(By.id("orderSuccess")).getText(); }
    public String orderError() { return driver.findElement(By.id("orderError")).getText(); }
}
