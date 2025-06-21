package com.assignment.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TableReaderTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("file:///C:/Prakhar.Singh/SeleniumPractice/Dropdown.html");
    }

    @Test
    public void testUniqueRowsInTable() {
        WebElement table = driver.findElement(By.tagName("table"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        Set<String> uniqueRows = new HashSet<>();

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            StringBuilder rowText = new StringBuilder();
            for (WebElement cell : cells) {
                rowText.append(cell.getText().trim()).append("|");
            }
            if (!rowText.toString().isBlank()) {
                uniqueRows.add(rowText.toString());
            }
        }

        System.out.println("Unique Rows Count: " + uniqueRows.size());
        for (String row : uniqueRows) {
            System.out.println(row);
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
