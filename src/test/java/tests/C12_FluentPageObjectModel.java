package tests;

import org.testng.annotations.Test;
import pages.SignInByPage;
import pages.SignInPage;
import utilities.Driver;

public class C12_FluentPageObjectModel {

    SignInPage signInPage;

    @Test
    public void test01() {

        Driver.getDriver().get("https://yasinanil67.github.io/signIn");
        signInPage = new SignInPage();
        signInPage.enterUsername("admin");
        signInPage.enterPassword("123");
        signInPage.clickSubmit();

    }

    @Test
    public void test02() {

        Driver.getDriver().get("https://yasinanil67.github.io/signIn");
        new SignInPage().enterUsername("admin").enterPassword("123").clickSubmit();

    }

    @Test
    public void test3() {

        Driver.getDriver().get("https://yasinanil67.github.io/signIn");
        new SignInByPage().enterUsername("admin").enterPassword("123").clickSubmit();

    }

}
