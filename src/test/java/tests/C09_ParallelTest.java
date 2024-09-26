package tests;

import org.testng.annotations.Test;
import pages.CLContactsPage;
import pages.CLHomePage;
import pages.FormPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C09_ParallelTest {

    @Test
    public void test01() {

        FormPage formPage = new FormPage();
        Driver.getDriver().get("https://testpages.eviltester.com/styled/basic-html-form-test.html");
        formPage.username.sendKeys("johndoe");
        formPage.password.sendKeys("1234");
        formPage.comments.clear();
        formPage.comments.sendKeys("Hello World");
        Driver.closeDriver();

    }

    @Test
    public void test02() {

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
    public void test03(){

        Driver.getDriver().get("https://talentifylab.com");
        System.out.println(Driver.getDriver().getTitle());
        Driver.getDriver().get("https://google.com");
        System.out.println(Driver.getDriver().getTitle());
        Driver.closeDriver();

    }

}
