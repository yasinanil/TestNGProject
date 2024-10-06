package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.WebTablePage;
import utilities.Driver;

import static org.testng.Assert.assertEquals;

public class Practice05 {

    /*
    Go to https://yasinanil67.github.io/addRecordWebTable
    Enter full name
    Enter age
    Select country
    Click on Add Record
    Assert the record is added
     */

    @Test(dataProvider = "excelDataEmployees", dataProviderClass = utilities.DataProviderUtilities.class)
    public void addRecordTest(Object name, Object age, Object country){

        WebTablePage webTablePage = new WebTablePage();

//        Go to https://yasinanil67.github.io/addRecordWebTable
        Driver.getDriver().get("https://yasinanil67.github.io/addRecordWebTable");

//        Enter full name
        //String name = Faker.instance().name().fullName();
        webTablePage.nameInput.sendKeys(name+"");

//        Enter age
        //String age = Faker.instance().number().numberBetween(18, 65)+"";

        String strAge = String.valueOf(age);
        strAge = strAge.substring(0, strAge.indexOf("."));

        webTablePage.ageInput.sendKeys(strAge);

//        Select country
        //int idx = Faker.instance().number().numberBetween(1,5);
        new Select(webTablePage.countrySelect).selectByVisibleText((String) country);

//        Click on Add Record
        webTablePage.addRecord.click();

//        Assert the record is added
        assertEquals(name, webTablePage.lastRowName.getText());

    }

}
