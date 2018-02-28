package uk.co.news.methode.automation.Helper.Tablet;


import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.window.*;
import uk.co.news.methode.automation.utils.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(uk.co.news.methode.automation.testng.Listener.class)
public class LoginTest extends AutoIt {

		@Test()
		public void login() throws Exception {
			 advanceReport.getTestByName("LoginTest").setEdition("national");
			 advanceReport.getTestByName("LoginTest").setComments("login into the application");
			 Login.doLogin();
		}

		@Test(dependsOnMethods= {"login"})
		public void closeMODWindow() throws Exception {
			 MoD.close();
		}

		@Test(dependsOnMethods= {"closeMODWindow"})
		public void openPagepLan() throws Exception {
			 PagePlanner.openExistingPagePlan("12/08/2017");
		}

}
