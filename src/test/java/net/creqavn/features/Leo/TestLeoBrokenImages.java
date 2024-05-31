package net.creqavn.features.Leo;


import net.creqavn.questions.TheImage;
import net.creqavn.questions.TheList;
import net.creqavn.tasks.DataProcessor;
import net.serenitybdd.annotations.ClearCookiesPolicy;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


import java.util.List;

import static net.creqavn.ui.leo.LeoElements.*;

@RunWith(SerenityRunner.class)
public class TestLeoBrokenImages {

    static Actor swagger = Actor.named("Swagger");

    @Managed(uniqueSession = true, clearCookies = ClearCookiesPolicy.BeforeEachTest)
    public static WebDriver mightyBrowser;

    @Test
    public void checkBrokenImages() {
        swagger.can(BrowseTheWeb.with(mightyBrowser));
        swagger.attemptsTo(
                Open.url(DOMAIN)
        );
        List<String> srcAttributes = swagger.asksFor(TheImage.hasSrc());
        List<String> filteredSrc = TheList.hasFiltered(srcAttributes);
//        filteredSrc.forEach(src -> System.out.println(src));

        List<String> processedData = DataProcessor.processData(filteredSrc);
        DataProcessor.sendRequest(processedData);
    }
}
