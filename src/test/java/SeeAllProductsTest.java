import Pages.PrestaShop;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeeAllProductsTest extends BaseTest {
  @DisplayName("List all products")
  @Feature("List all products")
  @Description("should List more products on new list by pressing next until all products has been displayed ")
  @Test
  public void listAccessoriesAToZOrder()  {
    PrestaShop prestaShop = PageFactory.initElements(driver, PrestaShop.class);
    prestaShop.open();
    prestaShop.clickOnListAllProductsButton();
    String homepageUrl = driver.getCurrentUrl();
    prestaShop.clickOnNextButton();
    String lastProductPageUrl = driver.getCurrentUrl();
    Assertions.assertThat(lastProductPageUrl).isNotEqualTo(homepageUrl);
    Assertions.assertThat(lastProductPageUrl).contains("page=2");
  }
}

