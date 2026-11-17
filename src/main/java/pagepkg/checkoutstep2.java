
package pagepkg;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutstep2 {

    WebDriver driver;

    @FindBy(xpath="//*[@id=\"finish\"]")
    WebElement finishBtn;

    public checkoutstep2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFinish() {
        // Scroll down to ensure the Finish button is brought into view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        
        finishBtn.click();
    }
}