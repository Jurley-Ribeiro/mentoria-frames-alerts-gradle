package Framework;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;


import static Framework.Report.closeReport;


public class TestBase extends DriverManager{

    private static WebDriver driver;

    public static WebDriver getDriver(){

        driver = getDriver(TypeDriver.CHROME);
        return driver;
    }

    @AfterAll
    public static void tearDown(){

        closeReport();
        quitDriver();

    }
}
