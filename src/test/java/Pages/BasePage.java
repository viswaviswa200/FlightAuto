package Pages;

import Utilities.commonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    protected commonMethods helper;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

        helper = new commonMethods(driver);
    }

}
