import com.M10_FBPage_Locators.FaceBookPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static com.M10_FBPage_Locators.core.Constants.FACEBOOK_HOME_PAGE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FaceBookPageTests extends BaseTest{
//    String baseURL = Constants.FACEBOOK_HOME_PAGE_URL;
    private static WebDriver driver;
    FaceBookPage faceBookPage = new FaceBookPage(driver);
    @BeforeAll
    public static void classSetUp() {
        driver = getWebDriver();
        driver.get(FACEBOOK_HOME_PAGE_URL);
    }
    @AfterAll
    public static void classTearDown() {
        BaseTest.closeBrowser();
    }
    @Test
    public void homePageURLTest() {
        String actualURL = driver.getCurrentUrl();
        assertEquals(FACEBOOK_HOME_PAGE_URL, actualURL, "!!!URLs are not matching!!!");
    }
    @Test
    public void emailFieldTest() {
        WebElement emailElement = faceBookPage.emailField;
        assertNotNull(emailElement);
    }
    @Test
    public void passwordFieldTest() {
        WebElement passwordElement = faceBookPage.passwordField;
        assertNotNull(passwordElement);
    }
    @Test
    public void longTextEmailFieldTest() {
        WebElement emailElement = faceBookPage.emailField;
        assertNotNull(emailElement);

        List<String> charOptions = new ArrayList<String>();
        charOptions.add("a".repeat(50));
        charOptions.add("b".repeat(50));

        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 50; i++) {
            int randIndex = rand.nextInt(charOptions.size());
            sb.append(charOptions.get(randIndex));
        }
        String randomString = sb.toString();
        emailElement.sendKeys(randomString);
    }
    @Test
    public void longTextPasswordFieldTest() {
        WebElement passwordElement = faceBookPage.passwordField;
        assertNotNull(passwordElement);

        List<String> charOptions = new ArrayList<String>();
        charOptions.add("a".repeat(50));
        charOptions.add("b".repeat(50));
        charOptions.add("123".repeat(50));

        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 50; i++) {
            int randIndex = rand.nextInt(charOptions.size());
            sb.append(charOptions.get(randIndex));
        }
        String randomString = sb.toString();
        passwordElement.sendKeys(randomString);
    }
    @Test
    public void specialCharTest() {
        WebElement emailElement = faceBookPage.emailField;
        assertNotNull(emailElement);

        WebElement passwordElement = faceBookPage.passwordField;
        assertNotNull(passwordElement);

        List<String> charOptions = new ArrayList<String>();
        charOptions.add("$".repeat(50));
        charOptions.add("%".repeat(50));
        charOptions.add("&".repeat(50));
        charOptions.add(null);

        Random rand = new Random();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 50; i++) {
            int randIndex = rand.nextInt(charOptions.size());
            sb.append(charOptions.get(randIndex));
        }
        String randomString = sb.toString();
        emailElement.sendKeys(randomString);
        passwordElement.sendKeys(randomString);
    }
    @Test
    public void invalidInputTest() {
        WebElement emailElement = faceBookPage.emailField;
        assertNotNull(emailElement);

        List<String> invalidEmailOptions = new ArrayList<String>();
        invalidEmailOptions.add("");
        invalidEmailOptions.add("invalid-email");
        invalidEmailOptions.add(null);

        Random rand = new Random();
        int randIndex = rand.nextInt(invalidEmailOptions.size());
        String invalidEmail = invalidEmailOptions.get(randIndex);
        emailElement.sendKeys(invalidEmail);
    }
    @ParameterizedTest
    @MethodSource("invalidEmailProvider")
    public void invalidInputParamTest(String invalidEmail) {
        WebElement emailElement = faceBookPage.emailField;
        assertNotNull(emailElement);
        emailElement.sendKeys(invalidEmail);
    }
    static Stream<String> invalidEmailProvider() {
        return Stream.of("", "invalid-email");
    }
    @Test
    public void logInButtonTest() {
        WebElement logInButtonElement = faceBookPage.logInButtonField;
        assertNotNull(logInButtonElement);
    }
    @Test
    public void forgotAccountButtonTest() {
        WebElement forgotPassElement = faceBookPage.forgotPassField;
        assertNotNull(forgotPassElement);
    }
    //On Facebook main screen find XPath and create a method to press the Create New Account button
    @Test
    public void createNewAccountButtonTest() throws InterruptedException {
        WebElement createNewAccountElement = faceBookPage.createNewAccountField;
        assertNotNull(createNewAccountElement);
        createNewAccountElement.click();
        Thread.sleep(1000);
    }
    //Add JUnit tests for account creation page
    @Test
    public void jUnitForAccountCreationTest() {
        WebElement createNewAccountElement = faceBookPage.createNewAccountField;
        assertNotNull(createNewAccountElement);
        createNewAccountElement.click();
        //explicit wait:
        WebElement firstNameElement = faceBookPage.waitForFirstNameElementVisibility();
        assertNotNull(firstNameElement);

        firstNameElement = faceBookPage.firstNameField;
        assertNotNull(firstNameElement);

        firstNameElement.sendKeys("Megatron");
        String firstNameValue = firstNameElement.getAttribute("value");
        assertEquals("Megatron", firstNameValue);

        WebElement lastNameElement = faceBookPage.lastNameField;
        assertNotNull(lastNameElement);
        lastNameElement.sendKeys("Galaxy");
        String lastNameValue = lastNameElement.getAttribute("value");
        assertEquals("Galaxy", lastNameValue);

        WebElement newEmailElement = faceBookPage.newEmailField;
        assertNotNull(newEmailElement);
        newEmailElement.sendKeys("example@example.com");
        String newEmailValue = newEmailElement.getAttribute("value");
        assertEquals("example@example.com", newEmailValue);

        WebElement newPasswordElement = faceBookPage.newPasswordField;
        assertNotNull(newPasswordElement);
        newPasswordElement.sendKeys("qwerty1234");
        String newPasswordValue = newPasswordElement.getAttribute("value");
        assertEquals("qwerty1234", newPasswordValue);

        WebElement logInButtonElement2 = faceBookPage.logInButtonField2;
        assertNotNull(logInButtonElement2);
        logInButtonElement2.click();
    }
}
