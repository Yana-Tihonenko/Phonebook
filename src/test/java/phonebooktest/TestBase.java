package phonebooktest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    } catch (NoSuchElementException e){
      return false;
    }
  }

  @AfterMethod(enabled = false)
  public void tearDown() {
    driver.quit();
  }

  public void type(By locator, String text) {
    driver.findElement(locator).click();
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
  }

  public  void click (By locator){

    driver.findElement(locator).click();
}
}
