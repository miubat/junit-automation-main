import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Assignment {
    WebDriver driver;
    Faker faker;
    @BeforeAll
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        faker = new Faker();
    }

    @Test
    public void registration() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        WebElement acceptCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookies.click();

//      Selecting Elements
        WebElement name = driver.findElement(By.id("edit-name"));
        WebElement number = driver.findElement(By.id("edit-number"));
        WebElement selectAge = driver.findElements(By.className("ui-checkboxradio-label")).get(0);
        WebElement selectDate = driver.findElement(By.cssSelector("[type=date]"));
        WebElement email = driver.findElement(By.id("edit-email"));
        WebElement textArea = driver.findElement(By.cssSelector("textarea"));
        WebElement uploadFile = driver.findElement(By.cssSelector("[type=file]"));
        WebElement checkBox = driver.findElement(By.cssSelector("[type=checkbox]"));
        WebElement submitBtn = driver.findElement(By.id("edit-submit"));


//      Executing Element
        name.sendKeys(faker.name().fullName());
        number.sendKeys("01721391281");
        selectAge.click();
        Utils.scroll(driver,0,550);

//      Selecting current date
        selectDate.sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = currentDate.format(formatter);
        selectDate.sendKeys(formattedDate);
        selectDate.sendKeys(Keys.ENTER);

        email.sendKeys(faker.internet().emailAddress());
        textArea.sendKeys(faker.lorem().paragraph(3));
        uploadFile.sendKeys(System.getProperty("user.dir")+"/src/test/resources/images/errorRate.png");
//      Wait till file upload
        Thread.sleep(3000);
        checkBox.click();
        submitBtn.click();

        Thread.sleep(200000);
        driver.navigate().refresh();

        WebElement successMessage = driver.findElement(By.id("block-pagetitle-2"));
        assertEquals("Thank you for your submission!", successMessage.getText());

    }

    @AfterAll
    public void quitDriver(){
        driver.quit();
    }
}
