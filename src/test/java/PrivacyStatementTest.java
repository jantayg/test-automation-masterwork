import Pages.SignUpPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class PrivacyStatementTest extends BaseTest {

  @DisplayName("Privacy Statement Test")
  @Feature("Privacy statement")
  @Description("Privacy statement should appear in a separate window after clicking on its link. Checkbox should be clicked after clicking on it.")
  @Test
  public void clickOnPrivacyAndClickItsCheckbox() {
    SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
    signUpPage.open();
    String parentWindow = driver.getWindowHandle();
    signUpPage.getPrivacyLink().click();
    Set<String> handles = driver.getWindowHandles();
    for (String handle : handles) {
      if (!handle.equals(parentWindow)) {
        driver.switchTo().window(handle);
        Assertions.assertThat(driver.getTitle()).isEqualTo("Terms and conditions of use");
        driver.close();
        driver.switchTo().window(parentWindow);
      }
    }
    signUpPage.getPrivacythick().click();
    Assertions.assertThat(signUpPage.getPrivacythick().isSelected()).isTrue();
  }
}
