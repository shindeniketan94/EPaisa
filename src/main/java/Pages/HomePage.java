package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage 
{

	By mobilenumber=By.xpath("//input[@class='_2zrpKA']");
	
	By password=By.xpath("//input[@class='_2zrpKA _3v41xv']");
	
	By loginbutton=By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']");	
	
	By Continue=By.xpath("//div[contains(@class,'Km0IJL col col-3-5')]/div/form/div[2]/button[1]");	
	
	By login_with_password=By.xpath("//button[contains(text(),'Login with Password')]");
	
	By Login_Signup=By.xpath("//a[contains(text(),'Login & Signup')]");
	
    By Login_Popup=By.xpath("//button[contains(@class,'_2AkmmA _29YdH8')]");
    
    By SearchProductTextBox=By.xpath("//input[contains(@title,'Search for products, brands and more')]");
    
    By SearchIcon=By.xpath("//button[@class='vh79eN']");
	
	WebDriver driver;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public  void EnterMobileNumber(String mobileno)
	{
		driver.findElement(mobilenumber).sendKeys(mobileno);
	}
	public void EnterPassword(String paword)
	{
		driver.findElement(password).sendKeys(paword);
	}
	public void ClickOnLoginButton()
	{
		driver.findElement(loginbutton).click();
	}
	public void ClickOnLoginButton(String mobileno,String paword) throws InterruptedException
	{
		   List<WebElement> element=driver.findElements(Continue);
			   if(element.size() > 0)
			   {
				driver.findElement(mobilenumber).sendKeys(mobileno);
				driver.findElement(Continue).click();
				Thread.sleep(5000);
				driver.findElement(login_with_password).click();
				Thread.sleep(4000);
				driver.findElement(password).sendKeys(paword);
				driver.findElement(loginbutton).click();
			   }
			   else{
				   driver.findElement(mobilenumber).sendKeys(mobileno);			
				   driver.findElement(password).sendKeys(paword);
				   driver.findElement(loginbutton).click();
			   }
	}
		
	public void EnterProduct(String prod)
	{
		driver.findElement(SearchProductTextBox).sendKeys(prod);
	}
	public void click_on_search_icon()
	{
		driver.findElement(SearchIcon).click();
	}
		
	}
	
	
	
	
	
	

