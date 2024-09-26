package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import pages.FormPage;
import utilities.Driver;

public class C08_DataProvider {

//    @DataProvider(name = "loginData")
//    public Object[][] createData() {
//        return new Object[][]{
//                {"user1", "pass1"},
//                {"user2", "pass2"},
//                {"user3", "pass3"}
//        };
//    }

    @Test(dataProvider = "loginData", dataProviderClass = utilities.DataProviderUtilities.class)
    public void parameterizedTest(String username, String password) {

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println();


    }

    @Test(dataProvider = "fakeData", dataProviderClass = utilities.DataProviderUtilities.class)
    public void parameterizedTest2(String username, String password, String comment) {

        FormPage formPage = new FormPage();
        Driver.getDriver().get("https://testpages.eviltester.com/styled/basic-html-form-test.html");
        formPage.username.sendKeys(username);
        formPage.password.sendKeys(password);
        formPage.comments.clear();
        formPage.comments.sendKeys(comment);
        Driver.closeDriver();

    }

    @Test(dataProvider = "excelData", dataProviderClass = utilities.DataProviderUtilities.class)
    public void parameterizedTest3(String username, String password, String comment) {

        FormPage formPage = new FormPage();
        Driver.getDriver().get("https://testpages.eviltester.com/styled/basic-html-form-test.html");
        formPage.username.sendKeys(username);
        formPage.password.sendKeys(password);
        formPage.comments.clear();
        formPage.comments.sendKeys(comment);
        Driver.closeDriver();

    }



}
