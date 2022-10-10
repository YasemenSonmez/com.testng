package tests.day16_notations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_Priority extends TestBase {

    /*
    TestNG test method'larini isim sirasina gore calistirir.
    eger isim siralamasinin disinda bir siralama ile calismasini isterseniz o zaman
    test metodlarine öncelik (priority) tanimlayabiliriz.

    priority kucukten buyuge göre calısır.
    eger bir test methoduna priority degeri atanmamıssa  default olarak priority = 0 olarak kabul edilir.

    asagidaki testlerde once techpro sonra test02 sonra amazon testi calısır. amazon icin priority = -5 deseydik önce
    amazon calısırdı.

    priority ne kadar kucukse once o calısır. priority yoksa default =0 kabul edilir ve alfabetik siraya göre calısır.
     */


    @Test (priority = 5)
    public void amazonTesti() {
        driver.get("https://www.amazon.com");
        System.out.println(driver.getCurrentUrl());

    }

    @Test
    public void test02() {
        driver.get("https://www.bestbuy.com");
        System.out.println(driver.getCurrentUrl());

    }

    @Test(groups = "grup1")
    public void techproedTesti() {
        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getCurrentUrl());
    }
}