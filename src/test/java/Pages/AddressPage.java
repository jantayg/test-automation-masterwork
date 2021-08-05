package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {
  WebDriver driver;

  public AddressPage(WebDriver driver) {
    this.driver = driver;
  }

  @FindBy(name = "address1")
  private WebElement address;

  @FindBy(name = "city")
  private WebElement city;

  @FindBy(name = "postcode")
  private WebElement postcode;

  @FindBy(name = "id_state")
  private WebElement stateDropdown;

  @FindBy(name = "id_country")
  private WebElement countryDropdown;

  @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/footer/button")
  private WebElement saveButton;

  public void fillAddressFields(String address, String city, String state, String postalCode,
                                String country) {

    this.address.sendKeys(address);
    this.city.sendKeys(city);
    Select stateSelect = new Select(stateDropdown);
    stateSelect.selectByVisibleText(state);
    this.postcode.sendKeys(postalCode);
    Select countrySelect = new Select(countryDropdown);
    countrySelect.selectByVisibleText(country);
    this.saveButton.click();
  }

  public void editAddressField(String address) {
    this.address.clear();
    this.address.sendKeys(address);
    this.saveButton.click();
  }

}
