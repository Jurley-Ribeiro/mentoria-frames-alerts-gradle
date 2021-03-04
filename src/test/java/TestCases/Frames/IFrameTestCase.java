package TestCases.Frames;

import Framework.Report;
import Framework.Screenshot;
import Framework.TestBase;
import Tasks.Frames.HomeTask;
import Tasks.Frames.IFramesTask;
import Utils.FileOperations;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class IFrameTestCase extends TestBase {

    private WebDriver driver = this.getDriver();
    private static FileOperations fileOperations = new FileOperations();
    private String PATH = System.getProperty("user.dir") + File.separator+"src"+ File.separator + "main" + File.separator + "resources" + File.separator + "url.properties";
    private String Properties = "urlFrames";
    private HomeTask home = new HomeTask(this.driver);
    private IFramesTask iframe = new IFramesTask(this.driver);

    @BeforeEach
    public void initialTest(){
        Report.configReportExtent();
        this.driver.get(fileOperations.readProperties(PATH,Properties));
    }

    @Test
    public void verificarIFrames(){
        try{

            Report.startTestReport("Trabalhando com IFrames");
            home.acessarIFramePage();
            iframe.verificarIFrames();

        }catch (Exception e){

            Report.extentTest.log(Status.ERROR, e.getMessage(), Screenshot.screenshotBase64(driver));
        }

    }


}
