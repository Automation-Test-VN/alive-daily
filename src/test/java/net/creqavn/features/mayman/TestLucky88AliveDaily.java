package net.creqavn.features.mayman;

import net.creqavn.models.LoginAccount;
import net.creqavn.models.RegisterAccount;
import net.creqavn.questions.TheFootball;
import net.creqavn.tasks.*;
import net.creqavn.tasks.SwitchTo;
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
    static RegisterAccount registerAccount = new RegisterAccount();
    static LoginAccount loginAccount = new LoginAccount();

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
        when(swagger).attemptsTo(
                Register.theUser(registerAccount),
                Verify.theElementIsDisplayed(WELCOME_POPUP)
        );
    }

    @Test
    public void LoginWithAccountHasBalance() {
        when(swagger).attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                WaitForLoad.theURL(DOMAIN),
                Verify.theElementIsDisplayed(AVATAR_USER)
        );
    }

    @Test
    public void LoginWithAccountNonBalance() {
        when(swagger).attemptsTo(
                Login.theAccountNonBalance(loginAccount),
                WaitForLoad.theURL(CONTAINS_DEPOSIT),
                Ensure.that(AVATAR_USER).isDisplayed()
        );
    }

    @Test
    public void AccessFunctionWithAccountHasBalance() {
        when(swagger).attemptsTo(
                Click.on(GAME_BAI_BTN),
                Click.on(GAME_BAI_TLMN),
                Login.theAccountHasBalanceOnPopup(loginAccount),
                WaitForLoad.theURL(CONTAINS_GAME_BAI)
        );
    }

    @Test
    public void AccessFunctionWithAccountNonBalance() {
        when(swagger).attemptsTo(
                Click.on(GAME_BAI_BTN),
                Click.on(GAME_BAI_TLMN),
                Login.theAccountNonBalanceOnPopup(loginAccount),
                Click.on(GAME_BAI_TLMN),
                WaitForLoad.theURL(CONTAINS_GAME_BAI),
                Verify.theElementIsDisplayed(POPUP_DEPOSIT)
        );
    }

    @Test
    public void ForgetPassword() {
        when(swagger).attemptsTo(
                Click.on(FORGET_PWD_BTN),
                Enter.keyValues(registerAccount.getEmail()).into(EMAIL_RESTORE_FIELD),
                Click.on(EMAIL_RESTORE_BTN),
                Verify.theElementIsDisplayed(RESTORE_NOTIFY)
        );
    }

    @Test
    public void LogOut() {
        when(swagger).attemptsTo(
                Login.theAccountNonBalance(loginAccount),
                Click.on(AVATAR_USER),
                Click.on(LOGOUT_BTN),
                Verify.theElementIsDisplayed(LOGIN_USERNAME)
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
        when(swagger).attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Verify.theTextIsEqual(BALANCE_NUMBER,"200")
        );
    }

    @Test
    public void HomepageLiveCasino() {
        when(swagger).attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                SwipeTo.theBottom(),
                Click.on(FIRST_HOMEPAGE_CASINO),
                SwitchTo.newWindow(),
                WaitForLoad.theURL(CONTAINS_EZUGI_CASINO),
                SwitchTo.mainWindowAfterCloseCurrentWindow()
        );
    }

    @Test
    public void HomepageSieuPhamHoiTu() {
        swagger.attemptsTo(
                HoverOverElement.over(SU_KIEN_HOT_BTN),
                Click.on(SIEU_PHAM_HOI_TU_BTN),
                WaitForLoad.theURL(CONTAINS_SIEU_PHAM_HOI_TU)
        );
    }

    @Test
    public void HomepageNewsDetail() {
        swagger.attemptsTo(
                SwipeTo.theBottom(),
                Click.on(HOT_NEWS),
                WaitForLoad.theURL(CONTAINS_NEWS)
        );
    }

    @Test
    public void HomepageAboutUs() {
        swagger.attemptsTo(
                SwipeTo.theBottom(),
                Click.on(ABOUT_US),
                WaitForLoad.theURL(CONTAINS_ABOUT_US)
        );
    }

    @Test
    public void HomepageTyLeKeo() {
        swagger.attemptsTo(
                SwipeTo.theBottom(),
                Click.on(TY_LE_KEO_BTN),
                WaitForLoad.theURL(CONTAINS_TY_LE_KEO)
        );
    }

    @Test
    public void HomepageTerms() {
        swagger.attemptsTo(
                SwipeTo.theBottom(),
                Click.on(TERMS_BTN),
                WaitForLoad.theURL(CONTAINS_TERMS)
        );
    }

    @Test
    public void HomepagePrivacyPolicy() {
        swagger.attemptsTo(
                SwipeTo.theBottom(),
                Click.on(PRIVACY_POLICY_BTN),
                WaitForLoad.theURL(CONTAINS_PRIVACY_POLICY)
        );
    }

    @Test
    public void HomepageQuestion() {
        swagger.attemptsTo(
                SwipeTo.theBottom(),
                Click.on(QUESTION_BTN),
                WaitForLoad.theURL(CONTAINS_QUESTION),
                Click.on(FIRST_QUESTION),
                Verify.theElementIsDisplayed(FIRST_ANSWER)
        );
    }

    @Test
    public void HomepagePromotionInfomation() {
        swagger.attemptsTo(
                SwipeTo.theBottom(),
                Click.on(PROMOTION_INFOR_BTN),
                WaitForLoad.theURL(CONTAINS_PROMOTION_INFO)
        );
    }

    @Test
    public void HomepageContact() {
        swagger.attemptsTo(
                SwipeTo.theBottom(),
                Click.on(CONTACT_BTN),
                WaitForLoad.theURL(CONTAINS_CONTACT)
        );
    }

    @Test
    public void HomepageJackpot() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Scroll.to(JACKPOT_AREA),
                Click.on(JACKPOT_FIRST_GAME),
                SwitchTo.newWindow(),
                WaitForLoad.theURL("https://games.mt-sta.com/kts"),
                SwitchTo.mainWindowAfterCloseCurrentWindow()
        );
//        sleep(20000);
        swagger.attemptsTo(
                Verify.theValueIsNotEmpty(JACKPOT_RECENT),
                Verify.theValueIsNotEmpty(JACKPOT_MONTH),
                Verify.theValueIsNotEmpty(JACKPOT_FISH),
                Verify.theValueIsNotEmpty(JACKPOT_NUMBER)
        );
    }

    @Test
    public void AccountInfor() {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(AVATAR_USER),
                WaitForLoad.theURL(CONTAINS_PROFILE),
                Verify.theElementIsDisplayed(PROFILE_USERNAME),
                Verify.theElementIsDisplayed(PROFILE_PWD),
                Verify.theElementIsDisplayed(PROFILE_DISPLAY_NAME)
        );
    }

    @Test
    public void AccountChangePassword() {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(AVATAR_USER),
                Click.on(CHANGE_PWD_BTN),
                Verify.theElementIsDisplayed(CURRENT_PWD_FIELD),
                Verify.theElementIsDisplayed(NEW_PWD_FIELD),
                Verify.theElementIsDisplayed(CONFIRM_NEW_PWD_FIELD),
                Verify.theElementIsDisplayed(CHANGE_PWD_SUBMIT_BTN)
        );
    }

    @Test
    public void AccountVerifyPhoneNumber() {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(AVATAR_USER),
                Click.on(VERIFY_PHONE_NUMBER_BTN),
                Verify.theElementIsDisplayed(VERIFY_PHONE_NUMBER_NOW_BTN)
        );
    }

    @Test
    public void zAccountVerifyEmail() {
        LoginAccount loginAccount = new LoginAccount(registerAccount.getUserName());
        swagger.attemptsTo(
                Login.theAccountJustRegistered(loginAccount),
                Click.on(AVATAR_USER),
                Enter.keyValues(EMAIL_VERIFY).into(PROFILE_EMAIL),
                Click.on(VERIFY_EMAIL_BTN),
                Verify.theElementIsDisplayed(EMAIL_CONFIRM_NOTIFICATION)
        );
    }

    @Test
    public void AccountBankAccount() {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(AVATAR_USER),
                Click.on(BANK_BTN),
                Click.on(ADD_BANK_ACCOUNT_BTN),
                Verify.theElementIsDisplayed(FORM_BANK_ACCOUNT)
        );
    }

    @Test
    public void AccountBonus() {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(AVATAR_USER),
                Click.on(BONUS_BTN),
                Verify.theElementIsDisplayed(BONUS_INFO)
        );
    }


    @Test
    public void HomepageHotMatch() {
        WaitForLoad.thePage(LEFT_FOOTBALL_TEAM);
        String leftTeam = swagger.asksFor(TheFootball.name(LEFT_FOOTBALL_TEAM));
        String rightTeam = swagger.asksFor(TheFootball.name(RIGHT_FOOTBAL_TEAM));
        swagger.attemptsTo(
                Click.on(HOT_MATCH_BET_BTN),
                Switch.toFrame(FIRST_IFRAME),
                Verify.theTextIsEqual(HOT_MATCH_LEFT_TEAM,leftTeam),
                Verify.theTextIsEqual(HOT_MATCH_RIGHT_TEAM,rightTeam)
        );
    }

    @Test
    public void SportK() {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(SPORT_BTN),
                Browser.refreshPage(),
                WaitForLoad.thePage(SPORT_K_BTN),
                Click.on(SPORT_K_BTN),
                Switch.toFrame(FIRST_IFRAME),
                Verify.theElementIsDisplayed(SPORT_K_VERIFY)
        );
    }

    @Test
    public void SportI() {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(SPORT_BTN),
                Click.on(SPORT_I_BTN),
                Switch.toFrame(FIRST_IFRAME),
                Verify.theElementIsDisplayed(SPORT_I_VERIFY)
        );
    }

    @Test
    public void SportA() {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(SPORT_BTN),
                Click.on(SPORT_A_BTN),
                Switch.toFrame(FIRST_IFRAME),
                Switch.toFrame(SPORT_IFRAME),
                Verify.theElementIsDisplayed(SPORT_A_VERIFY)
        );
    }

    @Test
    public void SportC() {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(SPORT_BTN),
                Click.on(SPORT_C_BTN),
                Switch.toFrame(FIRST_IFRAME),
                Verify.theElementIsDisplayed(SPORT_C_VERIFY)
        );
    }

    @Test
    public void SportM() {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(SPORT_BTN),
                Click.on(SPORT_M_BTN),
                Switch.toFrame(FIRST_IFRAME),
                Verify.theElementIsDisplayed(SPORT_M_VERIFY)
        );
    }

    @Test
    public void SportHotDeal() {
        swagger.attemptsTo(
                HoverOverElement.over(SPORT_BTN),
                Click.on(SPORT_HOT_DEAL_BTN),
                Verify.theElementIsDisplayed(SPORT_HOT_DEAL_VERIFY)
        );
    }

    @Test
    public void SportVirtual() {
        swagger.attemptsTo(
                HoverOverElement.over(SPORT_BTN),
                Click.on(SPORT_VIRTUAL_BTN),
                SwitchTo.newWindow(),
                Switch.toFrame(SPORT_IFRAME),
                Verify.theElementIsDisplayed(SPORT_VIRTUAL_VERIFY),
                SwitchTo.mainWindowAfterCloseCurrentWindow()
        );
    }

    @Test
    public void SportESport() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                HoverOverElement.over(SPORT_BTN),
                Click.on(SPORT_E_SPORT_BTN)
        );
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(SPORT_E_SPORT_VERIFY),
                SwitchTo.mainWindowAfterCloseCurrentWindow()
        );
    }

    @Test
    public void SportHorseRacing() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                HoverOverElement.over(SPORT_BTN),
                Click.on(SPORT_HORSE_RACING_BTN)
        );
        sleep(3000);
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                WaitForLoad.theURL(CONTAINS_HORSE_RACING),
                SwitchTo.mainWindowAfterCloseCurrentWindow()
        );
    }

    @Test
    public void CasinoVivo() {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(LIVE_CASINO_BTN),
                Click.on(VIVO_CASINO_BTN),
                Click.on(FIRST_TABLE_PLAY_BTN),
                SwitchTo.newWindow(),
                WaitForLoad.thePage(VIVO_CASINO_VERIFY),
                Verify.theElementIsDisplayed(VIVO_CASINO_VERIFY),
                SwitchTo.mainWindowAfterCloseCurrentWindow()
        );
    }

    @Test
    public void CasinoMG() {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(LIVE_CASINO_BTN),
                Click.on(MG_CASINO_BTN),
                Click.on(FIRST_TABLE_PLAY_BTN),
                SwitchTo.newWindow(),
                WaitForLoad.theURL(CONTAINS_MG_CASINO),
                Verify.theElementIsDisplayed(MG_CASINO_VERIFY),
                SwitchTo.mainWindowAfterCloseCurrentWindow()
        );
    }

    @Test
    public void CasinoEzugi() {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(LIVE_CASINO_BTN),
                Click.on(EZUGI_CASINO_BTN),
                Click.on(FIRST_TABLE_PLAY_BTN),
                SwitchTo.newWindow(),
                WaitForLoad.theURL(CONTAINS_EZUGI_CASINO),
                Verify.theElementIsDisplayed(EZUGI_CASINO_VERIFY),
                SwitchTo.mainWindowAfterCloseCurrentWindow()
        );
    }

    @Test
    public void CasinoEvolution() {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(LIVE_CASINO_BTN),
                Click.on(EVOLUTION_CASINO_BTN),
                Click.on(FIRST_TABLE_PLAY_BTN),
                SwitchTo.newWindow(),
                Switch.toFrame(EVOLUTION_CASINO_IFRAME.resolveFor(swagger)),
                Verify.theElementIsDisplayed(EVOLUTION_CASINO_VERIFY),
                SwitchTo.mainWindowAfterCloseCurrentWindow()
        );
    }

    @Test
    public void LoDe3Mien(){
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                HoverOverElement.over(LO_DE_BTN),
                Click.on(LO_DE_3_MIEN_BTN),
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(LO_DE_3_MIEN_VERIFY),
                SwitchTo.mainWindowAfterCloseCurrentWindow()
        );
    }
}
