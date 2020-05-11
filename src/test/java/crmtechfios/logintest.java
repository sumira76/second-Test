package crmtechfios;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class logintest {
	WebDriver driver;
	
	@Test
	public void Login() {
		System.setProperty("webdriver.chrome.driver", "C:\\wp20\\w2020\\Mavenproject2\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("http://techfios.com/test/billing/?ng=login/");
		
		//using bucket of webelement
		WebElement USERNAME_ELEMENT=driver.findElement(By.name("username"));
		USERNAME_ELEMENT.clear();
		USERNAME_ELEMENT.sendKeys("techfiosdemo@gmail.com");
		
		
		driver.findElement(By.name("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		
				
		//store WebElement......oneway
		WebElement DASHBOARD_PAGE_TITLEelement=driver.findElement(By.xpath("//h2[contains(text(),'Dashboard ')]"));		
		//store element.......anotherway
		By element_LOCATOR=By.xpath("//h2[contains(text(),'Dashboard ')]");
		
		//by using Explicit Wait
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfAllElements(DASHBOARD_PAGE_TITLEelement));
		
		//Assertions condition
		
		String expectedTitle="Dashboard- TechFios Test Application - Billing";
		String actualTiltle=driver.getTitle();		
		Assert.assertEquals("Dashboard page did not display", expectedTitle, actualTiltle);
		
		
		
	}
}
