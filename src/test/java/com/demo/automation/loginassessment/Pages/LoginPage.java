package com.demo.automation.loginassessment.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.automation.loginassessment.Utils.CommonMethods;
import com.demo.automation.loginassessment.Utils.MyLoginException;

public class LoginPage implements LoginPageLocators {
 private WebDriver driver;
 private CommonMethods commonMethods;
   public LoginPage(WebDriver driver){
        this.driver = driver;
        commonMethods=new CommonMethods();
    // PageFactory.initElements(driver, this);
}
   
   public void enterUsername(String usernameID) throws MyLoginException {
    commonMethods.verifyUsername(usernameID);
    driver.findElement(userNameInput).sendKeys(usernameID);
   }
   
   public void enterPassword(String pwd) throws MyLoginException{
    commonMethods.verifyPassword(pwd);
    driver.findElement(passwordInput).sendKeys(pwd);
   }
   
   public void clickLogin() {
    driver.findElement(loginButton).click();
    WebDriverWait wait = new WebDriverWait(driver,10);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='content']/h2[1]")));
   }
}

