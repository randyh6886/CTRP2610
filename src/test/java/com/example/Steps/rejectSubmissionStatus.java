package com.example.Steps;

import com.example.Base.BaseClass;
import com.example.PageObjects.A_LoginPage;
import com.example.PageObjects.B_TrialsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;//trying to set headless

import java.util.concurrent.TimeUnit;

public class rejectSubmissionStatus extends BaseClass {
    static WebDriver driver;

    @Before
    public void setup() throws Exception{
        System.setProperty("webdriver.chrome.driver","chromedriver 4");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }
    @Given("^Open Chrome and launch application$")
    public void open_chrome_and_launch_application() throws Throwable{
        System.setProperty("webdriver.chrome.driver","chromedriver 4");
        // trying to set headless
        ChromeOptions options=new ChromeOptions();
        options.addArguments("headless");
        driver=new ChromeDriver(options);
        driver.get("https://trials-int.nci.nih.gov/");
        Thread.sleep(3000);
    }

    @When("^I enter Username and password")
    public void i_enterusername_and_password() throws Throwable{
        A_LoginPage loginPage=new A_LoginPage(driver);
        Thread.sleep(3000);
        loginPage.setUserName();
        loginPage.setPassword();
    }

    @When("^the website opens$")
    public void the_website_opens() throws Throwable{
        A_LoginPage loginPage=new A_LoginPage(driver);
        loginPage.clickSigninSubmit();
        Thread.sleep(4000);
    }

    @When("^I click on Protocol Abstraction$")
    public void i_click_on_protocol_abstraction() throws Throwable
    {
        A_LoginPage loginPage=new A_LoginPage(driver);
        loginPage.clickProtocolAbstraction();
        loginPage.clickAccept();
        Thread.sleep(4500);
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        //webdriver.quit();
//        objTrialsPage=new B_TrialsPage(driver);
//        objTrialsPage.clickTrialsMenuOption();
    }

    @Given("^I click on trials menu option$")
    public void i_click_on_trials_menu_option() throws Throwable{
        B_TrialsPage trialsPage=new B_TrialsPage(driver);
        trialsPage.clickTrialsMenuOption();
    }

    @When("^I click on submitted$")
    public void i_click_on_submitted() throws Throwable{
        B_TrialsPage trialsPage=new B_TrialsPage(driver);
        trialsPage.clickOnSubmitted();
    }

    @Then("^I click on search$")
    public void i_click_on_search() throws Throwable{
        B_TrialsPage trialsPage=new B_TrialsPage(driver);
        trialsPage.clickOnSearch();
    }

    @Then("^I click on NCI ID$")
    public void i_click_on_nci_id() throws Throwable{
        B_TrialsPage trialsPage=new B_TrialsPage(driver);
        trialsPage.clickOnNCIID();
    }

    @Then("^I click on trial validation$")
    public void i_click_on_trial_validation() throws Throwable{
        B_TrialsPage trialsPage=new B_TrialsPage(driver);
        trialsPage.clickOnTrialValidation();
    }

    @Then("^I click on reject$")
    public void i_click_on_reject() throws Throwable{
        B_TrialsPage trialsPage=new B_TrialsPage(driver);
        trialsPage.clickReject();
    }

    @Then("^I type trial is out of scope into textarea$")
    public void i_type_trial_is_out_of_scope_into_textarea() throws Throwable{
        B_TrialsPage trialsPage=new B_TrialsPage(driver);
        trialsPage.typeTrialIsOutOfScope();
    }

    @Then("^I click on done$")
    public void i_click_on_done(){
        B_TrialsPage trialsPage=new B_TrialsPage(driver);
        trialsPage.clickOnDone();
    }

    @Then("^I assert processing status matches rejected$")
    public void i_assert_processing_status_matches_rejected() throws Throwable{
        B_TrialsPage trialsPage=new B_TrialsPage(driver);
        trialsPage.assertStep();
    }

    @Then("^I click on logout$")
    public void i_click_on_logout() throws Throwable{
        B_TrialsPage trialsPage=new B_TrialsPage(driver);
        trialsPage.logout();
    }
}
