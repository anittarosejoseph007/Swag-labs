	package testpkg;

	import org.testng.annotations.Test;

	import basepkg.baseclass;
	import pagepkg.infopage;
	import pagepkg.loginpage;
	import pagepkg.productpage;
	import pagepkg.checkoutpage;

	public class infotest extends baseclass {

	    @Test
	    public void infovalidation() throws InterruptedException {

	        loginpage log = new loginpage(driver);
	        productpage pdt = new productpage(driver);
	        checkoutpage checkout = new checkoutpage(driver);
	        infopage info = new infopage(driver);

	        test = extent.createTest("Information page test");

	        log.setvalue("standard_user", "secret_sauce");

	        Thread.sleep(2000);

	        pdt.additems();

	        Thread.sleep(2000);

	        checkout.cartclick();

	        Thread.sleep(2000);

	        checkout.cartclick();

	        Thread.sleep(2000);

	        info.setvalue("Anitta", "Joseph", "689645");

	        Thread.sleep(2000);

	        test.pass("Information details entered successfully");

	    }
	}

