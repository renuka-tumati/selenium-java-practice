package com.interview.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.nio.file.Path;
import java.util.logging.Logger;

public abstract class BaseTest {
    public static final Logger LOG = Logger.getLogger(BaseTest.class.getName());
    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        if (Boolean.parseBoolean(System.getProperty("headless", "false"))) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--window-size=1280,900");
        driver = new ChromeDriver(options);
        String url = Path.of("app", "index.html").toAbsolutePath().toUri().toString();
        LOG.info("Navigating to URL: " + url);
        driver.get(url);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }
}
