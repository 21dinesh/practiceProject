package Generic;

import java.time.Duration;

import javax.lang.model.element.Element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility{

	public WebDriver launch(WebDriver driver,String url,long time,String browser) {
		
		switch(browser) {
		case "chrome": driver=new ChromeDriver();
		break;
		case "edge" : driver=new EdgeDriver();
		break;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		driver.manage().window().maximize();
		driver.get(url);
		return driver;		
		
	}
	
	public void moveToElement(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	
	
}
