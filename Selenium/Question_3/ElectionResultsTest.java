package com.assignment.tests;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.FileOutputStream;
import java.util.*;

public class ElectionResultsTest {
    WebDriver driver;
    List<List<String>> allRows = new ArrayList<>();

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://results.eci.gov.in/ResultAcGenMar2022/ConstituencywiseS0510.htm?ac=10");
    }

    @Test(priority = 1)
    public void extractTableData() throws Exception {
        WebElement table = driver.findElement(By.xpath("//table[@class='table-party']"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            List<String> rowData = new ArrayList<>();
            for (WebElement cell : cells) {
                rowData.add(cell.getText());
            }
            if (!rowData.isEmpty()) {
                rowData.add("Uttar Pradesh");
                rowData.add("Kairana");
                allRows.add(rowData);
            }
        }

        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("Election Results");

        Row header = sheet.createRow(0);
        String[] headers = {"Candidate", "Party", "Votes", "Percentage", "State", "Constituency"};
        for (int i = 0; i < headers.length; i++) {
            header.createCell(i).setCellValue(headers[i]);
        }

        for (int i = 0; i < allRows.size(); i++) {
            Row row = sheet.createRow(i + 1);
            List<String> data = allRows.get(i);
            for (int j = 0; j < data.size(); j++) {
                row.createCell(j).setCellValue(data.get(j));
            }
        }

        FileOutputStream fos = new FileOutputStream("ElectionOutput.xlsx");
        wb.write(fos);
        wb.close();
        fos.close();
    }

    @Test(priority = 2)
    public void calculateStatistics() {
        int maxVote = -1;
        String maxVoteCandidate = "";

        double maxPercent = -1;
        String maxPercentCandidate = "";

        int maxDiff = -1;
        String maxDiffCandidate = "";

        double maxDiffPercent = -1;
        String maxDiffPercentCandidate = "";

        int minWinVote = Integer.MAX_VALUE;
        String minVoteWinner = "";

        double minWinPercent = 101;
        String minPercentWinner = "";

        int notaVotes = 0;
        int belowNota = 0;
        int aboveFifty = 0;

        int minVote = Integer.MAX_VALUE;
        String minVoteCandidate = "";

        for (List<String> row : allRows) {
            String candidate = row.get(0);
            String party = row.get(1);
            int votes = Integer.parseInt(row.get(2).replaceAll(",", ""));
            double percent = Double.parseDouble(row.get(3).replace("%", ""));
            if (candidate.equalsIgnoreCase("nota")) {
                notaVotes = votes;
                continue;
            }

            if (votes > maxVote) {
                maxVote = votes;
                maxVoteCandidate = candidate;
            }

            if (percent > maxPercent) {
                maxPercent = percent;
                maxPercentCandidate = candidate;
            }

            if (percent > 50) {
                aboveFifty++;
            }

            if (votes < minVote) {
                minVote = votes;
                minVoteCandidate = candidate;
            }

            if (votes < notaVotes) {
                belowNota++;
            }
        }

        List<Integer> sortedVotes = new ArrayList<>();
        for (List<String> row : allRows) {
            if (!row.get(0).equalsIgnoreCase("nota")) {
                sortedVotes.add(Integer.parseInt(row.get(2).replaceAll(",", "")));
            }
        }
        Collections.sort(sortedVotes, Collections.reverseOrder());
        maxDiff = sortedVotes.get(0) - sortedVotes.get(1);

        System.out.println("Max Vote: " + maxVoteCandidate + " - " + maxVote
