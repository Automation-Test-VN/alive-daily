package net.creqavn.features.convoi;

import net.creqavn.questions.TheFootball;
import net.creqavn.tasks.*;
import net.creqavn.models.LoginAccount;
import net.creqavn.models.RegisterAccount;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import static net.creqavn.ui.convoi.ConvoiElements.*;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestConvoiAliveDaily {
    static Actor swagger = Actor.named("swagger");
    static RegisterAccount registerAccount = new RegisterAccount();
    static LoginAccount loginAccount = new LoginAccount(FORM_USER_NAME, ACCOUNT_HAS_BALANCE, FORM_PWD, FORM_LOGIN_SUBMIT_BTN, AVATER_USER);

    @Managed(uniqueSession = true)
    public static WebDriver mightyBrowser;

    @BeforeClass
    public static void init() {
        swagger.can(BrowseTheWeb.with(mightyBrowser));
    }

    @Before
    public void Setup() {
        swagger.attemptsTo(Open.url(DOMAIN));
    }

    @After
    public void tearDown() {
        swagger.attemptsTo(SwitchTo.mainWindowAfterCloseCurrentWindow());
    }

//    @Test
//    public void Register(){
//        swagger.attemptsTo(
//                Register.theUserConvoi(registerAccount),
//                Verify.theElementIsDisplayed(AVATER_USER)
//        );
//    }
//
//    @Test
//    public void LoginTheValidAccount() {
//        swagger.attemptsTo(
//                Click.on(LOGIN_BTN),
//                Login.theValidAccount(loginAccount),
//                WaitForLoad.theURL(DOMAIN)
//        );
//    }
//
//    @Test
//    public void LoginTheAccountNonBalance(){
//        swagger.attemptsTo(
//                Click.on(LOGIN_BTN),
//                Login.theAccountNonBalance(loginAccount,ACCOUNT_NON_BALANCE),
//                WaitForLoad.theURL(CONTAINS_DEPOSIT)
//        );
//    }
//
//    @Test
//    public void AccessFunctionWithValidAccount() {
//        swagger.attemptsTo(
//                Click.on(NO_HU_BTN),
//                JavaScriptClick.on(NO_HU_INDEX_PLAY_BTN.of("1")),
//                Login.theValidAccountOnPopup(loginAccount),
//                WaitForLoad.theURL(CONTAINS_NO_HU)
//        );
//    }
//
//    @Test
//    public void AccessFunctionWithAccountNonBalance() {
//        swagger.attemptsTo(
//                Click.on(NO_HU_BTN),
//                JavaScriptClick.on(NO_HU_INDEX_PLAY_BTN.of("1")),
//                Login.theAccountNonBalance(loginAccount,ACCOUNT_NON_BALANCE),
//                WaitForLoad.theURL(CONTAINS_DEPOSIT)
//        );
//    }
//
//    @Test
//    public void ForgetPassword(){
//        swagger.attemptsTo(
//                Click.on(LOGIN_BTN),
//                Click.on(FORGET_PWD_BTN),
//                Enter.keyValues(EMAIL_VERIFY).into(EMAIL_RECOVERY_FIELD),
//                Click.on(FORGET_PWD_SUBMIT_BTN),
//                Verify.theTextIsEqual(FORGET_PWD_VERIFY,"Email đã được gửi, vui lòng kiểm tra hộp thư để cập nhật thông tin.")
//        );
//    }
//
//    @Test
//    public void Logout(){
//        swagger.attemptsTo(
//                Click.on(LOGIN_BTN),
//                Login.theValidAccount(loginAccount),
//                Click.on(AVATER_USER),
//                Click.on(LOGOUT_BTN),
//                Verify.theElementIsDisplayed(LOGIN_BTN)
//        );
//    }

    @Test
    public void HomepageHeroBanner() {
        swagger.attemptsTo(
                Click.on(LOGIN_BTN),
                Login.theValidAccount(loginAccount),
                Click.on(FIRST_SLIDER_BTN),
                Click.on(FIRST_SLIDER_IMG),
                Switch.toFrame(FIRST_IFRAME),
                Verify.theElementIsDisplayed(SPORT_K_VERIFY)
        );
    }

    @Test
    public void HomepageHotMatch() throws InterruptedException {
        String leftTeam = swagger.asksFor(TheFootball.name(HOT_MATCH_LEFT_TEAM));
        String rightTeam = swagger.asksFor(TheFootball.name(HOT_MATCH_RIGHT_TEAM));
        swagger.attemptsTo(
//                Click.on(LOGIN_BTN),
//                Login.theValidAccount(loginAccount),
                Click.on(HOT_MATCH_PLAY_BTN),
                SwitchTo.newWindow(),
                Switch.toFrame(FIRST_IFRAME),
                Verify.theElementIsDisplayed(SPORT_K_VERIFY),
                Verify.theTextIsEqual(MATCH_LEFT_TEAM, leftTeam),
                Verify.theTextIsEqual(MATCH_RIGHT_TEAM, rightTeam)
        );
    }

//    @Test
//    public void HomepageSportK() throws InterruptedException {
//        swagger.attemptsTo(
//                Click.on(LOGIN_BTN),
//                Login.theValidAccount(loginAccount),
//                SwipeTo.theMiddle(),
//                Click.on(HOMEPAGE_SPORT_K),
//                SwitchTo.newWindow(),
//                Switch.toFrame(FIRST_IFRAME),
//                Verify.theElementIsDisplayed(SPORT_K_VERIFY)
//        );
//    }
//
//    @Test
//    public void HomepageSportC() throws InterruptedException {
//        swagger.attemptsTo(
//                Click.on(LOGIN_BTN),
//                Login.theValidAccount(loginAccount),
//                SwipeTo.theMiddle(),
//                Click.on(HOMEPAGE_SPORT_C),
//                SwitchTo.newWindow(),
//                Switch.toFrame(FIRST_IFRAME),
//                Switch.toFrame(SPORT_IFRAME),
//                Verify.theElementIsDisplayed(SPORT_C_VERIFY)
//        );
//    }
//
//    @Test
//    public void HomepageSportP() throws InterruptedException {
//        swagger.attemptsTo(
//                Click.on(LOGIN_BTN),
//                Login.theValidAccount(loginAccount),
//                SwipeTo.theMiddle(),
//                Click.on(HOMEPAGE_SPORT_P),
//                SwitchTo.newWindow(),
//                Switch.toFrame(FIRST_IFRAME),
//                Verify.theElementIsDisplayed(SPORT_P_VERIFY)
//        );
//    }
}
