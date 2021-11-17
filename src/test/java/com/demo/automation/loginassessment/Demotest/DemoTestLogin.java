package com.demo.automation.loginassessment.Demotest;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

import com.demo.automation.loginassessment.Pages.LoginPage;
import com.demo.automation.loginassessment.Utils.MyLoginException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoTestLogin {
  WebDriver driver;
  LoginPage loginPage;

     @BeforeClass
     static void setupClass() {
         WebDriverManager.chromedriver().setup();
          
     }

     @BeforeMethod
     void setupTest(){
      
         driver = new ChromeDriver();
         
                  
     }

     @AfterMethod
     void teardown() {
         if (driver != null) {
            driver.quit();
         }
     }
    

     @Test()
     void test() throws MyLoginException {
      loginPage = new LoginPage(driver);
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://embark-demo.paylinksolutions.co.uk/login");
    //Enter valid user name & password in place of below string parameters
    loginPage.enterUsername("//enter valid email address");
    loginPage.enterPassword("//Enter valid Password");
    loginPage.clickLogin();
         
         
     }

 }
