package net.creqavn.features.mayman;

import net.creqavn.models.LoginAccount;
import net.creqavn.models.RegisterAccount;
import net.creqavn.questions.TheFootball;
import net.creqavn.tasks.*;
import net.creqavn.tasks.Switch;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;


import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.Before;
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

    @Before
    public void setUp() {
        swagger.attemptsTo(Open.url(DOMAIN));
    }


    @Test
    public void RegisterNewAccount() {
        RegisterAccount registerAccount = new RegisterAccount();
        when(swagger).attemptsTo(
                Register.theUser(registerAccount),
                Ensure.that(WELCOME_POPUP).isEnabled()
        );
    }


    @Test
    public void LoginWithAccountHasBalance() {
        LoginAccount loginAccount = new LoginAccount();

        when(swagger).attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                WaitForLoad.theURL(DOMAIN)
        );
    }


    @Test
    public void LoginWithAccountNonBalance() {
        LoginAccount loginAccount = new LoginAccount();

        when(swagger).attemptsTo(
                Login.theAccountNonBalance(loginAccount),
                WaitForLoad.theURL(CONTAINS_DEPOSIT)
        );
    }


    @Test
    public void AccessFunctionWithAccountHasBalance() {
        LoginAccount loginAccount = new LoginAccount();

        when(swagger).attemptsTo(
                Click.on(GAME_BAI_BTN),
                Click.on(GAME_BAI_TLMN),
                Login.theAccountHasBalanceOnPopup(loginAccount),
                WaitForLoad.theURL(CONTAINS_GAME_BAI)
        );
    }


    @Test
    public void AccessFunctionWithAccountNonBalance() {
        LoginAccount loginAccount = new LoginAccount();

        when(swagger).attemptsTo(
                Click.on(GAME_BAI_BTN),
                Click.on(GAME_BAI_TLMN),
                Login.theAccountNonBalanceOnPopup(loginAccount),
                Click.on(GAME_BAI_TLMN),
                WaitForLoad.theURL(CONTAINS_GAME_BAI),
                Ensure.that(POPUP_DEPOSIT).isDisplayed()
        );
    }


    @Test
    public void ForgetPassword() {
        when(swagger).attemptsTo(
                Click.on(FORGET_PWD_BTN),
                Enter.keyValues(VERIFIED_EMAIL).into(EMAIL_RESTORE_FIELD),
                Click.on(EMAIL_RESTORE_BTN),
                Ensure.that(RESTORE_NOTIFY).isDisplayed()
        );
    }


    @Test
    public void LogOut() {
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
        when(swagger).attemptsTo(
                Click.on(FIRST_SWIPER_PAGINATION),
                Click.on(FIRST_HERO_BANNER),
                WaitForLoad.theURL(CONTAINS_HERO_BANNER)
        );
    }


    @Test
    public void HomepageCashBack() {
        LoginAccount loginAccount = new LoginAccount();

        when(swagger).attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Ensure.that(BALANCE_NUMBER).text().isEqualTo("200")
        );
    }


    @Test
    public void HomepageLiveCasino() {
        LoginAccount loginAccount = new LoginAccount();

        when(swagger).attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Scroll.to(FIRST_HOMEPAGE_CASINO),
                Click.on(FIRST_HOMEPAGE_CASINO),
                Switch.toNewWindow()
        );
        when(swagger).attemptsTo(
                WaitForLoad.theURL(CONTAINS_EZUGI_CASINO),
                Switch.closeCurrentWindowsAndSwitchBackToRemainingWindows()
        );
    }


    @Test
    public void HomepageSieuPhamHoiTu() {
        swagger.attemptsTo(
                HoverOverElement.over(SU_KIEN_HOT_BTN),
                Click.on(SIEU_PHAM_HOI_TU_BTN)
        );
        swagger.attemptsTo(
                WaitForLoad.theURL(CONTAINS_SIEU_PHAM_HOI_TU)
        );
    }


    @Test
    public void HomepageNewsDetail() {
        swagger.attemptsTo(
                SwipeTo.theBottom(),
                Click.on(HOT_NEWS)
        );
        swagger.attemptsTo(
                WaitForLoad.theURL(CONTAINS_NEWS)
        );
    }


    @Test
    public void HomepageAboutUs() {
        swagger.attemptsTo(
                SwipeTo.theBottom(),
                Click.on(ABOUT_US)
        );
        swagger.attemptsTo(
                WaitForLoad.theURL(CONTAINS_ABOUT_US)
        );
    }


    @Test
    public void HomepageTyLeKeo() {
        swagger.attemptsTo(
                SwipeTo.theBottom(),
                Click.on(TY_LE_KEO_BTN)
        );
        swagger.attemptsTo(
                WaitForLoad.theURL(CONTAINS_TY_LE_KEO)

        );
    }


    @Test
    public void HomepageTerms() {
        swagger.attemptsTo(
                SwipeTo.theBottom(),
                Click.on(TERMS_BTN)
        );
        swagger.attemptsTo(
                WaitForLoad.theURL(CONTAINS_TERMS)

        );
    }


    @Test
    public void HomepagePrivacyPolicy() {
        swagger.attemptsTo(
                SwipeTo.theBottom(),
                Click.on(PRIVACY_POLICY_BTN)
        );
        swagger.attemptsTo(
                WaitForLoad.theURL(CONTAINS_PRIVACY_POLICY)
        );
    }


    @Test
    public void HomepageQuestion() {
        swagger.attemptsTo(
                SwipeTo.theBottom(),
                Click.on(QUESTION_BTN)
        );
        swagger.attemptsTo(
                WaitForLoad.theURL(CONTAINS_QUESTION),
                Click.on(FIRST_QUESTION),
                Ensure.that(FIRST_ANSWER).isDisplayed()
        );
    }


    @Test
    public void HomepagePromotionInfomation() {
        swagger.attemptsTo(
                SwipeTo.theBottom(),
                Click.on(PROMOTION_INFOR_BTN)
        );
        swagger.attemptsTo(
                WaitForLoad.theURL(CONTAINS_PROMOTION_INFO)
        );
    }


    @Test
    public void HomepageContact(){
        swagger.attemptsTo(
                SwipeTo.theBottom(),
                Click.on(CONTACT_BTN),
                WaitForLoad.theURL(CONTAINS_CONTACT)
        );
    }


    @Test
    public void HomepageJackpot() throws InterruptedException {
        LoginAccount loginAccount = new LoginAccount();
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Scroll.to(JACKPOT_FORM)
        );
        swagger.attemptsTo(
                Click.on(JACKPOT_FIRST_GAME),
                Switch.toNewWindow()
        );
        swagger.attemptsTo(
                WaitForLoad.theURL("https://games.mt-sta.com/kts"),
                Switch.closeCurrentWindowsAndSwitchBackToRemainingWindows()
        );
        sleep(15000);
        swagger.attemptsTo(
                Ensure.that(JACKPOT_RECENT).text().isNotEmpty(),
                Ensure.that(JACKPOT_MONTH).text().isNotEmpty(),
                Ensure.that(JACKPOT_FISH).text().isNotEmpty(),
                Ensure.that(JACKPOT_NUMBER).text().isNotEmpty()
        );
    }


    @Test
    public void AccountInfor() {
        LoginAccount loginAccount = new LoginAccount();
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(AVATAR_USER),
                WaitForLoad.theURL(CONTAINS_PROFILE),
                Ensure.that(PROFILE_USERNAME).isDisplayed(),
                Ensure.that(PROFILE_PWD).isDisplayed(),
                Ensure.that(PROFILE_DISPLAY_NAME).isDisplayed()
        );
    }


    @Test
    public void AccountChangePassword() {
        LoginAccount loginAccount = new LoginAccount();
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(AVATAR_USER),
                Click.on(CHANGE_PWD_BTN),
                Ensure.that(CURRENT_PWD_FIELD).isDisplayed(),
                Ensure.that(NEW_PWD_FIELD).isDisplayed(),
                Ensure.that(CONFIRM_NEW_PWD_FIELD).isDisplayed(),
                Ensure.that(CHANGE_PWD_SUBMIT_BTN).isDisplayed()
        );
    }


    @Test
    public void AccountVerifyPhoneNumber() {
        LoginAccount loginAccount = new LoginAccount();
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(AVATAR_USER),
                Click.on(VERIFY_PHONE_NUMBER_BTN),
                Ensure.that(VERIFY_PHONE_NUMBER_NOW_BTN).isDisplayed()
        );
    }

/*
    @Test
    public void zAccountVerifyEmail() {
        LoginAccount loginAccount = new LoginAccount();
        swagger.attemptsTo(
                Login.theAccountJustRegistered(loginAccount),
                Click.on(AVATAR_USER),
                Enter.keyValues(GenerateRandomValue.generateEmail()).into(PROFILE_EMAIL),
                Click.on(VERIFY_EMAIL_BTN),
                Ensure.that(EMAIL_CONFIRM_NOTIFICATION).isDisplayed()
        );
    }
*/

    @Test
    public void AccountBankAccount() {
        LoginAccount loginAccount = new LoginAccount();
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(AVATAR_USER),
                Click.on(BANK_BTN),
                Click.on(ADD_BANK_ACCOUNT_BTN),
                Ensure.that(FORM_BANK_ACCOUNT).isDisplayed()
        );
    }


    @Test
    public void AccountBonus() {
        LoginAccount loginAccount = new LoginAccount();
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(AVATAR_USER),
                Click.on(BONUS_BTN),
                Ensure.that(BONUS_INFO).isDisplayed()
        );
    }


    @Test
    public void HomepageHotMatch() {
        WaitForLoad.thePage(LEFT_FOOTBALL_TEAM);
        String leftTeam = swagger.asksFor(TheFootball.name(LEFT_FOOTBALL_TEAM));
        String rightTeam = swagger.asksFor(TheFootball.name(RIGHT_FOOTBAL_TEAM));
        swagger.attemptsTo(
                Click.on(HOT_MATCH_BET_BTN)

        );
        swagger.attemptsTo(
                Switch.toFrame(FIRST_IFRAME),
                Ensure.that(HOT_MATCH_LEFT_TEAM).text().isEqualTo(leftTeam),
                Ensure.that(HOT_MATCH_RIGHT_TEAM).text().isEqualTo(rightTeam)
        );
    }


    @Test
    public void SportK(){
        LoginAccount loginAccount = new LoginAccount();
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(SPORT_BTN),
                Browser.refreshPage(),
                Click.on(SPORT_K_BTN),
                Switch.toFrame(FIRST_IFRAME),
                Ensure.that(SPORT_K_VERIFY).isDisplayed()
        );
    }


    @Test
    public void SportI(){
        LoginAccount loginAccount = new LoginAccount();
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(SPORT_BTN),
                Click.on(SPORT_I_BTN),
                Switch.toFrame(FIRST_IFRAME),
                Ensure.that(SPORT_I_VERIFY).isDisplayed()
        );
    }


//    @Test
//    public void SportA(){
//        LoginAccount loginAccount = new LoginAccount();
//        swagger.attemptsTo(
//                Login.theAccountHasBalance(loginAccount),
//                Click.on(SPORT_BTN),
//                Click.on(SPORT_A_BTN),
//                Switch.toFrame(FIRST_IFRAME),
//                Ensure.that(SPORT_A_VERIFY).isDisplayed()
//        );
//    }


//    @Test
//    public void SportC(){
//        LoginAccount loginAccount = new LoginAccount();
//        swagger.attemptsTo(
//                Login.theAccountHasBalance(loginAccount),
//                Click.on(SPORT_BTN),
//                Click.on(SPORT_C_BTN),
//                Switch.toFrame(FIRST_IFRAME),
//                Ensure.that(SPORT_C_VERIFY).isDisplayed()
//        );
//    }


//    @Test
//    public void SportM(){
//        LoginAccount loginAccount = new LoginAccount();
//        swagger.attemptsTo(
//                Login.theAccountHasBalance(loginAccount),
//                Click.on(SPORT_BTN),
//                Click.on(SPORT_M_BTN),
//                Switch.toFrame(FIRST_IFRAME),
//                Ensure.that(SPORT_M_VERIFY).isDisplayed()
//        );
//    }
}
