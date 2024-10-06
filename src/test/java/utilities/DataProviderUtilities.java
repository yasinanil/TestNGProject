package utilities;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

public class DataProviderUtilities {

    @DataProvider(name = "loginData")
    public Object[][] createData() {
        return new Object[][]{
                {"user1", "pass1"},
                {"user2", "pass2"},
                {"user3", "pass3"}
        };
    }

    @DataProvider(name = "fakeData")
    public Object[][] createDataViaFaker() {
        Faker faker = new Faker();
        return new Object[][]{
                {faker.name().username(), faker.internet().password(), faker.lorem().paragraph()},
                {faker.name().username(), faker.internet().password(), faker.lorem().paragraph()},
                {faker.name().username(), faker.internet().password(), faker.lorem().paragraph()}

        };
    }

    @DataProvider(name = "excelData")
    public Object[][] getDataFromExcel() {

        ExcelUtilities excelUtilities = new ExcelUtilities("Users.xlsx", "UserData");

        return excelUtilities.getExcelDataAsArray();

    }

    @DataProvider(name = "excelDataEmployees")
    public Object[][] getDataFromExcelEmployees() {

        ExcelUtilities excelUtilities = new ExcelUtilities("Users.xlsx", "Employees");

        return excelUtilities.getExcelDataAsArray();

    }

}
