import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C11 extends TestBase {
    @Test
    public void name() throws InterruptedException {
//        4. 'Sepet' düğmesine tıklayın
        WebElement card= driver.findElement(By.xpath("//*[@class='fa fa-shopping-cart']"));
        card.click();
//        5. Altbilgiye doğru aşağı kaydırın
        driver.findElement(By.xpath("//*[@lang='en']")).sendKeys(Keys.ARROW_DOWN);
//        6. 'ABONELİK' metnini doğrulayın
      String subscription=  driver.findElement(By.xpath("//*[.='Subscription']")).getText();
        Assert.assertTrue(subscription.contains("SUBSCRIPTION"));

//        7. Giriş alanına e-posta adresini girin ve ok düğmesine tıklayın
        driver.findElement(By.id("susbscribe_email")).sendKeys("fatmakaya@hotmail.com",Keys.ENTER);
//        8. Başarı mesajını doğrulayın 'Başarılı bir şekilde abone oldunuz!' görünür
        driver.findElement(By.xpath("//*[@class='alert-success alert']")).isDisplayed();

    }
}
