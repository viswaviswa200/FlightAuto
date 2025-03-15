package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class FlightBookingHomePage extends BasePage {


    public FlightBookingHomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'One-way')]/../preceding-sibling::span[contains(@class,'field')]")
    private WebElement radio_oneWay;

    @FindBy(xpath = "//button[contains(@data-ui-name,'from')]")
    private WebElement from_Button;

    @FindBy(xpath = "//div[contains(@class,'ShellWrapper')]//span[contains(@class,'Icon')]")
    private WebElement clear_from;

    @FindBy(xpath = "//input[contains(@placeholder,'Airport or city')]")
    private WebElement from_TextBox;

    @FindBy(xpath = "//div[contains(@class,'OriginDestination')]/button[contains(@data-ui-name,'to')]")
    private  WebElement to_Button;

    @FindBy(xpath = "//input[contains(@placeholder,'Airport or city')]")
    private WebElement to_TextBox;

    @FindBy(xpath = "//button[contains(@data-ui-name,'button_date')]")
    private  WebElement calender_btn;

    @FindBy(xpath = "//div[contains(@data-ui-name,'calendar_body')]/button[contains(@class,'prev')]")
    private WebElement calender_prev_btn;

    @FindBy(xpath = "//div[contains(@data-ui-name,'calendar_body')]/button[contains(@class,'next')]")
    private WebElement calender_next_btn;

    @FindBy(xpath = "//div[@data-ui-name='calendar_body']/div[contains(@class,'Calendar-module')]")
    private WebElement calender_body;

    @FindBy(xpath = "//span[text()='Search']")
    private WebElement search_btn;

    public void clickOneWay(){
        radio_oneWay.click();
    }

    public void clickFrom(){
        from_Button.click();
    }

    public void setFromLocation(String location){
        helper.waitForElementToVisible(clear_from);
        clear_from.click();

        from_TextBox.sendKeys(location);

        String loc = "//li[contains(@class,'List')]//b[text()='"+location+"']";
        helper.waitForElementToVisible(loc);
        driver.findElement(By.xpath(loc)).click();

    }

    public void clickTo(){
        to_Button.click();
    }

    public void setToLocation(String location){
        helper.waitForElementToVisible(to_TextBox);
        to_TextBox.sendKeys(location);

        String loc = ".//li[contains(@class,'List')]//b[text()='"+location+"']";
        helper.waitForElementToVisible(loc);
        driver.findElement(By.xpath(loc)).click();
    }

    public void selectTodayDate(){
        calender_btn.click();

        LocalDate date = LocalDate.now().plusDays(1);



        while(true){
            WebElement cc = calender_body;
            WebElement dd = cc.findElement(By.xpath(".//div"));

            YearMonth d1 = YearMonth.parse(dd.findElement(By.xpath(".//h3")).getText(), DateTimeFormatter.ofPattern("MMMM yyyy"));
            int year = d1.getYear();

            if(year == date.getYear()) break;
            else if (year < date.getYear()) calender_next_btn.click();
            else {
                calender_prev_btn.click();
            }
            //helper.waitUntillElementBecameStale(cc);
        }

        while(true){
            WebElement cc  = calender_body;
            WebElement dd = cc.findElement(By.xpath(".//div"));

            YearMonth d1 = YearMonth.parse(dd.findElement(By.xpath(".//h3")).getText(), DateTimeFormatter.ofPattern("MMMM yyyy"));
            int month = d1.getMonthValue();

            if(month == date.getMonthValue()){
                dd.findElements(By.xpath(".//span[@role='checkbox']")).get(date.getDayOfMonth()-1).click();
                break;
            }
            else if(month < date.getMonthValue()) calender_next_btn.click();
            else calender_prev_btn.click();

           // helper.waitUntillElementBecameStale(cc);
        }
    }
    public void clickSearch(){
        search_btn.click();
    }

}
