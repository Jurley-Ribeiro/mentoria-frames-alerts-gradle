package Tasks.Alerts;

import Framework.Report;
import Framework.Screenshot;
import Framework.Waits;
import PageObjects.Alerts.AlertsPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AlertsConfirmTask {

    private WebDriver driver;
    private AlertsPage alertsPage;
    private Waits wait;

    public AlertsConfirmTask(WebDriver driver){

        this.driver = driver;
        alertsPage = new AlertsPage(this.driver);
        wait = new Waits(this.driver);

    }

    public void verificarButtonConfirm(){

        alertsPage.getConfirmButton().click();
        validaConfirm();
        alertsPage.getAlert().accept();
        validaOkConfirm();
        alertsPage.getConfirmButton().click();
        validaConfirm();
        alertsPage.getAlert().dismiss();
        validaCancelConfirm();

    }



    private void validaConfirm(){
        try{
            String message = alertsPage.getAlert().getText();
            Assertions.assertEquals(message,"I am a JS Confirm");
            //Report.extentTest.log(Status.PASS, "Alert carregado com sucesso : " + message,Screenshot.screenshotBase64(driver));
            Report.extentTest.log(Status.PASS, "Confirm carregado com sucesso : " + message);
        }catch (Exception e){
            Report.extentTest.log(Status.FAIL,"Confirm não carregado", Screenshot.screenshotBase64(driver));
        }
    }

    private void validaOkConfirm(){

        try{
            wait.loadElement(alertsPage.getResultText());
            String result = alertsPage.getResultText().getText();
            Assertions.assertEquals(result,"You clicked: Ok");
            Report.extentTest.log(Status.PASS, "Clicou no OK do Confirm : " + result , Screenshot.screenshotBase64(driver));
        }catch (Exception e){
            Report.extentTest.log(Status.FAIL,"Não Clicou no OK do Confirm", Screenshot.screenshotBase64(driver));
        }
    }

    private void validaCancelConfirm(){

        try{
            wait.loadElement(alertsPage.getResultText());
            String result = alertsPage.getResultText().getText();
            Assertions.assertEquals(result,"You clicked: Cancel");
            Report.extentTest.log(Status.PASS, "Clicou no Cancel do Confirm : " + result , Screenshot.screenshotBase64(driver));
        }catch (Exception e){
            Report.extentTest.log(Status.FAIL,"Não Clicou no Cancel do Confirm", Screenshot.screenshotBase64(driver));
        }
    }



}
