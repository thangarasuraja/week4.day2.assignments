package week4.day2assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CustomerServiceOptions {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		//Launch the chrome browser
		
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver=new ChromeDriver(options);
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Load the URL
		driver.get("https://login.salesforce.com");

		//Maximize the window
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		
		driver.findElement(By.id("password")).sendKeys("Password#123");
		
		driver.findElement(By.id("Login")).click();
		
		//click learn more option
		
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		
		//parent window
		
		String parentWindow = driver.getWindowHandle();
		
		
		//get child window1
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String>windowHandles1=new ArrayList<String>(windowHandles);
		
		String childWindow1 = windowHandles1.get(1);
		
		driver.switchTo().window(childWindow1);
		
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		//findElementByXPath(By.xpath("(//span[@class='nav-item-label--l1'])[2]"));
		
		Shadow dom=new Shadow(driver);
		
		 dom.findElementByXPath("//span[contains(text(),'Products')]").click();
		 
		 dom.findElementByXPath("//span[text()='Service']").click();
		 
		 dom.findElementByXPath("//a[text()='Customer Service']").click();
		 
		 List<WebElement> findElementsByXPath = dom.findElementsByXPath("//ul[@class='page-list page-list-level-2']");
		 
		//WebElement findElementByXPath = dom.findElementByXPath("//ul[@class='page-list page-list-level-2']/li[1]");
		   //System.out.println(findElementByXPath.getText());
		 
		 int size = findElementsByXPath.size();
	
		 for (int i = 0; i <size; i++) {
			 WebElement webElement = findElementsByXPath.get(i);
			 String text = webElement.getText();
			 System.out.println("Available services:");
			 System.out.println(text);
		}
		 
		 String title = driver.getTitle();
		 System.out.println("Page title is:"+title);
		 
		 driver.quit();
		 
		

		
		
		
		
		

	}

}
