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
	
	WebElement hover = driver.findElement(By.xpath(loc.getProperty("computers_reiter"))); // Maus Hover über "Computers"
	Actions action = new Actions(driver);
	action.moveToElement(hover).perform();
	
	driver.findElement(By.xpath(loc.getProperty("desktop_button"))).click(); //Desktops
	driver.findElement(By.xpath(loc.getProperty("simplecomputer_button"))).click(); //Simple Computer
	driver.findElement(By.id(loc.getProperty("8gb_checkbox"))).click(); //8GB Auwahl	
	driver.findElement(By.id(loc.getProperty("prozessor_checkbox"))).click(); // Prozessor Auswahl
	driver.findElement(By.id(loc.getProperty("addtocart_button"))).click(); //Add to cart Click
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(loc.getProperty("addtocart_alert")))); //Wartet bis Anzeige kommt, dass der Artikel dem Warenkorb hinzugefügt wurde
	
	driver.findElement(By.xpath(loc.getProperty("warenkorb_button"))).click(); //Warenkorb
	
	WebElement ddown = driver.findElement(By.id(loc.getProperty("countryid")));
	Select select = new Select(ddown);
	select.selectByValue("35");
	
	driver.findElement(By.id(loc.getProperty("zipcode_box"))).sendKeys("12345"); //PLZ
	driver.findElement(By.xpath(loc.getProperty("estimateshipping_button"))).click();
	driver.findElement(By.id(loc.getProperty("agb_checkbox"))).click(); //AGB`s Aktzeptiern
	driver.findElement(By.xpath(loc.getProperty("checkout_button0"))).click(); //Checkout click
	driver.findElement(By.xpath(loc.getProperty("checkoutasguest_button"))).click();		
	driver.findElement(By.id(loc.getProperty("firstname_box"))).sendKeys("Max"); //Vorname	
	driver.findElement(By.id(loc.getProperty("lastname_box"))).sendKeys("Mustermann"); //Nachname
	driver.findElement(By.id(loc.getProperty("email_box"))).sendKeys("maxmustermann@gmail.com"); //Mail
	
	WebElement ddown1 = driver.findElement(By.id(loc.getProperty("country_ddown"))); //Dropdown Auswahl Land
	Select select1 = new Select(ddown1);
	select1.selectByValue("35");
	
	driver.findElement(By.id(loc.getProperty("city_box"))).sendKeys("Stadt"); //Stadt eingabe
	driver.findElement(By.id(loc.getProperty("street_box"))).sendKeys("Strasse 1"); //Strasse eingabe
	driver.findElement(By.id(loc.getProperty("zipcode_box_checkout"))).sendKeys("12345"); //PLZ
	driver.findElement(By.id(loc.getProperty("phonenumber_box"))).sendKeys("123456789123"); //Telefonnummer
	driver.findElement(By.xpath(loc.getProperty("continue_button0"))).click(); //Continue
	driver.findElement(By.xpath(loc.getProperty("continue_button1"))).click(); //Continue
	driver.findElement(By.id(loc.getProperty("shippingoption2_checkbox"))).click(); //Versandoption 2
	driver.findElement(By.xpath(loc.getProperty("continue_button2"))).click(); //Continue
	driver.findElement(By.id(loc.getProperty("payment_checkbox3"))).click(); //Zahlungsmethode 3
	driver.findElement(By.xpath(loc.getProperty("continue_button3"))).click(); //Continue
	driver.findElement(By.id(loc.getProperty("po_number_box"))).sendKeys("12345"); //PurchaseOrderNumber PO-Number
	driver.findElement(By.xpath(loc.getProperty("continue_button4"))).click(); //Continue
	driver.findElement(By.xpath(loc.getProperty("checkout_button1"))).click(); //Bestellung abschließen
	Thread.sleep(1000);
	
	}
}
