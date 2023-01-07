import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C08 extends TestBase {

        @Test
        public void test01() throws InterruptedException {
//        2. 'http://automationexercise.com' URL'sine gidin

            //3. Ana sayfanın başarıyla göründüğünü doğrulayın
            String actionalUrl = "https://automationexercise.com/";
            String exceptedUrl = driver.getCurrentUrl();
            Assert.assertEquals(actionalUrl, exceptedUrl);
            //4. 'Ürünler' düğmesine tıklayın
            driver.findElement(By.xpath("//*[@class='material-icons card_travel']")).click();
            driver.navigate().refresh();
            driver.findElement(By.xpath("//*[@class='material-icons card_travel']")).click();
            String urunlerpdf = driver.getTitle();
            System.out.println("urunlerpdf = " + urunlerpdf);
            //.5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
            WebElement gorunenYaz = driver.findElement(By.xpath("//*[@class='title text-center']"));
            System.out.println("gorunenYaz.isDisplayed() = " + gorunenYaz.isDisplayed());
            //6. Ürün listesi görünür
            WebElement urunler = driver.findElement(By.xpath("//*[@class='material-icons card_travel']"));
            Assert.assertTrue(urunlerpdf.contains("Products"));
            //7. İlk ürünün 'Ürünü Görüntüle'ye tıklayın
            WebElement ilkUrun = driver.findElement(By.xpath("//*[@href='/product_details/1']"));
            ilkUrun.sendKeys(Keys.ENTER);
            //8. Kullanıcı ürün detay sayfasına yönlendirildi
            String urunDetay = driver.getCurrentUrl();
            String urunDetayBeklenen = "https://automationexercise.com/product_details/1";
            Assert.assertEquals(urunDetay, urunDetayBeklenen);
            //9. Ürün adı, kategorisi, fiyatı, bulunabilirliği, durumu, markası gibi ayrıntıların göründüğünü doğrulayın.
            driver.findElement(By.xpath("//*[@class='product-information']")).isDisplayed();   }

}
