package com.phonebooktests;


import com.phonebook.model.Contact;
import com.phonebook.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RemoveContactTest extends TestBase {

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
  public void removeContactPositive() throws InterruptedException {
    if (!app.getContact().isPresentContactItems()) {
      app.getContact().clickOnAddLink();
      app.getContact().fillAddContactForm(new Contact()
          .setName("Misha")
          .setLastName("Tykhonenko")
          .setPhone("1234567890")
          .setEmal("aaa@gmail.com")
          .setAddress("address")
          .setDescription("description"));
      app.getContact().clickOnSaveButton();
    }
    app.getContact().waitSeconds(10);
    int beforeCountContact = app.getContact().countContactFromList();
    app.getContact().clickOnContactItem();
    app.getContact().clickOnDeleteButton();
    app.getContact().pause(10);
    app.getContact().clickOnContactLink();
    int afterCountContact = app.getContact().countContactFromList();
    Assert.assertEquals(afterCountContact, beforeCountContact - 1);
  }
}
