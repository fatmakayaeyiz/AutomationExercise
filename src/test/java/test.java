import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class test {
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
        //1. tarayıcıyı başlat
//2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");
//3. Ana sayfanın başarıyla göründüğünü doğrulayın
      driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).isDisplayed();


//4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
//5. 'Hesabınıza giriş yapın'ın görünür olduğunu doğrulayın
        driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).isDisplayed();
//6. Doğru e-posta adresini ve şifreyi girin
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("fatakaya16@hotmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("12345");

//7. 'Giriş' düğmesini tıklayın
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
//8. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        driver.findElement(By.xpath("//*[@class='fa fa-user']")).isDisplayed();

//9. 'Çıkış' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

//10. Kullanıcının oturum açma sayfasına yönlendirildiğini doğrulayın
        driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).isDisplayed();
    }
    @After
    public void after () {
        driver.close();
    }
    }





