package tests;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.FormPage;
import utilities.Driver;

public class C07_Parameterizing {

    @Test
    @Parameters({"username","password"})
    public void parameterizedTest(String username, String password){

        System.out.println("Username: "+username);
        System.out.println("Password: "+password);


    }

    @Test
    @Parameters({"username","password"})
    public void parameterizedTest2(@Optional("JohnDoe") String username, @Optional("123") String password){

        FormPage formPage = new FormPage();
        Driver.getDriver().get("https://testpages.eviltester.com/styled/basic-html-form-test.html");
        formPage.username.sendKeys(username);
        formPage.password.sendKeys(password);
        Driver.closeDriver();

    }


}
