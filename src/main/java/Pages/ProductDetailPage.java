package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage
{
	
	WebDriver driver;
	
	By ProductName=By.xpath("//div[contains(@data-id,'TABFB5Z4CVTSNNZN')]/div[1]/a[2]");
	
	By ProductRating=By.xpath("//span[@id='productRating_LSTTABFB5Z4CVTSNNZNZD2TDS_TABFB5Z4CVTSNNZN_']");
	                                   
	
	By ProductPrice=By.xpath("//div[contains(@data-id,'TABFB5Z4CVTSNNZN')]/div[1]/a[3]/div/div");
	
	
	public ProductDetailPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getProductName()
	{
		String Name=driver.findElement(ProductName).getAttribute("title");
		return Name;
	}
	
	public String getProductRating()
	{
		String rating=driver.findElement(ProductRating).getText();
		return rating;
	}
	
	public String getProductPrice()
	{
		String price=driver.findElement(ProductPrice).getText();
		return price;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
