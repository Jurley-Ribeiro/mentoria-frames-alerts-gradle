package TestCases.Frames;

import Framework.Report;
import Framework.Screenshot;
import Framework.TestBase;
import Tasks.Frames.FramesTask;
import Tasks.Frames.HomeTask;
import Utils.FileOperations;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class FrameTestCase  extends TestBase {

    private WebDriver driver = this.getDriver();
    private FileOperations fileOperations = new FileOperations();
    private String PATH = System.getProperty("user.dir") + File.separator+"src"+ File.separator + "main" + File.separator + "resources" + File.separator + "url.properties";
    private String Properties = "urlFrames";
    private HomeTask home = new HomeTask(this.driver);
    private FramesTask frame = new FramesTask(this.driver);

    @BeforeEach
    public void initialTest(){
        Report.configReportExtent();
        this.driver.get(fileOperations.readProperties(PATH,Properties));
    }

    @Test
    public void verificarFrames(){
        try{

            Report.startTestReport("Trabalhando com Frames");
            home.acessarFramePage();
            frame.verificarFrames();


        }catch (Exception e){

            Report.extentTest.log(Status.ERROR, e.getMessage(), Screenshot.screenshotBase64(driver));
        }
    }


}
