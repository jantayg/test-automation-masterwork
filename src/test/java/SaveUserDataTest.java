import Pages.AddressPage;
import Pages.AddressesPage;
import Pages.LoginPage;
import Pages.YourAccountPage;
import io.qameta.allure.Description;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.PageFactory;

public class SaveUserDataTest extends BaseTest {
  @DisplayName("Saves users first address")
  @Description("Successfully saves users first address to a file named by username")
  @ParameterizedTest
  @CsvFileSource(resources = "/alreadyregistereduserdata.csv", numLinesToSkip = 1, encoding = "utf-8")
  public void saveUsersFirstAddressIntoFile(ArgumentsAccessor argumentsAccessor)
      throws IOException {
    String registeredAddress = "";
    registeredAddress += argumentsAccessor.getString(1) + " ";
    registeredAddress += argumentsAccessor.getString(2) + "\n";
    registeredAddress += argumentsAccessor.getString(15) + "\n";
    registeredAddress += argumentsAccessor.getString(11) + ", ";
    registeredAddress += argumentsAccessor.getString(12) + " ";
    registeredAddress += argumentsAccessor.getString(13) + "\n";
    registeredAddress += argumentsAccessor.getString(14);
    List<String> registeredAddressList = new ArrayList<>();
    registeredAddressList.add(registeredAddress);
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    loginPage.open();
    loginPage.logIn(argumentsAccessor.getString(3),
        argumentsAccessor.getString(4));

    YourAccountPage yourAccountPage = PageFactory.initElements(driver, YourAccountPage.class);
    yourAccountPage.getAddressButton().click();

    AddressesPage addressesPage = PageFactory.initElements(driver, AddressesPage.class);
    List<String> address = new ArrayList<>();
    address.add(addressesPage.getFirstAddress().getText());
    Path filePath = Paths.get("src/test/resources/address_" + argumentsAccessor.getString(1)
        + argumentsAccessor.getString(2) + ".txt");
    Files.write(filePath, address);
    Assertions.assertThat(address).isEqualTo(registeredAddressList);
  }
}
