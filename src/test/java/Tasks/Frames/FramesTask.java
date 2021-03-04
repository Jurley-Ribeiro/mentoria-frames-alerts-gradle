package Tasks.Frames;

import Framework.Report;
import Framework.Screenshot;
import PageObjects.Frames.FramesPage;
import PageObjects.Frames.HomePage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class FramesTask {

    private static WebDriver driver;
    private static FramesPage framesPage;

    public FramesTask(WebDriver driver) {

        this.driver = driver;
        framesPage = new FramesPage(this.driver);
    }

    public void verificarFrames(){

        validaFrameLeft();
        driver.switchTo().defaultContent();
        validaFrameMiddle();
        driver.switchTo().defaultContent();
        validaFrameRight();

    }

    private void validaFrameLeft(){

        try{
            String label = framesPage.getLeftFrame().getText();
            Assertions.assertEquals(label, "Left List Item 3");
            Report.extentTest.log(Status.PASS, "Frame Left Verificado", Screenshot.screenshotBase64(driver));

        }catch (Exception e){
            Report.extentTest.log(Status.FAIL, "Não foi possível encontrar o Frame", Screenshot.screenshotBase64(driver));
        }

    }

    private void validaFrameMiddle(){

        try{
            String label = framesPage.getMiddleFrame().getText();
            Assertions.assertEquals(label, "Middle List Item 4");
            Report.extentTest.log(Status.PASS, "Frame Middle Verificado", Screenshot.screenshotBase64(driver));

        }catch (Exception e){
            Report.extentTest.log(Status.FAIL, "Não foi possível encontrar o Frame", Screenshot.screenshotBase64(driver));
        }

    }

    private void validaFrameRight(){

        try{
            String label = framesPage.getRightFrame().getText();
            Assertions.assertEquals(label, "Right List Item 5");
            Report.extentTest.log(Status.PASS, "Frame Right Verificado", Screenshot.screenshotBase64(driver));

        }catch (Exception e){
            Report.extentTest.log(Status.FAIL, "Não foi possível encontrar o Frame", Screenshot.screenshotBase64(driver));
        }

    }

}
