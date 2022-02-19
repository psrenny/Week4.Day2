package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(); // Open a new chrome browser
        driver.manage().window().maximize(); // Maximize the opened chrome browser window
        driver.get("http://leaftaps.com/opentaps/control/login"); // Loads the URL in the opened browser
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handle = new ArrayList<String>(windowHandles);
		String SecWindow = handle.get(1);
		driver.switchTo().window(SecWindow);
		driver.findElement(By.xpath("(//td//div//a[@class='linktext'])[3]")).click();
		driver.switchTo().window(handle.get(0));
		
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> handle1 = new ArrayList<String>(windowHandles1);
		String SecWindow1 = handle1.get(1);
		driver.switchTo().window(SecWindow1);
		driver.findElement(By.xpath("(//td//div//a[@class='linktext'])[8]")).click();
		driver.switchTo().window(handle1.get(0));
		
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		String title = driver.getTitle();
		
		if(title.equals("View Contact | opentaps CRM"))
		{
			
			System.out.println("Merged successfully");
		}
		else
		{
			System.out.println("Not merged");
		}
		

	}

}
