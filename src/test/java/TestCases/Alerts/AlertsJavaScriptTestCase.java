package TestCases.Alerts;

import Framework.Report;
import Framework.Screenshot;
import Framework.TestBase;
import Tasks.Alerts.AlertsConfirmTask;
import Tasks.Alerts.AlertsPromptTask;
import Tasks.Alerts.AlertsTask;
import Tasks.Alerts.HomeTask;
import Utils.FileOperations;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class AlertsJavaScriptTestCase extends TestBase {

    private WebDriver driver = this.getDriver();
    private static FileOperations fileOperations = new FileOperations();
    private String PATH = System.getProperty("user.dir") + File.separator+"src"+ File.separator + "main" + File.separator + "resources" + File.separator + "url.properties";
    private String Properties = "urlAlerts";
    private HomeTask homeTask = new HomeTask(this.driver);
    private AlertsTask alertsTask = new AlertsTask(this.driver);
    private AlertsConfirmTask alertsConfirmTask = new AlertsConfirmTask(this.driver);
    private AlertsPromptTask alertsPromptTask = new AlertsPromptTask(this.driver);

    @BeforeEach
    public void initialTest(){
        Report.configReportExtent();
        getDriver().get(fileOperations.readProperties(PATH,Properties));
    }

    @Test
    public void validarAlerts(){
        try{

            Report.startTestReport("Trabalhando com Alertas");

            homeTask.acessarJavaScriptPage();
            alertsTask.verificarButtonAlert();
            alertsConfirmTask.verificarButtonConfirm();
            alertsPromptTask.verificarButtonPrompt();
        }catch (Exception e){

            Report.extentTest.log(Status.ERROR, e.getMessage(), Screenshot.screenshotBase64(driver));
        }
    }





}
