package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesExample {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(); // Open a new chrome browser
        driver.manage().window().maximize(); // Maximize the opened chrome browser window
        driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver"); // Loads the URL in the opened browser
        
        driver.switchTo().frame("frame1");
        driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Testleaf");
        
        driver.switchTo().frame("frame3");
        driver.findElement(By.xpath("//input[@id='a']")).click();
        
        driver.switchTo().defaultContent();
        
        driver.switchTo().frame("frame2");
        
        WebElement findElement = driver.findElement(By.id("animals"));
        Select ani = new Select(findElement);
        ani.selectByVisibleText("Baby Cat");
        
        driver.switchTo().defaultContent();
	}

}
