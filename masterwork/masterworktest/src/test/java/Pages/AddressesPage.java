package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressesPage {
  WebDriver driver;

  public AddressesPage(WebDriver driver) {
    this.driver = driver;
  }

  @FindBy(xpath = "//section[@id=\"content\"]/div/a")
  private WebElement addNewAddressButton;

  public WebElement getAddNewAddressButton() {
    return addNewAddressButton;
  }

  @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
  private WebElement addressSuccessfullyAddedMessage;

  public WebElement getAddressSuccessfullyAddedMessage() {
    return addressSuccessfullyAddedMessage;
  }

  @FindBy(xpath = "//section[@id=\"content\"]/div[1]/article/div[@class=\"address-footer\"]/a[2]")
  private WebElement deleteAddressButton;

  public WebElement getDeleteAddressButton() {
    return deleteAddressButton;
  }

  @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
  private WebElement adressSuccessfullyDeletedMessage;

  public WebElement getAdressSuccessfullyDeletedMessage() {
    return adressSuccessfullyDeletedMessage;
  }
  //*[@id="address-497"]/div[2]/a[1]
  @FindBy(xpath = "//section[@id=\"content\"]/div[1]/article/div[@class=\"address-footer\"]/a[1]")
  private WebElement editAddressButton;

  public WebElement getEditAddressButton() {
    return editAddressButton;
  }

  @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
  private WebElement addressSuccessfullyUpdatedMessage;

  public WebElement getAddressSuccessfullyUpdatedMessage() {
    return addressSuccessfullyUpdatedMessage;
  }
}


//*[@id="content"]/div[3]/a