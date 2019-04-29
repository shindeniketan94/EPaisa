package ProductDetailTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ProductDetailPage;
import Utility.Contstants;
import Utility.ExcelHelper;
import Utility.Testreporter;


@Listeners(Testreporter.class)
public class ProductSearchTest 
{
	 WebDriver driver;
	 @BeforeTest
     public void startBrowser()
 	 {
		System.setProperty("webdriver.chrome.driver","Driver//chromedriver1.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();		
		driver.manage().window().maximize();
		driver.get(Contstants.url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 	  }	
	
   @Test
	public void getProductdetail() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		ExcelHelper reader=new ExcelHelper("C:\\Users\\mahadev shinde\\workspace\\EPaisa\\src\\main\\java\\TestData\\epaisa test data.xlsx");
		int i1=reader.getrowcount(0);
				
		System.out.println("Total no of rows:"+i1);
		
		String productname=reader.getdata(0,1,0);
		
		System.out.println("First product name from excel sheet :" +productname);
		
		HomePage HomeObj=new HomePage(driver);
		
		HomeObj.ClickOnLoginButton(Contstants.moblienumber,Contstants.password);
		
		Thread.sleep(4000);
		
		HomeObj.EnterProduct(productname);
		
		HomeObj.click_on_search_icon();
		
		Thread.sleep(8000);
		
		ProductDetailPage ProdObj=new ProductDetailPage(driver);
		
		String name=ProdObj.getProductName();
		
		String rating=ProdObj.getProductRating();
		
		String price=ProdObj.getProductPrice();
		
		System.out.println(name);
		
		System.out.println(rating);
		
		System.out.println(price);		
	
		reader.writeData("C:\\Users\\mahadev shinde\\workspace\\EPaisa\\test-output\\Results.xlsx",
				"Product_Details", 1, 0, name);
		reader.writeData("C:\\Users\\mahadev shinde\\workspace\\EPaisa\\test-output\\Results.xlsx",
				"Product_Details", 1, 1, rating);
		reader.writeData("C:\\Users\\mahadev shinde\\workspace\\EPaisa\\test-output\\Results.xlsx",
				"Product_Details", 1, 2, price);
	}
   @AfterTest
   public void closebrowser()
   {
	   driver.close();
   }
	
	
	
}
