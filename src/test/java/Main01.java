import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main01 {                       //12. Ders
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box"); //14.Ders

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.click();
        fullName.sendKeys("qwerty");

        WebElement eMail = driver.findElement(By.cssSelector(".mr-sm-2[placeholder=\"name@example.com\"]"));
        eMail.click();
        eMail.sendKeys("asdf@gmail.com");

        WebElement currentAdress = driver.findElement(By.cssSelector(".form-control[placeholder=\"Current Address\"]"));
        currentAdress.click();
        currentAdress.sendKeys("Bursa");

        JavascriptExecutor jsx = (JavascriptExecutor) driver; //selenium sf. aş. kaydırma
        jsx.executeScript("window.scrollBy(0,350)", "");

        WebElement permanentAdress = driver.findElement(By.xpath("//textarea[@id=\"permanentAddress\"]"));
        permanentAdress.click();
        permanentAdress.sendKeys("Bursa,Türkiye");

        WebElement submitbutton = driver.findElement(By.id("submit"));
        submitbutton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

       driver.quit();

        /*

        //13.ders//Selenium WebDriver Komutları

        //Timeouts//
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //Sayfanın yüklenmesini bekler
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Sayfa üzerinde yapılan işlemi
                                                                             // bekler
        // Window
        driver.manage().window().maximize(); //pen. max. eder
        int X = driver.manage().window().getPosition().getX(); //Pencerenin X düzlemindeki konumunu verir.
        int Y = driver.manage().window().getPosition().getY(); //Pencerenin Y düzlemindeki konumunu verir.

        //Url
        driver.get("https:url"); //Sit. git. amaçlı
        String CurrentUrl = driver.getCurrentUrl(); // Sayfadaki erl'yi getirir.
        String Title = driver.getTitle(); // Sf. baş. get.
        String PageSource = driver.getPageSource(); // Sf'nin kaynak kodlarini getirir.

        */
    }

}
