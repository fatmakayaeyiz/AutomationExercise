import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C12 extends TestBase{
    @Test
    public void name() {
        //4. 'Ürünler' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@class='material-icons card_travel']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@class='material-icons card_travel']")).click();
        //5. İlk ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın
        driver.findElement(By.xpath("(//*[@data-product-id='1'])[1]")).click();
        //6. 'Alışverişe Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//*[.='Continue Shopping']")).click();
        //7. İkinci ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın
        driver.findElement(By.xpath("(//*[@data-product-id='2'])[1]")).click();
        //8. 'Sepeti Görüntüle' düğmesini tıklayın
        driver.findElement(By.xpath("//u[.='View Cart']")).click();
        //9. Her iki ürünün de Sepete eklendiğini doğrulayın
        driver.findElement(By.xpath("//*[@id='product-1']")).isDisplayed();
        driver.findElement(By.xpath("//*[@id='product-2']")).isDisplayed();
        //10. Fiyatlarını, miktarlarını ve toplam fiyatlarını doğrulayın
        WebElement fiyatWomen=driver.findElement(By.xpath("(//*[text()='Rs. 500'])[1]"));
        Assert.assertEquals("Rs. 500",fiyatWomen.getText());
        WebElement adetWomen=driver.findElement(By.xpath("(//*[@class='disabled'])[1]"));
        Assert.assertEquals("1",adetWomen.getText());
        WebElement toplamFiyatWomen=driver.findElement(By.xpath("(//*[text()='Rs. 500'])[2]"));
        Assert.assertEquals("Rs. 500",toplamFiyatWomen.getText());

        WebElement fiyatMen=driver.findElement(By.xpath("(//*[text()='Rs. 400'])[1]"));
        Assert.assertEquals("Rs. 400",fiyatMen.getText());
        WebElement adetMen=driver.findElement(By.xpath("(//*[@class='disabled'])[2]"));
        Assert.assertEquals("1",adetMen.getText());
        WebElement toplamFiyatMen=driver.findElement(By.xpath("(//*[text()='Rs. 400'])[2]"));
        Assert.assertEquals("Rs. 400",toplamFiyatMen.getText());
    }
}
