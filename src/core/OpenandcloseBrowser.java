package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

//import testcase.Unregistered_User;

public class OpenandcloseBrowser {
	public static WebDriver driver;
	public String ParnetHome,test;

	
	@Parameters({"browser","baseURL"})
	@BeforeTest
    public void openBrowser(String browser,String baseURL)
    {
		if(browser.equals("FIREFOX"))
			{
				driver=new FirefoxDriver();
			}
		
		else if(browser.equals("CHROME"))
			{
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\lib\\chromedriver.exe");
				driver=new ChromeDriver();
			}
	
		else if(browser.equals("IE"))
			{
				System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\lib\\IEDriverServer.exe");
				driver=new InternetExplorerDriver();
			}
		else
			{
				System.out.println("OOSP No Browser Defined");
			
			}
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		this.ParnetHome=driver.getWindowHandle();

		
		this.test="apple";
    }
	
	
	//@AfterTest
	public void closeBrowser()
	{
		driver.close();
	System.out.println("DRIVER CLOSING COMMAND");	
	}
	
	
	
/*@BeforeMethod
public void a()
{
System.out.println("BEFORE A");	
}
*/	
	
	@AfterMethod
	public void closeWindow(ITestResult tr)
	{
		
		System.out.println("IN AFTER METHOD");
	if(tr.getMethod().getMethodName().equalsIgnoreCase("click_view_sample_resume"))
	{
		
		
		closeBrowser();
		new Useractions().SwitchwindowHandles(ParnetHome);
		System.out.println(driver.getTitle());
		
	}
	}

	
	public WebDriver getInsatnce()
	{
		return driver;
	}
	

}
