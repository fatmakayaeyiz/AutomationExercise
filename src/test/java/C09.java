import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C09 extends TestBase{
    @Test
    public void name() {

//1. Launch browser
        //1. Tarayıcıyı başlatın

        //2. Navigate to url 'http://automationexercise.com'
        //2. 'http://automationexercise.com' URL'sine gidin

        //3. Verify that home page is visible successfully
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın

        WebElement logoElementi = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElementi.isDisplayed());  //logoElementinin gorunur oldugunu gosterecek
        //4. Click on 'Products' button
        //4. 'Ürünler' düğmesine tıklayın
        driver.findElement(By.xpath("//a[text()=' Products']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[text()=' Products']")).click();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        //5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
        String actuelTitle = driver.getTitle();
        Assert.assertTrue(actuelTitle.contains("All Products"));
        //6. Enter product name in search input and click search button
        //6. Arama girişine ürün adını girin ve ara düğmesine tıklayın
        driver.findElement(By.xpath("//*[@id='search_product']")).sendKeys("Blue Top", Keys.TAB, Keys.ENTER);
        //7. Verify 'SEARCHED PRODUCTS' is visible
        //7. "ARALAN ÜRÜNLER"in görünür olduğunu doğrulayın
        driver.findElement(By.xpath("//*[@class='title text-center']")).isDisplayed();
        //8. Verify all the products related to search are visible
        //8. Arama ile ilgili tüm ürünlerin görünür olduğunu doğrulayın
        List<WebElement> ilkUrun = driver.findElements(By.xpath("(//*[@class='product-overlay'])[1]"));
        for (WebElement w : ilkUrun) {
            Assert.assertTrue(w.isDisplayed());
            System.out.println(w.getText());
        }
        //9. Close driver

    }}

