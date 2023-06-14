package phonebooktest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

  @Test
  public void openHomePageTest() {

    Assert.assertTrue(isElements(By.cssSelector("div:nth-child(2)>div>div")));
  }


}
