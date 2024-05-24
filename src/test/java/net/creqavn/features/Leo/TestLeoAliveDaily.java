package net.creqavn.features.Leo;

import net.creqavn.models.LoginAccount;
import net.creqavn.models.RegisterAccount;
import net.creqavn.tasks.*;
import net.serenitybdd.annotations.ClearCookiesPolicy;
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
    static LoginAccount validAccount = new LoginAccount(SIGN_IN_USERNAME, VALID_ACCOUNT, SIGN_IN_PWD, SIGN_IN_SUBMIT, LOGGED_USER);
    static LoginAccount invalidAccount = new LoginAccount(SIGN_IN_USERNAME, INVALID_ACCOUNT, SIGN_IN_PWD, SIGN_IN_SUBMIT, LOGGED_USER);

    @Managed(uniqueSession = true,clearCookies = ClearCookiesPolicy.BeforeEachTest)
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
    public void Register() {
        swagger.attemptsTo(
                Click.on(SIGN_UP_BTN),
                Register.theUserLeo(registerAccount)
        );
    }

    @Test
    public void LoginTheValidAccount() {
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theAccount(validAccount)
        );
    }

    @Test
    public void LoginTheInvalidAccount() {
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theAccount(invalidAccount)
        );
    }

    @Test
    public void LoginTheValidAccountOnPopup() {
        swagger.attemptsTo(
                Click.on(LIVE_CASINO_BTN),
                Click.on(LIVE_CASINO_EVOLUTION_BTN),
                JavaScriptClick.on(LIVE_CASINO_INDEX_PLAY_BTN.of("1")),
                Login.theAccount(validAccount)
        );
    }

    @Test
    public void LoginTheInvalidAccountOnPopup() {
        swagger.attemptsTo(
                Click.on(LIVE_CASINO_BTN),
                Click.on(LIVE_CASINO_EVOLUTION_BTN),
                JavaScriptClick.on(LIVE_CASINO_INDEX_PLAY_BTN.of("1")),
                Login.theAccount(invalidAccount)
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
                Login.theAccount(invalidAccount),
                Click.on(LOGGED_USER),
                Click.on(LOGOUT_BTN),
                Verify.theElementIsDisplayed(SIGN_IN_BTN)
        );
    }

    @Test
    public void HomepageHeroBanner() {
        swagger.attemptsTo(
                Click.on(HERO_BANNER),
                WaitForLoad.theURL(CONTAINS_HERO_BANNER)
        );
    }

    @Test
    public void HomepageSubBanner() {
        swagger.attemptsTo(
                Click.on(SUB_BANNER),
                WaitForLoad.theURL(CONTAIN_SUB_BANNER)
        );
    }

    @Test
    public void HomepageMostPopular() {
        swagger.attemptsTo(
                Click.on(MOST_POPULAR_BTN),
                Switch.toFrame(K_SPORT_IFRAME.resolveFor(swagger)),
                Verify.theElementIsDisplayed(SPORT_K_VERIFY, 60)
        );
    }

    @Test
    public void HomepageMostCommon() throws InterruptedException {
        swagger.attemptsTo(
                Click.on(MOST_COMMON_BTN),
                Login.theAccount(validAccount)
        );
        sleep(3000);
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(CANVAS_1)
        );
    }

    @Test
    public void HomepageBestLiveCasino() throws InterruptedException {
        swagger.attemptsTo(
                Click.on(BEST_LIVE_CASINO),
                Login.theAccount(validAccount)
        );
        sleep(3000);
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(LIVE_CASINO_SA_GAMING_VERIFY)
        );
    }

    @Test
    public void HomepageLiveCasino() {
        swagger.attemptsTo(
                Click.on(LIVE_CASINO_BTN),
                WaitForLoad.theURL(CONTAINS_LIVE_CASINO)
        );
    }

    @Test
    public void HomepageSports() {
        swagger.attemptsTo(
                Click.on(SPORTS_BTN),
                WaitForLoad.theURL(CONTAINS_SPORTS)
        );
    }

    @Test
    public void HomepageCasino() {
        swagger.attemptsTo(
                Click.on(CASINO_BTN),
                WaitForLoad.theURL(CONTAINS_CASINO)
        );
    }

    @Test
    public void HomepageLottery() {
        swagger.attemptsTo(
                Click.on(LOTTERY_BTN),
                WaitForLoad.theURL(CONTAINS_LOTTERY)
        );
    }

    @Test
    public void HomepageSiamGames() {
        swagger.attemptsTo(
                Click.on(SIAM_GAMES_BTN),
                WaitForLoad.theURL(CONTAINS_SIAM_GAMES)
        );
    }

    @Test
    public void HomepageFishing() {
        swagger.attemptsTo(
                Click.on(FISHING_BTN),
                WaitForLoad.theURL(CONTAINS_FISHING)
        );
    }

    @Test
    public void HomepageFastGames() {
        swagger.attemptsTo(
                Click.on(FAST_GAMES_BTN),
                WaitForLoad.theURL(CONTAINS_FAST_GAMES)
        );
    }

    @Test
    public void HomepageCockFight() throws InterruptedException {
        swagger.attemptsTo(
                HoverOverElement.over(COCK_FIGHT_BTN),
                Click.on(COCK_FIGHT_GAME_BTN),
                Login.theAccount(invalidAccount)
        );
        sleep(3000);
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                WaitForLoad.theURL(CONTAINS_COCK_FIGHT)
        );
    }

    @Test
    public void HomepageVIP() {
        swagger.attemptsTo(
                HoverOverElement.over(OTHERS_BTN),
                Click.on(VIP_BTN),
                WaitForLoad.theURL(CONTAINS_VIP)
        );
    }

    @Test
    public void HomepagePromotion() {
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
    public void ProfileInfo() {
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theAccount(invalidAccount),
                Click.on(LOGGED_USER),
                Click.on(USER_INFO_BTN),
                Verify.theElementIsDisplayed(USER_INFO)
        );
    }

    @Test
    public void ProfileBankDetail() {
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theAccount(invalidAccount),
                Click.on(LOGGED_USER),
                Click.on(USER_INFO_BTN),
                Click.on(BANK_DETAILS_BTN),
                Verify.theElementIsDisplayed(BANK_DETAILS)
        );
    }

    @Test
    public void ProfileChangePassword() {
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theAccount(invalidAccount),
                Click.on(LOGGED_USER),
                Click.on(USER_INFO_BTN),
                Click.on(CHANGE_PWD_BTN),
                Verify.theElementIsDisplayed(CHANGE_PWD)
        );
    }

    @Test
    public void ProfilePromotionAndCashBack() {
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theAccount(invalidAccount),
                Click.on(LOGGED_USER),
                Click.on(USER_INFO_BTN),
                Click.on(PROMOTION_CASHBACK_BTN),
                Verify.theElementIsDisplayed(PROMOTION_CASHBACK)
        );
    }

    @Test
    public void ProfileVipProgram() {
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theAccount(invalidAccount),
                Click.on(LOGGED_USER),
                Click.on(USER_INFO_BTN),
                Click.on(VIP_PROGRAM_BTN),
                Verify.theElementIsDisplayed(VIP_PROGRAM)
        );
    }

    @Test
    public void SportbookLeo() {
        swagger.attemptsTo(
                HoverOverElement.over(SPORTS_BTN),
                Click.on(SPORT_LEO),
                Switch.toFrame(K_SPORT_IFRAME.resolveFor(swagger)),
                Verify.theElementIsDisplayed(SPORT_K_VERIFY, 60)
        );
    }

    @Test
    public void SportbookIBC() {
        swagger.attemptsTo(
                HoverOverElement.over(SPORTS_BTN),
                Click.on(SPORT_IBC),
                Switch.toFrame(A_SPORT_IFRAME.resolveFor(swagger)),
                Switch.toFrame(SPORT_IFRAME.resolveFor(swagger)),
                Verify.theElementIsDisplayed(SPORT_IBC_VERIFY)
        );
    }

    @Test
    public void SportbookBTI() {
        swagger.attemptsTo(
                HoverOverElement.over(SPORTS_BTN),
                Click.on(SPORT_BTI),
                Switch.toFrame(BTI_IFRAME.resolveFor(swagger)),
                Verify.theElementIsDisplayed(SPORT_BTI_VERIFY)
        );
    }

    @Test
    public void SportbookLeoVirtual() throws InterruptedException {
        swagger.attemptsTo(
                HoverOverElement.over(SPORTS_BTN),
                Click.on(SPORT_LEO_VIRTUAL)
        );
        sleep(3000);
        swagger.attemptsTo(
                Switch.toFrame(V_SPORT_IFRAME.resolveFor(swagger)),
                Switch.toFrame(VIRTUAL_IFRAME.resolveFor(swagger)),
                Verify.theElementIsDisplayed(SPORT_LEO_VIRTUAL_VERIFY, 60)
        );
    }

    @Test
    public void SportbookSABAVirtual() {
        swagger.attemptsTo(
                HoverOverElement.over(SPORTS_BTN),
                Click.on(SPORT_SABA_VIRTUAL),
                Switch.toFrame(ATHENA_SABA_IFRAME.resolveFor(swagger)),
                Switch.toFrame(SPORT_IFRAME.resolveFor(swagger)),
                Verify.theElementIsDisplayed(SPORT_IBC_VERIFY)
        );
    }

    @Test
    public void SportbookSABAEsport() {
        swagger.attemptsTo(
                HoverOverElement.over(SPORTS_BTN),
                Click.on(SPORT_SABA_ESPORT),
                Switch.toFrame(SABA_IFRAME.resolveFor(swagger)),
                Verify.theElementIsDisplayed(SPORT_SABA_ESPORT_VERIFY)
        );
    }

    @Test
    public void SportbookIMESport() {
        swagger.attemptsTo(
                Click.on(SIGN_IN_BTN),
                Login.theAccount(invalidAccount),
                HoverOverElement.over(SPORTS_BTN),
                Click.on(SPORT_IM_ESPORT),
                Switch.toFrame(IM_IFRAME.resolveFor(swagger)),
                Verify.theElementIsDisplayed(SPORT_IM_ESPORT_VERIFY)
        );
    }

    @Test
    public void LiveCasinoSAGaming() throws InterruptedException {
        swagger.attemptsTo(
                HoverOverElement.over(LIVE_CASINO_BTN),
                Click.on(LIVE_CASINO_SAGAMING_BTN),
                JavaScriptClick.on(LIVE_CASINO_INDEX_PLAY_BTN.of("1")),
                Login.theAccount(validAccount)
        );
        sleep(3000);
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(LIVE_CASINO_SA_GAMING_VERIFY)
        );
    }

    @Test
    public void LiveCasinoEzugi() throws InterruptedException {
        swagger.attemptsTo(
                HoverOverElement.over(LIVE_CASINO_BTN),
                Click.on(LIVE_CASINO_EZUGI_BTN),
                JavaScriptClick.on(LIVE_CASINO_INDEX_PLAY_BTN.of("1")),
                Login.theAccount(validAccount)
        );
        sleep(3000);
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(LIVE_CASINO_EZUGI_VERIFY)
        );
    }

    @Test
    public void LiveCasinoEvolution() throws InterruptedException {
        swagger.attemptsTo(
                HoverOverElement.over(LIVE_CASINO_BTN),
                Click.on(LIVE_CASINO_EVOLUTION_BTN),
                JavaScriptClick.on(LIVE_CASINO_INDEX_PLAY_BTN.of("1")),
                Login.theAccount(validAccount)
        );
        sleep(3000);
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                Switch.toFrame(EVOLUTION_IFRAME.resolveFor(swagger)),
                Verify.theElementIsDisplayed(LIVE_CASINO_EVOLUTION_VERIFY)
        );
    }

    @Test
    public void LiveCasinoPragmatic() throws InterruptedException {
        swagger.attemptsTo(
                HoverOverElement.over(LIVE_CASINO_BTN),
                Click.on(LIVE_CASINO_PRAGMATIC_BTN),
                JavaScriptClick.on(LIVE_CASINO_INDEX_PLAY_BTN.of("1")),
                Login.theAccount(validAccount)
        );
        sleep(3000);
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(LIVE_CASINO_PRAGMATIC_VERIFY)
        );
    }

    @Test
    public void LiveCasinoMicrogaming() throws InterruptedException {
        swagger.attemptsTo(
                HoverOverElement.over(LIVE_CASINO_BTN),
                Click.on(LIVE_CASINO_MICROGAMING_BTN),
                JavaScriptClick.on(LIVE_CASINO_INDEX_PLAY_BTN.of("1")),
                Login.theAccount(validAccount)
        );
        sleep(3000);
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(LIVE_CASINO_MICROGAMING_VERIFY)
        );
    }

    @Test
    public void CasinoFaChai() throws InterruptedException {
        swagger.attemptsTo(
                HoverOverElement.over(CASINO_BTN),
                Click.on(CASINO_FACHAI_BTN),
                JavaScriptClick.on(CASINO_INDEX_PLAY_BTN.of("1")),
                Login.theAccount(invalidAccount)
        );
        sleep(3000);
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(CANVAS_1)
        );
    }

    @Test
    public void CasinoAskmebet() throws InterruptedException {
        swagger.attemptsTo(
                HoverOverElement.over(CASINO_BTN),
                Click.on(CASINO_ASKMEBET_BTN),
                JavaScriptClick.on(CASINO_INDEX_PLAY_BTN.of("1")),
                Login.theAccount(invalidAccount)
        );
        sleep(3000);
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                Switch.toFrame(GAME_IFRAME.resolveFor(swagger)),
                Verify.theElementIsDisplayed(CANVAS_1)
        );
    }

    @Test
    public void CasinoEvoplay() throws InterruptedException {
        swagger.attemptsTo(
                HoverOverElement.over(CASINO_BTN),
                Click.on(CASINO_EVOPLAY_BTN),
                JavaScriptClick.on(CASINO_INDEX_PLAY_BTN.of("1")),
                Login.theAccount(invalidAccount)
        );
        sleep(3000);
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(SLOT_CANVAS)
        );
    }

    @Test
    public void CasinoMicrogaming() throws InterruptedException {
        swagger.attemptsTo(
                HoverOverElement.over(CASINO_BTN),
                Click.on(CASINO_MICROGAMING_BTN),
                JavaScriptClick.on(CASINO_INDEX_PLAY_BTN.of("1")),
                Login.theAccount(invalidAccount)
        );
        sleep(3000);
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(CANVAS_VIEW)
        );
    }

    @Test
    public void CasinoPlayNGo() throws InterruptedException {
        swagger.attemptsTo(
                HoverOverElement.over(CASINO_BTN),
                Click.on(CASINO_PLAY_N_GO_BTN),
                JavaScriptClick.on(CASINO_INDEX_PLAY_BTN.of("1")),
                Login.theAccount(validAccount)
        );
        sleep(3000);
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(CANVAS_1)
        );
    }

    @Test
    public void CasinoPragmatic() throws InterruptedException {
        swagger.attemptsTo(
                HoverOverElement.over(CASINO_BTN),
                Click.on(CASINO_PRAGMATIC_BTN),
                JavaScriptClick.on(CASINO_INDEX_PLAY_BTN.of("1")),
                Login.theAccount(validAccount)
        );
        sleep(3000);
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(CANVAS_1)
        );
    }

    @Test
    public void CasinoNetEnt() throws InterruptedException {
        swagger.attemptsTo(
                HoverOverElement.over(CASINO_BTN),
                Click.on(CASINO_NETENT_BTN),
                JavaScriptClick.on(CASINO_INDEX_PLAY_BTN.of("1")),
                Login.theAccount(validAccount)
        );
        sleep(3000);
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                Switch.toFrame(CASINO_NETENT_IFRAME.resolveFor(swagger)),
                Switch.toFrame(SLOT_CONTAINER_IFRAME.resolveFor(swagger)),
                Verify.theElementIsDisplayed(CANVAS_ANIMATION_MANAGER, 60)
        );
    }

    @Test
    public void CasinoJili() throws InterruptedException {
        swagger.attemptsTo(
                HoverOverElement.over(CASINO_BTN),
                Click.on(CASINO_JILI_BTN),
                JavaScriptClick.on(CASINO_INDEX_PLAY_BTN.of("1")),
                Login.theAccount(validAccount)
        );
        sleep(3000);
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(GAME_CANVAS)
        );
    }

    @Test
    public void CasinoJDB() throws InterruptedException {
        swagger.attemptsTo(
                HoverOverElement.over(CASINO_BTN),
                Click.on(CASINO_JDB_BTN),
                JavaScriptClick.on(CASINO_INDEX_PLAY_BTN.of("1")),
                Login.theAccount(validAccount)
        );
        sleep(3000);
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(CASINO_JDB_VERIFY)
        );
    }

    @Test
    public void CasinoRedTiger() throws InterruptedException {
        swagger.attemptsTo(
                HoverOverElement.over(CASINO_BTN),
                Click.on(CASINO_RED_TIGER_BTN),
                JavaScriptClick.on(CASINO_INDEX_PLAY_BTN.of("1")),
                Login.theAccount(validAccount)
        );
        sleep(3000);
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                Switch.toFrame(CASINO_RED_TIGER_IFRAME.resolveFor(swagger)),
                Switch.toFrame(CASINO_RED_TIGER_IFRAME_2.resolveFor(swagger)),
                Verify.theElementIsDisplayed(CASINO_RED_TIGER_VERIFY, 60)
        );
    }

    @Test
    public void CasinoBTG() throws InterruptedException {
        swagger.attemptsTo(
                HoverOverElement.over(CASINO_BTN),
                Click.on(CASINO_BTG_BTN),
                JavaScriptClick.on(CASINO_INDEX_PLAY_BTN.of("1")),
                Login.theAccount(validAccount)
        );
        sleep(3000);
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                Switch.toFrame(CASINO_BTG_IFRAME.resolveFor(swagger)),
                Switch.toFrame(CASINO_BTG_IFRAME_2.resolveFor(swagger)),
                Verify.theElementIsDisplayed(CANVAS_1)
        );
    }

    @Test
    public void CasinoNLC() throws InterruptedException {
        swagger.attemptsTo(
                HoverOverElement.over(CASINO_BTN),
                Click.on(CASINO_NLC_BTN),
                JavaScriptClick.on(CASINO_INDEX_PLAY_BTN.of("1")),
                Login.theAccount(validAccount)
        );
        sleep(3000);
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                Switch.toFrame(CASINO_NLC_IFRAME.resolveFor(swagger)),
                Switch.toFrame(CASINO_NLC_IFRAME_2.resolveFor(swagger)),
                Verify.theElementIsDisplayed(CANVAS_1, 60)
        );
    }

    @After
    public void tearDown() {
        swagger.attemptsTo(SwitchTo.mainWindowAfterCloseCurrentWindow());
    }
}
