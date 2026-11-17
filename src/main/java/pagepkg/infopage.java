package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class infopage {
	
		WebDriver driver;
		@FindBy(xpath="//*[@id=\"first-name\"]")
		WebElement firstname;
		@FindBy(xpath="//*[@id=\"last-name\"]")
		WebElement lastname;
		@FindBy(xpath="//*[@id=\"postal-code\"]")
		WebElement zip;
		@FindBy(xpath="//*[@id=\"continue\"]")
		public WebElement login;
		
		public infopage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}

		public void setvalue(String first,String name,String postal)
		{
		firstname.sendKeys(first);
		lastname.sendKeys(name);
		zip.sendKeys(postal);
		login.click();
	}
}
