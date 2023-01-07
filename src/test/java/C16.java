import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class C16 extends TestBase{
    @Test
    public void name() {
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' URL'sine gidin
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        //4. 'Kaydol / Giriş Yap' düğmesini tıklayın
        //5. E-postayı, şifreyi doldurun ve 'Giriş' düğmesine tıklayın
        //6. En üstte 'Kullanıcı adı olarak oturum açıldı'yı doğrulayın
        signUp();
        //7. Sepete ürün ekleyin
        driver.findElement(By.xpath("(//*[text()='Add to cart'])[1]")).click();

        //8. 'Sepet' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();

        //9. Sepet sayfasının görüntülendiğini doğrulayın
        String url=driver.getCurrentUrl();
        Assert.assertEquals("https://automationexercise.com/view_cart",url);

        //10. Ödeme İşlemine Devam Et'i tıklayın
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();

        //11. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
        driver.findElement(By.xpath("//*[text()='Address Details']")).isDisplayed();
        driver.findElement(By.id("product-1")).isDisplayed();

        //12. Açıklama metin alanına açıklamayı girin ve 'Sipariş Ver'i tıklayın
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@class='form-control']")).sendKeys("teşekkürler",
                Keys.TAB, Keys.ENTER);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@class='form-control']")).sendKeys("teşekkürler",
                Keys.TAB, Keys.ENTER);

        //13. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma Tarihi
        driver.findElement(By.xpath("//*[@name='name_on_card']")).sendKeys("fatma",
                Keys.TAB, "687354354135", Keys.TAB, "526", Keys.TAB, "23", Keys.TAB, "2023");

        //14. 'Öde ve Siparişi Onayla' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@id='submit']")).click();

        //15. Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'
        String basariliSiparis = driver.findElement(By.xpath("//*[.='Congratulations! Your order has been confirmed!']")).getText();
        Assert.assertEquals("Congratulations! Your order has been confirmed!", basariliSiparis);

        //16. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-trash-o']")).click();

        //17. 'HESAP SİLİNDİ!' ve 'Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed();
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

    }
}
