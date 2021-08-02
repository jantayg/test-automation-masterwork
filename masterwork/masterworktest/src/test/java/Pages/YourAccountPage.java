package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourAccountPage {
  WebDriver driver;

  public YourAccountPage(WebDriver driver) {
    this.driver = driver;
  }

  @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a[1]")
  private WebElement signOutButton;

  @FindBy(xpath = "//section[@id=\"content\"]/div/div/a[2]")
  private  WebElement addressButton;

  public WebElement getAddressButton() {
    return addressButton;
  }

  @FindBy(xpath = "//*[@id=\"addresses-link\"]")
  private  WebElement addressesButton;

  public WebElement getAddressesButton() {
    return addressesButton;
  }

  public void logOut() {
    this.signOutButton.click();
  }

}
