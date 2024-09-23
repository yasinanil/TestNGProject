package tests;

import org.testng.annotations.Test;
import pages.CLContactsPage;
import pages.CLHomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_PageFactory {

    @Test
    public void pageFactoryTest() {

        CLHomePage clHomePage = new CLHomePage();
        CLContactsPage clContactsPage = new CLContactsPage();

        Driver.getDriver().get(ConfigReader.getProperty("clHomePage"));

        clHomePage.username.sendKeys(ConfigReader.getProperty("username"));
        clHomePage.password.sendKeys(ConfigReader.getProperty("password"));
        clHomePage.submit.click();
        assert clContactsPage.logout.isDisplayed();

        Driver.closeDriver();


    }

}
