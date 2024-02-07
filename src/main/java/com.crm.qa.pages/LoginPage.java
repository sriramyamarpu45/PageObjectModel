package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    //PageFactory
    @FindBy(name = "username")
    WebElement username;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginbtn;

    @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    WebElement signupbtn;

    //Initialize page objects
    public LoginPage()
    {
        PageFactory.initElements(driver,this);
    }

    public String validateLoginPageTitle()
    {
        return driver.getTitle();
    }
    public HomePage login(String uname, String pwd)
    {
        username.sendKeys(uname);
        password.sendKeys(pwd);
        loginbtn.click();
        return new HomePage();

    }
}
