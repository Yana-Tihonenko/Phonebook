package phonebooktests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactsTests extends TestBase {
  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignButton();
    }
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginRegistrationForm(new User().setEmail("tykhonenko@gmail.com").setPassword("R!q121212"));
    app.getUser().click(By.name("login"));

  }

  @Test
  public void addContactPositiveTest() {
    app.getContact().clickOnAddLink();
    app.getContact().fillAddContactForm(new Contact()
        .setName("Misha")
        .setLastName("Tykhonenko")
        .setPhone("1234567890")
        .setEmal("aaa@gmail.com")
        .setAddress("address")
        .setDescription("description"));
    app.getContact().clickOnSaveButton();
    Assert.assertTrue(isContactCreated("Misha"));


  }

  @AfterMethod
  public void removeContactItem(){
    app.getContact().clickOnContactItem();
    app.getContact().clickOnDeleteButton();
  }

  public boolean isContactCreated(String name) {
    List<WebElement> contacts = app.driver.findElements(By.cssSelector("h2"));
    for (WebElement element : contacts) {
      if (element.getText().contains(name)) {
        return true;
      }
    }
    return false;
  }

}
