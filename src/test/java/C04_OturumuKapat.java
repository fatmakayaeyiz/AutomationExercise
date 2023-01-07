import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_OturumuKapat extends TestBase{
   @Test
    public void test() {
        //    1. Tarayıcıyı başlatın

//2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

//            3. Ana sayfanın başarıyla göründüğünü doğrulayın
        driver.findElement(By.xpath("//*[@style='color: orange;']")).isDisplayed();

//4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

//5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
        driver.findElement(By.xpath("//*[@class='login-form']")).isDisplayed();

//6. Doğru e-posta adresini ve şifreyi girin
//7. 'Giriş' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("fatmaae@hotmail.com", Keys.TAB,"12345",Keys.ENTER);

//8. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        driver.findElement(By.xpath("//*[@class='fa fa-user']")).isDisplayed();

//9. 'Çıkış' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

//10. Kullanıcının oturum açma sayfasına yönlendirildiğini doğrulayın
        WebElement oturumAcmaAnaSayfasi = driver.findElement(By.xpath("//*[@class='fa fa-lock']"));

        Assert.assertTrue(oturumAcmaAnaSayfasi.isDisplayed());
    }



}
