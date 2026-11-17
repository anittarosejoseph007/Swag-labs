
package testpkg;

import org.testng.annotations.Test;

import basepkg.baseclass;
import pagepkg.checkoutpage;
import pagepkg.checkoutstep2;
import pagepkg.infopage;
import pagepkg.loginpage;
import pagepkg.productpage;

public class checkout2test extends baseclass {

    @Test
    public void iconclick() throws InterruptedException {

        loginpage log = new loginpage(driver);
        productpage pdt = new productpage(driver);
        checkoutpage checkout = new checkoutpage(driver);
        infopage pag = new infopage(driver);
        checkoutstep2 step2 = new checkoutstep2(driver);

        test = extent.createTest("checkout finish test");

        log.setvalue("standard_user", "secret_sauce");
        Thread.sleep(2000);

        pdt.additems();
        Thread.sleep(2000);

        checkout.cartclick();
        Thread.sleep(2000);

        checkout.checkoutclick();
        Thread.sleep(2000);

        pag.setvalue("Anitta", "Joseph", "689645");
        Thread.sleep(2000);

        step2.clickFinish();
        Thread.sleep(2000);

        test.pass("Successfully clicked Finish on Checkout Overview");
    }
}
