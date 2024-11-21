package testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @Test
    public void verifyLogin() {
        driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
        driver.findElement(By.id("Email")).sendKeys("ramdemotest@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Demo@teset3");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
    }
}
