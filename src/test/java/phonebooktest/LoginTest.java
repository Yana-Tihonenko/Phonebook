package phonebooktest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest extends TestBase{
  @BeforeMethod
  public void ensurePrecondition() {

    if (!isElement(By.cssSelector("[href='/login']"))) {
      driver.findElement(By.xpath("//button[.='Sign Out']")).click();
    }
  }

@Test
  public  void  loginTest(){
  click(By.cssSelector("[href='/login']"));
  type(By.cssSelector("[placeholder='Email']"), "tykhonenko@gmail.com");
  type(By.cssSelector("[placeholder='Password']"), "R!q121212");
  driver.findElement(By.name("login")).click();
  Assert.assertTrue(isElement(By.xpath("//button[.='Sign Out']")));
}

}
