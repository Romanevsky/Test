package UItest;

import com.codeborne.selenide.selector.ByText;
import org.example.UI_Base.Options;
import org.example.UI_Base.PageObject;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.example.UI_Base.PageObject.URL;

public class Test_SberLeasing extends Options {
    PageObject selector = page(PageObject.class);

    @Test
    public void testCarOptions() {
        open(URL);
        selector.inputSearchGoogle.setValue("СберЛизинг").pressEnter();
        $(byText("СберЛизинг — официальный сайт лизинговой компании ...")).click();
        selector.cookie.click();
        selector.options.click();
        selector.filterCity.click();
        selector.filterCity.val("Новосибирск");
        selector.filterMark.click();
        selector.filterMark.val("Lada");
        selector.filterModel.click();
        selector.filterModel.val("Granta седан");
        $(new ByText("передний")).click();
        $(new ByText("механика")).click();
        $(new ByText("седан")).click();
        $(new ByText("бензин")).click();
        $(byAttribute("placeholder", "Выберите или введите")).click();
        $(byAttribute("placeholder", "Выберите или введите")).val("белый");
        selector.buttonShowOffers.scrollTo();
        selector.buttonShowOffers.click();
        $$(".car-card__item-section").get(0).click();
        selector.tagsOptions.shouldHave(text("Lada").because("Марка автомобиля не соответствует"));
        System.out.println("Марка автомобиля соответствует выбранному параметру");



    }


}
