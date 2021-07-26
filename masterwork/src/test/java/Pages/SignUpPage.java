package Pages;

import org.jsoup.select.Evaluator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {
  WebDriver driver;

  public SignUpPage(WebDriver driver) {
    this.driver = driver;
  }

  public void open() {
    driver.get("http://test-automation-shop1.greenfox.academy/login?create_account=1");
  }

  @FindBy(xpath = "//*[@id='customer-form']/section/div[1]/div[1]/label[1]/span/input")
  private WebElement chooseMale;

  @FindBy(xpath = "//*[@id='customer-form']/section/div[1]/div[1]/label[2]/span/input")
  private WebElement chooseFemale;

  @FindBy(name = "firstname")
  private WebElement firstName;

  @FindBy(name = "lasttname")
  private WebElement lastName;

  @FindBy(name = "email")
  private WebElement email;

  @FindBy(name = "password")
  private WebElement password;

  @FindBy(name = "birthday")
  private WebElement birthday;

  @FindBy(name = "optin")
  private WebElement offersFromPartnersThick;

  @FindBy(name = "customer_privacy")
  private WebElement customerPrivacyThick;

  @FindBy(name = "newsletter")
  private WebElement newsletterThick;

  @FindBy(name = "psgdpr")
  private WebElement privacythick;

  @FindBy(xpath = "//*[@id=\"customer-form\"]/footer/button")
  private WebElement submitButton;

  public void signUp(String gender, String firstName, String lastName, String email,
                     String password, String birthday, boolean offersFromPartners,
                     boolean customerPrivacy, boolean newsletter, boolean privacy) {
    if (gender == "male") {
      this.chooseMale.click();
    } else {
      this.chooseFemale.click();
    }
    this.firstName.sendKeys(firstName);
    this.lastName.sendKeys(lastName);
    this.email.sendKeys(email);
    this.password.sendKeys(password);
    this.birthday.sendKeys(birthday);
    if (offersFromPartners == true) {
      this.offersFromPartnersThick.click();
    }
    if (customerPrivacy == true) {
      this.customerPrivacyThick.click();
    }
    if (newsletter == true) {
      this.newsletterThick.click();
    }
    if (privacy == true) {
      this.privacythick.click();
    }
    this.submitButton.click();


  }

}
