package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutpage {

    WebDriver driver;

    @FindBy(className = "shopping_cart_link")
    WebElement cart;

    @FindBy(id = "checkout")
    WebElement checkout;

    public checkoutpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void cartclick() {
        cart.click();
    }

    public void checkoutclick() {
        checkout.click();
    }
}