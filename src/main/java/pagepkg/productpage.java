package pagepkg;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productpage {
WebDriver driver;
@FindBy(xpath="//*[@id=\"header_container\"]/div[1]/div[2]/div")
WebElement logo;
@FindBy(xpath="//button[text()='Add to cart']")
List<WebElement> cartbutton;
@FindBy(xpath="//*[@id=\"inventory_container\"]/div/div")
List<WebElement> productdetails;
@FindBy(xpath = "//*[@class='product_sort_container']")
WebElement dropdown;
public productpage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);}

public WebElement logoverify()
{
	return logo;
}
public void additems()
{
	for(WebElement items:cartbutton)
	{
		items.click();
	}
}
public List<WebElement> productdls()
{
	return productdetails;
}

public WebElement getDropdownElement() {
    return dropdown;
}
}
