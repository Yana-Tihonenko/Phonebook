package phonebooktest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
  // precondition user should be logged out
// clock on login link
  // enter email
  // enter password
  // click on login button
  // assert Sing button is displayed
  @BeforeMethod
  public void ensurePrecondition() {

    if (!isElement(By.cssSelector("[href='/login']"))) {
      driver.findElement(By.xpath("//button[.='Sign Out']")).click();
    }
  }

  @Test
  public void newUseRegistrationPositiveTest() {

    click(By.cssSelector("[href='/login']"));
    type(By.cssSelector("[placeholder='Email']"), "tykhonenko@gmail.com");
    type(By.cssSelector("[placeholder='Password']"), "R!q121212");
    driver.findElement(By.name("registration")).click();
    Assert.assertTrue(isElement(By.xpath("//button[.='Sign Out']")));

  }

}
