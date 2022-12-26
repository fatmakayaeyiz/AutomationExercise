import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_YanlisEmailSifre {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test() {
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        driver.findElement(By.cssSelector("i[class='fa fa-home']")).isDisplayed();

        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.cssSelector("i[class='fa fa-lock']")).click();

        //5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
        driver.findElement(By.cssSelector("div[class='login-form']")).isDisplayed();

        //6. Yanlış e-posta adresi ve şifre girin
        //7. 'Giriş' düğmesine tıklayın
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys("fatma@hotmail.com", Keys.TAB,"543124",Keys.ENTER);

        //8. 'E-postanız veya şifreniz yanlış!' hatasını doğrulayın. görünür
        driver.findElement(By.cssSelector("p[style='color: red;']")).isDisplayed();
    }

    @After
    public void tearDown() {

        driver.close();
    }
}