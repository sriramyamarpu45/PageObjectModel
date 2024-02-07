package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    TestUtil testUtil;
    public HomePageTest()
    {
        super();
    }
    @BeforeMethod
    public void setup()
    {
        initialization();
        loginPage = new LoginPage();
        testUtil = new TestUtil();
        homePage=loginPage.login(properties.getProperty("username"),properties.getProperty("password"));
    }
    @Test
    public void verifyHomepageTitle()
    {
        String homepagetitle = homePage.verifyHomepageTitle();
        Assert.assertEquals(homepagetitle,"CRMPRO","Home Page title is not matched");
    }
    @Test
    public  void verifyUsernameTest()
    {
        testUtil.switchToFrame();
        homePage.verifyUsername();
        Assert.assertTrue(homePage.verifyUsername());
    }
    @Test
    public  void clickContacts()
    {
        testUtil.switchToFrame();
        homePage.clickOnContacts();
    }
    @AfterTest
    public void teardown()
    {
        driver.quit();
    }
}

