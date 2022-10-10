package tests.day16_notations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_BeforeMethod_AfterMethod extends TestBase {

    /*
      BeforeMethod ve AfterMethod notasyonları
      JUnit'deki @Before ve @After gibidir.
      Her test method'undan once ve sonra calisirlar

      TestNG alfabetik siraya göre calısır. Asagıdaki testlerde önce amazon sonra techproedTest daha sonra test02 calısır.

      NOT : Method isimlerini kucuk harf ile yapın ki class isimleri ile karısmasın
     */


    @Test
    public void amazonTesti() {
        driver.get("https://www.amazon.com");

    }

    @Test
    public void test02(){
        driver.get("https://www.bestbuy.com");

    }

    @Test
    public void techproedTesti() {
        driver.get("https://www.techproeducation.com");


    }
}
