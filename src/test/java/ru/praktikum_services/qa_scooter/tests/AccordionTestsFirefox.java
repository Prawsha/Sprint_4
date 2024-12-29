package ru.praktikum_services.qa_scooter.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.praktikum_services.qa_scooter.pages.MainPage;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class AccordionTestsFirefox {
    private WebDriver driver;
    private MainPage mainPage;


    private int questionIndex;
    private String expectedContent;

    public AccordionTestsFirefox(int questionIndex, String expectedContent){
        this.questionIndex = questionIndex;
        this.expectedContent = expectedContent;
    }

    @Parameterized.Parameters
    public static Object[][] getAnswerText(){
        return new Object[][] {
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\qaeng\\Desktop\\ForTests\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void testAccordionFunctionality() {
        mainPage.scrollToImportantQuestions();
        String actualContent = mainPage.getContent(questionIndex);
        Assert.assertEquals("Текст ответа должен совпадать с ожидаемым", expectedContent, actualContent);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
