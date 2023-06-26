package phonebooktests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignButton();
    }
  }

  @Test
  public void newUseRegistrationPositiveTest() {

    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginRegistrationForm(new User().setEmail("tykhsossenko@gmail.com").setPassword("R!q121212"));
    app.getUser().clickOnRegistrationButton();
    Assert.assertTrue(app.getUser().isAlertPresent());

  }

  @Test
  public void exitedUseRegistrationNegativeTest() {

    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginRegistrationForm(new User().setEmail("tykhonenko@gmail.com").setPassword("R!q121212"));
   app.getUser().clickOnRegistrationButton();
    Assert.assertTrue(app.getUser().isAlertPresent());
  }

}
