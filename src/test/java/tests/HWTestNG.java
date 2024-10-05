package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.XYZBankCustomerPage;
import pages.XYZBankHomePage;
import pages.XYZBankManagerPage;
import utilities.Driver;

import static org.testng.Assert.assertEquals;

public class HWTestNG {
//    Open 5 new  Accounts, deposit 100 USD and withdraw 100 USD from any account and delete all accounts you created.
//    App:https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
//    Note: Use TestNG POM

 /*
Given
    Go to url https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
When
    Click on "Bank Manager Login" button
And
    Click on "Add Customer" button
And
    Fill inputs and click on "Add Customer" submit button
And
    Accept alert
And
    Add 4 more customers
And
    Click on "Open Account"  button
And
    Click on "Customer" dropdown
And
    Select customer name
And
    Click on "Currency" dropdown
And
    Select "Dollar"
And
    Click on "Process" button
And
    Accept alert
And
    Open 4 more accounts
And
    Click on "Customers" button
And
    Count table row numbers
Then
    Assert that you created 5 customers
When
    Click on "Home" button
And
    Click on "Customer Login" button
And
    Click on "Your Name" dropdown
And
    Select the any name you created
And
    Click on "Login" button
And
    Click on "Deposit" button
And
    Type 100 into "Amount to be Deposited" input
And
    Click on "Deposit"(Submit) button
Then
    Assert that "Deposit Successful" is displayed
And
    Click on "Withdrawal" button
And
    Type 100 into "Amount to be Withdrawn" input
And
    Click on "Withdraw"(Submit) button
Then
    Assert that "Transaction  Successful" is displayed
When
    Click on "Logout" button
And
    Click on "Home" button
And
    Click on "Bank Manager Login" button
And
    Click on "Customers" button
And
    Click on each "Delete" button
And
    Count table row numbers
Then
    Assert that number of customers is 0
 */

    @Test
    public void xyzBankTest() {

//        Go to url https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
        Driver.getDriver().get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

//        Click on "Bank Manager Login" button
        XYZBankHomePage xyzBankHomePage = new XYZBankHomePage();
        xyzBankHomePage.bankManagerLoginButton.click();

//        Click on "Add Customer" button
        XYZBankManagerPage xyzBankManagerPage = new XYZBankManagerPage();
        xyzBankManagerPage.addCustomerButton.click();

//        Fill inputs and click on "Add Customer" submit button
//        Add 4 more customers
        for (int i = 0; i < 5; i++) {
            xyzBankManagerPage.firstnameInput.sendKeys(Faker.instance().name().firstName());
            xyzBankManagerPage.lastnameInput.sendKeys(Faker.instance().name().lastName());
            xyzBankManagerPage.postCodeInput.sendKeys(Faker.instance().address().zipCode());
            xyzBankManagerPage.addCustomerSubmitButton.click();

//        Accept alert
            try {
                Driver.getDriver().switchTo().alert().accept();
            } catch (Exception _) {
            }
        }

//        Click on "Open Account"  button
        xyzBankManagerPage.openAccountButton.click();

//        Click on "Customer" dropdown
//        Select customer name
        for (int i = 0; i < 5; i++) {
            new Select(xyzBankManagerPage.customerDropDown).selectByIndex(i + 6);

//        Click on "Currency" dropdown
//        Select "Dollar"
            new Select(xyzBankManagerPage.currencyDropDown).selectByVisibleText("Dollar");

//        Click on "Process" button
            xyzBankManagerPage.processSubmitButton.click();

//        Accept alert
            try {
                Driver.getDriver().switchTo().alert().accept();
            } catch (Exception _) {
            }
        }


//        Click on "Customers" button
        xyzBankManagerPage.customersButton.click();
//        Count table row numbers
        int numOfRows = xyzBankManagerPage.numberOfRows.size();

//        Assert that you created 5 customers
        assertEquals(10, numOfRows);

//        Click on "Home" button
        xyzBankManagerPage.homeButton.click();

//        Click on "Customer Login" button
        xyzBankHomePage.customerLoginButton.click();

//        Click on "Your Name" dropdown
//        Select any name you created
        XYZBankCustomerPage xyzBankCustomerPage = new XYZBankCustomerPage();
        new Select(xyzBankCustomerPage.yourNameDropDown).selectByIndex(6);

//        Click on "Login" button
        xyzBankCustomerPage.loginButton.click();

//        Click on "Deposit" button
        xyzBankCustomerPage.depositButton.click();

//        Type 100 into "Amount to be Deposited" input
        xyzBankCustomerPage.amountToBeDepositedInput.sendKeys("100");

//        Click on "Deposit"(Submit) button
        xyzBankCustomerPage.depositSubmitButton.click();

//        Assert that "Deposit Successful" is displayed
        assert xyzBankCustomerPage.depositSuccessMessage.isDisplayed();

//        Click on "Withdrawal" button
        xyzBankCustomerPage.withdrawalButton.click();

//        Type 100 into "Amount to be Withdrawn" input
        xyzBankCustomerPage.withdrawSubmitButton.click();
        xyzBankCustomerPage.amountToBeWithdrawnInput.sendKeys("100");

//        Click on "Withdraw"(Submit) button
        xyzBankCustomerPage.withdrawSubmitButton.click();

//        Assert that "Transaction  Successful" is displayed
        assert xyzBankCustomerPage.transactionSuccessMessage.isDisplayed();

//        Click on "Logout" button
        xyzBankCustomerPage.logOutButton.click();

//        Click on "Home" button
        xyzBankManagerPage.homeButton.click();

//        Click on "Bank Manager Login" button
        xyzBankHomePage.bankManagerLoginButton.click();

//        Click on "Customers" button
        xyzBankManagerPage.customersButton.click();

//        Click on each "Delete" button
        xyzBankManagerPage.deleteButtons.forEach(WebElement::click);

//        Count table row numbers
//        Assert that number of customers is 0
        assert xyzBankManagerPage.deleteButtons.isEmpty();

        Driver.closeDriver();

    }

}
