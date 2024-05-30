package testcase;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import base.BaseTest;
import utilities.ReadXLSXFile;

public class FirstTest extends BaseTest {
	@SuppressWarnings("deprecation")
	@Test(dataProviderClass = ReadXLSXFile.class, dataProvider = "testdata")
	public void LoginIn(String username, String password) {

		driver.findElement(By.linkText(p2.getProperty("SignInButton"))).click();
		driver.findElement(By.xpath(p2.getProperty("Email"))).sendKeys(username);
		driver.findElement(By.xpath(p2.getProperty("NextButton"))).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(p2.getProperty("Password"))).sendKeys(password);
		driver.findElement(By.xpath(p2.getProperty("LogInButton"))).click();
	}

	/*
	 * @DataProvider(name = "testdata") public Object[][] TestData() {
	 * 
	 * return new Object[][] {
	 * 
	 * {"praveenwizard00@gmail.com","PRAveen587"},
	 * {"praveenwizard00@gmail.com","PRAveen587"},
	 * {"praveenwizard00@gmail.com","PRAveen587"},
	 * {"praveenwizard00@gmail.com","PRAveen587"},
	 * {"praveenwizard00@gmail.com","PRAveen587"}
	 * 
	 * 
	 * };
	 * 
	 * }
	 */

}
