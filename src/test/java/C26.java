import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class C26 extends TestBase{
   @Test
    public void test(){
        //4. Sayfayı aşağıya doğru kaydırın
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        //5. 'ABONELİK'in görünür olduğunu doğrulayın
        driver.findElement(By.xpath("//*[text()='Subscription']")).isDisplayed();
        //6. Sayfayı yukarı kaydır
       driver.findElement(By.xpath("//*[@class='fa fa-angle-up']")).click();

       //7. Sayfanın yukarı kaydırıldığını ve
        // 'Otomasyon Mühendisleri için Tam Teşekküllü uygulama web sitesi' metninin ekranda göründüğünü doğrulayın
       Assert.assertTrue(driver.findElement(By.xpath("//*[@class='shop-menu pull-right']")).isDisplayed());
       driver.findElement(By.xpath("(//*[text()='Full-Fledged practice website for Automation Engineers'])[2]")).isDisplayed();

   }
}
