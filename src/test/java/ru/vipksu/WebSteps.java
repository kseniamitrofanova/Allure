package ru.vipksu;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step("Open main page")
    public void openMainPage(){
        open("https://github.com");
    }

    @Step("Looking for a repository {repo}")
    public void searchForRepository(String repo){
        $(".search-input").click();
        $("#query-builder-test").sendKeys(repo);
        $(".QueryBuilder-InputWrapper").submit();
    }

    @Step("Click on the repository link {repo}")
    public void clickRepositoryLink(String repo){
        $(linkText(repo)).click();
    }

    @Step("Open tab Issue")
    public void openIssuesTab(){
        $("#issues-tab").click();
    }

    @Step("Checking for availability Issue with number {iss}")
    public void shouldSeeIssueWithNumber(int iss){
        $(withText("#"+iss)).should(Condition.exist);

    }
}
