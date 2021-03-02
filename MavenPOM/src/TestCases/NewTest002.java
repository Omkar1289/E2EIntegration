package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class NewTest002 {
  @Test
  public void addEmpORHM() throws InterruptedException {
	    System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
				
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
				
	
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin"); 
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//input[@class='button' and @name='Submit']")).click();
		Thread.sleep(2000);

		Boolean flag = driver.getPageSource().contains("Dashboard");
		if(flag)
		{
			System.out.println("Login successful");
		}
		else
		{
			System.out.println("Login failed");
		}
				
		driver.findElement(By.linkText("PIM")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Add Employee")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("firstName")).sendKeys("abc1");
		driver.findElement(By.id("lastName")).sendKeys("l");
		driver.findElement(By.id("chkLogin")).click();
		driver.findElement(By.id("user_name")).sendKeys("abc11111");
		driver.findElement(By.id("user_password")).sendKeys("abc11111");
		driver.findElement(By.id("re_password")).sendKeys("abc11111");
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(2000);
			
		
		int size = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/h1")).size();
		if(size>0)
		{
			System.out.println("Test case pass. Personal details element is present. Employee added successfully.");
			
			
			String actText = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div/h1")).getText();
			String expText = "abc1 l";
			if(actText.equals(expText))
			{
				System.out.println("Test case-2 pass. Employee name is correct.");
			}
			else
			{
				System.out.println("Test case-2 failed. Employee name is not correct.");
			}
			
		}
		else
		{
			System.out.println("Test case fail. Personal details element is NOT present. Employee has not been added successfully.");
		}
		
		Thread.sleep(1000);		
		
		
		driver.findElement(By.xpath("//*[@id='welcome']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		driver.close();

		
  }
}
