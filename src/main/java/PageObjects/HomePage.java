package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

    @FindBy(name="fromPort")
    public  WebElement depCity;

    @FindBy(name="toPort")
    public WebElement destcity;    

    @FindBy(xpath="//input[@value='Find Flights']")
    public WebElement btnFindFlight;
    
    @FindBy(xpath="//input[@value='Choose This Flight']")
    public List<WebElement> chooseFlight;
    
    @FindBy(xpath="//input[@value='Purchase Flight']")
    public WebElement btnPurchaseFlight;


    @FindBy(xpath="//table[@class='table']//td")
    public List<WebElement> tableData;

   
    
    public HomePage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
}
