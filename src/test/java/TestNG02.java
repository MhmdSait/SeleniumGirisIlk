import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// 19.Ders
public class TestNG02 {
    WebDriver driver;
    @BeforeTest
    public void testtenOncekiAdimlar() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void anaSayfaBaglanma(){
        driver.get("https://www.google.com");
    }
    @Test
    public void anaSayfaBaglanma2(){
        driver.get("https://translate.google.com/?hl=tr&tab=TT");
    }
    @AfterTest
    public void testSonrasiAdimlar(){
        driver.quit();
    }

}
