package ru.praktikum_services.qa_scooter.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum_services.qa_scooter.pages.MainPage;
import ru.praktikum_services.qa_scooter.pages.OrderPage;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)

public class OrderTestsChrome {
    private WebDriver driver;
    private MainPage mainPage;
    private OrderPage orderPage;
    private String firstNameValue;
    private String lastNameValue;
    private String addressValue;
    private String phoneNumberValue;
    private String commentValue;

    public OrderTestsChrome(String firstNameValue, String lastNameValue, String addressValue, String phoneNumberValue, String commentValue) {
        this.firstNameValue = firstNameValue;
        this.lastNameValue = lastNameValue;
        this.addressValue = addressValue;
        this.phoneNumberValue = phoneNumberValue;
        this.commentValue = commentValue;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        //Сгенерируй тестовые данные (свою учётку и несколько случайных)
        return new Object[][] {
                {"Иван", "Иванов", "Вавилова, 22", "89009009900", "Домофон 321"},
                {"Людмила", "Смирнова", "Академическая, 2, 4", "89669112233", "Позвоните за 15 минут"},
        };
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\qaeng\\Desktop\\ForTests\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
    }

    @Test
    public void testOrderFlowFromTopOrderButton() {
        mainPage.clickCookieButton();
        mainPage.clickOrderButtonTop();
        orderPage.insertDataFirstPageOrder(firstNameValue, lastNameValue, addressValue, phoneNumberValue);
        orderPage.clickNextButton();
        orderPage.insertDataSecondPageOrder(commentValue);
        orderPage.clickOrderButton();
        orderPage.clickYesButton();
        orderPage.waitSuccessPage();
        boolean actualStatus = orderPage.findSuccessStatus();
        Assert.assertTrue("Статус \"Заказ оформлен\" должен отображаться в окне", actualStatus);
    }

    @Test
    public void testOrderFlowFromButtonOrderButton() {
        mainPage.clickCookieButton();
        mainPage.scrollToButtonOrderButton();
        mainPage.clickOrderButtonBottom();
        orderPage.insertDataFirstPageOrder(firstNameValue, lastNameValue, addressValue, phoneNumberValue);
        orderPage.clickNextButton();
        orderPage.insertDataSecondPageOrder(commentValue);
        orderPage.clickOrderButton();
        orderPage.clickYesButton();
        orderPage.waitSuccessPage();
        boolean actualStatus = orderPage.findSuccessStatus();
        Assert.assertTrue("Статус \"Заказ оформлен\" должен отображаться в окне", actualStatus);
    }

    @After
    public void tearDown() {
            driver.quit();
    }

}


