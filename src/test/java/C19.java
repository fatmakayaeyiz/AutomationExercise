import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class C19 extends TestBase{
    @Test
    public void name() {
       //3. 'Ürünler' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Products']")).click();
        //4. Sol taraftaki çubukta Markaların göründüğünü doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Brands']")).isDisplayed());
        driver.navigate().refresh();
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Brands']")).isDisplayed());
        //5. Herhangi bir marka adına tıklayın
        driver.findElement(By.xpath("//*[text()='H&M']")).click();
        //6. Kullanıcının marka sayfasına yönlendirildiğini ve marka ürünlerinin görüntülendiğini doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Brand - H&M Products']")).isDisplayed());
        //7. Sol taraftaki çubukta herhangi bir başka marka bağlantısına tıklayın
        driver.findElement(By.xpath("//*[text()='Mast & Harbour']")).click();
        //8. Kullanıcının o marka sayfasına gittiğini ve ürünleri görebildiğini doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Brand - Mast & Harbour Products']")).isDisplayed());

    }
}
