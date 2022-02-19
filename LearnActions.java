package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnActions {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		
		//Learn Drag and drop to offset
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/draggable");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		Actions builder = new Actions(driver);
		WebElement src = driver.findElement(By.id("draggable"));
        builder.dragAndDropBy(src, 100, 100).perform();
        driver.switchTo().defaultContent();
        driver.close();
        
        //Learn Drag and drop to target location
        ChromeDriver driver1 = new ChromeDriver();
        driver1.get("https://jqueryui.com/droppable/");
        driver1.manage().window().maximize();
		driver1.switchTo().frame(0);
		Actions builder1 = new Actions(driver1);
		WebElement src1 = driver1.findElement(By.id("draggable"));
		WebElement dest1 = driver1.findElement(By.id("droppable"));
        builder1.dragAndDrop(src1, dest1).perform();
        driver1.switchTo().defaultContent();
        driver1.close();
        
      //Learn Re-sizeable
        ChromeDriver driver2 = new ChromeDriver();
        driver2.get("https://jqueryui.com/resizable/");
        driver2.manage().window().maximize();
		driver2.switchTo().frame(0);
		Actions builder2 = new Actions(driver2);
		WebElement src2 = driver2.findElement(By.xpath("(//div[@id='resizable']//div)[3]"));
		builder2.clickAndHold(src2).moveByOffset(50, 50).release().build().perform();
		Thread.sleep(2000);
        driver2.switchTo().defaultContent();
        driver2.close();
        
      //Learn Selectable
        ChromeDriver driver3 = new ChromeDriver();
        driver3.get("https://jqueryui.com/selectable/");
        driver3.manage().window().maximize();
		driver3.switchTo().frame(0);
		Actions builder3 = new Actions(driver3);
		WebElement src3 = driver3.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement src31 = driver3.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement src32 = driver3.findElement(By.xpath("//li[text()='Item 5']"));
		builder3.keyDown(Keys.CONTROL).click(src3).click(src31).click(src32).keyUp(Keys.CONTROL).perform();
		driver3.switchTo().defaultContent();
        driver3.close(); 
        
		//Learn Sortable
        ChromeDriver driver4 = new ChromeDriver();
        driver4.get("https://jqueryui.com/sortable/");
        driver4.manage().window().maximize();
		driver4.switchTo().frame(0);
		Actions builder4 = new Actions(driver4);
		WebElement src4 = driver4.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement dest4 = driver4.findElement(By.xpath("//li[text()='Item 2']"));
        builder4.dragAndDropBy(src4, 11, 130).perform();
        builder4.dragAndDropBy(dest4, 11, 210).perform();
        //builder4.clickAndHold(src4).moveToElement(dest4).release().build().perform();
        Thread.sleep(2000);
        driver4.switchTo().defaultContent();
        driver4.close();
        
	}

}
