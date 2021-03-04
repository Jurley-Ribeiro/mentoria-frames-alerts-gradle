package Tasks.Alerts;

import Framework.Report;
import Framework.Screenshot;
import Framework.Waits;
import PageObjects.Alerts.AlertsPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;


public class AlertsTask {
    private WebDriver driver;
    private AlertsPage alertsPage;
    private Waits wait;

    public AlertsTask(WebDriver driver){

        this.driver = driver;
        alertsPage = new AlertsPage(this.driver);
        wait = new Waits(this.driver);

    }

    public void verificarButtonAlert(){

        alertsPage.getAlertButton().click();
        validaAlert();
        //wait.loadElement((WebElement) alertsPage.getAlert());
        alertsPage.getAlert().accept();
    }



   private void validaAlert(){
        try{
                String message = alertsPage.getAlert().getText();
                Assertions.assertEquals(message,"I am a JS Alert");
                //Report.extentTest.log(Status.PASS, "Alert carregado com sucesso : " + message,Screenshot.screenshotBase64(driver));
                Report.extentTest.log(Status.PASS, "Alert carregado com sucesso : " + message);
        }catch (Exception e){
                Report.extentTest.log(Status.FAIL,"Alert não carregado", Screenshot.screenshotBase64(driver));
        }
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
            String result = alertsPage.getResultText().getText();
            Assertions.assertEquals(result,"You clicked: Ok");
            Report.extentTest.log(Status.PASS, "Confirm carregado com sucesso : " + result , Screenshot.screenshotBase64(driver));
        }catch (Exception e){
            Report.extentTest.log(Status.FAIL,"Confirm não carregado", Screenshot.screenshotBase64(driver));
        }
    }



}
