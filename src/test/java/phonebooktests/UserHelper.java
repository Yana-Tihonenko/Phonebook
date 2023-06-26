package phonebooktests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{

  public UserHelper(WebDriver driver) {
    super(driver);
  }

  public void clickOnSignButton() {
    click(By.xpath("//button[.='Sign Out']"));
  }

  public void clickOnRegistrationButton() {
    click(By.name("registration"));
  }

  public void fillLoginRegistrationForm(User user) {
    type(By.cssSelector("[placeholder='Email']"), user.getEmail());
    type(By.cssSelector("[placeholder='Password']"), user.getPassword());
  }

  public void clickOnLoginButton() {
    click(By.name("login"));
  }

  public boolean isLoginLinkPresent() {
    return isElement(By.cssSelector("[href='/login']"));
  }

  protected void clickOnLoginLink() {
    click(By.cssSelector("[href='/login']"));
  }

  public boolean isSingButtonPresent() {
    return isElement(By.xpath("//button[.='Sign Out']"));
  }

}
