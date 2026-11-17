
package basepkg;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporterclass {

    public static ExtentSparkReporter reporter;
    public static ExtentReports extent;

    public static ExtentReports sam() {

        new File("./Reports").mkdirs();

        reporter = new ExtentSparkReporter("./Reports/swaglabreport.html");

        reporter.config().setDocumentTitle("Automation testing");
        reporter.config().setReportName("Functional test");
        reporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        extent.setSystemInfo("hostname", "localhost");
        extent.setSystemInfo("os", "windows11");
        extent.setSystemInfo("testername", "anitta");
        extent.setSystemInfo("browser", "chrome");

        return extent;
    }

    public static String Screenshotmethod(WebDriver driver, String screenshotname)
            throws IOException {

        new File("./Reports").mkdirs();

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String destination = "./Reports/" + screenshotname + ".png";

        FileHandler.copy(src, new File(destination));

        return destination;
    }
}
