package org.example.UI_Base;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Name;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageObject {

    public static final String URL = "https://www.google.com";

    //Страница Google
    @Name("Поле поиска")
    @FindBy(how = How.NAME, using = "q")
    public SelenideElement inputSearchGoogle;

    //Страница СберЛизинг
    @Name("Кнопка Принять Куки")
    @FindBy(how = How.XPATH, using = "//button[@class='sbl-btn sbl-btn_large m-0'][text()=' Принять всё ']")
    public SelenideElement cookie;

    @Name("Кнопка Подобрать по параметрам")
    @FindBy(how = How.XPATH, using = "//a[@class='sbl-btn sbl-btn_medium mx-auto sbl-btn_icon sbl-btn_icon-config'][text()='Подобрать по параметрам']")
    public SelenideElement options;

    @Name("Фильтр Город")
    @FindBy(how = How.CSS, using = "#filter-city > input")
    public SelenideElement filterCity;

    @Name("Фильтр Марка")
    @FindBy(how = How.CSS, using = "#filter-mark > input")
    public SelenideElement filterMark;

    @Name("Фильтр Модель")
    @FindBy(how = How.CSS, using = "#filter-model > input")
    public SelenideElement filterModel;

    @Name("Кнопка Показать все предложения")
    @FindBy(how = How.XPATH, using = "//a[@class='sbl-btn sbl-btn_medium'][text()=' Показать все предложения ']")
    public SelenideElement buttonShowOffers;

    @Name("Выбранные тэги")
    @FindBy(how = How.CLASS_NAME, using = "h2")
    public SelenideElement tagsOptions;




}
