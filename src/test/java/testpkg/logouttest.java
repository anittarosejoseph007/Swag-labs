
package testpkg;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg.baseclass;

import pagepkg.loginpage;
import pagepkg.checkoutpage;
import pagepkg.checkoutstep2;
import pagepkg.infopage;
import pagepkg.logoutpage;

public class logouttest extends baseclass {

    @Test
    public void logout() throws InterruptedException, IOException {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        loginpage log = new loginpage(driver);

        checkoutpage checkout = new checkoutpage(driver);

        infopage pag = new infopage(driver);

        checkoutstep2 step2 = new checkoutstep2(driver);

        logoutpage lgout = new logoutpage(driver);

        Thread.sleep(5000);

        // 1. OPEN SAUCEDEMO WEBSITE

        test = extent.createTest("Open SauceDemo Website");

        driver.get("https://www.saucedemo.com/");

        System.out.println("Opening SauceDemo website");

        test.info("SauceDemo website opened");


        // 2. LOGIN

        test = extent.createTest("Login Test - Logout Flow");

        log.setvalue("standard_user", "secret_sauce");

        wait.until(
                ExpectedConditions.urlContains("inventory.html"));

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory.html"),
                "Login failed");

        System.out.println("Successfully logged in");

        test.pass("Successfully logged in");


        // 3. PRODUCT LOGO VERIFICATION

        test = extent.createTest("Product Logo Verification");

        System.out.println("Product logo verification");

        WebElement logo = driver.findElement(
                By.className("app_logo"));

        Assert.assertTrue(logo.isDisplayed(),
                "Product logo not displayed");

        test.pass("Product logo displayed");


        // 4. PRODUCT DETAILS

        test = extent.createTest("Product Details Verification");

        System.out.println("Displaying product details");

        List<WebElement> products =
                driver.findElements(
                        By.className("inventory_item"));

        System.out.println("SWAG LABS PRODUCT DETAILS");

        for (int i = 0; i < products.size(); i++) {

            WebElement product = products.get(i);

            String name = product.findElement(
                    By.className("inventory_item_name")).getText();

            String description = product.findElement(
                    By.className("inventory_item_desc")).getText();

            String price = product.findElement(
                    By.className("inventory_item_price")).getText();

            System.out.println("Product " + (i + 1));

            System.out.println("Product Name: " + name);

            System.out.println("Description: " + description);

            System.out.println("Price: " + price);

            test.info("Product Name: " + name);

            test.info("Description: " + description);

            test.info("Price: " + price);
        }

        Assert.assertEquals(products.size(), 6,
                "Expected six products");

        test.pass("All six product details displayed");


        // 5. DROPDOWN VALIDATION

        test = extent.createTest("Product Dropdown Validation");

        System.out.println("Product dropdown validation");

        WebElement dropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.className("product_sort_container")));

        Assert.assertTrue(dropdown.isDisplayed());

        test.pass("Product dropdown displayed");


        // 6. ADD PRODUCTS TO CART

        test = extent.createTest("Add Products To Cart");

        System.out.println("Adding products to cart");

        List<WebElement> addButtons =
                driver.findElements(
                        By.xpath("//button[contains(@id,'add-to-cart')]"));

        Assert.assertTrue(addButtons.size() > 0,
                "No add to cart buttons found");

        // Add first two products

        for (int i = 0; i < 2; i++) {

            addButtons.get(i).click();

        }

        test.pass("Products added to cart");


        // 7. OPEN SHOPPING CART

        test = extent.createTest("Shopping Cart Verification");

        checkout.cartclick();

        wait.until(
                ExpectedConditions.urlContains("cart.html"));

        System.out.println("Shopping cart opened");

        test.pass("Shopping cart opened");


        // 8. CLICK CHECKOUT

        test = extent.createTest("Checkout Button Verification");

        checkout.checkoutclick();

        wait.until(
                ExpectedConditions.urlContains("checkout-step-one.html"));

        System.out.println("Checkout button clicked");

        test.pass("Checkout button clicked");


        // 9. ENTER CUSTOMER INFORMATION

        test = extent.createTest("Customer Information Validation");

        pag.setvalue("Anitta", "Joseph", "689645");

        wait.until(
                ExpectedConditions.urlContains("checkout-step-two.html"));

        System.out.println("Customer information entered");

        test.pass("Customer information entered");


        // 10. FINISH ORDER

        test = extent.createTest("Order Completion Verification");

        step2.clickFinish();

        wait.until(
                ExpectedConditions.urlContains("checkout-complete.html"));

        System.out.println("Order completed successfully");

        test.pass("Order completed successfully");


        // 11. LOGOUT

        test = extent.createTest("Logout Verification");

        lgout.logoutclick();

        // Verify logout

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("login-button")));

        System.out.println("Successfully logged out");

        Assert.assertTrue(
                driver.findElement(By.id("login-button")).isDisplayed(),
                "Logout verification failed");

        test.pass("Successfully completed checkout and logout");

    }

}
