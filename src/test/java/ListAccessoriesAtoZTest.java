
import Pages.PrestaShop;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListAccessoriesAtoZTest extends BaseTest {
  @DisplayName("List accessories in A to Z order")
  @Feature("List products in A to Z order")
  @Description("choosing the option to display accessories in A to Z order should display the accessories in A to Z order")
  @Test
  public void listAccessoriesAToZOrder() {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    PrestaShop prestaShop = PageFactory.initElements(driver, PrestaShop.class);
    prestaShop.open();
    prestaShop.clickOnAccessoriesLink();
    prestaShop.selectAToZOrder();
    ArrayList<String> productNameList = new ArrayList<>();
    wait.until(
        (ExpectedCondition<Boolean>) driver -> prestaShop.getOrderSelectorDropdown().getText()
            .contains("Name, A to Z"));
    List<WebElement> elementList = driver.findElements(By.tagName("h2"));
    for (WebElement we : elementList) {
      productNameList.add(we.getText());
    }
    ArrayList<String> sortedList = new ArrayList<>();
    for (String s : productNameList) {
      sortedList.add(s);
    }
    Collections.sort(sortedList);
    Assertions.assertThat(productNameList).isEqualTo(sortedList);
  }
}