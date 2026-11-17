
package basepkg;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class baseclass {

    public static ExtentReports extent;
    public static ExtentTest test;
    public static WebDriver driver;

    public String url = "https://www.saucedemo.com/";

    @BeforeSuite
    public void browser_launch() {

        extent = Reporterclass.sam();

        driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void browserclose(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {

            test.log(Status.FAIL, "Test case failed: " + result.getName());
            test.log(Status.FAIL, result.getThrowable());

            String screenshotpath =
                    Reporterclass.Screenshotmethod(driver, result.getName());

            test.addScreenCaptureFromPath(screenshotpath);
        }

        else if (result.getStatus() == ITestResult.SKIP) {

            if (test != null) {
                test.log(Status.SKIP, "Test case skipped: " + result.getName());
            }
        }

        else if (result.getStatus() == ITestResult.SUCCESS) {

            test.log(Status.PASS, "Test case passed: " + result.getName());
        }
    }

    @AfterSuite
    public void teardown() {

        if (driver != null) {
            driver.quit();
        }

        if (extent != null) {
            extent.flush();
        }
    }
}
