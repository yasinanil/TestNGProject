package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class C11_AllureReport {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verifies that the login functionality works correctly with valid credentials.")
    public void testLoginFunctionality() throws Exception {
        System.out.println("CRITICAL Test");
        throw new Exception("Failed");
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Checks a non-critical feature that displays a help message.")
    public void testHelpMessageDisplay() {
        System.out.println("TRIVIAL Test");
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("Tests a minor functionality related to user settings.")
    public void testUserSettingsFunctionality() {
        System.out.println("MINOR Test");
    }

    @Test
    public void normalTest() {
        System.out.println("´Normal Test");
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verifies that the critical service is running before proceeding with further tests.")
    public void testCriticalServiceStatus() {
        System.out.println("BLOCKER Test");
        throw new SkipException("Skipped");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Tests the functionality of submitting a feedback form.")
    public void testFeedbackFormSubmission() {
        System.out.println("CRITICAL Test");
        assert false;
    }


}
