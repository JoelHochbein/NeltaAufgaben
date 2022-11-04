package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MainTest extends BaseTest{
	
	@Test 
	public static void main() throws InterruptedException
	{
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Driver wartet bis das nächte Element gefunden wurde (max. 10 Sekunden)
	
	WebElement hover = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a")); // Maus Hover über "Computers"
	Actions action = new Actions(driver);
	action.moveToElement(hover).perform();
	
	driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/ul/li[1]/a")).click(); //Desktops
	driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[6]/div/div[1]/a/img")).click(); //Simple Computer
	driver.findElement(By.id("product_attribute_75_6_32_99")).click(); //8GB Auwahl	
	driver.findElement(By.id("product_attribute_75_5_31_96")).click(); // Prozessor Auswahl
	driver.findElement(By.id("add-to-cart-button-75")).click(); //Add to cart Click
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content"))); //Wartet bis Anzeige kommt, dass der Artikel dem Warenkorb hinzugefügt wurde
	
	driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]")).click(); //Warenkorb
	
	WebElement ddown = driver.findElement(By.id("CountryId"));
	Select select = new Select(ddown);
	select.selectByValue("35");
	
	driver.findElement(By.id("ZipPostalCode")).sendKeys("12345"); //PLZ
	driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[2]/div[1]/div[2]/div/div[3]/div[4]/input")).click();
	driver.findElement(By.id("termsofservice")).click(); //AGB`s Aktzeptiern
	driver.findElement(By.id("checkout")).click(); //Checkout click
	driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[1]/div[3]/input[1]")).click();		
	driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Max"); //Vorname	
	driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Mustermann"); //Nachname
	driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("maxmustermann@gmail.com"); //Mail
	
	WebElement ddown1 = driver.findElement(By.id("BillingNewAddress_CountryId")); //Dropdown Auswahl Land
	Select select1 = new Select(ddown1);
	select1.selectByValue("35");
	
	driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Stadt"); //Stadt eingabe
	driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Strasse 1"); //Strasse eingabe
	driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("12345"); //PLZ
	driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("123456789123"); //Telefonnummer
	driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/input")).click(); //Continue
	driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/input")).click(); //Continue
	driver.findElement(By.id("shippingoption_2")).click(); //Versandoption 2
	driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input")).click(); //Continue
	driver.findElement(By.id("paymentmethod_3")).click(); //Zahlungsmethode 3
	driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")).click(); //Continue
	driver.findElement(By.id("PurchaseOrderNumber")).sendKeys("12345"); //PurchaseOrderNumber PO-Number
	driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input")).click(); //Continue
	driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input")).click(); //Bestellung abschließen
	Thread.sleep(1000);
	
	}
}
