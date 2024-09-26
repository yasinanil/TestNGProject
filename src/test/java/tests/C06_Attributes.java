package tests;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C06_Attributes {

    @BeforeGroups(groups = "A")
    public void beforeGroup() {
        System.out.println("Before Group A");
    }

    @AfterGroups(groups = "A")
    public void afterGroup() {
        System.out.println("After Group A");
    }


    @Test(priority = 4)
    void test01() {
        System.out.println("Test 01");
    }

    @Test(priority = 3, groups = "A")
    void test02() {
        System.out.println("Test 02");
    }

    @Test(priority = 2, groups = "A")
    void test03() {
        System.out.println("Test 03");
    }

    @Test(priority = 1, dependsOnMethods = "test01")
    void test04() {
        System.out.println("Test 04");
    }

    @Test(enabled = false)
    void test05() {
        System.out.println("Test 05");
    }

    @Test(timeOut = 2000,  groups = "A")
    void test06() throws InterruptedException {
        Thread.sleep(1000);//ThreadTimeoutException
        System.out.println("Test 06");
    }

    @Test(invocationCount = 10, groups = "B")
    void test07() {
        System.out.println("Test 07");
        System.out.println("B");
    }

    @DataProvider(name = "data")
    public Object[][] provideData() {
        return new Object[][]{{"data1", "dataA"}, {"data2", "dataB"}, {"data3", "dataC"}};
    }

    @Test(dataProvider = "data")
    void test08(String arg1, String arg2) {
        System.out.println("Test 08");
        System.out.println(arg1+"-"+arg2);
        System.out.println();
    }

    @Test(expectedExceptions = {ArithmeticException.class}, groups = "C")
    void test09() {
        System.out.println("C");
        System.out.println("Test 09");
        int x = 1/0;
    }

    @Test(expectedExceptions = {NullPointerException.class}, groups = "D")
    void test10() {
        System.out.println("D");
        System.out.println("Test 10");
        String str = null;
        System.out.println(str.substring(0));
    }



}
