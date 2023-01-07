import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class C23 extends TestBase{
    @Test
    public void name() {
        //4. 'Kaydol / Giriş Yap' düğmesini tıklayın

        //5. Kaydol'daki tüm ayrıntıları doldurun ve hesap oluşturun

        //6. 'HESAP OLUŞTURULDU!'nu doğrulayın. ve 'Devam Et' düğmesini tıklayın
        //7. Üstte "Kullanıcı adı olarak oturum açıldı"yı doğrulayın
        signUp();
        //8. Sepete ürün ekleyin
        driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[2]")).click();
       //9. 'Sepet' düğmesine tıklayın
        driver.findElement(By.xpath("//*[.='View Cart']")).click();

        //10. Sepet sayfasının görüntülendiğini doğrulayın
        driver.findElement(By.xpath("//*[@class='cart_description']")).isDisplayed();

        //11. Ödeme İşlemine Devam Et'i tıklayın
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();

        //12. Teslimat adresinin, hesap kaydı sırasında girilen adresle aynı olduğunu doğrulayın.

        List<String> delivery= Collections.singletonList(Arrays.toString(driver.findElement(By.xpath("//ul[@id='address_delivery']")).getText().split(" ")));
        System.out.println(delivery);
        //13. Fatura adresinin, hesap kaydı sırasında girilen adresle aynı olduğunu doğrulayın.
        List<String> billing= Collections.singletonList(Arrays.toString(driver.findElement(By.xpath("//ul[@id='address_invoice']")).getText().split(" ")));
        System.out.println(billing);

        //14. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();
        //15. 'HESAP SİLİNDİ!' ve 'Devam Et' düğmesini tıklayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed());
        driver.findElement(By.xpath("//*[text()='Continue']")).click();

    }
}
