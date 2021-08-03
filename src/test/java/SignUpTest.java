import Pages.SignUpPage;
import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.PageFactory;


public class SignUpTest extends BaseTest {
  @DisplayName("Successful signup from csv file")
  @Description("Successful signup users from 'validuserdataforregistration.csv' file")
  @ParameterizedTest
  @CsvFileSource(resources = "validuserdataforregistration.csv", numLinesToSkip = 1, encoding = "utf-8")
  public void signUpSuccessfully(String gender, String firstName, String lastName, String email,
                                 String password, String birthday, boolean offersFromPartners,
                                 boolean customerPrivacy, boolean newsletter, boolean privacy)
      throws InterruptedException {
    SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
    signUpPage.open();
    signUpPage.signUp(gender, firstName, lastName, email, password, birthday, offersFromPartners,
        customerPrivacy, newsletter, privacy);
    Assertions.assertThat(driver.getTitle()).isEqualTo("PrestaShop");
  }

  @DisplayName("Unsuccessful signup with already registered emails")
  @Description("Signup users attempt with not valid, already registered emil addresses from 'alreadyregistereduserdata.csv' file, should receive error mesage: 'The email is already used, please choose another one or sign in'")
  @ParameterizedTest
  @CsvFileSource(resources = "../resources/alreadyregistereduserdata.csv", numLinesToSkip = 1, encoding = "utf-8")
  public void signUpUnSuccessfully(String gender, String firstName, String lastName, String email,
                                   String password, String birthday, boolean offersFromPartners,
                                   boolean customerPrivacy, boolean newsletter, boolean privacy)
      throws InterruptedException {
    SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
    signUpPage.open();
    signUpPage.signUp(gender, firstName, lastName, email, password, birthday, offersFromPartners,
        customerPrivacy, newsletter, privacy);
    Assertions.assertThat(signUpPage.getEmailErrorMesage().getText())
        .isEqualTo("The email is already used, please choose another one or sign in");
  }


}
