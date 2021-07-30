import Pages.LoginPage;
import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.PageFactory;

public class LoginTest extends BaseTest {
  @DisplayName("Successful login test")
  @Description("Successful login test, userdata pulled from 'alreadyregistereduserdata.csv' file")
  @ParameterizedTest
  @CsvFileSource(resources = "../resources/alreadyregistereduserdata.csv", numLinesToSkip = 1, encoding = "utf-8")
  public void logInSuccessfully(ArgumentsAccessor argumentsAccessor) {
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    loginPage.open();
    loginPage.logIn(argumentsAccessor.getString(3), argumentsAccessor.getString(4));
    Assertions.assertThat(driver.getTitle()).isEqualTo("My account");
  }

  @DisplayName("Unsussessful login test")
  @Description("Unsuccessfull login test, userdata pulled from 'alreadyregistereduserdata.csv' file, an extra q character added to the passwords to make them invalid")
  @ParameterizedTest
  @CsvFileSource(resources = "../resources/alreadyregistereduserdata.csv", numLinesToSkip = 1, encoding = "utf-8")
  public void logInUnSuccessfully(ArgumentsAccessor argumentsAccessor) {
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    loginPage.open();
    loginPage.logIn(argumentsAccessor.getString(3), argumentsAccessor.getString(4) + "q");
    Assertions.assertThat(loginPage.getAuthenticationErrorMessage().getText())
        .isEqualTo("Authentication failed.");
  }

}
