import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class C21 extends TestBase{
    @Test
    public void name() {
//3. 'Ürünler' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Products']")).click();

        driver.findElement(By.xpath("//*[text()=' Products']")).click();

//4. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='All Products']")).isDisplayed());

//5. 'Ürünü Görüntüle' düğmesine tıklayın
        driver.findElement(By.xpath("(//*[text()='View Product'])[1]")).click();
//6. "İncelemenizi Yazın"ın görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Write Your Review']")).isDisplayed());

//7. Adı, e-postayı girin ve gözden geçirin
        //8. 'Gönder' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@placeholder='Your Name']")).sendKeys("Fatma", Keys.TAB,
                "flztjtsituebbukeaimzllykekl@hotmail.com",Keys.TAB,"Merhaba",Keys.TAB,Keys.ENTER);


//9. Başarı mesajını doğrulayın 'İncelemeniz için teşekkür ederiz.'
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Thank you for your review.']")).isDisplayed());

    }
}
