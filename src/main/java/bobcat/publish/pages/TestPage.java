package bobcat.publish.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cognifide.qa.bb.aem.core.pages.AemAuthorPage;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.cognifide.qa.bb.wait.BobcatWait;
import com.google.inject.Inject;

import com.cognifide.qa.bb.aem.page.PublishPage;

@PageObject
public class TestPage extends PublishPage {

  @Inject
  private BobcatWait bobcatWait;

  private String title = "English";
  private String url = "/content/etap/LoginPage.html";

  public String getPageTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContentPath() {
	    return url;
  }

  public void setContentPath(String url) {
    this.url = url;
  }
  
  public boolean isDisplayed() {
    return bobcatWait.isConditionMet(ExpectedConditions.titleIs(getPageTitle()));
  }

  public boolean isNotAvailable() {
    return bobcatWait.isConditionMet(ExpectedConditions.titleContains("404 Resource"));
  }
  
  public boolean isURLDisplayed() {
	    return bobcatWait.isConditionMet(ExpectedConditions.urlToBe(getContentPath()));
  }

  public boolean isURLNotAvailable() {
	    return bobcatWait.isConditionMet(ExpectedConditions.urlContains("404 Resource"));
  }
}
