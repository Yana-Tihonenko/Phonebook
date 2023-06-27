package com.phonebook.fw;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseHelper {

  WebDriver driver;

    public BaseHelper(WebDriver driver) {
    this.driver=driver;
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

  public void  waitSeconds (int time){
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

  }

  public void pause(int millisecond)  {
    try {
      Thread.sleep(millisecond);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
