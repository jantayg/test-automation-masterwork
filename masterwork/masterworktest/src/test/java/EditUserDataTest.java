import Pages.AddressPage;
import Pages.AddressesPage;
import Pages.LoginPage;
import Pages.YourAccountPage;
import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.PageFactory;

public class EditUserDataTest extends BaseTest {
  @DisplayName("Successfully edit users first address")
  @Description("Successfully edit users first address of an existing user account , userdata pulled from 'alreadyregistereduserdata.csv' file")
  @ParameterizedTest
  @CsvFileSource(resources = "/alreadyregistereduserdata.csv", numLinesToSkip = 1, encoding = "utf-8")
  public void logInSuccessfully(ArgumentsAccessor argumentsAccessor) {
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    YourAccountPage yourAccountPage = PageFactory.initElements(driver, YourAccountPage.class);
    AddressesPage addressesPage = PageFactory.initElements(driver, AddressesPage.class);
    AddressPage addressPage = PageFactory.initElements(driver, AddressPage.class);
    loginPage.open();
    loginPage.logIn(argumentsAccessor.getString(3),
        argumentsAccessor.getString(4));
    yourAccountPage.getAddressButton().click();
    addressesPage.getEditAddressButton().click();
    addressPage.editAddressField(argumentsAccessor.getString(15));
    Assertions.assertThat(addressesPage.getAddressSuccessfullyUpdatedMessage().getText()).isEqualTo("Address successfully updated!");
  }

}