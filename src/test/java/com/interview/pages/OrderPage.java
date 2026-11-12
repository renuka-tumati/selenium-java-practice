package com.interview.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

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
    }
    public String successText() { return driver.findElement(By.id("orderSuccess")).getText(); }
    public String orderError() { return driver.findElement(By.id("orderError")).getText(); }
}
