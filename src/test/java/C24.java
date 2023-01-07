import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C24 extends TestBase {
    @Test
    public void name() {
        //4. Sepete ürün ekleyin
        driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[2]")).click();

        //5. 'Sepet' düğmesine tıklayın
        driver.findElement(By.xpath("//*[.='View Cart']")).click();

        //6. Sepet sayfasının görüntülendiğini doğrulayın
        driver.findElement(By.xpath("//*[@class='cart_description']")).isDisplayed();

        //7. Ödeme İşlemine Devam Et'i tıklayın
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();

        //8. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()='Register / Login']")).click();
        //9. Kaydol'daki tüm ayrıntıları doldurun ve hesap oluşturun
        //10. 'HESAP OLUŞTURULDU!'nu doğrulayın! ve 'Devam Et' düğmesini tıklayın
        //11. Üstte "Kullanıcı adı olarak oturum açıldı"yı doğrulayın
        signUp();
        //12.'Sepet' düğmesine tıklayın
        driver.findElement(By.xpath("(//*[text()='Add to cart'])[1]")).click();

        driver.findElement(By.xpath("//*[text()='View Cart']")).click();

        //13. 'Ödeme İşlemine Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();

        //14. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
        driver.findElement(By.xpath("//*[text()='Address Details']")).isDisplayed();
        driver.findElement(By.id("product-1")).isDisplayed();
        //15. Açıklama metin alanına açıklamayı girin ve 'Sipariş Ver'i tıklayın
        driver.findElement(By.xpath("//*[@class='form-control']")).sendKeys("teşekkürler",
                Keys.TAB, Keys.ENTER);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@class='form-control']")).sendKeys("teşekkürler",
                Keys.TAB, Keys.ENTER);
        //16. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma Tarihi
        driver.findElement(By.xpath("//*[@name='name_on_card']")).sendKeys("fatma",
                Keys.TAB, "687354354135", Keys.TAB, "526", Keys.TAB, "23", Keys.TAB, "2023");
        //17. 'Öde ve Siparişi Onayla' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@id='submit']")).click();

        //18. Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'
        String basariliSiparis = driver.findElement(By.xpath("//*[.='Congratulations! Your order has been confirmed!']")).getText();
        Assert.assertEquals("Congratulations! Your order has been confirmed!", basariliSiparis);

        //19. 'Faturayı İndir' düğmesini tıklayın ve faturanın başarıyla indirildiğini doğrulayın.
        driver.findElement(By.xpath("//*[text()='Download Invoice']")).click();
        String filePath = System.getProperty("user.home") + "/Downloads/invoice (1).txt";
        boolean indirildimi = Files.exists(Paths.get(filePath));
        Assert.assertTrue(indirildimi);
        //20. 'Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()='Continue']")).click();
        //21. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();
        //22. 'HESAP SİLİNDİ!' ve 'Devam Et' düğmesini tıklayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed());
        driver.findElement(By.xpath("//*[text()='Continue']")).click();
    }
}
