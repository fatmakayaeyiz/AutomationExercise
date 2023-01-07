import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v106.page.Page;
import org.openqa.selenium.interactions.Actions;

public class C22 extends TestBase{
    @Test
    public void name() throws InterruptedException {
//        3. Sayfanın en altına gidin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

//        4. 'ÖNERİLEN ÖĞELER'in görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='recommended items']")).isDisplayed());
//        5. Önerilen üründe 'Sepete Ekle'ye tıklayın
        driver.findElement(By.xpath("(//*[@data-product-id='4'])[3]")).click();
//        6. 'Sepeti Görüntüle' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();
//        7. Sepet sayfasında ürünün görüntülendiğini doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Stylish Dress']")).isDisplayed());
    }
}
