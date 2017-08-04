//package pjatk.restaurant.app.selenium;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//public class UserManagementTest extends BaseSeleniumTest {
//
//    @Test
//    public void addUser() {
//        // login as dgmerek:
//        loginAs("dgmerek", "dgmerek");
//
//        // click on User Management link and wait:
//        driver.findElement(By.id("userManagementLink")).click();
//        waitSeconds(3);
//
//        // find user form elements:
//        WebElement userRealNameInput = driver.findElement(By.id("userRealNameInput"));
//        WebElement userIdInput = driver.findElement(By.id("userIdInput"));
//        WebElement passwordInput = driver.findElement(By.id("passwordInput"));
//        WebElement userPositionInput = driver.findElement(By.id("userPositionInput"));
//        WebElement submitUserButton = driver.findElement(By.id("submitUserButton"));
//
//        // generate unique userId:
//        String userId = "SeleniumId-" + System.currentTimeMillis();
//
//        // fill user form inputs:
//        userRealNameInput.sendKeys("SeleniumName");
//        userIdInput.sendKeys(userId);
//        passwordInput.sendKeys("SeleniumPassword");
//        userPositionInput.sendKeys("admin");
//
//        // click Submit button and wait:
//        submitUserButton.click();
//        waitSeconds(3);
//
//        // logout:
//        logout();
//
//        // login as created user:
//        loginAs(userId, "SeleniumPassword");
//
//        // verify that user is log in (Logout button should be visible):
//        WebElement logoutButton = driver.findElement(By.id("logoutButton"));
//        Assert.assertTrue("Logout button not visible!", logoutButton.isDisplayed());
//    }
//}
