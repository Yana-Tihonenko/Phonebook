package phonebooktests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {
  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignButton();
    }
  }

  @Test
  public void loginTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginRegistrationForm(new User().setEmail("tykhonenko@gmail.com").setPassword("R!q121212"));
    app.getUser().clickOnLoginButton();
    Assert.assertTrue(app.getUser().isSingButtonPresent());
  }
  @Test
  public void loginNegativeWithoutPasswordTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginRegistrationForm(new User().setEmail("tykhonenko@gmail.com"));
    app.getUser().clickOnLoginButton();
    Assert.assertTrue(app.getUser().isAlertPresent());
  }

}
