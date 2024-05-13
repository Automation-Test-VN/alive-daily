package net.creqavn.features.mayman;

import net.creqavn.models.LoginAccount;
import net.creqavn.models.RegisterAccount;
import net.creqavn.tasks.Login;
import net.creqavn.tasks.Register;
import net.creqavn.tasks.SwipeTo;
import net.creqavn.tasks.Switcher;
import net.serenitybdd.annotations.Managed;
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


import static java.lang.Thread.sleep;
import static net.creqavn.ui.mayman.Lucky88Elements.*;
import static net.serenitybdd.screenplay.GivenWhenThen.when;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLucky88AliveDaily {
    static Actor swagger = Actor.named("Swagger");

    @Managed(uniqueSession = true)
    public static WebDriver mightyBrowser;

    @BeforeClass
    public static void init() {
        swagger.can(BrowseTheWeb.with(mightyBrowser));
    }

    @Test()
    public void RegisterNewAccount() {
        swagger.attemptsTo(Open.url(DOMAIN));

        RegisterAccount registerAccount = new RegisterAccount();

        when(swagger).attemptsTo(
                Register.theUser(registerAccount),
                Ensure.that(WELCOME_POPUP).isEnabled()
        );
    }


    @Test
    public void LoginWithAccountHasBalance() {
        swagger.attemptsTo(Open.url(DOMAIN));

        LoginAccount loginAccount = new LoginAccount();

        when(swagger).attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Ensure.thatTheCurrentPage().currentUrl().contains(CONTAINS_NOHU)
        );
    }


    @Test
    public void LoginWithAccountNonBalance() {
        swagger.attemptsTo(Open.url(DOMAIN));
        LoginAccount loginAccount = new LoginAccount();

        when(swagger).attemptsTo(
                Login.theAccountNonBalance(loginAccount),
                Ensure.thatTheCurrentPage().currentUrl().contains(CONTAINS_DEPOSIT)
        );
    }


    @Test
    public void AccessFunctionWithAccountHasBalance() {
        swagger.attemptsTo(Open.url(DOMAIN));

        LoginAccount loginAccount = new LoginAccount();

        when(swagger).attemptsTo(
                Click.on(GAME_BAI_BTN),
                Click.on(GAME_BAI_TLMN),
                Login.theAccountHasBalanceOnPopup(loginAccount),
                Ensure.thatTheCurrentPage().currentUrl().contains(CONTAINS_GAME_BAI)
        );
    }


    @Test
    public void AccessFunctionWithAccountNonBalance() {
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

    @Test
    public void ForgetPassword() {
        swagger.attemptsTo(Open.url(DOMAIN));

        when(swagger).attemptsTo(
                Click.on(FORGET_PWD_BTN),
                Enter.keyValues(VERIFIED_EMAIL).into(EMAIL_RESTORE_FIELD),
                Click.on(EMAIL_RESTORE_BTN),
                Ensure.that(RESTORE_NOTIFY).isDisplayed()
        );
    }

    @Test
    public void LogOut() {
        swagger.attemptsTo(Open.url(DOMAIN));
        LoginAccount loginAccount = new LoginAccount();

        when(swagger).attemptsTo(
                Login.theAccountNonBalance(loginAccount),
                Click.on(AVATAR_USER),
                Click.on(LOGOUT_BTN),
                Ensure.that(LOGIN_USERNAME).isDisplayed()
        );
    }

    @Test
    public void HomepageHeroBanner() {
        swagger.attemptsTo(Open.url(DOMAIN));
        when(swagger).attemptsTo(
                Click.on(FIRST_SWIPER_PAGINATION),
                Click.on(FIRST_HERO_BANNER),
                Ensure.thatTheCurrentPage().currentUrl().contains(CONTAINS_HERO_BANNER)
        );
    }

    /*
    @Test
    public void HomepageCashBlack(){
        swagger.attemptsTo(Open.url(DOMAIN));
        LoginAccount loginAccount = new LoginAccount();

        when(swagger).attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Ensure.that(BALANCE_NUMBER).text().isEqualTo("200")
        );
    }
     */

    @Test
    public void HomepageLiveCasino() throws InterruptedException {
        swagger.attemptsTo(Open.url(DOMAIN));

        LoginAccount loginAccount = new LoginAccount();

        when(swagger).attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Scroll.to(FIRST_HOMEPAGE_CASINO),
                Click.on(FIRST_HOMEPAGE_CASINO),
                Switcher.toNewWindow()
        );
        sleep(5000);
        when(swagger).attemptsTo(
                Ensure.thatTheCurrentPage().currentUrl().contains(CONTAINS_EZUGI_CASINO),
                Switcher.closeCurrentWindowsAndSwitchBackToRemainingWindows()
        );
    }

    @Test
    public void HomepageSieuPhamHoiTu() throws InterruptedException {
        swagger.attemptsTo(
                Open.url(DOMAIN),
                HoverOverElement.over(SU_KIEN_HOT_BTN),
                Click.on(SIEU_PHAM_HOI_TU_BTN)
        );
        sleep(3000);
        swagger.attemptsTo(
                Ensure.thatTheCurrentPage().currentUrl().contains(CONTAINS_SIEU_PHAM_HOI_TU)
        );
    }

    @Test
    public void HomepageNewsDetail() throws InterruptedException {
        swagger.attemptsTo(
                Open.url(DOMAIN),
                SwipeTo.theBottom(),
                Click.on(HOT_NEWS)
        );
        sleep(3000);
        swagger.attemptsTo(
                Ensure.thatTheCurrentPage().currentUrl().contains(CONTAINS_NEWS)
        );
    }

    @Test
    public void HomepageAboutUs() throws InterruptedException {

        swagger.attemptsTo(
                Open.url(DOMAIN),
                SwipeTo.theBottom(),
                Click.on(ABOUT_US)
        );
        sleep(3000);
        swagger.attemptsTo(
            Ensure.thatTheCurrentPage().currentUrl().contains(CONTAINS_ABOUT_US)
        );
    }

}
