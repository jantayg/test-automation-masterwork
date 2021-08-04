package Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PrestaShop {
  WebDriver driver;

  public PrestaShop(WebDriver driver) {
    this.driver = driver;
  }

  public void open() {
    driver.get("http://test-automation-shop1.greenfox.academy");
  }

  @FindBy(id = "category-6")
  private WebElement accessoriesLink;

  public WebElement getOrderSelectorDropdown() {
    return orderSelectorDropdown;
  }

  @FindBy(xpath = "//*[@id=\"js-product-list-top\"]/div[2]/div/div[1]/button")
  private WebElement orderSelectorDropdown;

  @FindBy(linkText = "Name, A to Z")
  private WebElement aToZOrderButton;

  @FindBy(xpath = "//*[@id=\"content\"]/section/a")
  private WebElement listAllProductsButton;

  public WebElement getNextButton() {
    return nextButton;
  }

  @FindBy(xpath = "//nav[@class='pagination']/div[2]/ul/li[3]/a")
  private WebElement nextButton;

  public void clickOnAccessoriesLink() {
    this.accessoriesLink.click();
  }

  public void selectAToZOrder() {
    this.orderSelectorDropdown.click();
    this.aToZOrderButton.click();
  }

  public void clickOnListAllProductsButton(){
    this.listAllProductsButton.click();
  }

  public void clickOnNextButton() throws InterruptedException {
    while (true) {
      Thread.sleep(2000);
      if (!this.nextButton.getText().contains("Next")) {
        break;
      } else this.nextButton.click();
    }
  }
}
