import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_MevcutEmailKayit {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
   @Test
           public void test(){
       //1. Tarayıcıyı başlatın
       //2. 'http://automationexercise.com' URL'sine gidin
       driver.get("http://automationexercise.com");
       //3. Ana sayfanın başarıyla göründüğünü doğrulayın
       driver.findElement(By.cssSelector("i[class='fa fa-home']")).isDisplayed();
       //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
       driver.findElement(By.cssSelector("i[class='fa fa-lock']")).click();
       //5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
       driver.findElement(By.xpath("//*[@class='signup-form']")).isDisplayed();
       //6. Adı ve kayıtlı e-posta adresini girin
       //7. 'Kaydol' düğmesini tıklayın
       driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("Fatma", Keys.TAB,"fatmaae@hotmail.com",Keys.ENTER);
       //8. 'E-posta Adresi zaten mevcut!' hatasını doğrulayın. görünür
       driver.findElement(By.cssSelector("p[style='color: red;']")).isDisplayed();
   }



    @After
    public void tearDown() {
     driver.close();
    }
}
