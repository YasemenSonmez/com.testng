package tests.day18_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigReaderKullanimi {


    @Test
    public void test01() {

        FacebookPage facebookPage = new FacebookPage();

        //facebook anasayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        //cookies cıkıyorsa kabul edin
        facebookPage.cookieButonu.click();

        //kullanıcı mail kutusuna rastgele bir isim yazdirin
        facebookPage.mailKutusu.sendKeys(ConfigReader.getProperty("fbWrongUsername"));

        //kullanıcı sifre kutusuna rastgele bir password yazdirin
        facebookPage.sifreKutusu.sendKeys(ConfigReader.getProperty("fbWrongPassword"));

        //login butonuna basin
        facebookPage.loginTusu.click();

        //giris yapilmadıgını test edin
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());

        //sayfayı kapatın
        Driver.closeDriver();






    }
}
