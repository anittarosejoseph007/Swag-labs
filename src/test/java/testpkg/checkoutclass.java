package testpkg;

import org.testng.annotations.Test;

import basepkg.baseclass;
import pagepkg.checkoutpage;
import pagepkg.loginpage;
import pagepkg.productpage;

public class checkoutclass extends baseclass {

    @Test
    public void iconclick() throws InterruptedException {

        loginpage log = new loginpage(driver);
        productpage pdt = new productpage(driver);
        checkoutpage checkout = new checkoutpage(driver);

        test = extent.createTest("checkout test");

        log.setvalue("standard_user", "secret_sauce");

        Thread.sleep(2000);

        pdt.additems();

        Thread.sleep(2000);

        checkout.cartclick();

        Thread.sleep(2000);

        test.pass("Checkout test passed");
    }
}