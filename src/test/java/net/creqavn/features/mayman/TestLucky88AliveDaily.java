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


import org.junit.*;
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

    @After
    public void tearDown() {
        swagger.attemptsTo(SwitchTo.mainWindowAfterCloseCurrentWindow());
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
                WaitForLoad.theURL(CONTAINS_DEPOSIT)
        );
    }

    @Test
    public void AccessFunctionWithAccountHasBalance() {
        when(swagger).attemptsTo(
                Click.on(GAME_BAI_BTN),
                Click.on(GAME_BAI_RIK),
                Login.theAccountHasBalanceOnPopup(loginAccount),
                WaitForLoad.theURL(CONTAINS_GAME_BAI)
        );
    }

    @Test
    public void AccessFunctionWithAccountNonBalance() {
        when(swagger).attemptsTo(
                Click.on(GAME_BAI_BTN),
                Click.on(GAME_BAI_RIK),
                Login.theAccountNonBalanceOnPopup(loginAccount),
                Click.on(GAME_BAI_RIK),
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
                Verify.theTextIsEqual(BALANCE_NUMBER, "200")
        );
    }

    @Test
    public void HomepageLiveCasino() throws InterruptedException {
        when(swagger).attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                SwipeTo.theBottom(),
                Click.on(FIRST_HOMEPAGE_CASINO),
                SwitchTo.newWindow(),
                WaitForLoad.theURL(CONTAINS_EZUGI_CASINO)
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
                WaitForLoad.theURL(CONTAINS_NO_HU_GAME),
                SwitchTo.mainWindowAfterCloseCurrentWindow(),
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
                Verify.theTextIsEqual(HOT_MATCH_LEFT_TEAM, leftTeam),
                Verify.theTextIsEqual(HOT_MATCH_RIGHT_TEAM, rightTeam)
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
    public void SportVirtual() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                HoverOverElement.over(SPORT_BTN),
                Click.on(SPORT_VIRTUAL_BTN),
                SwitchTo.newWindow(),
                Switch.toFrame(SPORT_IFRAME),
                Verify.theElementIsDisplayed(SPORT_VIRTUAL_VERIFY)
        );
    }

    @Test
    public void SportESport() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                HoverOverElement.over(SPORT_BTN),
                Click.on(SPORT_E_SPORT_BTN),
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(SPORT_E_SPORT_VERIFY)
        );
    }

    @Test
    public void SportHorseRacing() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                HoverOverElement.over(SPORT_BTN),
                Click.on(SPORT_HORSE_RACING_BTN)
        );
        swagger.attemptsTo(
                SwitchTo.newWindow(),
                WaitForLoad.theURL(CONTAINS_HORSE_RACING)
        );
    }

    @Test
    public void CasinoVivo() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(LIVE_CASINO_BTN),
                Click.on(VIVO_CASINO_BTN),
                Click.on(FIRST_TABLE_PLAY_BTN),
                SwitchTo.newWindow(),
                WaitForLoad.thePage(VIVO_CASINO_VERIFY),
                Verify.theElementIsDisplayed(VIVO_CASINO_VERIFY)
        );
    }

    @Test
    public void CasinoMG() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(LIVE_CASINO_BTN),
                Click.on(MG_CASINO_BTN),
                Click.on(FIRST_TABLE_PLAY_BTN),
                SwitchTo.newWindow(),
                WaitForLoad.theURL(CONTAINS_MG_CASINO),
                Verify.theElementIsDisplayed(MG_CASINO_VERIFY)
        );
    }

    @Test
    public void CasinoEzugi() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(LIVE_CASINO_BTN),
                Click.on(EZUGI_CASINO_BTN),
                Click.on(FIRST_TABLE_PLAY_BTN),
                SwitchTo.newWindow(),
                WaitForLoad.theURL(CONTAINS_EZUGI_CASINO),
                Verify.theElementIsDisplayed(EZUGI_CASINO_VERIFY)
        );
    }

    @Test
    public void CasinoEvolution() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(LIVE_CASINO_BTN),
                Click.on(EVOLUTION_CASINO_BTN),
                Click.on(FIRST_TABLE_PLAY_BTN),
                SwitchTo.newWindow(),
                Switch.toFrame(EVOLUTION_CASINO_IFRAME.resolveFor(swagger)),
                Verify.theElementIsDisplayed(EVOLUTION_CASINO_VERIFY)
        );
    }

    @Test
    public void LoDe3Mien() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                HoverOverElement.over(LO_DE_BTN),
                Click.on(LO_DE_3_MIEN_BTN),
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(LO_DE_3_MIEN_VERIFY)
        );
    }

    @Test
    public void LoDeKenoVietlot() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(LO_DE_BTN),
                Click.on(LO_DE_KENO_VIETLOT_BTN),
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(LO_DE_KENO_VIETLOT_VERIFY)
        );
    }

    @Test
    public void LoDeSieuToc() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                HoverOverElement.over(LO_DE_BTN),
                Click.on(LO_DE_SIEU_TOC_BTN),
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(LO_DE_SIEU_TOC_VERIFY)
        );
    }

    @Test
    public void NoHuAccessGame() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(NO_HU_BTN),
                Click.on(NO_HU_GAME_PLAY_BTN),
                SwitchTo.newWindow(),
                WaitForLoad.theURL(CONTAINS_NO_HU_GAME)
        );
    }

    @Test
    public void NoHuCheckMoney() throws InterruptedException {
        swagger.attemptsTo(
                Click.on(NO_HU_BTN)
        );
        sleep(25000);
        swagger.attemptsTo(
                Verify.theValueIsNotEmpty(NO_HU_GAME_MONEY)
        );
    }

    @Test
    public void GameBaiRik() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(GAME_BAI_BTN),
                Click.on(GAME_BAI_RIK),
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(RIK_SUPPLIER_VERIFY)
        );
    }

    @Test
    public void GameBaiGo() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(GAME_BAI_BTN),
                Click.on(GAME_BAI_GO),
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(GO_SUPPLIER_VERIFY)
        );
    }

    @Test
    public void TableGameRik() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(TABLE_GAME_BTN),
                Click.on(TABLE_GAME_RIK),
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(RIK_SUPPLIER_VERIFY)
        );
    }

    @Test
    public void TableGameGo() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(TABLE_GAME_BTN),
                Click.on(TABLE_GAME_GO),
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(GO_SUPPLIER_VERIFY)
        );
    }

    @Test
    public void TableGameTP() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(TABLE_GAME_BTN),
                Click.on(TABLE_GAME_TP),
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(TP_SUPPLIER_VERIFY)
        );
    }

    @Test
    public void TableGameB52() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(TABLE_GAME_BTN),
                Click.on(TABLE_GAME_B52),
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(B52_SUPPLIER_VERIFY)
        );
    }

    @Test
    public void BanCaTP() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(BAN_CA_BTN),
                Click.on(BAN_CA_TP),
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(TP_SUPPLIER_VERIFY)
        );
    }

    @Test
    public void BanCaQTech() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(BAN_CA_BTN),
                Click.on(BAN_CA_QTECH),
                SwitchTo.newWindow(),
                Switch.toFrame(QTECH_SUPPLIER_IFRAME.resolveFor(swagger)),
                Verify.theElementIsDisplayed(QTECH_SUPPLIER_VERIFY)
        );
    }

    @Test
    public void BanCaCQ9() throws InterruptedException {
        swagger.attemptsTo(
//                Login.theAccountHasBalance(loginAccount),
                Click.on(BAN_CA_BTN)
//                Click.on(BAN_CA_QTECH),
//                SwitchTo.newWindow(),
//                Switch.toFrame(QTECH_SUPPLIER_IFRAME.resolveFor(swagger)),
//                Verify.theElementIsDisplayed(QTECH_SUPPLIER_VERIFY)
        );
    }

    @Test
    public void Keno() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(KENO_BTN),
                Click.on(KENO_PLAY_BTN),
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(LO_DE_KENO_VIETLOT_VERIFY)
        );
    }

    @Test
    public void QuaySo() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                Click.on(QUAY_SO_BTN),
                Click.on(QUAY_SO_PLAY_BTN),
                SwitchTo.newWindow(),
                Switch.toFrame(SPORT_IFRAME),
                Verify.theElementIsDisplayed(QUAY_SO_VERIFY)
        );
    }

    @Test
    public void XemThemGameNhanh() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                HoverOverElement.over(XEM_THEM_BTN),
                Click.on(GAME_NHANH_BTN),
                Click.on(XEM_THEM_PLAY_BTN),
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(QTECH_SUPPLIER_VERIFY)
        );
    }

    @Test
    public void XemThemCoUp() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                HoverOverElement.over(XEM_THEM_BTN),
                Click.on(CO_UP_BTN),
                SwitchTo.newWindow(),
                Verify.theElementIsDisplayed(QTECH_SUPPLIER_VERIFY)
        );
    }

    @Test
    public void XemThemGameKhac() throws InterruptedException {
        swagger.attemptsTo(
                Login.theAccountHasBalance(loginAccount),
                HoverOverElement.over(XEM_THEM_BTN),
                Click.on(GAME_KHAC_BTN),
                Click.on(XEM_THEM_PLAY_BTN),
                SwitchTo.newWindow(),
                Switch.toFrame(GAME_IFRAME.resolveFor(swagger)),
                Verify.theElementIsDisplayed(QTECH_SUPPLIER_VERIFY)
        );
    }
}
