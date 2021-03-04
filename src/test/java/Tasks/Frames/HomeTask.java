package Tasks.Frames;

import Framework.Report;
import Framework.Screenshot;
import PageObjects.Frames.HomePage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class HomeTask {

    private static WebDriver driver;
    private static HomePage homePage;

    public HomeTask(WebDriver driver) {

        this.driver = driver;
        homePage = new HomePage(this.driver);
    }

    public void acessarFramePage(){

        homePage.getFramPageLink().click();
        validaFramePage();
        driver.switchTo().defaultContent();

    }

    public void acessarIFramePage(){

        homePage.getIFramePageLink().click();
        validaIFramePage();

    }

    private void validaFramePage(){
        try{

        String label = homePage.getFramPageLabel().getText();
        Assertions.assertEquals(label, "Nested Frames Example");
        Report.extentTest.log(Status.PASS, "Pagina Frame Carregada",Screenshot.screenshotBase64(driver));

        }catch (Exception e){
            Report.extentTest.log(Status.FAIL, "Pagina de frames nao foi carregada", Screenshot.screenshotBase64(driver));
        }
    }

    private void validaIFramePage(){
        try{

            String label = homePage.getIFramePageLabel().getText();
            Assertions.assertEquals(label, "iFrames Example");
            Report.extentTest.log(Status.PASS, "Pagina IFrame Carregada",Screenshot.screenshotBase64(driver));

        }catch (Exception e){
            Report.extentTest.log(Status.FAIL, "Pagina de IFrames nao foi carregada", Screenshot.screenshotBase64(driver));
        }

    }



}
