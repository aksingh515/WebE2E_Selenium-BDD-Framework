package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

	private static ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		try {
			if (tDriver.get() == null) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				options.addArguments("--disable-save-password-bubble");
				options.addArguments("--incognito");

				WebDriver driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				tDriver.set(driver);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tDriver.get();
	}

	public static void quitDriver() {
		if (tDriver.get() != null) {
			tDriver.get().quit();
			// driver = null;
			tDriver.remove();
		}
	}

}
