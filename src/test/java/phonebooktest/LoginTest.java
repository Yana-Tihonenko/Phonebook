package phonebooktest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {
  @BeforeMethod
  public void ensurePrecondition() {
    if (!isLoginLinkPresent()) {
      clickOnSignButton();
    }
  }

  @Test
  public void loginTest() {
    clickOnLoginLink();
    fillLoginRegistrationForm(new User().setEmail("tykhonenko@gmail.com").setPassword("R!q121212"));
    clickOnLoginButton();
    Assert.assertTrue(isSingButtonPresent());
  }
  @Test
  public void loginNegativeWithoutPasswordTest() {
    clickOnLoginLink();
    fillLoginRegistrationForm(new User().setEmail("tykhonenko@gmail.com"));
    clickOnLoginButton();
    Assert.assertTrue(isAlertPresent());
  }

}
