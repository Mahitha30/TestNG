package pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page1 {
	
	private static final String Public = null;
	WebDriver driver;

	@Test
	public void gui_elements() {
	    driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).sendKeys("Shami");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//input[@placeholder='Enter EMail']")).sendKeys("shami123@gmail.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//input[@placeholder='Enter Phone']")).sendKeys("9876543210");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//textarea[@id='textarea']")).sendKeys("Plotno-73,Housing board,Alwal");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//label[text()='Female']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//label[text()='Friday']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Select country_drp = new Select(driver.findElement(By.xpath("//select[@id='country']")));
		country_drp.selectByVisibleText("Japan");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Select colors_drp = new Select(driver.findElement(By.xpath("//select[@id='colors']")));
		colors_drp.selectByIndex(4);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Select sorted_list = new Select(driver.findElement(By.xpath("//select[@id='animals']")));
		sorted_list.selectByVisibleText("Lion");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//		WebElement date_inp= driver.findElement(By.xpath("//input[@id='datepicker']"));
//		date_inp.click();
		}
	@Test
	public void tabs() {
		driver= new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		System.out.println(driver.getWindowHandle());
		driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("Lion");
		driver.findElement(By.xpath("//input[@type='submit']")).click();	
		driver.findElement(By.xpath("//a[text()='Lion']")).click();
		driver.switchTo().window("692A85CF960052E17B5DEFA0C3028CCE");
		

		
	}
	@Test
	public void dynamic_btn() {
		driver= new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement ele = driver.findElement(By.xpath("//button[text()='STOP' or text()= 'START']"));
		ele.click();
	}
	@Test
	public void alerts() {
		driver= new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//Simple Alert
		driver.findElement(By.xpath("//button[text()='Simple Alert']")).click();
		Alert alert = driver.switchTo().alert();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		alert.accept();
		//Confirmation Alert
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement ele = driver.findElement(By.xpath("//button[text()='Confirmation Alert']"));
		ele.click();
		String text = driver.switchTo().alert().getText();
	    System.out.println("Confirmation Alert Text is" + text);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    driver.switchTo().alert().accept();
	    //Prompt Alert
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    WebElement ele1 = driver.findElement(By.xpath("//button[text()='Prompt Alert']"));
	    ele1.click();
	    driver.switchTo().alert().sendKeys("Mahitha");
	    driver.switchTo().alert().accept();
		}
	@Test
	public void actions() {
		driver= new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement ele = driver.findElement(By.xpath("//button[text()='Point Me']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).build();
	}
	@Test
	public void newtab() {
		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		String parentHandle = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[text()='New Tab']")).click();
		Set<String> window_ids = driver.getWindowHandles();
		for (String name : window_ids) {
			if (parentHandle.equals(name)) {
				driver.switchTo().window(name);
				return;
			}
		}
	}
	@Test
	public void popup() {
		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String parenthandle = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[text()='Popup Windows']")).click();
		Set<String> window_ids = driver.getWindowHandles();
		for (String name:window_ids) {
			if(parenthandle.equals(name)) {
				driver.switchTo().window(name);
			}
		}
	}
	@Test
	public void doubleclick() {
		driver= new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.xpath("//input[@id='field1']")).sendKeys("Mahitha");
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//button[text()='Copy Text']"));
		act.doubleClick(ele).perform();
	}
	@Test
	public void draganddrop() {
		driver= new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Actions act = new Actions(driver);
		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
		//act.dragAndDrop(drag, drop).build().perform();
		act.clickAndHold(drag).moveToElement(drop).release(drop).build().perform();
	}
}
