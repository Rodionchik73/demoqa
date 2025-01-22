package org.example.demoqa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.get("https://demoqa.com/dynamic-properties");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void visible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#visibleAfter")));
        WebElement visibleButton = driver.findElement(By.cssSelector("#visibleAfter"));
        assertTrue(visibleButton.isDisplayed(), "Кнопка не отображается на странице");
    }

    @Test
    public void visible2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement visibleButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#visibleAfter")));
        assertTrue(visibleButton.isDisplayed(), "Кнопка не отображается на странице");
    }
}
