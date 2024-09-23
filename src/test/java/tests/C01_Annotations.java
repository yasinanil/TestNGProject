package tests;

import org.testng.annotations.*;

public class C01_Annotations {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("@BeforeSuite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("@AfterSuite");
    }

    @BeforeMethod
    public void beforeEach() {
        System.out.println("@BeforeMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("@AfterMethod");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("@BeforeTest");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("@AfterTest");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("@BeforeClass");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("@AfterClass");
    }


    @Test
    void test01() {
        System.out.println("Test 01");
    }

    @Test
    void test02() {
        System.out.println("Test 02");
    }

    @Test
    void test03() {
        System.out.println("Test 03");
    }

    @Test
    void test04() {
        System.out.println("Test 04");
    }

}
