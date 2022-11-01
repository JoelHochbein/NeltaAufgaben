package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Programm1 {
	
	
	public static String browser = "edge"; //Browser Auswahl (später in XLS oder CSV)
	
	public static WebDriver driver;
	@Test
	public static void main(String[] args) {
		
		
		
		if (browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			EdgeOptions options = new EdgeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		}
		else if (browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			FirefoxOptions options = new FirefoxOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		}
		else if (browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		}
		
		
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		
		
		
		WebElement hover = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a")); // Maus Hover über "Computers"
		Actions action = new Actions(driver);
		action.moveToElement(hover).perform();
		
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[6]/div/div[1]/a/img")).click();
		driver.findElement(By.id("product_attribute_75_6_32_99")).click();
		
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException e) {                             //Kunde entscheidet sich statt den 8GB für 4GB
		    System.out.println("got interrupted!");
		}
		
		
		driver.findElement(By.id("product_attribute_75_5_31_96")).click(); // Prozessor Auswahl
		driver.findElement(By.id("add-to-cart-button-75")).click(); //ADD TO CART
		
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException e) {                             //Timer, weil lädt
		    System.out.println("got interrupted!");
		}
		
		driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]")).click(); //Warenkorb
		
		WebElement ddown = driver.findElement(By.id("CountryId"));
		Select select = new Select(ddown);
		select.selectByValue("35");
		
		driver.findElement(By.id("ZipPostalCode")).sendKeys("12345");
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[2]/div[1]/div[2]/div/div[3]/div[4]/input")).click();
		driver.findElement(By.id("termsofservice")).click();
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[1]/div[3]/input[1]")).click();
		
		driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Max");
		driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Mustermann");
		driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("maxmustermann@gmail.com");
		
		WebElement ddown1 = driver.findElement(By.id("BillingNewAddress_CountryId"));
		Select select1 = new Select(ddown1);
		select1.selectByValue("35");
		
		driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Stadt");
		driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Strasse 1");
		driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("12345");
		driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("123456789123");		
		driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/input")).click();
		
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException e) {                             //Timer, weil lädt
		    System.out.println("got interrupted!");
		}
		
		driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/input")).click();
		
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException e) {                             //Timer, weil lädt
		    System.out.println("got interrupted!");
		}
		
		driver.findElement(By.id("shippingoption_2")).click();
		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input")).click();
		
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException e) {                             //Timer, weil lädt
		    System.out.println("got interrupted!");
		}
		
		driver.findElement(By.id("paymentmethod_3")).click();
		driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")).click();
		
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException e) {                             //Timer, weil lädt
		    System.out.println("got interrupted!");
		}
		
		driver.findElement(By.id("PurchaseOrderNumber")).sendKeys("12345");
		driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input")).click();
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException e) {                             //Timer, weil lädt
		    System.out.println("got interrupted!");
		}
		driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input")).click();
		driver.close();
		}
	}


