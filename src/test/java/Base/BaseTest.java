package Base;

import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected Properties prop;

    @BeforeClass
    @Parameters({"os","browser"})
    public void setUp(String OS,String browser) throws IOException {
        prop = new Properties();
        prop.load(Files.newInputStream(Paths.get(System.getProperty("user.dir") + "//src//test//resources//config.properties")));

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Invalid Browser");
                return;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(prop.getProperty("URL"));
    }
}
