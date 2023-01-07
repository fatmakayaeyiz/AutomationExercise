import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_KullaniciyiKaydet extends TestBase {
    @Test
    public void kullaniciyiKaydet() {
//        1. Tarayıcıyı başlatın

//2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");
//3. Ana sayfanın başarıyla göründüğünü doğrulayın
        driver.findElement(By.xpath("//*[@id='header']")).isDisplayed();

//4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

//5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
        driver.findElement(By.xpath("//*[@class='signup-form']")).isDisplayed();

//6. Adı ve e-posta adresini girin
//7. 'Kaydol' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("Fatma",
                Keys.TAB, "fatmaae@hotmail.com", Keys.ENTER);

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
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("12345", Keys.TAB, "17", Keys.TAB, "Month",
                Keys.TAB, "1989", Keys.TAB, Keys.SPACE, Keys.TAB, Keys.SPACE, Keys.TAB, "Fatma", Keys.TAB, "Kaya", Keys.TAB, "Techpro",
                Keys.TAB, "Turkiye", Keys.TAB, "Turk", Keys.TAB, "United States", Keys.TAB, "ıst", Keys.TAB, "Bursa", Keys.TAB, "15000",
                Keys.TAB, "0123854839284", Keys.ENTER);

//14. 'HESAP OLUŞTURULDU!' görünür
        driver.findElement(By.xpath("//*[@class='col-sm-9 col-sm-offset-1']")).isDisplayed();
//15. 'Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@class='pull-right']")).click();
//16. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın

        driver.findElement(By.xpath("//*[@class='title text-center']")).isDisplayed();
        driver.navigate().refresh();
//17. 'Hesabı Sil' düğmesini tıklayın
//        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
//        driver.findElement(By.xpath("//*[@class='fa fa-trash-o']")).click();
////18. 'HESAP SİLİNDİ!' görünür ve 'Devam Et' düğmesini tıklayın
//        driver.findElement(By.xpath("//*[@class='col-sm-9 col-sm-offset-1']")).isDisplayed();
//        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
//
 }
}
