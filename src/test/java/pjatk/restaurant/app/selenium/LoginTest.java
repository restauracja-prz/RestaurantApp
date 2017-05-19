package pjatk.restaurant.app.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseSeleniumTest {

    @Test
    public void loginPageVisible() {
        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement submitButton = driver.findElement(By.name("submit"));

        Assert.assertTrue("Username input not found!", usernameInput.isDisplayed());
        Assert.assertTrue("Password input not found!", passwordInput.isDisplayed());
        Assert.assertTrue("Login button not found!", submitButton.isDisplayed());
        Assert.assertEquals("Login button not found!", "Login", submitButton.getAttribute("value"));
    }

    @Test
    public void login() {
        loginAs("dgmerek", "dgmerek");

        WebElement logoutButton = driver.findElement(By.id("logoutButton"));

        Assert.assertTrue("Logout button not visible!", logoutButton.isDisplayed());
    }

    @Test
    public void logout() {
        loginAs("dgmerek", "dgmerek");

        WebElement logoutButton = driver.findElement(By.id("logoutButton"));
        logoutButton.click();

        waitSeconds(3);

        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement submitButton = driver.findElement(By.name("submit"));

        Assert.assertTrue("Username input not found!", usernameInput.isDisplayed());
        Assert.assertTrue("Password input not found!", passwordInput.isDisplayed());
        Assert.assertTrue("Login button not found!", submitButton.isDisplayed());
        Assert.assertEquals("Login button not found!", "Login", submitButton.getAttribute("value"));
    }
}
