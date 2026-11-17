
package testpkg;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepkg.Reporterclass;
import basepkg.baseclass;
import pagepkg.loginpage;
import utilepkg.excelutil;

public class logintest extends baseclass {

    loginpage log;

    @DataProvider(name = "loginData")
    public Object[][] getData() throws Exception {

        String path = "C:\\Users\\Anitta Rose Joseph\\Desktop\\Selenium Automation\\swaglab.xlsx";

        return excelutil.getTestdata(path, "Sheet1");
    }

    // LOGIN TEST - DATA DRIVEN

    @Test(dataProvider = "loginData", priority = 1)
    public void loginTest(String user, String password)
            throws InterruptedException, IOException {

        driver.get("https://www.saucedemo.com/");

        test = extent.createTest("Login Test - " + user);

        log = new loginpage(driver);

        log.setvalue(user, password);

        System.out.println("Tested for: " + user);

        if (driver.getCurrentUrl().contains("inventory.html")) {

            test.pass("Login successful for: " + user);

        } else {

            String screenshotName = "LoginFailed_" + user;

            String screenshotPath =
                    Reporterclass.Screenshotmethod(driver, screenshotName);

            test.addScreenCaptureFromPath(screenshotPath);

            test.fail("Login failed for: " + user);

            log.clearInputs();
        }
    }

    // LOGO VERIFICATION

    @Test(priority = 2)
    public void logoverification() throws IOException {

        driver.get("https://www.saucedemo.com/");

        test = extent.createTest("Logo Validation Test");

        log = new loginpage(driver);

        WebElement x = log.logoverification();

        Assert.assertTrue(x.isDisplayed(),
                "Logo is not displayed");

        test.pass("Logo displayed successfully");
    }

    // LOGIN BUTTON TEXT VALIDATION

    @Test(priority = 3)
    public void buttontextvalidation() throws IOException {

        driver.get("https://www.saucedemo.com/");

        test = extent.createTest("Button Text Validation Test");

        log = new loginpage(driver);

        String text = log.login.getDomAttribute("value");

        Assert.assertEquals(text, "Login",
                "Login button text mismatch");

        test.pass("Button text is Login");
    }

    // PLACEHOLDER VALIDATION

    @Test(priority = 4)
    public void placeholdervalidation() throws IOException {

        driver.get("https://www.saucedemo.com/");

        test = extent.createTest("Placeholder Validation Test");

        log = new loginpage(driver);

        String username =
                log.username.getDomAttribute("placeholder");

        String password =
                log.pass.getDomAttribute("placeholder");

        Assert.assertEquals(username, "Username",
                "Username placeholder mismatch");

        Assert.assertEquals(password, "Password",
                "Password placeholder mismatch");

        test.pass("Placeholder validation passed");
    }

    // PAGE TITLE VALIDATION

    @Test(priority = 5)
    public void fetchtitle() throws IOException {

        driver.get("https://www.saucedemo.com/");

        test = extent.createTest("Title Validation Test");

        String act = driver.getTitle();

        String exp = "Swag Labs";

        Assert.assertEquals(act, exp, "Title mismatch");

        test.pass("Title validation passed");
    }
}
