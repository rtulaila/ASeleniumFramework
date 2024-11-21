package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseClass {

    @Test
    public void verifyRegistration() {
        driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
        
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys(generateRandomString());
        driver.findElement(By.id("LastName")).sendKeys(generateRandomString());
        driver.findElement(By.id("Email")).sendKeys(generateRandomEmail());
        
        String password = generateRandomPassword();
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
        driver.findElement(By.id("register-button")).click();
        
        String actualMessage = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]")).getText();
        Assert.assertEquals(actualMessage, "Your registration completed", "Registration success message does not match.");
    }

    private String generateRandomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    private String generateRandomEmail() {
        return generateRandomString() + RandomStringUtils.randomNumeric(4) + "@example.com";
    }

    private String generateRandomPassword() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
}
