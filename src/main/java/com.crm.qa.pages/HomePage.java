package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
    @FindBy(xpath="//td[contains(text(),\'User: Sriramya Marpu \')]")
    WebElement usernameText;
    @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    WebElement contactsLink;
    @FindBy(xpath = "//a[contains(text(),'Deals')]")
    WebElement dealsLink;
    @FindBy(xpath = "//a[contains(text(),'New Contact')]")
    WebElement newContactLink;
    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }
    public String verifyHomepageTitle()
    {
        return driver.getTitle();
    }
    public ContactsPage clickOnContacts()
    {
        contactsLink.click();
        return new ContactsPage();
    }
    public boolean verifyUsername()
    {
        return usernameText.isDisplayed() ;
    }
    public void ClickOnNewContactLink()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(contactsLink).build().perform();
        newContactLink.click();
    }
}
