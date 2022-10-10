package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeLoginTest {

    BrcPage brcPage;

    @Test
    public void yanlisSifre() {

       brcPage = new BrcPage();

        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //login butonuna tikla
        brcPage.ilkLoginButonu.click();

        //user email : customer@bluerentalcars.com
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));

        //password : 54321
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongEmail"));

        //ikinci login butonuna tiklayin
        brcPage.ikinciLoginButonu.click();

        //Degerleri girildiginde sayfaya baarili sekilde girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed()); //ikinci login butonu hala gorunuyorsa sayfaya giremedi

        Driver.closeDriver();

    }
    
    @Test
    public void yanlisKullanici() {

        brcPage = new BrcPage();

        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //login butonuna tikla
        brcPage.ilkLoginButonu.click();

        //user email : client@bluerentalcars.com
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcWrongEmail"));

        //password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));

        //ikinci login butonuna tiklayin
        brcPage.ikinciLoginButonu.click();

        //Degerleri girildiginde sayfaya baarili sekilde girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed()); //ikinci login butonu hala gorunuyorsa sayfaya giremedi

        Driver.closeDriver();
        
    }


    @Test
    public void yanlisSifreVeKullanici() {

        brcPage = new BrcPage();

        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //login butonuna tikla
        brcPage.ilkLoginButonu.click();

        //user email : client@bluerentalcars.com
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcWrongEmail"));

        //password : 54321
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));

        //ikinci login butonuna tiklayin
        brcPage.ikinciLoginButonu.click();

        //Degerleri girildiginde sayfaya baarili sekilde girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed()); //ikinci login butonu hala gorunuyorsa sayfaya giremedi

        Driver.closeDriver();
    }
}
