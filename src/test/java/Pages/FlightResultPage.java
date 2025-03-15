package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class FlightResultPage extends BasePage{
    public FlightResultPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//button[@id='TAB-CHEAPEST']")
    private WebElement cheapest_btn;

    @FindBy(xpath = "//div[@id='CHEAPEST']/div/ul/li")
    private List<WebElement> cheapest_list;

    @FindBy(xpath = "//div[starts-with(@class,'LoadingScreen')]")
    private WebElement loadingScreen;

    private String airlineName_loc = ".//div[starts-with(@id,'flight-card')] //div[starts-with(@class,'Frame')]/div[starts-with(@class,'Text')]";

    public void clickOnCheapest(){
        helper.waitForElementToVisible(cheapest_btn);
        cheapest_btn.click();
    }

    public void getCheapestFlights(){

        helper.waitForElementToVisible(cheapest_list.get(0));
        helper.waitForElementToClikable(cheapest_list.get(0));

        helper.waitForinvisibleofElement(loadingScreen);

        cheapest_list.stream().forEach(ele->{
            System.out.println(ele.findElement(By.xpath(airlineName_loc)).getText());
        });

    }
}
