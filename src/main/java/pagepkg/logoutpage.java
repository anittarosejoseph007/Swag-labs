
package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class logoutpage {

    WebDriver driver;

    @FindBy(id = "react-burger-menu-btn")
    WebElement sidebar;

    @FindBy(id = "logout_sidebar_link")
    WebElement logout;

    public logoutpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logoutclick() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(sidebar)).click();

        wait.until(ExpectedConditions.visibilityOf(logout));

        wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
    }
}
