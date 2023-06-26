package phonebooktests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends BaseHelper {


  public ContactHelper(WebDriver driver) {
    super(driver);
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

  public void clickOnContactItem() {
    click(By.cssSelector("[class*=contact-item_card]"));
  }

  public void clickOnDeleteButton() {
    click(By.xpath("//button[contains(text(),'Remove')]"));
  }

  public boolean isPresentContactItems() {
    if (isElements(By.cssSelector("[class*=contact-item_card]"))) {
      return true;
    }
    return false;
  }

  public  int countContactFromList(){
    return driver.findElements(By.cssSelector("[class*=contact-item_card]")).size();

  }

  public void clickOnContactLink() {
    click(By.cssSelector("[href='/contacts']"));
  }

}
