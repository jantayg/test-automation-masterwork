import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
  WebDriver driver;

  @BeforeAll
  public void setDriver() {
    WebDriverManager.chromedriver().setup();
  }

  @BeforeEach
  public void setup() {
    this.driver = new ChromeDriver();
  }

  @AfterEach
  public void tearDown() {
    driver.close();
  }
}
