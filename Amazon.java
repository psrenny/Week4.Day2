package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		String Price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		String Review = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
		System.out.println("No of customer reviews for 1st product is : "+Review);
		driver.findElement(By.xpath("(//span[@class='a-declarative']//i)[1]")).click();
		String Stars = driver.findElement(By.xpath("(//td//span[@class='a-size-base']//a)[2]")).getText();
		System.out.println("Percentage of 5 Stars is : "+Stars);
		driver.findElement(By.xpath("(//a[@target='_blank']//span)[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> Handle = new ArrayList<String>(windowHandles);
		String SecondWindow = Handle.get(1);
		driver.switchTo().window(SecondWindow);
		File fileName1 = driver.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("./src/main/resources/screenshots/Week4.Day2/Amazon/product.jpeg");
		FileUtils.copyFile(fileName1, dest1);
		WebElement cart = driver.findElement(By.id("add-to-cart-button"));
		WebDriverWait Wait = new WebDriverWait(driver,20);
		Wait.until(ExpectedConditions.elementToBeClickable(cart));
		cart.click();
		String SubTotal = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
		if(Price.contains(SubTotal))
		{
			System.out.println("Cart Subtotal is correct");
		}
		else
		{
			System.out.println("Cart Subtotal is incorrect");
		}
	}

}
