package net.creqavn.features.Leo;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.util.EnvironmentVariables;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLeoAccessDomain {
    private String theRestApiBaseUrl;
    private EnvironmentVariables environmentVariables;
    static Actor swagger = Actor.named("Swagger");
    private String DOMAIN = "https://leo88.top/";


    @Before
    public void configureBaseUrl() {
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse(DOMAIN);
        swagger.whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @Test
    public void testHomepage() {
        swagger.attemptsTo(
                Get.resource("")
        );

       swagger.should(
                seeThatResponse( "Status code should be 200",
                        response -> response.statusCode(200))
        );
    }
}
