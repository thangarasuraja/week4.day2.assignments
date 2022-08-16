package week4.day2assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ArchitectCertifications {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		//Launch the chrome browser


		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver=new ChromeDriver(options);



		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

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
		
		driver.findElement(By.xpath("//a[text()='Resources']")).click();
		
		Shadow dom=new Shadow(driver);
		
		dom.findElementByXPath("//span[contains(text(),'Learning')]").click();
		
		WebElement webElement = dom.findElementByXPath("//span[contains(text(),'Learning on Trailhead')]");
		
        webElement.click();
        
        dom.findElementByXPath("//a[contains(text(),'Salesforce Certification')]").click();
        
        driver.findElement(By.xpath("(//div[@class='roleMenu-item_text'])[2]")).click();
        
        WebElement webElement2 = driver.findElement(By.xpath("//div[@class='cert-site_text slds-text-align--center Lh(1.5) Fz(16px) slds-container--center slds-p-bottom--large']"));
        String text = webElement2.getText();
        
        System.out.println("Summary");
        System.out.println(text);
        
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
        
        System.out.println("List of Salesforce Architect Certifications Available");
        for (int i = 0; i < list.size(); i++) {
        	
			WebElement element = list.get(i);
			
			System.out.println("Cerification"+ (i+1)+ element.getText());
			
		}
        
        driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
        
        
        List<WebElement> list2 = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
        
        System.out.println("List of Certifications available in Application Architect");
        
        for (int i = 0; i < list2.size(); i++) {
        	
			WebElement element = list2.get(i);
			
			System.out.println("Cerification"+ (i+1)+ element.getText());
			
		}
        driver.quit();
	}

}
