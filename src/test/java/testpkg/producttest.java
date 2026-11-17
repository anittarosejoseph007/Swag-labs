package testpkg;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg.Reporterclass;
import basepkg.baseclass;
import pagepkg.loginpage;
import pagepkg.productpage;

public class producttest extends baseclass {

    loginpage log;
    productpage pdt;

    public void loginToApplication() throws InterruptedException {
        driver.get(url);
        log = new loginpage(driver);
        log.setvalue("standard_user", "secret_sauce");
        Thread.sleep(3000);
    }

    @Test(priority = 1)
    public void logo() throws IOException, InterruptedException {
        test = extent.createTest("Product Page Logo Validation");
        loginToApplication();

        pdt = new productpage(driver);
        WebElement x = pdt.logoverify();

        if (x.isDisplayed()) {
            System.out.println("Product page logo displayed successfully!");
            test.pass("Logo displayed successfully in product page");
        } else {
            String path = Reporterclass.Screenshotmethod(driver, "logo_validation");
            test.addScreenCaptureFromPath(path);
            test.fail("Logo not displayed");
            Assert.fail("Product page logo not displayed");
        }
    }

    @Test(priority = 2)
    public void additemstocart() throws InterruptedException {
        test = extent.createTest("Add Items to Cart Test");
        loginToApplication();

        pdt = new productpage(driver);
        Thread.sleep(3000);

        printProductDetails();
        Thread.sleep(2000);

        pdt.additems();
        Thread.sleep(3000);

        String cartCount = driver.findElement(By.className("shopping_cart_badge")).getText();
        System.out.println("Total products added to cart: " + cartCount);
        test.info("Total products added to cart: " + cartCount);

        Assert.assertEquals(cartCount, "6", "All six products were not added to cart");
        System.out.println("Successfully added all products to cart!");
        test.pass("All six products added successfully to cart");
    }

    @Test(priority = 3)
    public void dropdownValidation() throws InterruptedException {
        test = extent.createTest("Product Dropdown Validation");
        loginToApplication();

        pdt = new productpage(driver);
        Thread.sleep(2000);

        WebElement dropdownElement = pdt.getDropdownElement();
        Select select = new Select(dropdownElement);
        select.selectByVisibleText("Name (Z to A)");

        Thread.sleep(3000);
        String selectedOption = select.getFirstSelectedOption().getText();

        System.out.println("Selected dropdown option: " + selectedOption);
        test.info("Selected dropdown option: " + selectedOption);

        Assert.assertEquals(selectedOption, "Name (Z to A)", "Dropdown selection failed");
        System.out.println("Successfully selected Name (Z to A) from dropdown!");
        test.pass("Successfully selected Name (Z to A) from dropdown");
    }

    public void printProductDetails() {
        List<WebElement> products = driver.findElements(By.className("inventory_item"));

        System.out.println("\n==========================================");
        System.out.println("          SWAG LABS PRODUCT DETAILS");
        System.out.println("==========================================");

        test.info("Total products displayed: " + products.size());

        for (int i = 0; i < products.size(); i++) {
            WebElement product = products.get(i);

            String name = product.findElement(By.className("inventory_item_name")).getText();
            String description = product.findElement(By.className("inventory_item_desc")).getText();
            String price = product.findElement(By.className("inventory_item_price")).getText();

            System.out.println("\nProduct " + (i + 1));
            System.out.println("Product Name: " + name);
            System.out.println("Description: " + description);
            System.out.println("Price: " + price);
            System.out.println("------------------------------------------");

            test.info("Product " + (i + 1) + ": " + name);
            test.info("Description: " + description);
            test.info("Price: " + price);
        }

        System.out.println("Total Number of Products: " + products.size());
        System.out.println("==========================================\n");

        Assert.assertEquals(products.size(), 6, "Expected six products on the product page");
        test.pass("All product details displayed successfully");
    }

	

	
}