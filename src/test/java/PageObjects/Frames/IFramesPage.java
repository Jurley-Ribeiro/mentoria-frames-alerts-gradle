package PageObjects.Frames;

import Framework.JavaScriptExecutor;
import Framework.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IFramesPage {

    private WebDriver driver;
    private Waits wait;
    private JavaScriptExecutor js = new JavaScriptExecutor();

    public IFramesPage(WebDriver driver){

        this.driver = driver;
        wait = new Waits(driver);

    }

    public WebElement getIFrame(){

        driver.switchTo().frame("thedynamichtml");
        WebElement getIFrame = wait.visibilityOfElement(By.id("iframe3"));
        js.highlight(driver,getIFrame);
        return getIFrame;
    }

    public WebElement getIFrameExample(){

        driver.switchTo().frame("theheaderhtml");
        WebElement getIFrameExample = wait.visibilityOfElement(By.xpath("//body/div[@class='page-body']/h1"));
        js.highlight(driver,getIFrameExample);
        return getIFrameExample;
    }

    public WebElement getIframeExampleLink(){

        driver.switchTo().frame("theheaderhtml");
        WebElement getIframeExampleLink = wait.visibilityOfElement(By.xpath("//body/div[@class='page-body']/div[@class='page-navigation']/a"));
        js.highlight(driver,getIframeExampleLink);
        return getIframeExampleLink;

    }


}
