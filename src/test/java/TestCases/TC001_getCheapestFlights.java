package TestCases;

import Base.BaseTest;
import Pages.FlightBookingHomePage;
import Pages.FlightResultPage;
import org.testng.annotations.Test;

public class TC001_getCheapestFlights extends BaseTest {

    @Test
    public void getChapestFlight(){
        String from = prop.getProperty("from");
        String to = prop.getProperty("to");

        FlightBookingHomePage hp = new FlightBookingHomePage(driver);
        hp.clickOneWay();

        hp.clickFrom();
        hp.setFromLocation(from);

        hp.clickTo();
        hp.setToLocation(to);

        hp.selectTodayDate();

        hp.clickSearch();

        FlightResultPage res = new FlightResultPage(driver);
        res.clickOnCheapest();
        res.getCheapestFlights();
    }
}
