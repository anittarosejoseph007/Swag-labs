package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {

	WebDriver driver;
	@FindBy(xpath="//*[@id=\"user-name\"]")
	public WebElement username;
	@FindBy(xpath="//*[@id=\"password\"]")
	public WebElement pass;
	@FindBy(name="login-button")
	public WebElement login;
	@FindBy(xpath="//*[@id=\"root\"]/div/div[1]")
	public WebElement logo;
	
	
	public loginpage(WebDriver driver) {
this.driver=driver;
PageFactory.initElements(driver, this);}
	public WebElement logoverification()
	{
		return logo;
	}
	public WebElement buttonverification()
	{
		return login;
		
	}
	public void setvalue(String user,String password)
	{
		username.sendKeys(user);
		pass.sendKeys(password);
		login.click();
	}

        
	public void clearInputs() {
		// TODO Auto-generated method stub
		username.clear();
        pass.clear();
    }
	}

