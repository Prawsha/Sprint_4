package ru.praktikum_services.qa_scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {
    private WebDriver driver;

    // Заголовок «Вопросы о важном»
    private By importantQuestions = By.xpath("//div[text()='Вопросы о важном']");

    // Кнопка «да все привыкли» (куки)
    private By cookieButton = By.xpath("//*[contains(text(), 'да все привыкли')]");

    // Кнопка «Заказать» (вверху)
    private By orderButtonTop = By.xpath("//div[@class='Header_Nav__AGCXC']//button[text()='Заказать']");

    // Кнопка «Заказать» (внизу)
    private By orderButtonBottom = By.xpath("//div[@class='Home_FinishButton__1_cWm']//button[text()='Заказать']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToImportantQuestions() {
        WebElement element = driver.findElement(importantQuestions);
        ((JavascriptExecutor) driver).
                executeScript("arguments[0].scrollIntoView();", element);
    }

    public String getContent(int questionIdNumber){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath (".//div[@id='accordion__heading-" + questionIdNumber + "']")));
        driver.findElement(By.xpath (".//div[@id='accordion__heading-" + questionIdNumber + "']")).click();
        new WebDriverWait(driver, 3).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath (".//div[@id='accordion__panel-" + questionIdNumber + "']//p")));
        return driver.findElement(By.xpath (".//div[@id='accordion__panel-" + questionIdNumber + "']//p")).getText();
    }

    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    public void clickOrderButtonTop() {
        driver.findElement(orderButtonTop).click();
    }

    public void scrollToButtonOrderButton() {
        WebElement element = driver.findElement(orderButtonBottom);
        ((JavascriptExecutor) driver).
                executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickOrderButtonBottom() {
        driver.findElement(orderButtonBottom).click();
    }

//    public void clickQuestionButton() {
//        driver.findElement(questionButton).click();
//    }
//
//    public String getQuestionAnswerText() {
//        return driver.findElement(questionAnswer).getText();
//    }

}
