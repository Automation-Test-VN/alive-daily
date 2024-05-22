package net.creqavn.features.Leo;

import net.creqavn.models.LoginAccount;
import net.creqavn.models.RegisterAccount;
import net.creqavn.tasks.*;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;
import static net.creqavn.ui.leo.LeoElements.*;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLeoAliveDaily {
    static Actor swagger = Actor.named("Swagger");
    static RegisterAccount registerAccount = new RegisterAccount();
    static LoginAccount loginAccount = new LoginAccount(SIGN_IN_USERNAME, VALID_ACCOUNT, SIGN_IN_PWD, SIGN_IN_SUBMIT, LOGGED_USER);
    static LoginAccount loginInvalidAccount = new LoginAccount(SIGN_IN_USERNAME, INVALID_ACCOUNT, SIGN_IN_PWD, SIGN_IN_SUBMIT, LOGGED_USER);

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

    @After
    public void tearDown() {
        swagger.attemptsTo(SwitchTo.mainWindowAfterCloseCurrentWindow());
    }

    @Test
    public void Register() {
        swagger.attemptsTo(
                Click.on(SIGN_UP_BTN),
                Register.theUserLeo(registerAccount)
        );
    }

    @Test
    public void LoginTheValidAccount(){
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theValidAccount(loginAccount)
        );
    }

    @Test
    public void LoginTheInvalidAccount(){
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theInvalidAccount(loginInvalidAccount)
        );
    }

    @Test
    public void LoginTheValidAccountOnPopup(){
        swagger.attemptsTo(
                Click.on(LIVE_CASINO_BTN),
                Click.on(EVOLUTION_CASINO_BTN),
                JavaScriptClick.on(LIVE_CASINO_INDEX_PLAY_BTN.of("1")),
                Login.theValidAccount(loginAccount)
        );
    }

    @Test
    public void LoginTheInvalidAccountOnPopup(){
        swagger.attemptsTo(
                Click.on(LIVE_CASINO_BTN),
                Click.on(EVOLUTION_CASINO_BTN),
                JavaScriptClick.on(LIVE_CASINO_INDEX_PLAY_BTN.of("1")),
                Login.theInvalidAccount(loginInvalidAccount)
        );
    }

    @Test
    public void ForgetPassword() {
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Click.on(FORGET_PWD),
                Enter.keyValues(VALID_ACCOUNT).into(SIGN_IN_USERNAME),
                Click.on(FORGET_PWD_SUBMIT),
                Verify.theTextIsEqual(PWD_RECOVERY_NOTY, PWD_RECOVERY_TEXT)
        );
    }

    @Test
    public void LogOut() {
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theInvalidAccount(loginInvalidAccount),
                Click.on(LOGGED_USER),
                Click.on(LOGOUT_BTN),
                Verify.theElementIsDisplayed(SIGN_IN_BTN)
        );
    }

    @Test
    public void HomepageHeroBanner(){
        swagger.attemptsTo(
                Click.on(HERO_BANNER),
                WaitForLoad.theURL(CONTAINS_HERO_BANNER)
        );
    }

    @Test
    public void HomepageSubBanner(){
        swagger.attemptsTo(
                Click.on(SUB_BANNER),
                WaitForLoad.theURL(CONTAIN_SUB_BANNER)
        );
    }

    @Test
    public void HomepageMostPopular(){
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theValidAccount(loginAccount),
                Click.on(MOST_POPULAR_BTN),
                Switch.toFrame(SPORT_K_IFRAME.resolveFor(swagger)),
                Verify.theElementIsDisplayed(SPORT_K_VERIFY)
        );
    }

    @Test
    public void HomepageMostCommon() throws InterruptedException {
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theValidAccount(loginAccount),
                Click.on(MOST_COMMON_BTN)
        );
        sleep(3000);
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(CANVAS)
        );
    }

    @Test
    public void HomepageBestLiveCasino() throws InterruptedException {
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theValidAccount(loginAccount),
                Click.on(BEST_LIVE_CASINO)
        );
        sleep(3000);
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(SA_GAMING_CASINO_VERIFY)
        );
    }

    @Test
    public void HomepageLiveCasino(){
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theInvalidAccount(loginInvalidAccount),
                Click.on(LIVE_CASINO_BTN),
                WaitForLoad.theURL(CONTAINS_LIVE_CASINO)
        );
    }

    @Test
    public void HomepageSports(){
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theInvalidAccount(loginInvalidAccount),
                Click.on(SPORTS_BTN),
                WaitForLoad.theURL(CONTAINS_SPORTS)
        );
    }

    @Test
    public void HomepageCasino(){
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theInvalidAccount(loginInvalidAccount),
                Click.on(CASINO_BTN),
                WaitForLoad.theURL(CONTAINS_CASINO)
        );
    }

    @Test
    public void HomepageLottery(){
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theInvalidAccount(loginInvalidAccount),
                Click.on(LOTTERY_BTN),
                WaitForLoad.theURL(CONTAINS_LOTTERY)
        );
    }

    @Test
    public void HomepageSiamGames(){
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theInvalidAccount(loginInvalidAccount),
                Click.on(SIAM_GAMES_BTN),
                WaitForLoad.theURL(CONTAINS_SIAM_GAMES)
        );
    }

    @Test
    public void HomepageFishing(){
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theInvalidAccount(loginInvalidAccount),
                Click.on(FISHING_BTN),
                WaitForLoad.theURL(CONTAINS_FISHING)
        );
    }

    @Test
    public void HomepageFastGames(){
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theInvalidAccount(loginInvalidAccount),
                Click.on(FAST_GAMES_BTN),
                WaitForLoad.theURL(CONTAINS_FAST_GAMES)
        );
    }

    @Test
    public void HomepageCockFight() throws InterruptedException {
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theInvalidAccount(loginInvalidAccount),
                HoverOverElement.over(COCK_FIGHT_BTN),
                Click.on(COCK_FIGHT_GAME_BTN)
        );
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                WaitForLoad.theURL(CONTAINS_COCK_FIGHT)
        );
    }

    @Test
    public void HomepageVIP(){
        swagger.attemptsTo(
                HoverOverElement.over(OTHERS_BTN),
                Click.on(VIP_BTN),
                WaitForLoad.theURL(CONTAINS_VIP)
        );
    }

    @Test
    public void HomepagePromotion(){
        swagger.attemptsTo(
                HoverOverElement.over(OTHERS_BTN),
                Click.on(PROMOTION_BTN),
                WaitForLoad.theURL(CONTAINS_PROMOTION)
        );
    }

    @Test
    public void HomepageLiveChat() {
        swagger.attemptsTo(
                Click.on(LIVE_CHAT_BTN),
                Switch.toFrame(LIVE_CHAT_IFRAME.resolveFor(swagger)),
                Click.on(LIVE_CHAT_MINIMIZE_BTN)
        );
    }

    @Test
    public void ProfileInfo(){
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theInvalidAccount(loginInvalidAccount),
                Click.on(LOGGED_USER),
                Click.on(USER_INFO_BTN),
                Verify.theElementIsDisplayed(USER_INFO)
        );
    }

    @Test
    public void ProfileBankDetail(){
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theInvalidAccount(loginInvalidAccount),
                Click.on(LOGGED_USER),
                Click.on(USER_INFO_BTN),
                Click.on(BANK_DETAILS_BTN),
                Verify.theElementIsDisplayed(BANK_DETAILS)
        );
    }

    @Test
    public void ProfileChangePassword(){
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theInvalidAccount(loginInvalidAccount),
                Click.on(LOGGED_USER),
                Click.on(USER_INFO_BTN),
                Click.on(CHANGE_PWD_BTN),
                Verify.theElementIsDisplayed(CHANGE_PWD)
        );
    }

    @Test
    public void ProfilePromotionAndCashBack(){
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theInvalidAccount(loginInvalidAccount),
                Click.on(LOGGED_USER),
                Click.on(USER_INFO_BTN),
                Click.on(PROMOTION_CASHBACK_BTN),
                Verify.theElementIsDisplayed(PROMOTION_CASHBACK)
        );
    }

    @Test
    public void ProfileVipProgram(){
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theInvalidAccount(loginInvalidAccount),
                Click.on(LOGGED_USER),
                Click.on(USER_INFO_BTN),
                Click.on(VIP_PROGRAM_BTN),
                Verify.theElementIsDisplayed(VIP_PROGRAM)
        );
    }
}
