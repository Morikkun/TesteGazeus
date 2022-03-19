package br.com.projeto.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {
WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    //Using find by to map my elements
        @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div/a")
        WebElement signupBtn;
        @FindBy(how = How.ID, using = "emailIn")
        WebElement emailForm;
        @FindBy(how = How.ID, using = "password-field")
        WebElement passwordForm;
        @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div/h4")
        WebElement pageText;
        @FindBy(how = How.CSS, using = "#botao > input")
        WebElement createAccountBtn;
        @FindBy(how = How.CSS, using = "body > div.header > div > ul > li.header__nav-item.header__nav-item--profile > ul >" +
                " li.header__subnav-item.header__subnav-item--info > div.header__subnav-info-email")
        WebElement emailValidation;

    public void waitAndClickOnSignUp(){
        int timeout = 10;
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(signupBtn));
        signupBtn.click();
    }

    public void waitAndCheckEmailField(String emailField){
        int timeout = 10;
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(emailForm));
        String expectedElement = "emailIn";
        String actualElement = emailField;
        Assert.assertTrue(actualElement.contains(expectedElement));
    }

    public void waitAndCheckPassField(String passwordField){
        int timeout = 10;
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(passwordForm));
        String expectedElement = "password-field";
        String actualElement = passwordField;
        Assert.assertTrue(actualElement.contains(expectedElement));
        driver.quit();
    }

    public void waitAndCheckText(String textForChecking){
        int timeout = 10;
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(pageText));
        String expectedElement = "Crie sua conta e Jogue Grátis!";
        String actualElement = textForChecking;
        Assert.assertEquals(expectedElement, actualElement);
        driver.quit();
    }

    public void waitAndTypeEmail(){
        int timeout = 10;
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(emailForm));
        emailForm.sendKeys("emaildeteste@testemail.com");
    }

    public void waitAndTypePass(){
        int timeout = 10;
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(passwordForm));
        passwordForm.sendKeys("abc123def456");
    }

    public void waitAndClickCreateAccount() {
        int timeout = 10;
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(createAccountBtn));
        createAccountBtn.click();
    }

    public void waitAndCheckAccountCreation(){
        int timeout = 30;
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(emailValidation));
        System.out.println(emailValidation.getText());
        Assert.assertTrue(emailValidation.getText().contains("emaildeteste@testemail.com"));
        driver.quit();
    }

}
