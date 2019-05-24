package bobcat.publish.login;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.cognifide.qa.bb.aem.core.api.AemActions;
import com.cognifide.qa.bb.api.actions.ActionException;
import com.cognifide.qa.bb.api.actions.ActionsController;
import com.cognifide.qa.bb.junit5.guice.Modules;
import com.cognifide.qa.bb.modules.BobcatRunModule;
import com.cognifide.qa.bb.page.BobcatPageFactory;
import com.google.inject.Inject;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import bobcat.publish.pages.TestPage;

import com.cognifide.qa.bb.aem.AemLogin;

/**
 * Test for presenting how to log in to the page.
 */
@Modules(BobcatRunModule.class)
@Epic("AEM 6.4 Base Tests")
@Feature("Login to AEM")
public class AuthorizationTest {

	@Inject
	private ActionsController controller;

	@Inject
	private BobcatPageFactory bobcatPageFactory;
	
	@Inject
	private TestPage testPage;
	
	 @Inject
	  private AemLogin aemLogin;


	@Test
	@Story("Login to AEM and open Test page")
	@Description("Login to publish instance and open test page")
	public void loginTest() throws ActionException {
		/*TestPage testpage = bobcatPageFactory.create("/content/we-retail/us/en.html", TestPage.class);
		System.out.println("Inside 1");
		controller.execute(AemActions.LOG_IN);
		System.out.println("Inside 2");
		testPage.open();
		System.out.println("Inside 3");
		assertTrue(testPage.isDisplayed());*/
		aemLogin.authorLogin();
	    testPage.open();
	    assertTrue(testPage.isDisplayed());
		
	}

}
