package ru.praktikum_services.qa_scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OrderPage {
    private WebDriver driver;

    // Поле ввода «Имя»
    private By firstName = By.xpath("//*[@placeholder='* Имя']");

    // Поле ввода «Фамилия»
    private By lastName = By.xpath("//*[@placeholder='* Фамилия']");

    // Поле ввода «Адрес»
    private By address = By.xpath("//*[@placeholder='* Адрес: куда привезти заказ']");

    // Выбор «Станция метро»
    private By subwayStation = By.xpath("//*[@placeholder='* Станция метро']");
    private By subwayStationSelect = By.xpath("//*[@class='select-search has-focus']//*[@class='select-search__select']/ul/li[5]");

    // Поле ввода «Телефон»
    private By phoneNumber = By.xpath("//*[@placeholder='* Телефон: на него позвонит курьер']");

    // Кнопка «Далее»
    private By nextButton = By.xpath("//button[contains(text(), 'Далее')]");

    // Выбор даты «Когда привезти самокат»
    private By datePicker = By.xpath("//*[@placeholder='* Когда привезти самокат']");
    private By selectLostDay = By.xpath("//*[@class='react-datepicker__week'][last()]//*[contains(@class, 'react-datepicker__day')][last()]");

    // Выбор «Срок аренды»
    private By rentalPeriod = By.xpath("//*[contains(text(), 'Срок аренды')]");
    private By rentalPeriodSelect = By.xpath("//*[contains(@class, 'Dropdown-option')][last()]");

    // Выбор «Цвет самоката»
    private By scooterColor = By.id("grey");

    // Поле ввода «Комментарий для курьера»
    private By comment = By.xpath("//*[@placeholder='Комментарий для курьера']");

    // Кнопка «Заказать»
    private By orderButton = By.xpath("//div[@class = 'Order_Buttons__1xGrp']//button[contains(text(), 'Заказать')]");

    // Кнопка «ДА»
    private By yesButton = By.xpath("//button[contains(text(), 'Да')]");

    //Окно "Заказ оформлен"
    private By successPage = By.xpath(".//*[@id='root']//div[@class='Order_ModalHeader__3FDaJ']");

    // Текст "Заказ оформлен"
    private By successStatus = By.xpath("//*[contains(text(), 'Заказ оформлен')]");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void insertDataFirstPageOrder(String firstNameValue, String lastNameValue, String addressValue, String phoneNumberValue) {
        driver.findElement(firstName).sendKeys(firstNameValue);
        driver.findElement(lastName).sendKeys(lastNameValue);
        driver.findElement(address).sendKeys(addressValue);
        driver.findElement(subwayStation).click();
        driver.findElement(subwayStationSelect).click();
        driver.findElement(phoneNumber).sendKeys(phoneNumberValue);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void insertDataSecondPageOrder(String commentValue) {
        driver.findElement(datePicker).click();
        driver.findElement(selectLostDay).click();
        driver.findElement(rentalPeriod).click();
        driver.findElement(rentalPeriodSelect).click();
        driver.findElement(scooterColor).click();
        driver.findElement(comment).sendKeys(commentValue);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }

    public void waitSuccessPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(successPage));
    }

    public boolean findSuccessStatus() {
        return driver.findElement(successStatus).isDisplayed();
    }

}
