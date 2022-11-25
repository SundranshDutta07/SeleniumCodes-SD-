import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class SetGeoLocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\grid\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("latitude", 40);
		param.put("longitude", 3);
		param.put("accuracy", 1);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride",param);
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		driver.findElement(By.cssSelector(".our-story-card-title")).getText();
		System.out.println(driver.findElement(By.xpath("//div[@class='our-story-card-text']/h1")).getText());
	}
}













