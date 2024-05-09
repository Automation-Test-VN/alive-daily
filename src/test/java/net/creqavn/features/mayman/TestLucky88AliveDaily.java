package net.creqavn.features.mayman;

import net.creqavn.models.LoginAccount;
import net.creqavn.models.RegisterAccount;
import net.creqavn.tasks.Login;
import net.creqavn.tasks.Register;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.WithTag;
import net.serenitybdd.annotations.WithTags;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;


import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;


import static net.creqavn.ui.mayman.Lucky88Elements.*;
import static net.serenitybdd.screenplay.GivenWhenThen.*;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLucky88AliveDaily {
    static Actor swagger = Actor.named("Swagger");

    @Managed(uniqueSession = true)
    public static WebDriver mightyBrowser;

    @BeforeClass
    public static void init(){
        swagger.can(BrowseTheWeb.with(mightyBrowser));
    }


    @WithTags({
            @WithTag("fbc1:mayman"),
    })
    @Test
    public void RegisterNewAccount() {
        swagger.attemptsTo(Open.url(DOMAIN));

        RegisterAccount registerAccount = new RegisterAccount();

        when(swagger).attemptsTo(
                Register.theUser(registerAccount),
                Ensure.that(WELCOME_POPUP).isEnabled()
        );
    }


    @WithTags({
            @WithTag("fbc1:mayman"),
    })
    @Test
    public void LoginWithAccountHasBalance(){
        swagger.attemptsTo(Open.url(DOMAIN));

        LoginAccount loginAccount = new LoginAccount();

        when(swagger).attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Ensure.thatTheCurrentPage().currentUrl().contains(CONTAINS_NOHU)
        );
    }


    @WithTags({
            @WithTag("fbc1:mayman"),
    })
    @Test
    public void LoginWithAccountNonBalance(){
        swagger.attemptsTo(Open.url(DOMAIN));
        LoginAccount loginAccount = new LoginAccount();

        when(swagger).attemptsTo(
                Login.theAccountNonBalance(loginAccount),
                Ensure.thatTheCurrentPage().currentUrl().contains(CONTAINS_DEPOSIT)
        );
    }


    @WithTags({
            @WithTag("fbc1:mayman"),
    })
    @Test
    public void AccessFunctionWithAccountHasBalance(){
        swagger.attemptsTo(Open.url(DOMAIN));

        LoginAccount loginAccount = new LoginAccount();

        when(swagger).attemptsTo(
                Click.on(GAME_BAI_BTN),
                Click.on(GAME_BAI_TLMN),
                Login.theAccountHasBalanceOnPopup(loginAccount),
                Ensure.thatTheCurrentPage().currentUrl().contains(CONTAINS_GAME_BAI)
        );
    }


    @WithTags({
            @WithTag("fbc1:mayman"),
    })
    @Test
    public void AccessFunctionWithAccountNonBalance(){
        swagger.attemptsTo(Open.url(DOMAIN));

        LoginAccount loginAccount = new LoginAccount();

        when(swagger).attemptsTo(
                Click.on(GAME_BAI_BTN),
                Click.on(GAME_BAI_TLMN),
                Login.theAccountNonBalanceOnPopup(loginAccount),
                Ensure.thatTheCurrentPage().currentUrl().contains(CONTAINS_GAME_BAI),
                Ensure.that(POPUP_DEPOSIT).isDisplayed()
        );
    }


    @WithTags({
            @WithTag("fbc1:mayman"),
    })
    @Test
    public void ForgetPassword(){
        swagger.attemptsTo(Open.url(DOMAIN));

        when(swagger).attemptsTo(
                Click.on(FORGET_PWD_BTN),
                Enter.keyValues(VERIFIED_EMAIL).into(EMAIL_RESTORE_FIELD),
                Click.on(EMAIL_RESTORE_BTN),
                Ensure.that(RESTORE_NOTIFY).isDisplayed()
        );
    }


    @WithTags({
            @WithTag("fbc1:mayman"),
    })
    @Test
    public void LogOut(){
        swagger.attemptsTo(Open.url(DOMAIN));
        LoginAccount loginAccount = new LoginAccount();

        when(swagger).attemptsTo(
                Login.theAccountNonBalance(loginAccount),
                Click.on(AVATAR_USER),
                Click.on(LOGOUT_BTN),
                Ensure.that(LOGIN_USERNAME).isDisplayed()
        );
    }
}
