package com.example.PageObjects;

import com.example.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class B_TrialsPage extends BaseClass {
    // old implementation is below and gave null pointer exception - here is new attempt

    public static WebDriver weBdriver;

    public B_TrialsPage(WebDriver ldriver) {
        this.weBdriver=ldriver;
        PageFactory.initElements(ldriver,this);
    }

    public void clickTrialsMenuOption(){
        WebElement element=weBdriver.findElement(By.id("trialSearchMenuOption"));
        element.click();
    }

    public void clickOnSubmitted(){
        WebElement element=weBdriver.findElement(By.cssSelector("tr:nth-child(5) > td:nth-child(2) .select2-search__field"));
        element.click();
    }

    public void clickOnSearch(){
        WebElement element=weBdriver.findElement(By.cssSelector(".search"));
        element.click();
    }

    public void clickOnNCIID(){
        WebElement element=weBdriver.findElement(By.cssSelector(".row>tbody>tr:nth-of-type(1)>td:nth-of-type(1)>a"));
        element.click();
    }

    public void clickOnTrialValidation(){
        WebElement element=weBdriver.findElement(By.linkText("Trial Validation"));
        element.click();
    }

    public void clickReject(){
        WebElement element=weBdriver.findElement(By.cssSelector(".cancel"));
        element.click();

    }

    public void typeTrialIsOutOfScope(){
        WebElement element=weBdriver.findElement(By.id("reasonCodes"));
        element.click();
        {
            WebElement dropdown=webDriver.findElement(By.id("reasonCodes"));
            dropdown.findElement(By.xpath("//option[. = 'Out of Scope']")).click();
        }
    }

    public void clickOnDone(){
        WebElement element=weBdriver.findElement(By.cssSelector(".save"));
        element.click();
    }

    public void assertStep(){
        assertThat(weBdriver.findElement(By.cssSelector(".float33:nth-child(4) > .row:nth-child(3) > .value")).getText(), is("Rejected"));

    }

    public void logout(){
        WebElement element=weBdriver.findElement(By.linkText("Logout"));
        element.click();
    }
}
