package phonebooktest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
  @BeforeMethod
  public void ensurePrecondition() {
    if (!isLoginLinkPresent()) {
      clickOnSignButton();
    }
  }

  @Test
  public void newUseRegistrationPositiveTest() {

    clickOnLoginLink();
    fillLoginRegistrationForm(new User().setEmail("tykhsossenko@gmail.com").setPassword("R!q121212"));
    clickOnRegistrationButton();
    Assert.assertTrue(isAlertPresent());

  }

  @Test
  public void exitedUseRegistrationNegativeTest() {

    clickOnLoginLink();
    fillLoginRegistrationForm(new User().setEmail("tykhonenko@gmail.com").setPassword("R!q121212"));
   clickOnRegistrationButton();
    Assert.assertTrue(isAlertPresent());
  }

}
