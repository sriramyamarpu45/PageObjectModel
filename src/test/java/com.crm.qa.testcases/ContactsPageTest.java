package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.*;

public class ContactsPageTest extends TestBase {
    ContactsPage contactsPage;
    HomePage homePage;
    TestUtil testUtil;
    LoginPage loginPage;
    String sheetname= "Contacts";
    public ContactsPageTest()
    {
        super();
    }
    @BeforeMethod
    public void setup()
    {
        initialization();
        contactsPage = new ContactsPage();
        homePage = new HomePage();
        testUtil = new TestUtil();
        loginPage = new LoginPage();
        homePage =  loginPage.login(properties.getProperty("username"),properties.getProperty("password"));
        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContacts();

    }
    @Test
    public void verifyContactsLabel()
    {
        Assert.assertTrue(contactsPage.verifyContactsPageLabel(),"Contact label is not visible");
    }
    @Test
    public void selectContact()
    {
        contactsPage.selectContact("test test");
    }

    @Test(dataProvider="getCRMdata")
    public void createNewContact(String title,String firstname,String lastname)
    {
        homePage.ClickOnNewContactLink();
       // contactsPage.createNewContact("Ms.","Test1","Test2");
        contactsPage.createNewContact(title,firstname,lastname);
    }
    @DataProvider
    public Object[][] getCRMdata()
    {
        Object[][] dataFromExcel = testUtil.getTestData(sheetname);
        return dataFromExcel;
    }
    @AfterMethod
    public void teatDown()
    {
        driver.quit();
    }



}
