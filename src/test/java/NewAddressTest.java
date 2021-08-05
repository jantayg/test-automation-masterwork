import Pages.AddressPage;
import Pages.AddressesPage;
import Pages.LoginPage;
import Pages.YourAccountPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.PageFactory;

public class NewAddressTest extends BaseTest {
  @DisplayName("Successfully add a new address")
  @Feature("Add new address")
  @Description("Successfully add a new address to the account")
  @Test
  public void logInSuccessfully() throws InterruptedException {
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    loginPage.open();
    loginPage.logIn("tesztzoltan@test.com", "password");

    YourAccountPage yourAccountPage = PageFactory.initElements(driver, YourAccountPage.class);
    yourAccountPage.getAddressButton().click();

    AddressesPage addressesPage = PageFactory.initElements(driver, AddressesPage.class);
    if (driver.getTitle().equals("Addresses")) {
      addressesPage.getAddNewAddressButton().click();
    }

    AddressPage addressPage = PageFactory.initElements(driver, AddressPage.class);
    addressPage.fillAddressFields("123 Sheep Str.", "Marathon", "Texas", "79842", "United States");
    Assertions.assertThat(addressesPage.getAddressSuccessfullyAddedMessage().getText())
        .isEqualTo("Address successfully added!");
  }
}
