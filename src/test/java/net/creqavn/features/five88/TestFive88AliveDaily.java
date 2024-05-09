package net.creqavn.features.five88;

import net.creqavn.Account;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import static net.creqavn.ui.five88.HomePageUI.*;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestFive88AliveDaily {

    static Actor jacob = Actor.named("Jacob");

    @Managed(uniqueSession = true)
    public static WebDriver mightyBrowser;

    @Before
    public void jacobBrowser(){
        jacob.can(BrowseTheWeb.with(mightyBrowser));
        jacob.attemptsTo(Open.url("https://five88.vin/"));
    }

    @Test
    public void WhenRegisteringAccount_ShouldSeeDepositPage(){

        Account account = new Account();

        jacob.attemptsTo(
                Click.on(REGISTER_BUTTON),
                Enter.theValue(account.getUsername()).into(REGISTER_FORM.of(USER_NAME)),
                Enter.theValue(account.getPassword()).into(REGISTER_FORM.of(PASSWORD)),
                Enter.theValue(account.getPhoneNumber()).into(REGISTER_FORM.of(PHONE_NUMBER)),
                Click.on(SUBMIT_BUTTON),
                //Ensure.that(MENU_RAR.of("Nạp tiền")).isDisplayed(),
                Ensure.that(ACCOUNT_NAME).hasText(account.getUsername().toUpperCase()),
                Ensure.that(ACTIVE_MENU).hasText(DEPOSIT.toUpperCase()),
                Ensure.that(TheWebPage.currentUrl()).endsWith("deposit.aspx")
        );
    }

}
