package Tasks.Frames;

import Framework.Report;
import Framework.Screenshot;
import Framework.Waits;
import PageObjects.Frames.FramesPage;
import PageObjects.Frames.HomePage;
import PageObjects.Frames.IFramesPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class IFramesTask {

    private static WebDriver driver;
    private static IFramesPage iframesPage;
    private static Waits wait;
    private static HomePage homePage;

    public IFramesTask(WebDriver driver) {

        this.driver = driver;
        iframesPage = new IFramesPage(this.driver);
        homePage = new HomePage(this.driver);
        wait = new Waits(this.driver);
    }

    public void verificarIFrames(){

        validaIFrame();
        driver.switchTo().defaultContent();
        validaIFrameExample();
        driver.switchTo().defaultContent();
        iframesPage.getIframeExampleLink().click();
        validaIframeLink();
    }

    private void validaIFrame(){

        try{
            String label = iframesPage.getIFrame().getText();
            Assertions.assertEquals(label, "iFrame List Item 3");
            Report.extentTest.log(Status.PASS, "IFrame Verificado", Screenshot.screenshotBase64(driver));

        }catch (Exception e){
            Report.extentTest.log(Status.FAIL, "Não foi possível encontrar o Frame", Screenshot.screenshotBase64(driver));
        }

    }

    private void validaIFrameExample(){

        try{
            String label = iframesPage.getIFrameExample().getText();
            Assertions.assertEquals(label, "Nested Page Example");
            Report.extentTest.log(Status.PASS, "IFrame Example Verificado: " + label, Screenshot.screenshotBase64(driver));

        }catch (Exception e){
            Report.extentTest.log(Status.FAIL, "Não foi possível encontrar o Frame", Screenshot.screenshotBase64(driver));
        }

    }

    private void validaIframeLink(){
        try{
             wait.loadElement(homePage.getIFramePageLink());
             Assertions.assertTrue(true, String.valueOf((homePage.getIFramePageLink().isEnabled())));
             Report.extentTest.log(Status.PASS, "Pagina Index Carregada", Screenshot.screenshotBase64(driver));

        }catch (Exception e){
            Report.extentTest.log(Status.FAIL, "Pagina Index não carregada", Screenshot.screenshotBase64(driver));
        }
    }


}
