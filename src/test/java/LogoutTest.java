import Pages.LoginPage;
import Pages.YourAccountPage;
import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.PageFactory;

public class LogoutTest extends BaseTest {

  @DisplayName("Successful logout test")
  @Description("Successful logout test, userdata for the login pulled from 'alreadyregistereduserdata.csv' file")
  @ParameterizedTest
  @CsvFileSource(resources = "/alreadyregistereduserdata.csv", numLinesToSkip = 1, encoding = "utf-8")
  public void logInSuccessfully(ArgumentsAccessor argumentsAccessor) {
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    YourAccountPage yourAccountPage = PageFactory.initElements(driver, YourAccountPage.class);
    loginPage.open();
    loginPage.logIn(argumentsAccessor.getString(3), argumentsAccessor.getString(4));
    yourAccountPage.logOut();
    Assertions.assertThat(driver.getTitle()).isEqualTo("Login");
  }
}
