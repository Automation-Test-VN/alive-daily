package net.creqavn.features.mayman;

import net.creqavn.models.LoginAccount;
import net.creqavn.tasks.Login;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;


import static net.serenitybdd.screenplay.GivenWhenThen.*;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLucky88AliveDaily {


    static Actor swagger = Actor.named("Swagger");

    @Managed(uniqueSession = true)
    public static WebDriver mightyBrowser;

//    @Test
//    public void aRegisterNewAccount() {
//        swagger.can(BrowseTheWeb.with(mightyBrowser));
//        swagger.attemptsTo(Open.url("https://lucky88.vip/"));
//
//        RegisterAccount registerAccount = new RegisterAccount();
//
//        when(swagger).attemptsTo(
//                Register.theUser(registerAccount),
//                Ensure.that(WELCOME_POPUP).isEnabled()
//        );
//
//    }

    @Test
    public void bLoginWithAccountHasBalance(){
        swagger.can(BrowseTheWeb.with(mightyBrowser));
        swagger.attemptsTo(Open.url("https://lucky88.vip/"));

        LoginAccount loginAccount = new LoginAccount();

        when(swagger).attemptsTo(
                Login.theAccountHasBalance(loginAccount)
        );
    }

    @Test
    public void bLoginWithAccountNonBalance(){
        swagger.can(BrowseTheWeb.with(mightyBrowser));
        swagger.attemptsTo(Open.url("https://lucky88.vip/"));
        LoginAccount loginAccount = new LoginAccount();

        when(swagger).attemptsTo(
                Login.theAccountNonBalance(loginAccount)
        );
    }
}
