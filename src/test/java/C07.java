import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class C07 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String actionalUrl = "https://automationexercise.com/";
        String exceptedUrl = driver.getCurrentUrl();
        Assert.assertEquals(actionalUrl, exceptedUrl);
        //4. 'Test Durumları' düğmesine tıklayın
        driver.findElement(By.xpath("(//*[.='Test Cases'])[1]")).click();
        driver.navigate().refresh();


        //5. Kullanıcının test senaryoları sayfasına başarıyla yönlendirildiğini doğrulayın
        String gorunenYazi = driver.findElement(By.xpath("//*[text()='Test Cases']")).getText();
        String gorunmesiGerekenYazi = "Test Cases";
        Assert.assertEquals(gorunmesiGerekenYazi, gorunenYazi);

    }
}