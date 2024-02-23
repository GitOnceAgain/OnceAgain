package FinalProject.E2EProject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ClosePopup;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class ValidateTitle extends base {
	private static Logger log=LogManager.getLogger(base.class.getName());
	// private static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialze() throws IOException, InterruptedException {

	}

	@Test

	public void basePageNavigation() throws IOException, InterruptedException {

		driver = InitializeDriver();
		 log.info("Initialize Driver");
		driver.get(prop.getProperty("url"));
		 log.info("Navigate to Home Page");
		//Thread.sleep(20);

		// ClosePopup cp =new ClosePopup(driver);
		// cp.ClosePopup().click();

		LandingPage ld = new LandingPage(driver);
		// compare the text on browser and required text

		Assert.assertEquals(ld.getTitle().getText(),"An Academy To learn Everything About Tesing");
		System.out.println(ld.getTitle().getText());
		//System.out.print(ld.getTitle().getText());
		 log.info("Successfully Validate Text");

	}

	@AfterTest
	public void teardown() {
		driver.close();
		// log.info("Driver Close");
	}

}
