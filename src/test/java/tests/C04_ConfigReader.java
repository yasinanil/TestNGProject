package tests;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_ConfigReader {

    @Test
    public void configReaderTest(){

        Driver.getDriver().get(ConfigReader.getProperty("url"));

        System.out.println(Driver.getDriver().getTitle());

        Driver.closeDriver();

    }

}
