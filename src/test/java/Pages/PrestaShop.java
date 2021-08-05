package Pages;


import java.time.Instant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

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

  @FindBy(xpath = "//*[@id=\"js-product-list-top\"]/div[2]/div/div[1]/button")
  private WebElement orderSelectorDropdown;

  @FindBy(linkText = "Name, A to Z")
  private WebElement aToZOrderButton;

  @FindBy(xpath = "//*[@id=\"content\"]/section/a")
  private WebElement listAllProductsButton;

  @FindBy(xpath = "//nav[@class='pagination']/div[2]/ul/li[3]/a")
  private WebElement nextButton;

  public WebElement getOrderSelectorDropdown() {
    return orderSelectorDropdown;
  }

  public void clickOnAccessoriesLink() {
    this.accessoriesLink.click();
  }

  public void selectAToZOrder() {
    this.orderSelectorDropdown.click();
    this.aToZOrderButton.click();
  }

  public void clickOnListAllProductsButton() {
    this.listAllProductsButton.click();
  }

  public void clickOnNextButton() {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    while (true) {
      if (!this.nextButton.getText().contains("Next")) {
        break;
      } else {
        String currentUrl = driver.getCurrentUrl();
        this.nextButton.click();
        wait.until(
            (ExpectedCondition<Boolean>) driver -> Boolean.valueOf(!driver.getCurrentUrl().equals(currentUrl)));
      }
    }
  }
}