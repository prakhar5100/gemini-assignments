package com.assignment.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class DateSelectionTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("file:///C:/SeleniumPractice/Dropdown.html");
    }

    @Test
    public void testDateSelection() {
        Select day = new Select(driver.findElement(By.id("dob-day")));
        Select month = new Select(driver.findElement(By.id("dob-month")));
        Select year = new Select(driver.findElement(By.id("dob-year")));

        day.selectByValue("05");
        month.selectByValue("05");
        year.selectByValue("2005");

        Assert.assertEquals(day.getFirstSelectedOption().getAttribute("value"), "05");
        Assert.assertEquals(month.getFirstSelectedOption().getAttribute("value"), "05");
        Assert.assertEquals(year.getFirstSelectedOption().getAttribute("value"), "2005");

        System.out.println("Selected Date: " +
            day.getFirstSelectedOption().getText() + "-" +
            month.getFirstSelectedOption().getText() + "-" +
            year.getFirstSelectedOption().getText());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
