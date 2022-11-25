import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v105.network.Network;
import org.openqa.selenium.devtools.v105.network.model.ConnectionType;

public class NetworkSpeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\grid\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		//log file ->
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		//Network.emulateNetworkConditions
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.emulateNetworkConditions(false, 3000, 20000, 100000, Optional.of(ConnectionType.ETHERNET)));
		devTools.addListener(Network.loadingFailed(), loadingFailed->
		{
			System.out.println(loadingFailed.getErrorText());
			System.out.println(loadingFailed.getTimestamp());			
		});
		long startTime = System.currentTimeMillis();
		// driver.get("https://www.google.com/");
		//driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
		//driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		//driver.findElement(By.cssSelector(".our-story-card-title")).getText();
		//System.out.println(driver.findElement(By.xpath("//div[@class='our-story-card-text']/h1")).getText());
		
	driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		driver.close();
	}
}
