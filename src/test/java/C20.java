import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C20 extends TestBase{
    @Test
    public void name() {
//        3. 'Ürünler' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Products']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[text()=' Products']")).click();

//4. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='All Products']")).isDisplayed());

//5. Arama girişine ürün adını girin ve ara düğmesine tıklayın
        driver.findElement(By.xpath("//*[@id='search_product']")).sendKeys("Jean", Keys.TAB,Keys.ENTER);
//6. "ARALAN ÜRÜNLER"in görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Searched Products']")).isDisplayed());
//7. Arama ile ilgili tüm ürünlerin görünür olduğunu doğrulayın
//        List<WebElement> tumUrunler=driver.findElements(By.xpath("//*[@class='features_items']"));
//        System.out.println(tumUrunler.stream().count());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='features_items']")).isDisplayed());

//8. Bu ürünleri sepete ekleyin
        driver.findElement(By.xpath("(//*[.='Add to cart'])[1]")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();
        driver.findElement(By.xpath("(//*[.='Add to cart'])[3]")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();
        driver.findElement(By.xpath("(//*[.='Add to cart'])[5]")).click();


//9. 'Sepet' düğmesine tıklayın ve ürünlerin sepette göründüğünü doğrulayın
        driver.findElement(By.xpath("(//*[.='View Cart'])[1]")).click();
Assert.assertTrue(driver.findElement(By.id("cart_info")).isDisplayed());
//10. 'Kaydol / Giriş Yap' düğmesini tıklayın ve giriş bilgilerini gönderin
        logIn();

//11. Tekrar Sepet sayfasına gidin
        driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[1]")).click();

//12. Giriş yaptıktan sonra bu ürünlerin de sepette göründüğünü doğrulayın.
        Assert.assertTrue(driver.findElement(By.id("cart_info")).isDisplayed());

    }
}
