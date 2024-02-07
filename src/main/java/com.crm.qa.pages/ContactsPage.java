package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage extends TestBase {
    @FindBy(xpath = "//td[contains(text(),'Contacts')]")
    WebElement contactstext;
    @FindBy(id = "first_name")
    WebElement firstName;
    @FindBy(id = "surname")
    WebElement lastName;
    @FindBy(xpath = "//input[2][@type='submit' and @value='Save']")
    WebElement saveButton;

    public ContactsPage()
    {
        PageFactory.initElements(driver,this);
    }
    public boolean verifyContactsPageLabel()
    {
       return contactstext.isDisplayed();
    }
    public void selectContact(String name)
    {
        driver.findElement(By.xpath("//a[contains(text(),'test test')]" +
                "//parent::td[@class='datalistrow']//preceding-sibling::td")).click();
    }
    public void createNewContact(String title,String fname,String lname)
    {
        Select select = new Select(driver.findElement(By.name("title")));
        select.selectByVisibleText(title);
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        saveButton.click();
    }

}
