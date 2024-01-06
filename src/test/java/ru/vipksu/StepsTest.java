package ru.vipksu;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {
    private static final String REPOSITORY="kseniamitrofanova/MyProject";
    private static final int ISSUE=3;

    @Test
    public void testLambdaStep(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main page", () -> {
            open("https://github.com");
        });

        step("Looking for a repository " +REPOSITORY, () ->{
            $(".search-input").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $(".QueryBuilder-InputWrapper").submit();
        });

        step("Click on the repository link " + REPOSITORY, () ->{
            $(linkText(REPOSITORY)).click();
        });

        step("Open tab Issues ", ()->{
            $("#issues-tab").click();
        });

        step("Checking for availability Issue with number " + ISSUE, () ->{
            $(withText("#"+ISSUE)).should(Condition.exist);
        });
    }

    @Test
    public void testAnnotatedStep(){
        WebSteps steps=new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE);
    }
}
