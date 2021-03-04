package Tasks.Alerts;

import Framework.Report;
import Framework.Screenshot;
import PageObjects.Alerts.HomePage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;


public class HomeTask {

    private WebDriver driver;
    private HomePage homePage;

    public HomeTask(WebDriver driver){

        this.driver = driver;
        homePage = new HomePage(this.driver);

    }

    public void acessarJavaScriptPage(){

        homePage.getJavaScriptLink().click();
        validaPageJavaScript();

    }

    private void validaPageJavaScript(){

        try{
            Assertions.assertEquals(homePage.getPageTextLabel().getText(), "JavaScript Alerts");
            Report.extentTest.log(Status.PASS, "Pagina JavaScript Carregada", Screenshot.screenshotBase64(driver));
        }catch (Exception e) {

            Report.extentTest.log(Status.FAIL,"Pagina JavaScript nao carregada", Screenshot.screenshotBase64(driver));
        }
    }


}
