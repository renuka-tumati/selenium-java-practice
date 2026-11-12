package com.interview.tests;

import com.interview.core.BaseTest;
import com.interview.pages.LoginPage;
import com.interview.pages.OrderPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static org.junit.jupiter.api.Assertions.*;

public class PortalTests extends BaseTest {
    @Test
    void validLoginDisplaysDashboard() {
        new LoginPage(driver).login("qa_user", "Passw0rd!");
        assertEquals("Welcome, qa_user", new OrderPage(driver).welcomeText());
    }

    @Test
    void invalidLoginShowsError() {
        new LoginPage(driver).login("qa_user", "incorrect");
        assertEquals("Invalid username or password", new LoginPage(driver).errorText());
    }

    @Test
    void createOrderDisplaysConfirmation() {
        new LoginPage(driver).login("qa_user", "Passw0rd!");
        OrderPage orders = new OrderPage(driver);
        orders.openOrderForm();
        orders.createOrder("keyboard", 2);
        assertTrue(orders.successText().contains("Order created"));
    }

    @Test
    void dashboardHasNewOrderButton() {
        new LoginPage(driver).login("qa_user", "Passw0rd!");
        assertTrue(driver.findElement(By.id("newOrder")).isDisplayed());
    }
}
