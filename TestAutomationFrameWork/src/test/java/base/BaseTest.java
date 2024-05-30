package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	public static WebDriver driver;
	public static FileReader fl;
	public static Properties p;
	public static FileReader fl2;
	public static Properties p2;
	


	@BeforeMethod
	public void setUp() throws IOException {

		if (driver == null) {

			fl = new FileReader(System.getProperty("user.dir") + "/src/test/resources/configfiles/config.properties");
			p = new Properties();
			p.load(fl);
			fl2 = new FileReader(System.getProperty("user.dir") + "/src/test/resources/configfiles/locators.properties");
			p2 = new Properties();
			p2.load(fl2);

		}

		if (p.getProperty("browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.get(p.getProperty("testurl"));
			driver.manage().window().maximize();
		}

		else if (p.getProperty("browser").equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
			driver.get(p.getProperty("testurl"));
			driver.manage().window().maximize();
		}
	}

	
	@AfterMethod
	public void tearDown() {

		driver.quit();
		System.out.println("TearDown Successful");

	}
}
