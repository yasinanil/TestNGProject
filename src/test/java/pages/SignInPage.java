package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignInPage {

    public SignInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submit;

    public SignInPage enterUsername(String username) {
        this.username.sendKeys(username);
        return this;
    }

    public SignInPage enterPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public SignInPage clickSubmit() {
        this.submit.click();
        return this;
    }

}
