import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C06 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //    3. Ana sayfanın başarıyla göründüğünü doğrulayın
        driver.findElement(By.xpath("//*[@alt='Website for automation practice']")).isDisplayed();

//4. 'Bize Ulaşın' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-envelope']")).click();
        driver.navigate().refresh();
//5. "İLETİŞİME GEÇİN" ifadesinin görünür olduğunu doğrulayın

        driver.findElement(By.xpath("//*[.='Get In Touch']")).isDisplayed();
//6. Adı, e-postayı, konuyu ve mesajı girin
        driver.findElement(By.xpath("(//*[@class='form-control'])[1]")).sendKeys("Fatma", Keys.TAB,
                "fatmakaya@hotmail.com", Keys.TAB, "autamation", Keys.TAB, "Test Case");
//7. Dosya yükleyin
        driver.findElement(By.xpath("//*[@name='upload_file']")).sendKeys("C:/Users/DELL/Desktop/seleniumtask.docx");
//8. 'Gönder' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@name='submit']")).sendKeys(Keys.ENTER);


//9. Tamam düğmesine tıklayın

        driver.switchTo().alert().accept();

//10. Başarı mesajını doğrulayın 'Başarı! Bilgileriniz başarıyla gönderildi.' görünür
        String actualResult = driver.findElement(By.xpath("(//*[text()='Success! Your details have been submitted successfully.'])[1]")).getText();
        System.out.println(actualResult);
        String expectedResult = "Success! Your details have been submitted successfully.";
        Assert.assertTrue(actualResult.contains(expectedResult));

//11. 'Ana Sayfa' düğmesine tıklayın ve ana sayfaya başarıyla geldiğini doğrulayın
        driver.findElement(By.xpath("//*[@class='logo pull-left']")).isDisplayed();
    }


}
