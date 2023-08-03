import config.env_target;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CartTestCase extends env_target {
    @Test
    public void testCartWithLogin() {
        //set chrome driver location path
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        //maximize
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //set url
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("login2"))
        );
        driver.findElement(By.id("login2")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))
        );
        driver.findElement(By.id("loginusername")).sendKeys("cek12345@gmail.com");
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword"))
        );
        driver.findElement(By.id("loginpassword")).sendKeys("cek12345");
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Log out"))
        );//untuk bantuan
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Cart"))
        );
        driver.findElement(By.linkText("Cart")).click();
        driver.quit();
    }

    @Test
    public void TestCartWithoutLogin(){
        //set chrome driver location path
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        //maximize
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //set url
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Cart"))
        );
        driver.findElement(By.linkText("Cart")).click();
        driver.quit();
    }

    @Test
    public void TestAddToCartWithLogin(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("login2"))
        );
        driver.findElement(By.id("login2")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))
        );
        driver.findElement(By.id("loginusername")).sendKeys("cek12345@gmail.com");
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword"))
        );
        driver.findElement(By.id("loginpassword")).sendKeys("cek12345");
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Log out"))
        );//untuk bantuan
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Samsung galaxy s6"))
        );
        driver.findElement(By.linkText("Samsung galaxy s6")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart"))
        );
        driver.findElement(By.linkText("Add to cart")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.quit();
    }

    @Test
    public void TestAddToCartWithOutLogin(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Samsung galaxy s6"))
        );
        driver.findElement(By.linkText("Samsung galaxy s6")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart"))
        );
        driver.findElement(By.linkText("Add to cart")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.quit();
    }

    @Test
    public void TestAddMoreThanOneWithLogin(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("login2"))
        );
        driver.findElement(By.id("login2")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))
        );
        driver.findElement(By.id("loginusername")).sendKeys("cek12345@gmail.com");
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword"))
        );
        driver.findElement(By.id("loginpassword")).sendKeys("cek12345");
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Log out"))
        );//untuk bantuan
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Samsung galaxy s6"))
        );
        driver.findElement(By.linkText("Samsung galaxy s6")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart"))
        );
        driver.findElement(By.linkText("Add to cart")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert(); // switch to alert

        String alertMessage= driver.switchTo().alert().getText(); // capture alert message

        System.out.println(alertMessage); // Print Alert Message
        alert.accept();
        driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Nokia lumia 1520" ))
        );
        driver.findElement(By.linkText("Nokia lumia 1520")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart"))
        );
        driver.findElement(By.linkText("Add to cart")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alertMessage); // Print Alert Message
        alert.accept();
        driver.quit();
    }

    @Test
    public void TestAddMoreThanOneWithOutLogin(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Samsung galaxy s6"))
        );
        driver.findElement(By.linkText("Samsung galaxy s6")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart"))
        );
        driver.findElement(By.linkText("Add to cart")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert(); // switch to alert

        String alertMessage= driver.switchTo().alert().getText(); // capture alert message

        System.out.println(alertMessage); // Print Alert Message
        alert.accept();
        driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Nokia lumia 1520" ))
        );
        driver.findElement(By.linkText("Nokia lumia 1520")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart"))
        );
        driver.findElement(By.linkText("Add to cart")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alertMessage); // Print Alert Message
        alert.accept();
        driver.quit();
    }

    @Test
    public void TestDeleteOneWithLogin(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("login2"))
        );
        driver.findElement(By.id("login2")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))
        );
        driver.findElement(By.id("loginusername")).sendKeys("cek12345@gmail.com");
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword"))
        );
        driver.findElement(By.id("loginpassword")).sendKeys("cek12345");
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Log out"))
        );//untuk bantuan
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Samsung galaxy s6"))
        );
        driver.findElement(By.linkText("Samsung galaxy s6")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart"))
        );
        driver.findElement(By.linkText("Add to cart")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert(); // switch to alert

        String alertMessage= driver.switchTo().alert().getText(); // capture alert message

        System.out.println(alertMessage); // Print Alert Message
        alert.accept();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Cart"))
        );
        driver.findElement(By.linkText("Cart")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.linkText("Delete")).click();
    }

    @Test
    public void TestDeleteOneWithOutLogin(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Samsung galaxy s6"))
        );
        driver.findElement(By.linkText("Samsung galaxy s6")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart"))
        );
        driver.findElement(By.linkText("Add to cart")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert(); // switch to alert
        String alertMessage= driver.switchTo().alert().getText(); // capture alert message
        System.out.println(alertMessage); // Print Alert Message
        alert.accept();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Cart"))
        );
        driver.findElement(By.linkText("Cart")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.linkText("Delete")).click();
    }

    @Test
    public void TestDeleteMoreThanOneWithLogin(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("login2"))
        );
        driver.findElement(By.id("login2")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))
        );
        driver.findElement(By.id("loginusername")).sendKeys("cek12345@gmail.com");
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword"))
        );
        driver.findElement(By.id("loginpassword")).sendKeys("cek12345");
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Log out"))
        );//untuk bantuan
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Samsung galaxy s6"))
        );
        driver.findElement(By.linkText("Samsung galaxy s6")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart"))
        );
        driver.findElement(By.linkText("Add to cart")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert(); // switch to alert

        String alertMessage= driver.switchTo().alert().getText(); // capture alert message

        System.out.println(alertMessage); // Print Alert Message
        alert.accept();
        driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Nokia lumia 1520" ))
        );
        driver.findElement(By.linkText("Nokia lumia 1520")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart"))
        );
        driver.findElement(By.linkText("Add to cart")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alertMessage); // Print Alert Message
        alert.accept();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Cart"))
        );
        driver.findElement(By.linkText("Cart")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Delete")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Cart"))
        );
        driver.findElement(By.linkText("Cart")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Delete")).click();
        driver.quit();
    }

    @Test
    public void TestDeleteMoreThanOneWithOutLogin(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Samsung galaxy s6"))
        );
        driver.findElement(By.linkText("Samsung galaxy s6")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart"))
        );
        driver.findElement(By.linkText("Add to cart")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert(); // switch to alert

        String alertMessage= driver.switchTo().alert().getText(); // capture alert message

        System.out.println(alertMessage); // Print Alert Message
        alert.accept();
        driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Nokia lumia 1520" ))
        );
        driver.findElement(By.linkText("Nokia lumia 1520")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart"))
        );
        driver.findElement(By.linkText("Add to cart")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alertMessage); // Print Alert Message
        alert.accept();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Cart"))
        );
        driver.findElement(By.linkText("Cart")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Delete")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Cart"))
        );
        driver.findElement(By.linkText("Cart")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Delete")).click();
        driver.quit();
    }
}
