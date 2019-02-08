import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class segundoTest {


    @Test
    public void testGoogleSearch() throws InterruptedException {
        // Optional, if not specified, WebDriver will search your path for chromedriver.
//        System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
//
//
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://www.google.com/xhtml");
//        try {
//            Thread.sleep(5000);  // Let the user actually see something!
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        WebElement searchBox = driver.findElement(By.name("q"));
//        searchBox.sendKeys("ChromeDriver");
//        searchBox.submit();
//        Thread.sleep(5000);  // Let the user actually see something!
//        driver.quit();
    }
}
