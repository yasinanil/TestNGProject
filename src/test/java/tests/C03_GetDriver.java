package tests;

import org.testng.annotations.Test;
import utilities.Driver;

public class C03_GetDriver {

    @Test
    public void getDriverTest(){

        Driver.getDriver().get("https://talentifylab.com");

        System.out.println(Driver.getDriver().getTitle());

        Driver.getDriver().get("https://google.com");

        System.out.println(Driver.getDriver().getTitle());

        Driver.closeDriver();


    }

}
