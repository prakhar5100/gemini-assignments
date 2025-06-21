package com.assignment.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class YearValidationTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("file:///C:/SeleniumPractice/Dropdown.html");
    }

    @Test
    public void testYearsInAscendingOrder() {
        WebElement yearDropdown = driver.findElement(By.id("dob-year"));
        List<WebElement> options = yearDropdown.findElements(By.tagName("option"));

        List<Integer> actualYears = new ArrayList<>();

        for (WebElement option : options) {
            String val = option.getAttribute("value");
            if (!val.isEmpty() && val.matches("\d+")) {
                actualYears.add(Integer.parseInt(val));
            }
        }

        List<Integer> sortedYears = new ArrayList<>(actualYears);
        Collections.sort(sortedYears, Collections.reverseOrder());

        Assert.assertEquals(actualYears, sortedYears);
        System.out.println("Years are in descending order as expected.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
