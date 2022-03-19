package br.com.projeto.steps;
import br.com.projeto.pages.HomePage;

import br.com.projeto.support.BrowserGetter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Steps {

    private final BrowserGetter browserGetter = new BrowserGetter();
    private WebDriver driver;
    HomePage homePage;

    //Interacting with a button
    @Given("I am at the Jogatina page")
    public void i_am_at_the_jogatina_page() {
        driver = browserGetter.getChromeDriver();
        driver.get("https://www.jogatina.com/");
    }

    @When("I click on the Sign up button")
    public void i_click_on_the_sign_up_button() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.waitAndClickOnSignUp();
    }

    @Then("the form for email should appear")
    public void the_form_for_email_should_appear() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.waitAndCheckEmailField("emailIn");
    }

    @Then("the form for password should appear")
    public void the_form_for_password_should_appear() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.waitAndCheckPassField("password-field");
    }

    //Creating a new account on the page
    @When("I type in my email")
    public void iTypeInMyEmail() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.waitAndTypeEmail();
    }
    @When("I type in my password")
    public void iTypeInMyPassword() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.waitAndTypePass();
    }

    @When("I click on the create account button")
    public void iClickOnTheCreateAccountButton() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.waitAndClickCreateAccount();
    }

    @Then("my account should be created")
    public void myAccountShouldBeCreated() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.waitAndCheckAccountCreation();
    }

    //Checking if a text is avaliable
    @Given("I want to check for a text on the Jogatina page")
    public void i_want_to_check_for_a_text_on_the_jogatina_page() {
        Assert.assertEquals(1, 1);
    }
    @When("I open the Jogatina page")
    public void i_open_the_jogatina_page() {
        driver = browserGetter.getChromeDriver();
        driver.get("https://www.jogatina.com/");
    }
    @Then("the text should be there")
    public void the_text_should_be_there() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.waitAndCheckText("Crie sua conta e Jogue Grátis!");
        //driver.quit();
    }
}
