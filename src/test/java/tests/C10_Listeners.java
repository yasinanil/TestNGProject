package tests;

import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CLContactsPage;
import pages.CLHomePage;
import utilities.ConfigReader;
import utilities.Driver;

//@Listeners(utilities.MyTestListener.class)
public class C10_Listeners {

    @Test
    public void passedTest() {

        CLHomePage clHomePage = new CLHomePage();
        CLContactsPage clContactsPage = new CLContactsPage();
        Driver.getDriver().get(ConfigReader.getProperty("clHomePage"));
        clHomePage.username.sendKeys(ConfigReader.getProperty("username"));
        clHomePage.password.sendKeys(ConfigReader.getProperty("password"));
        clHomePage.submit.click();
        assert clContactsPage.logout.isDisplayed();
        Driver.closeDriver();

    }

    @Test
    public void failedTest() {

        CLHomePage clHomePage = new CLHomePage();
        CLContactsPage clContactsPage = new CLContactsPage();
        Driver.getDriver().get(ConfigReader.getProperty("clHomePage"));
        clHomePage.username.sendKeys("XYZ");
        clHomePage.password.sendKeys(ConfigReader.getProperty("password"));
        clHomePage.submit.click();
        assert clContactsPage.logout.isDisplayed();
        Driver.closeDriver();

    }

    @Test
    public void skippedTest() {

        throw new SkipException("Test Skipped!");

    }



}
