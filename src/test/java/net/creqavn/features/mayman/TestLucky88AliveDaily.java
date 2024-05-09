package net.creqavn.features.mayman;

import net.creqavn.models.LoginAccount;
import net.creqavn.models.RegisterAccount;
import net.creqavn.tasks.Login;
import net.creqavn.tasks.Register;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;


import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;


import static net.creqavn.ui.Lucky88Elements.*;
import static net.serenitybdd.screenplay.GivenWhenThen.*;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLucky88AliveDaily {


    static Actor swagger = Actor.named("Swagger");

    @Managed(uniqueSession = true)
    public static WebDriver mightyBrowser;

    @Test
    public void aRegisterNewAccount() {
        swagger.can(BrowseTheWeb.with(mightyBrowser));
        swagger.attemptsTo(Open.url("https://lucky88.vip/"));

        RegisterAccount registerAccount = new RegisterAccount();

        when(swagger).attemptsTo(
                Register.theUser(registerAccount),
                Ensure.that(WELCOME_POPUP).isEnabled()
        );

    }

    @Test
    public void bLoginWithAccountHasBalanceCase1(){
        swagger.can(BrowseTheWeb.with(mightyBrowser));
        swagger.attemptsTo(Open.url("https://lucky88.vip/"));

        LoginAccount loginAccount = new LoginAccount();

        when(swagger).attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Ensure.thatTheCurrentPage().currentUrl().contains(CONTAINS_NOHU)
        );
    }

    @Test
    public void bLoginWithAccountNonBalanceCase1(){
        swagger.can(BrowseTheWeb.with(mightyBrowser));
        swagger.attemptsTo(Open.url("https://lucky88.vip/"));
        LoginAccount loginAccount = new LoginAccount();

        when(swagger).attemptsTo(
                Login.theAccountNonBalance(loginAccount),
                Ensure.thatTheCurrentPage().currentUrl().contains(CONTAINS_DEPOSIT)
        );
    }
}
