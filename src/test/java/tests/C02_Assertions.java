package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class C02_Assertions {

    @Test
    public void hardAssertionTest(){

        assertEquals(4, 4);

        assertEquals("Hello", "Hello");

        System.out.println("This line will not be executed if assertions fail!");

    }

    @Test
    public void softAssertionTest(){

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(14, 4);

        softAssert.assertEquals("Hello", "Hello");

        System.out.println("This line will be executed even if assertions fail!");

        softAssert.assertAll();

        System.out.println("This line will not be executed if assertions fail!");
    }



}
