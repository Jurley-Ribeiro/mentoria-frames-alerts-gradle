package PageObjects.Frames;

import Framework.JavaScriptExecutor;
import Framework.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;
    private Waits wait;
    private JavaScriptExecutor js = new JavaScriptExecutor();

    public HomePage(WebDriver driver){

        this.driver = driver;
        wait = new Waits(driver);

    }

    public WebElement getFramPageLink(){
        WebElement getFramPageLink = wait.visibilityOfElement(By.id("framestest"));
        js.highlight(driver,getFramPageLink);
        return getFramPageLink;
    }

    public WebElement getIFramePageLink(){
        WebElement getIFramePageLink = wait.visibilityOfElement(By.id("iframestest"));
        js.highlight(driver,getIFramePageLink);
        return getIFramePageLink;
    }

    public WebElement getFramPageLabel(){

        driver.switchTo().frame("top");
        WebElement getFramPageLabel = wait.visibilityOfElement(By.xpath("//body/div[@class='page-body']/h1"));
        js.highlight(driver,getFramPageLabel);
        return getFramPageLabel;
    }

    public WebElement getIFramePageLabel(){
        
        WebElement getIFramePageLabel = wait.visibilityOfElement(By.xpath("//body/div[@class='page-body']/h1"));
        js.highlight(driver,getIFramePageLabel);
        return getIFramePageLabel;
    }

}
