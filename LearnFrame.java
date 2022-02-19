package week4.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrame {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().window().maximize();
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Renny");
        alert.accept();
        String str1 = driver.findElement(By.xpath("//p[text()='Hello Renny! How are you today?']")).getText();
        System.out.println("Try it button clicked : "+str1);
        if(str1.contains("Renny"))
        {
        	System.out.println("Entered Name exists");
        }
        else
        {
        	System.out.println("Entered Name doesnt exists");
        }
        driver.switchTo().defaultContent();
	}

}
