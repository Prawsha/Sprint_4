package ru.praktikum_services.qa_scooter.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ForDifferentBrowsers {

    public static final String URL_QA_SCOOTER = "https://qa-scooter.praktikum-services.ru/";

    public static final String BROWSER_NAME = "CHROME";

    public static WebDriver getWebDriver(String browserName) {
        if (browserName.equals("FIREFOX")) {
            return new FirefoxDriver();
        } else if (browserName.equals("CHROME")) {
            return new ChromeDriver();
        } else {
            throw new RuntimeException("Не распознан браузер: " + browserName);
        }
    }
}
