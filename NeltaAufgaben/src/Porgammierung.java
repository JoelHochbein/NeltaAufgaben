import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Porgammierung {

	public static String browser = "chrome"; //Browser Auswahl (später in XLS oder CSV)
	public static WebDriver driver;

	
    
	public static void main(String[] args) {			    		
		
		if (browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browser.equals("edge"));
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.get("http://www.comdirect.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"privacy-init-wall-button-accept\"]")).click(); //Pop-Up Click
		driver.findElement(By.xpath("//*[@id=\"llLink\"]/a/span")).click(); // //Login Button Click
		driver.findElement(By.id("param1Input")).sendKeys("28018516"); //Kontonummer
		driver.findElement(By.id("param3Input")).sendKeys("437400"); //Passwort
		driver.findElement(By.xpath("//*[@id=\"loginAction\"]/span")).click(); //Login Button Click
		driver.findElement(By.xpath("//*[@id=\"login_2fa-tanAbbruch\"]/span")).click(); //Abbruch Button Click
		
	
	}

}
