package utilities;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MyTestListener implements ITestListener, IRetryAnalyzer, IAnnotationTransformer {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test started: " + context.getStartDate());
    }


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test method started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test finished successfully: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test finished: " + context.getEndDate());
        Driver.closeDriver();

        try {
            new ProcessBuilder().command("cmd.exe", "/c", "allure serve").start(); //Windows
            //new ProcessBuilder().command("bash", "-c", "allure serve").start(); //MAC
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // Automatically retries failed test cases.
    private int retryCount = 0;
    private static final int MAX_RETRY_COUNT = 3; // Maximum retry limit

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < MAX_RETRY_COUNT) {
            retryCount++;
            return true; // Retry the test case
        }
        return false; // No more retries
    }

    // Configures retry logic using TestNG XML.
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(MyTestListener.class); // Set the retry analyzer
    }

}
