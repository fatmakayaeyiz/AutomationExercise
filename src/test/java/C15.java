import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class C15 extends TestBase{
    @Test
    public void test01() {
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' URL'sine gidin
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        //4. 'Kaydol / Giriş Yap' düğmesini tıklayın
        //5. Kaydol'daki tüm ayrıntıları doldurun ve hesap oluşturun
        //6. 'HESAP OLUŞTURULDU!'nu doğrulayın. ve 'Devam Et' düğmesini tıklayın
        //7. Üstte "Kullanıcı adı olarak oturum açıldı"yı doğrulayın
        signUp();












        //8. Sepete ürün ekleyin
        driver.findElement(By.xpath("(//*[text()='Add to cart'])[1]")).click();

        //9. 'Sepet' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();
        //10. Sepet sayfasının görüntülendiğini doğrulayın
        String url=driver.getCurrentUrl();
        Assert.assertEquals("https://automationexercise.com/view_cart",url);

        //11. Ödeme İşlemine Devam Et'i tıklayın
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();

        //12. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
        driver.findElement(By.xpath("//*[text()='Address Details']")).isDisplayed();
        driver.findElement(By.id("product-1")).isDisplayed();


        //13. Açıklama metin alanına açıklamayı girin ve 'Sipariş Ver'i tıklayın

        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@class='form-control']")).sendKeys("teşekkürler",
                Keys.TAB, Keys.ENTER);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@class='form-control']")).sendKeys("teşekkürler",
                Keys.TAB, Keys.ENTER);
        //14. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma Tarihi


        driver.findElement(By.xpath("//*[@name='name_on_card']")).sendKeys("fatma",
                Keys.TAB, "687354354135", Keys.TAB, "526", Keys.TAB, "23", Keys.TAB, "2023");

        //15. 'Öde ve Siparişi Onayla' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@id='submit']")).click();

        //16. Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'
        String basariliSiparis = driver.findElement(By.xpath("//*[.='Congratulations! Your order has been confirmed!']")).getText();
        Assert.assertEquals("Congratulations! Your order has been confirmed!", basariliSiparis);

        //17. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-trash-o']")).click();

        //18. 'HESAP SİLİNDİ!' ve 'Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed();
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

    }
}
