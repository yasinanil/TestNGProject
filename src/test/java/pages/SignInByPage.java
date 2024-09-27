package pages;

import org.openqa.selenium.By;
import utilities.Driver;

public class SignInByPage {

    private By username = By.id("username");
    private By password = By.id("password");
    private By submit = By.xpath("//input[@type='submit']");

    public SignInByPage enterUsername(String username) {
        Driver.getDriver().findElement(this.username).sendKeys(username);
        return this;
    }

    public SignInByPage enterPassword(String password) {
        Driver.getDriver().findElement(this.password).sendKeys(password);
        return this;
    }

    public SignInByPage clickSubmit() {
        Driver.getDriver().findElement(this.submit).click();
        return this;
    }

}
