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

  @BeforeEach
  public void setup() {
    WebDriverManager.chromedriver().setup();
    this.driver = new ChromeDriver();
  }

  @AfterEach
  public void tearDown() {
    driver.close();
  }
}
