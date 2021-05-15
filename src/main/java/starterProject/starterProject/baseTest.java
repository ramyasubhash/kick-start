package starterProject.starterProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
//import io.cucumber.core.api.Scenario;

public class baseTest {

	public static WebDriver driver=null;
	public  SessionId session=null;
	public static Properties prop = new Properties();
	
	public baseTest(){
    	try {
    		 System.out.println(System.getProperty("user.dir"));
    		//prop.load( new FileInputStream("/kick-start/src/test/resources/application.properties") ); --comment: relative path not working
    		 prop.load( new FileInputStream("C:/Users/ramya/git/kick-start/src/test/resources/application.properties") );
    		// prop.load( new FileInputStream(".kick-start\\src\\test\\resources\\application.properties") ); --comment: didn't work
    		
    	} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public WebDriver getDriver() {
		return this.getDriver();
	}
	
	public void setDriver(WebDriver driver){
		this.driver=driver;
	}
	
	@Before
    public  void setUpDriver(){
		System.out.println(new File(".").getAbsolutePath());
        String browser = prop.getProperty("browser");
        System.out.println(System.getProperty("user.dir"));
        System.out.println(prop.getProperty("browser"));
        System.out.println(prop.getProperty("url"));
        if (browser == null) {
            browser = "chrome";
        }
        switch (browser) {
            case "chrome":
            	System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
            	   //session = ((ChromeDriver)driver).getSessionId();
                driver = new ChromeDriver(chromeOptions);
                driver.get(prop.getProperty("url"));
                break;
            case "firefox":
            	System.setProperty("webdriver.gecko.driver","./src/test/lib/geckodriver.exe");
                driver = new FirefoxDriver();
                driver.get("http://automationpractice.com/index.php");
                driver.manage().window().maximize();
                 //session = ((FirefoxDriver)driver).getSessionId();
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
        }
    }
    
	/*
	 * public void closeDriver(Scenario scenario){ if(scenario.isFailed()){
	 * saveScreenshotsForScenario(scenario); } driver.close(); }
	 * 
	 * private void saveScreenshotsForScenario(final Scenario scenario) { final
	 * byte[] screenshot = ((TakesScreenshot) driver)
	 * .getScreenshotAs(OutputType.BYTES); scenario.embed(screenshot, "image/png");
	 * }
	 */
    
    
    }
