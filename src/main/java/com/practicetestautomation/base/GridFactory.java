package com.practicetestautomation.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridFactory {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private String browser;
	private Logger log;

	public GridFactory(String browser, Logger log) {
		this.browser = browser.toLowerCase();
		this.log = log;
	}


	public WebDriver createDriver() {
		log.info("Connecting to node: " + browser);
		DesiredCapabilities capabilities = new DesiredCapabilities();
	

		switch (browser) {
		case "chrome":
			// Make sure to upgrade chromedriver to work with your browser version: https://chromedriver.chromium.org/downloads
		//	System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			//System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			//driver.set(new ChromeDriver());
			capabilities.setBrowserName("chrome");
			break;

		case "edge":
			// Make sure to upgrade geckodriver to work with your browser version: https://github.com/mozilla/geckodriver/releases
		//	System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
		//	System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		//	System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
			//driver.set(new FirefoxDriver());
			capabilities.setBrowserName("edge");
			break;

		default:
			//log.debug("Do not know how to start: " + browser + ", starting chrome.");
			//System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			//System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			//driver.set(new ChromeDriver());
			capabilities.setBrowserName("chrome");
		//	break;
		}
		
		URL url = null;
		try {
			 url = new URL("http://localhost:4444");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		driver.set(new RemoteWebDriver(url, capabilities));
		
		
		java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
		return driver.get();
	}
}
