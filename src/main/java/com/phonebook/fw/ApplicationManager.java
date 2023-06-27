package com.phonebook.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ApplicationManager {

  String browser;
  public WebDriver driver;
  UserHelper user;
  ContactHelper contact;
  HomePageHelper homePage;

  AboutPageHelper aboutPageHelper;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public UserHelper getUser() {
    return user;
  }

  public ContactHelper getContact() {
    return contact;
  }

  public HomePageHelper getHomePage() {
    return homePage;
  }

  public AboutPageHelper getAboutPageHelper() {return aboutPageHelper;  }

  public void init() {
    System.err.close();
    if (browser.equalsIgnoreCase("chrome")) {
      driver = new ChromeDriver();
    } else if (browser.equalsIgnoreCase("firefox")) {
      driver = new FirefoxDriver();
    }
    driver.navigate().to("https://telranedu.web.app/home");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    user = new UserHelper(driver);
    contact = new ContactHelper(driver);
    homePage = new HomePageHelper(driver);
    aboutPageHelper = new AboutPageHelper(driver);
  }

  public void stop() {
    driver.quit();
  }


}
