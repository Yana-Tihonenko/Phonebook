package phonebooktests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutPageHelper  extends BaseHelper{

  public AboutPageHelper(WebDriver driver) {
    super(driver);
  }

  public void clickOnAboutLink()  {
    click(By.cssSelector("[href='/about']"));
  }
}

