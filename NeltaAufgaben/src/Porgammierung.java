import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Porgammierung {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\browserdriver\\chromedriver.exe"); //Versionen prüfen!
		//System.setProperty("webdriver.firefox.driver", "C:\\browserdriver\\firefoxdriver.exe"); <-- Firefox nutzen
		
		ChromeDriver driver = new ChromeDriver();
		//FirefoxDriver driver = new FirefoxDriver(); <-- Firefox nutzen
		
		
		driver.get("http://www.comdirect.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"privacy-init-wall-button-accept\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"llLink\"]/a/span")).click();
		driver.findElement(By.id("param1Input")).sendKeys("42218726");
		driver.findElement(By.id("param3Input")).sendKeys("421442");
		driver.findElement(By.xpath("//*[@id=\"loginAction\"]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"login_2fa-tanAbbruch\"]/span")).click();
		
		
	}

}
