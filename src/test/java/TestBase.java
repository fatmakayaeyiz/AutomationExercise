import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public abstract class TestBase {
    protected static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
        driver.findElement(By.cssSelector("i[class='fa fa-home']")).isDisplayed();
    }

    @After
    public void tearDown() {
          //driver.close();

    }

    public static void signUp() {
        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
//5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
        driver.findElement(By.xpath("//*[@class='signup-form']")).isDisplayed();
        //6. Adı ve e-posta adresini girin
//7. 'Kaydol' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("Fatma",
                Keys.TAB, "flztjtsiaimzllykekl@hotmail.com", Keys.ENTER);
        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin göründüğünü doğrulayın
        driver.findElement(By.xpath("//*[@class='login-form']")).isDisplayed();

        //9. Ayrıntıları doldurun: Unvan, Ad, E-posta, Parola, Doğum tarihi
//10. 'Bültenimize kaydolun!' onay kutusunu seçin.
//11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
//12. Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
//13. 'Hesap Oluştur düğmesini' tıklayın

        driver.findElement(By.xpath("//*[@value='Mrs']")).click();
        driver.findElement(By.xpath("(//*[@class='form-control'])[1]"));

        driver.findElement(By.xpath("//*[@id='email']"));
        driver.findElement(By.xpath("//*[@type='password']")).
                sendKeys("12345",
                        Keys.TAB, "17",
                        Keys.TAB, "Month",
                        Keys.TAB, "1989",
                        Keys.TAB,
                        Keys.SPACE,
                        Keys.TAB,
                        Keys.SPACE,
                        Keys.TAB, "Fatma",
                        Keys.TAB, "Kaya",
                        Keys.TAB, "Techpro",
                        Keys.TAB, "Turkiye",
                        Keys.TAB, "Turk",
                        Keys.TAB, "United States",
                        Keys.TAB, "ıst",
                        Keys.TAB, "Bursa",
                        Keys.TAB, "15000",
                        Keys.TAB, "0123854839284",
                        Keys.ENTER);
        //6. 'HESAP OLUŞTURULDU!'nu doğrulayın. ve 'Devam Et' düğmesini tıklayın
        WebElement signUpButton = driver.findElement(By.xpath("//*[@class='fa fa-lock']"));
        signUpButton.click();
        //7. Üstte "Kullanıcı adı olarak oturum açıldı"yı doğrulayın
        driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed();
    }
    public static void logIn(){


        driver.findElement(By.xpath("//*[@style='color: orange;']")).isDisplayed();
        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
        //5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
        driver.findElement(By.xpath("//*[@class='login-form']")).isDisplayed();
        //6. Doğru e-posta adresini ve şifreyi girin
        //7. 'Giriş' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("flztjtsituebbukeaimzllykekl@hotmail.com", Keys.TAB,"12345",Keys.ENTER);

    }
}
