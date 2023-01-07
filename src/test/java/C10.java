import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class C10 extends TestBase {
    @Test
    public void name() {

//        1. Tarayıcıyı başlatın
//        2. 'http://automationexercise.com' URL'sine gidin

//        3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals("https://automationexercise.com/", actualUrl);

//        4. Altbilgiye doğru aşağı kaydırın

      driver.findElement(By.xpath("//*[@lang='en']")).sendKeys(Keys.ARROW_DOWN);

//        5. 'ABONELİK' metnini doğrulayın
        driver.findElement(By.xpath("//*[text()='Subscription']")).isDisplayed();

//        6. Giriş alanına e-posta adresini girin ve ok düğmesine tıklayın
        driver.findElement(By.id("susbscribe_email")).sendKeys("fatmakaya@hotmail.com",Keys.ENTER);
//        7. Başarı mesajını doğrulayın 'Başarılı bir şekilde abone oldunuz!' görünür
        driver.findElement(By.xpath("//*[@class='alert-success alert']")).isDisplayed();

    }
}
