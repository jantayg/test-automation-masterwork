import Pages.PrestaShop;
import io.qameta.allure.Description;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeeAllProductsTest extends BaseTest {
  @DisplayName("List all products")
  @Description("should List more products on new list by pressing next until all products has been displayed ")
  @Test
  public void listAccessoriesAToZOrder() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    PrestaShop prestaShop = PageFactory.initElements(driver, PrestaShop.class);
    prestaShop.open();
    prestaShop.clickOnListAllProductsButton();
    String homepageUrl = driver.getCurrentUrl();
    wait.until(ExpectedConditions.elementToBeClickable(prestaShop.getNextButton()));
    prestaShop.clickOnNextButton();
    String lastProductPageUrl = driver.getCurrentUrl();
    Assertions.assertThat(lastProductPageUrl).isNotEqualTo(homepageUrl);
    Assertions.assertThat(lastProductPageUrl).contains("page=2");

  }
}

