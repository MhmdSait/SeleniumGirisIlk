import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class Main02 { // 16.Ders Proje-1
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,300)", "");

        WebElement elements = driver.findElement(By.className("card-body"));
        elements.click();

        WebElement webTables = driver.findElement(By.xpath("//span[normalize-space()='Web Tables']"));
        webTables.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        addButton.click();

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.click();
        firstName.sendKeys("ilkKan");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.click();
        lastName.sendKeys("davasi");

        WebElement eMail = driver.findElement(By.cssSelector("#userEmail"));
        eMail.click();
        eMail.sendKeys("ilk@gmail.com");

        WebElement age = driver.findElement(By.id("age"));
        age.click();
        age.sendKeys("04");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement salary = driver.findElement(By.id("salary"));
        salary.click();
        salary.sendKeys("13000");

        WebElement department = driver.findElement(By.xpath("//input[@id='department']"));
        department.click();
        department.sendKeys("Software Test Specialist");

        WebElement submitButton = driver.findElement(By.cssSelector("#submit"));
        submitButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
