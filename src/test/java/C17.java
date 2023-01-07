import org.junit.Test;
import org.openqa.selenium.By;

public class C17 extends TestBase{
    @Test
    public void name() {
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' URL'sine gidin
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        //4. Sepete ürün ekleyin
        driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[2]")).click();

        //5. 'Sepet' düğmesine tıklayın
        driver.findElement(By.xpath("//*[.='View Cart']")).click();

        //6. Sepet sayfasının görüntülendiğini doğrulayın
        driver.findElement(By.xpath("//*[@class='cart_description']")).isDisplayed();

        //7. Belirli bir ürüne karşılık gelen 'X' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-times']")).click();
        //8. Ürünün sepetten çıkarıldığını doğrulayın
        driver.findElement(By.xpath("//*[.='Cart is empty!']")).isDisplayed();
    }
}
