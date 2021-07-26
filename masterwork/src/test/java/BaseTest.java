import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
  WebDriver driver;

  @BeforeEach
  public void setup() throws IOException {
    Properties properties = new Properties();
    InputStream resourceAsSTream = this.getClass().getResourceAsStream(("/test.properties"));
    properties.load(resourceAsSTream);
    String browser = properties.getProperty("browser");
    if (browser.equals("chrome")) {
      WebDriverManager.chromedriver().setup();
      this.driver = new ChromeDriver();
    }
    else {
      WebDriverManager.firefoxdriver().setup();
      this.driver = new SafariDriver();
    }


  }

  @AfterEach
  public void tearDown() {
    driver.close();
  }
}
