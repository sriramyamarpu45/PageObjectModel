package com.crm.qa.base;

import com.crm.qa.util.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties properties;
    public TestBase()  {
        properties = new Properties();
        try {
            FileInputStream FI = new FileInputStream("C:/Users/drn/IdeaProjects/PageObjectModel-CRM/src/main/java/com/crm/qa/config/config.properties");
            properties.load(FI);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            catch (IOException e)
            {
                e.printStackTrace();
        }

    }
    public static void initialization()
    {
       String browserName= properties.getProperty("browser");
       if (browserName.equals("chrome"))
       {
           System.setProperty("webdriver.http.factory","jdk-http-client");
           WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
       } else if (browserName.equals("Firefox")) {
           System.setProperty("webdriver.http.factory","jdk-http-client");
           WebDriverManager.firefoxdriver().setup();
           driver = new FirefoxDriver();
       }
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
       driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
       driver.get(properties.getProperty("url"));
    }
}
