package net.creqavn.features;

import net.creqavn.tasks.RandomValueGenerator;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;


import net.serenitybdd.screenplay.ui.PageElement;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLucky88AliveDaily {

    static Actor swagger = Actor.named("Swagger");

    @Managed(uniqueSession = true)
    public static WebDriver mightyBrowser;
//
//    @BeforeClass
//    public static void init(){
//        swagger.can(BrowseTheWeb.with(mightyBrowser));
//        swagger.attemptsTo(Open.url("https://lucky88.vip/"));
//    }
//
//    @Before
//    public void swaggerCanBrowseTheWeb() {
//
//    }

    @Test
    public void aRegisterNewAccount() {
        swagger.can(BrowseTheWeb.with(mightyBrowser));
        swagger.attemptsTo(Open.url("https://lucky88.vip/"));
        String randomNumericString = RandomValueGenerator.generateRandomNumericString(10);
        String randomNumber = RandomValueGenerator.generateRandomPhoneNumber();
        when(swagger).attemptsTo(
                Click.on(".base-button--bg-green"),
                Enter.keyValues(randomNumericString).into(".form-register [name='username']"),
                Enter.keyValues("Creq@123321").into("//div[@class='base-input base-input--password']//input[@name='password']"),
                Enter.keyValues(randomNumber).into(".form-register [name='phone']"),
                Click.on(".base-button--full"),
                Click.on("//div[@class='lucky-content__item'][1]"),
                Click.on(".lucky-content__btn")
        );
        Ensure.that(PageElement.located(By.xpath("//div[@class='welcome']")));
    }
}
