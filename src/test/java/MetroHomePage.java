import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MetroHomePage {
    private String stationFrom;
    // поле с экземпляром веб драйвера
    private WebDriver driver;

    // локатор кнопки выпадающего списка городов по имени класса
    private static By selectCityButton = By.className("select_metro__button");


    // локатор поля ввода «Откуда» по XPATH, поиск по плейсхолдеру
    private static By fieldFrom = By.xpath("//*[@placeholder='Откуда']");

    // локатор поля ввода «Куда» по XPATH, поиск по плейсхолдеру
    private  static By fieldTo = By.xpath("//*[@placeholder='Куда']");

    // локатор коллекций станций «Откуда» и «Куда» маршрута по имени класса
    //private static By stationCollection = By.className("route-details-block__station-list-item");
    List<WebElement> elements = driver.findElements(By.xpath("route-details-block__station-list-item"));

    private ElementsCollection routeStationFromTo;

//    public MetroHomePage(WebDriver driver, ElementsCollection routeStationFromTo) {
//        this.driver = driver;
//        this.routeStationFromTo = routeStationFromTo;
//    }

//     конструктор класса MetroHomePage с нужным параметром
    public MetroHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // метод ожидания загрузки страницы: проверили видимость станции «Театральная»
    public void waitForLoadHomePage() {
        // подожди 8 секунд, пока появится веб-элемент с нужным текстом
        new WebDriverWait(driver, 8)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Театральная']")));
    }

    // метод выбора города по переданному названию
    public void chooseCity(By cityName) {
        // кликни по выпадающему списку городов
        driver.findElement(selectCityButton).click();
        // выбери город, переданный в параметре метода
        driver.findElement(By.xpath(String.format("//*[text()='%s']", cityName))).click();
    }

    // метод ввода названия станции в поле «Откуда»
    public void setStationFrom(String stationFrom) {
        // введи название станции в поле ввода, а затем с помощью клавиш «Вниз» и Enter выбери его в выпадающем списке саджеста
        driver.findElement(fieldFrom).sendKeys(stationFrom, Keys.DOWN, Keys.ENTER);
    }

    // метод ввода названия станции в поле «Куда»
    public void setStationTo(String stationTo) {
        // введи название станции в поле ввода, а затем с помощью клавиш «Вниз» и Enter выбери его в выпадающем списке саджеста
        driver.findElement(fieldTo).sendKeys(stationTo, Keys.DOWN, Keys.ENTER);

    }

    // метод ожидания построения маршрута: проверяется видимость кнопки «Получить ссылку на маршрут»
    public void waitForLoadRoute() {
        // подожди 3 секунды, чтобы элемент с нужным текстом стал видимым
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//[text() = 'Получить ссылку на маршрут']")));
    }

    // метод построения маршрута
    public void buildRoute(String stationFrom, String stationTo) {
        // указание станции «Откуда»
        setStationFrom(stationFrom);
        // указание станции «Куда»
        setStationTo(stationTo);
        // ожидание построения маршрута
        waitForLoadRoute();
    }

    // метод получения имени станции «Откуда» для построенного маршрута
    public String getRouteStationFrom() {
        // возвращается текст первого элемента коллекции — станции «Откуда» и «Куда»
        return ...(routeStationFromTo)...
    }

    // метод получения имени станции «Куда» построенного маршрута
    public String getRouteStationTo() {
        // возвращается текст второго элемента коллекции — станции «Откуда» и «Куда»
        return ...(routeStationFromTo)...
    }

    // метод получения примерного времени маршрута
    public String getApproximateRouteTime(int routeNumber) {
        // возвращается текст из требуемого по номеру элемента из коллекции времен всех маршрутов
        return driver.findElements(...).get(routeNumber)...;
    }

    // метод проверки с ожиданием видимости станции метро
    public void waitForStationVisibility(String stationName) {
        // ждем видимости элемента с нужным текстом из параметра в течение 8 секунд
        new WebDriverWait(driver, 8)...

    }
}
