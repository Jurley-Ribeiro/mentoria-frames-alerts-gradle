package PageObjects.Frames;

import Framework.JavaScriptExecutor;
import Framework.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FramesPage {

    private WebDriver driver;
    private Waits wait;
    private JavaScriptExecutor js = new JavaScriptExecutor();

    public FramesPage(WebDriver driver){

        this.driver = driver;
        wait = new Waits(driver);

    }

    public WebElement getLeftFrame(){

        driver.switchTo().frame("left");
        WebElement getLeftFrame = wait.visibilityOfElement(By.id("left3"));
        js.highlight(driver,getLeftFrame);
        return getLeftFrame;
    }

    public WebElement getMiddleFrame(){

        driver.switchTo().frame("middle");
        WebElement getMiddleFrame = wait.visibilityOfElement(By.id("middle4"));
        js.highlight(driver,getMiddleFrame);
        return getMiddleFrame;
    }

    public WebElement getRightFrame(){

        driver.switchTo().frame("right");
        WebElement getRightFrame = wait.visibilityOfElement(By.id("right5"));
        js.highlight(driver,getRightFrame);
        return getRightFrame;
    }



}
