package com.demo.automation.loginassessment.Pages;

import org.openqa.selenium.By;

public interface LoginPageLocators {

    By userNameInput = By.xpath("//input[@id='username-i']");

    By passwordInput = By.id("password-i");

    By loginButton = By.id("login-btn");
    
}