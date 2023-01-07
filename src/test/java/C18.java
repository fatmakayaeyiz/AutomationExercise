import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C18 extends TestBase{
    @Test
    public void name() throws InterruptedException {
     //3. Kategorilerin sol taraftaki çubukta göründüğünü doğrulayın
        driver.findElement(By.xpath("//*[.='Category']")).isDisplayed();
        //4. 'Kadınlar' kategorisine tıklayın

        driver.findElement(By.xpath("(//*[@data-toggle='collapse'])[1]")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("(//*[@data-toggle='collapse'])[1]")).click();

        //5. "Kadınlar" kategorisi altındaki herhangi bir kategori bağlantısına tıklayın, örneğin: Elbise
      driver.findElement(By.xpath("(//a[text()='Tops '])[1]")).click();

        //6. Kategori sayfasının görüntülendiğini doğrulayın ve 'KADIN - TOPS ÜRÜNLERİ' metnini onaylayın
        WebElement verifyWd = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(verifyWd.isDisplayed());
        driver.navigate().refresh();

        //7. Sol taraftaki çubukta, 'Erkekler' kategorisinin herhangi bir alt kategori bağlantısına tıklayın
        driver.findElement(By.xpath("(//*[@class='fa fa-plus'])[2]")).click();
         driver.findElement(By.xpath("//*[text()='Tshirts ']")).click();
        //8. Kullanıcının o kategori sayfasına yönlendirildiğini doğrulayın
        driver.findElement(By.xpath("//*[.='Men - Tshirts Products']")).isDisplayed();
    }
}
