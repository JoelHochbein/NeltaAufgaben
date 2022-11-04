package selenium;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
	
	@BeforeTest
	public void setUp() throws IOException {
		
		if(driver==null) {
			FileReader fr = new FileReader("C:\\\\Users\\\\hochb\\\\git\\\\NeltaAufgaben\\\\selenium\\\\src\\\\test\\\\resources\\\\testdata\\\\config.properties");
			prop.load(fr);
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL); //Pageload Strategy damit der nächste Befehl erst ausgeführt wird, wenn die Seite vollstäntig geladen wurde.
			driver.get(prop.getProperty("testurl"));
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			EdgeOptions options = new EdgeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver.get(prop.getProperty("testurl"));
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			FirefoxOptions options = new FirefoxOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver.get(prop.getProperty("testurl"));
		}
		
	}
	@AfterTest 
	public void tearDown() {
		
		driver.close();
		System.out.println("Test erfolgreich!");
	}
}
