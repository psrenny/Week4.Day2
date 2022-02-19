package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames4 {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		
		WebElement frm = driver.findElement(By.xpath("//iframe[@src='default.html']"));
		driver.switchTo().frame(frm);
		WebElement SCR = driver.findElement(By.xpath("//button[@id='Click']"));
		File fileName = SCR.getScreenshotAs(OutputType.FILE);
		File dest = new File("./src/main/resources/screenshots/Week4.Day2/Frames4/frame1.jpeg");
		FileUtils.copyFile(fileName, dest);
		driver.switchTo().defaultContent();
		
		//to find number of frames
		List<WebElement> count = driver.findElements(By.xpath("//iframe"));
		System.out.println("No of frames in this webpage is : "+count.size());
		
       	}
}
