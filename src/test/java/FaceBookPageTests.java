import com.M10_Assignment.FaceBookPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class FaceBookPageTests {

    private static final String FACEBOOK_HOME_PAGE_URL = "https://www.facebook.com/";
    private static WebDriver driver;

    @BeforeAll
    public static void classSetUp() {
        driver = FaceBookPage.getWebDriver();
        driver.get(FACEBOOK_HOME_PAGE_URL);
    }

    @AfterAll
    public static void classTearDown() {
        FaceBookPage.closeBrowser();
    }

    @Test
    public void homePageURLTest() {
        String actualURL = driver.getCurrentUrl();
        assertEquals(FACEBOOK_HOME_PAGE_URL, actualURL, "!!!URLs are not matching!!!");
    }

    //Find Xpathes for each text box component and Sign Up buttons
    @Test
    public void findByXpathEmailTest() {
        WebElement emailElement = driver.findElement(By.xpath("//input[@name='email']"));
        assertNotNull(emailElement);
    }

    @Test
    public void findByXpathPasswordTest() {
        WebElement passwordElement = driver.findElement(By.xpath("//input[@data-testid='royal_pass']"));
        assertNotNull(passwordElement);
    }

    @Test
    public void longTextEmailBoxTest() {

        WebElement emailElement = driver.findElement(By.xpath("//input[@name='email']"));
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
    public void longTextPasswordBoxTest() {

        WebElement passwordElement = driver.findElement(By.xpath("//input[@data-testid='royal_pass']"));
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

        WebElement emailElement = driver.findElement(By.xpath("//input[@name='email']"));
        assertNotNull(emailElement);

        WebElement passwordElement = driver.findElement(By.xpath("//input[@data-testid='royal_pass']"));
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

        WebElement emailElement = driver.findElement(By.xpath("//input[@name='email']"));
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
    public void invalidInputParamTest(String invalidEmail){
        WebElement emailElement = driver.findElement(By.xpath("//input[@name='email']"));
        assertNotNull(emailElement);
        emailElement.sendKeys(invalidEmail);
    }
    static Stream<String> invalidEmailProvider(){
        return Stream.of("","invalid-email");
    }

    @Test
    public void findByXpathLogInButtonTest() {
        WebElement logInButtonElement = driver.findElement(By.xpath("//button[@type='submit']"));
        assertNotNull(logInButtonElement);
    }

    @Test
    public void findByXpathForgotAccountButtonTest() {
        WebElement forgotPassElement = driver.findElement(By.xpath("//a[text()='Forgot password?']"));
        assertNotNull(forgotPassElement);
    }

    //On Facebook main screen find XPath and create a method to press the Create New Account button
    @Test
    public void createNewAccountButton_via_Star_SymbolTest() throws InterruptedException {
        WebElement createNewAccountElement = driver.findElement(By.xpath("//*[text()='Create new account']"));
        assertNotNull(createNewAccountElement);
        createNewAccountElement.click();
        Thread.sleep(1000);

    }

    //Add JUnit tests for account creation page
    @Test
    public void jUnitForAccountCreationTest()  {

        WebElement createNewAccountElement = driver.findElement(By.xpath("//*[text()='Create new account']"));
        assertNotNull(createNewAccountElement);
        createNewAccountElement.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement firstNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstname']")));
        assertNotNull(firstNameElement);

                firstNameElement = driver.findElement(By.xpath("//input[@name='firstname']"));
                assertNotNull(firstNameElement);
                firstNameElement.sendKeys("Megatron");
                String firstNameValue = firstNameElement.getAttribute("value");
                assertEquals("Megatron", firstNameValue);

                WebElement lastNameElement = driver.findElement(By.xpath("//input[@name='lastname']"));
                assertNotNull(lastNameElement);
                lastNameElement.sendKeys("Galaxy");
                String lastNameValue = lastNameElement.getAttribute("value");
                assertEquals("Galaxy", lastNameValue);


                WebElement newEmailElement = driver.findElement(By.xpath("//input[@name='reg_email__']"));
                assertNotNull(newEmailElement);
                newEmailElement.sendKeys("example@example.com");
                String newEmailValue = newEmailElement.getAttribute("value");
                assertEquals("example@example.com", newEmailValue);

                WebElement newPasswordElement = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
                assertNotNull(newPasswordElement);
                newPasswordElement.sendKeys("qwerty1234");
                String newPasswordValue = newPasswordElement.getAttribute("value");
                assertEquals("qwerty1234", newPasswordValue);

                WebElement logInButtonElement = driver.findElement(By.xpath("//button[@name='websubmit']"));
                assertNotNull(logInButtonElement);
                logInButtonElement.click();

            }
        }

