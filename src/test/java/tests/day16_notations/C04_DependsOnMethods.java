package tests.day16_notations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C04_DependsOnMethods {

    /*
    DependOnMethods test methodlarının calısma sırasına karısmaz.
    Sadece bagli olan test, baglandıgı testin sonucuna göre calısır. baglandıgı test passed ise kendisi de calısır.
    fail ise kendisi de calısmaz. böylelikle süreden kazanmıs oluruz.
     */

     WebDriver driver;

    @BeforeClass
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public void tearDown(){

        driver.close();
    }

    @Test
    public void test01() {
        // AMAZON ANASAYFAYA GIDELIM
        driver.get("https://www.amazon.com");

    }
    @Test (dependsOnMethods = "test01")  // testimizin çalismasinin hangi method a bagli oldugunu gösteriyor
    public void test02() {
         // Nutella aratalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

    }
    @Test (dependsOnMethods = "test02")
    public void test03() {
        // Sonuc yazisinin Nutella içerdeiğini test edelim
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYaziElementi.getText().contains("Nutella"));

    }
    @Test(groups = {"grup1","grup2"})
    public void test04() {
        System.out.println("bak bu calisti");
    }




}
