package ru.vipksu;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {
    @Test
    public void testIssueSearch(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".search-input").click();
        $("#query-builder-test").sendKeys("kseniamitrofanova/MyProject");
        $(".QueryBuilder-InputWrapper").submit();

        $(linkText("kseniamitrofanova/MyProject")).click();
        $("#issues-tab").click();
        $(withText("#3")).should(Condition.exist);
    }
}
