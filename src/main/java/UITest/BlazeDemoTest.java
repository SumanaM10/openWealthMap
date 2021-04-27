package UITest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.HomePage;

public class BlazeDemoTest {

	public static WebDriver driver;
	HomePage homepagerepo;

	@BeforeMethod
	public void beforMethod() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		Assert.assertEquals(driver.getTitle(),"BlazeDemo");
		homepagerepo = new HomePage(driver);

	}

	@Test(enabled = true, priority = 1)
	public void verifyConfirmationID() throws InterruptedException {

		Select depCity =new Select(homepagerepo.depCity);
		String defaultDep = depCity.getFirstSelectedOption().getText();
		Assert.assertEquals(defaultDep, "Paris");
		depCity.selectByVisibleText("Portland");
	
		Select desCity =new Select(homepagerepo.destcity);
		String defaultDes = desCity.getFirstSelectedOption().getText();
		Assert.assertEquals(defaultDes, "Buenos Aires");
		desCity.selectByVisibleText("Dublin");
		
		homepagerepo.btnFindFlight.click();
		
		Assert.assertEquals(driver.getTitle(),"BlazeDemo - reserve");
		
		homepagerepo.chooseFlight.get(0).click();
		Assert.assertEquals(driver.getTitle(),"BlazeDemo Purchase");
		homepagerepo.btnPurchaseFlight.click();
		
		Assert.assertEquals(driver.getTitle(),"BlazeDemo Confirmation");
		String bookingid = homepagerepo.tableData.get(1).getText();
		System.out.println(bookingid);
		Assert.assertTrue(bookingid.length()>0);

	}
	

	
	@AfterMethod
	public void afterTest() {
		 driver.quit();
	}

}
