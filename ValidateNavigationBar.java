package FinalProject.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class ValidateNavigationBar extends base {
	private static Logger log=LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initilize() throws IOException {
		driver = InitializeDriver();
		log.info("Driver is initialize");
		driver.get(prop.getProperty("url"));
		log.info("Navigate to home page");
	}

	@Test
	public void basePageNavigation() throws IOException {

		LandingPage ld = new LandingPage(driver);
		// compare the text on browser and required text
		Assert.assertTrue(ld.getNavigateBar().isDisplayed());
		// Assert.assertFalse(false);
		System.out.print(ld.getNavigateBar().getText());
		log.info("Successfully Displayed");
	}

	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Driver Close");
	}

}
