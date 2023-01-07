import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C14 extends TestBase {


    @Test
    public void name() {
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Add products to cart
//5. Click 'Cart' button
//6. Verify that cart page is displayed
//7. Click Proceed To Checkout
//8. Click 'Register / Login' button
//9. Fill all details in Signup and create account
//10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
//11. Verify ' Logged in as username' at top
//12.Click 'Cart' button
//13. Click 'Proceed To Checkout' button
//14. Verify Address Details and Review Your Order
//15. Enter description in comment text area and click 'Place Order'
//16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
//17. Click 'Pay and Confirm Order' button
//18. Verify success message 'Your order has been placed successfully!'
//19. Click 'Delete Account' button
//20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
//        4. Sepete ürün ekleyin
        driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[2]")).click();
//        5. 'Sepet' düğmesine tıklayın
        driver.findElement(By.xpath("//*[.='View Cart']")).click();
//        6. Sepet sayfasının görüntülendiğini doğrulayın
        driver.findElement(By.xpath("//*[@class='cart_description']")).isDisplayed();

//        7. Ödeme İşlemine Devam Et'i tıklayın
        driver.findElement(By.xpath("//*[.='Proceed To Checkout']")).click();
//        8. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()='Register / Login']")).click();

//        9. Kaydol'daki tüm ayrıntıları doldurun ve hesap oluşturun
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("Fatma",
                Keys.TAB, "ftmieaiaieckiayizt@hotmail.com", Keys.ENTER);
        driver.findElement(By.xpath("//*[@value='Mrs']")).click();
        driver.findElement(By.xpath("(//*[@class='form-control'])[1]"));

        driver.findElement(By.xpath("//*[@id='email']"));
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("12345", Keys.TAB, "17", Keys.TAB, "Month",
                Keys.TAB, "1989", Keys.TAB, Keys.SPACE, Keys.TAB, Keys.SPACE, Keys.TAB, "Fatma", Keys.TAB, "Kaya", Keys.TAB, "Techpro",
                Keys.TAB, "Turkiye", Keys.TAB, "Turk", Keys.TAB, "United States", Keys.TAB, "ıst", Keys.TAB, "Bursa", Keys.TAB, "15000",
                Keys.TAB, "0123854839284", Keys.ENTER);

//        10. 'HESAP OLUŞTURULDU!'nu doğrulayın! ve 'Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@class='col-sm-9 col-sm-offset-1']")).isDisplayed();
        driver.findElement(By.xpath("//*[@class='pull-right']")).click();

//        11. Üstte "Kullanıcı adı olarak oturum açıldı"yı doğrulayın
        driver.findElement(By.xpath("//*[@class='title text-center']")).isDisplayed();
        driver.navigate().refresh();

//        12.'Sepet' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-shopping-cart']")).click();
//        13. 'Ödeme İşlemine Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();
//        14. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
       driver.findElement(By.xpath("//*[text()='Address Details']")).isDisplayed();

        driver.findElement(By.id("product-1")).isDisplayed();
//        15. Açıklama metin alanına açıklamayı girin ve 'Sipariş Ver'i tıklayın
        driver.findElement(By.xpath("//*[@class='form-control']")).sendKeys("teşekkürler",
                Keys.TAB, Keys.ENTER);
//        16. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma Tarihi
        driver.findElement(By.xpath("//*[@name='name_on_card']")).sendKeys("fatma",
                Keys.TAB, "687354354135", Keys.TAB, "526", Keys.TAB, "23", Keys.TAB, "2023");

//        17. 'Öde ve Siparişi Onayla' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@id='submit']")).click();
//        18. Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'
        String basariliSiparis = driver.findElement(By.xpath("//*[.='Congratulations! Your order has been confirmed!']")).getText();
        Assert.assertEquals("Congratulations! Your order has been confirmed!", basariliSiparis);
//        19. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-trash-o']")).click();
//        20. 'HESAP SİLİNDİ!' ve 'Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed();
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();


    }
}

