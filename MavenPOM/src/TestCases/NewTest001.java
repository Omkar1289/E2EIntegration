package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class NewTest001 {
  @Test
  public void verifyTitleGoogle() throws InterruptedException {
	  System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com/");
		Thread.sleep(2000); 
		
		
		String expTitle = "Google";
		String actTitle = driver.getTitle();
		System.out.println("expTitle "+expTitle);
		System.out.println("actTitle "+actTitle);
		if(expTitle.equals(actTitle))
		{
			System.out.println("Testcase pass");
		}
		else
		{
			System.out.println("Testcase fail");
		}
		driver.close();  

  }
}
