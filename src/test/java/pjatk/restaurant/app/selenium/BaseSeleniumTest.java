//package pjatk.restaurant.app.selenium;
//
//import org.junit.After;
//import org.junit.Before;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import java.io.FileInputStream;
//import java.util.Properties;
//
//public abstract class BaseSeleniumTest {
//
//    private static final String WEBDRIVER_PROPERTY = "webdriver.gecko.driver";
//    private static final String RESTAURANT_APP_URL_PROPERTY = "restaurant.app.url";
//    private static final String PROPERTIES_FILE_PATH = "src/test/resources/selenium/config.properties";
//
//    protected WebDriver driver;
//
//    private String restaurantAppUrl;
//
//    @Before
//    public void beforeTest() throws Exception {
//        initializeProperties();
//
//        driver = new FirefoxDriver();
//
//        driver.get(this.restaurantAppUrl + "login");
//    }
//
//    @After
//    public void afterTest() {
//        driver.quit();
//    }
//
//    protected void waitSeconds(int seconds) {
//        try {
//            Thread.sleep(seconds * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    protected void loginAs(String user, String password) {
//        final WebElement usernameInput = driver.findElement(By.name("username"));
//        final WebElement passwordInput = driver.findElement(By.name("password"));
//        final WebElement submitButton = driver.findElement(By.name("submit"));
//
//        usernameInput.sendKeys(user);
//        passwordInput.sendKeys(password);
//        submitButton.click();
//
//        waitSeconds(3);
//    }
//
//    protected void logout() {
//        driver.findElement(By.id("logoutButton")).click();
//        waitSeconds(3);
//    }
//
//    private void initializeProperties() throws Exception {
//        Properties properties = loadProperties();
//
//        System.setProperty(WEBDRIVER_PROPERTY, properties.getProperty(WEBDRIVER_PROPERTY));
//        this.restaurantAppUrl = properties.getProperty(RESTAURANT_APP_URL_PROPERTY);
//    }
//
//    private Properties loadProperties() throws Exception {
//        Properties properties = new Properties();
//        properties.load(new FileInputStream(PROPERTIES_FILE_PATH));
//
//        return properties;
//    }
//}
