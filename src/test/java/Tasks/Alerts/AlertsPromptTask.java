package Tasks.Alerts;

import Framework.Report;
import Framework.Screenshot;
import Framework.Waits;
import PageObjects.Alerts.AlertsPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AlertsPromptTask {

    private WebDriver driver;
    private AlertsPage alertsPage;
    private Waits wait;

    public AlertsPromptTask(WebDriver driver){

        this.driver = driver;
        alertsPage = new AlertsPage(this.driver);
        wait = new Waits(this.driver);

    }

    public void verificarButtonPrompt(){

        alertsPage.getPromptButton().click();
        validaConfirm();
        alertsPage.getAlert().sendKeys("DBServer Automation");
        alertsPage.getAlert().accept();
        validaOkPrompt();
        alertsPage.getPromptButton().click();
        validaConfirm();
        alertsPage.getAlert().dismiss();
        validaCancelPrompt();

    }



    private void validaConfirm(){
        try{
            String message = alertsPage.getAlert().getText();
            Assertions.assertEquals(message,"I am a JS prompt");
            //Report.extentTest.log(Status.PASS, "Alert carregado com sucesso : " + message,Screenshot.screenshotBase64(driver));
            Report.extentTest.log(Status.PASS, "Confirm carregado com sucesso : " + message);
        }catch (Exception e){
            Report.extentTest.log(Status.FAIL,"Confirm não carregado", Screenshot.screenshotBase64(driver));
        }
    }

    private void validaOkPrompt(){

        try{
            wait.loadElement(alertsPage.getResultText());
            String result = alertsPage.getResultText().getText();
            Assertions.assertEquals(result,"You entered: DBServer Automation");
            Report.extentTest.log(Status.PASS, "Clicou no OK do Prompt : " + result , Screenshot.screenshotBase64(driver));
        }catch (Exception e){
            Report.extentTest.log(Status.FAIL,"Não Clicou no OK do Prompt", Screenshot.screenshotBase64(driver));
        }
    }

    private void validaCancelPrompt(){

        try{
            wait.loadElement(alertsPage.getResultText());
            String result = alertsPage.getResultText().getText();
            Assertions.assertEquals(result,"You entered: null");
            Report.extentTest.log(Status.PASS, "Clicou no Cancel do Prompt : " + result , Screenshot.screenshotBase64(driver));
        }catch (Exception e){
            Report.extentTest.log(Status.FAIL,"Não Clicou no Cancel do Prompt", Screenshot.screenshotBase64(driver));
        }
    }



}
