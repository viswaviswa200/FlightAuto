package TestCases;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;

public class Test1 {

    @Test
    public void te(){
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//
//        driver.get("https://www.booking.com/flights/");
//
//        driver.findElement(By.cssSelector("button[placeholder='Depart – Return']")).click();
//
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Calendar-module__content___VJ4Nz']//h3")));
//        String date = driver.findElement(By.xpath("//div[@class='Calendar-module__content___VJ4Nz']//h3")).getText();
        String date = "April 2025";
        String dat = "May 2025";
       YearMonth date1 = YearMonth.parse(date,DateTimeFormatter.ofPattern("MMMM yyyy"));
        YearMonth date2 = YearMonth.parse(dat,DateTimeFormatter.ofPattern("MMMM yyyy"));
        LocalDate date3 = LocalDate.now();



    }
}
