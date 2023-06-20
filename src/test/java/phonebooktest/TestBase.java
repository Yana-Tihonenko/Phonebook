package phonebooktest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

  WebDriver driver;

  @BeforeMethod
  public void setUp() {
    System.err.close();
    driver = new ChromeDriver();
    driver.navigate().to("https://telranedu.web.app/home");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

  }

  public boolean isElements(By locator) {
    return driver.findElements(locator).size() > 0;

  }

  public boolean isElement(By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  @AfterMethod(enabled = false)
  public void tearDown() {
    driver.quit();
  }

  public void type(By locator, String text) {
    if (text != null) {
      driver.findElement(locator).click();
      driver.findElement(locator).clear();
      driver.findElement(locator).sendKeys(text);
    }

  }

  public void click(By locator) {

    driver.findElement(locator).click();
  }

  public boolean isAlertPresent() {
    Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
        .until(ExpectedConditions.alertIsPresent());
    if (alert == null) {
      return false;
    } else {
      driver.switchTo().alert();
      alert.accept();
    }
    return true;
  }

  public void clickOnSignButton() {
    driver.findElement(By.xpath("//button[.='Sign Out']")).click();
  }

  public boolean isLoginLinkPresent() {
    return isElement(By.cssSelector("[href='/login']"));
  }

  public void clickOnRegistrationButton() {
    driver.findElement(By.name("registration")).click();
  }

  public void fillLoginRegistrationForm(User user) {
    type(By.cssSelector("[placeholder='Email']"), user.getEmail());
    type(By.cssSelector("[placeholder='Password']"), user.getPassword());
  }

  protected void clickOnLoginLink() {
    click(By.cssSelector("[href='/login']"));
  }

  public boolean isSingButtonPresent() {
    return isElement(By.xpath("//button[.='Sign Out']"));
  }

  public void clickOnLoginButton() {
    driver.findElement(By.name("login")).click();
  }

  public void clickOnSaveButton() {
    click(By.cssSelector(".add_form__2rsm2 button"));
  }

  public void fillAddContactForm(Contact contact) {
   // int randomNumber =(int) (System.currentTimeMillis()/1000)%3600;
    type(By.cssSelector("input:nth-child(1)"), contact.getName());
    type(By.cssSelector("input:nth-child(2)"), contact.getLastName());
    type(By.cssSelector("input:nth-child(3)"), contact.getPhone());
    type(By.cssSelector("input:nth-child(4)"), contact.getEmal());
    type(By.cssSelector("input:nth-child(5)"), contact.getAddress());
    type(By.cssSelector("input:nth-child(6)"), contact.getDescription());
  }

  public void clickOnAddLink() {
    click(By.xpath("//a[.='ADD']"));
  }

  public  void  clickOnContactItem(){
    driver.findElement(By.className("contact-item_card__2SOIM")).click();
  }

  public  void  clickOnDeleteButton(){
    driver.findElement(By.cssSelector(".contact-item-detailed_card__50dTS button:last-child")).click();
  }
}
