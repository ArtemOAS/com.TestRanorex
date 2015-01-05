package com.ranorextest.RanorexTest.webdriver;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            return createWebDriver();
        }
    };

    public static WebDriver getWebDriver() {
        WebDriver webDriver = driverThreadLocal.get();
        if (webDriver == null) {
            webDriver = createWebDriver();
            driverThreadLocal.set(webDriver);
        }
        return webDriver;
    }

    private static WebDriver createWebDriver() {

        WebBrowser browser = WebBrowser.valueOf(getBrowserName());
        System.out.println("I am using - " + browser.name());
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");

        switch (browser) {
            case FIREFOX:
                return new FirefoxDriver();
            case CHROME:
                return new ChromeDriver();
            case IE:
                return new InternetExplorerDriver();
            default:
                return new FirefoxDriver();
        }
    }

    private static String getBrowserName() {
        String browser = System.getProperty("browser");
        if (StringUtils.isEmpty(browser)) {
            browser = "CHROME";
        }
        return browser.toUpperCase();
    }

    public static void quit() {
        WebDriver webDriver = driverThreadLocal.get();
        if (webDriver != null) {
            driverThreadLocal.set(null);
            webDriver.quit();
        }
    }
}
