import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;

public class C13 extends TestBase {
    @Test
    public void name() throws InterruptedException, AWTException {
        //4. Ana sayfadaki herhangi bir ürün için 'Ürünü Görüntüle'ye tıklayın4
        driver.findElement(By.xpath("(//*[@class='fa fa-plus-square'])[1]")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("(//*[@class='fa fa-plus-square'])[1]")).click();
        //5. Ürün detayının açıldığını doğrulayın
        driver.findElement(By.xpath("//*[@class='product-information']")).isDisplayed();
        //6. Miktarı 4'e yükseltin
        //7. 'Sepete ekle' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@id='quantity']")).sendKeys(Keys.DELETE, "4", Keys.TAB, Keys.ENTER);
        //8. 'Sepeti Görüntüle' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();
        //9. Sepet sayfasında ürünün tam miktar ile görüntülendiğini doğrulayın.
        WebElement sepet = driver.findElement(By.xpath("//*[@class='disabled']"));
        Assert.assertEquals("4", sepet.getText());

    }
}
