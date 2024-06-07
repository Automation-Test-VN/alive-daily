package net.creqavn.features.Leo;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.model.util.EnvironmentVariables;
import org.junit.Test;
import org.junit.runner.RunWith;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;


@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("datatest/urls.csv")
public class TestLeoBrokenImages {
    private String domain;
    private String imgURL;
    static Actor swagger = Actor.named("Swagger");


    public String getDomain() {
        return domain;
    }
    public String getImgURL() {
        return imgURL;
    }
    private String theRestApiBaseUrl;
    private EnvironmentVariables environmentVariables;
    private String baseURI = "https://leo88.top";


    //@TestData(columnNames = "link")

    @Test
    public void testBrokenImage() {
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl").orElse(baseURI);
        swagger.whoCan(CallAnApi.at(theRestApiBaseUrl));

        swagger.attemptsTo(
                Get.resource(imgURL)
        );
        swagger.should(
                seeThatResponse("Status code should be 200",
                        response -> response.statusCode(200))
        );
    }
}
