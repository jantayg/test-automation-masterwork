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

  @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
  private WebElement addressSuccessfullyAddedMessage;

  @FindBy(xpath = "//section[@id=\"content\"]/div[1]/article/div[@class=\"address-footer\"]/a[2]")
  private WebElement deleteAddressButton;

  @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
  private WebElement adressSuccessfullyDeletedMessage;

  @FindBy(xpath = "//section[@id=\"content\"]/div[1]/article/div[@class=\"address-footer\"]/a[1]")
  private WebElement editAddressButton;

  @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
  private WebElement addressSuccessfullyUpdatedMessage;

  @FindBy(xpath = "//address")
  private WebElement firstAddress;

  public WebElement getAdressSuccessfullyDeletedMessage() {
    return adressSuccessfullyDeletedMessage;
  }

  public WebElement getEditAddressButton() {
    return editAddressButton;
  }

  public WebElement getDeleteAddressButton() {
    return deleteAddressButton;
  }

  public WebElement getAddNewAddressButton() {
    return addNewAddressButton;
  }

  public WebElement getAddressSuccessfullyAddedMessage() {
    return addressSuccessfullyAddedMessage;
  }

  public WebElement getAddressSuccessfullyUpdatedMessage() {
    return addressSuccessfullyUpdatedMessage;
  }

  public WebElement getFirstAddress() {
    return firstAddress;
  }
}
