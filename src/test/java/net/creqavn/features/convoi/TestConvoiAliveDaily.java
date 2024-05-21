package net.creqavn.features.convoi;

import net.creqavn.tasks.*;
import net.creqavn.models.LoginAccount;
import net.creqavn.models.RegisterAccount;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Open;
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
    static LoginAccount loginAccount = new LoginAccount(FORM_USER_NAME,ACCOUNT_HAS_BALANCE,FORM_PWD,FORM_LOGIN_SUBMIT_BTN,AVATER_USER);

    @Managed(uniqueSession = true)
    public static WebDriver mightyBrowser;

    @BeforeClass
    public static void init() {
        swagger.can(BrowseTheWeb.with(mightyBrowser));
    }

    @Before
    public void Setup(){
        swagger.attemptsTo(Open.url(DOMAIN));
    }

    @After
    public void tearDown(){
        swagger.attemptsTo(SwitchTo.mainWindowAfterCloseCurrentWindow());
    }

    @Test
    public void Register(){
        swagger.attemptsTo(
                Register.theUserConvoi(registerAccount),
                Verify.theElementIsDisplayed(AVATER_USER)
        );
    }

    @Test
    public void LoginTheValidAccount() {
        swagger.attemptsTo(
                Click.on(LOGIN_BTN),
                Login.theValidAccount(loginAccount),
                WaitForLoad.theURL(DOMAIN)
        );
    }

    @Test
    public void LoginTheAccountNonBalance(){
        swagger.attemptsTo(
                Click.on(LOGIN_BTN),
                Login.theAccountNonBalance(loginAccount,ACCOUNT_NON_BALANCE),
                WaitForLoad.theURL(CONTAINS_DEPOSIT)
        );
    }

    @Test
    public void AccessFunctionWithValidAccount() {
        swagger.attemptsTo(
                Click.on(NO_HU_BTN),
                JavaScriptClick.on(NO_HU_INDEX_PLAY_BTN.of("1")),
                Login.theValidAccountOnPopup(loginAccount),
                WaitForLoad.theURL(CONTAINS_NO_HU)
        );
    }

    @Test
    public void AccessFunctionWithAccountNonBalance() {
        swagger.attemptsTo(
                Click.on(NO_HU_BTN),
                JavaScriptClick.on(NO_HU_INDEX_PLAY_BTN.of("1")),
                Login.theAccountNonBalance(loginAccount,ACCOUNT_NON_BALANCE),
                WaitForLoad.theURL(CONTAINS_DEPOSIT)
        );
    }

    @Test
    public void ForgetPassword(){
        swagger.attemptsTo(
                Click.on(LOGIN_BTN),
                Click.on(FORGET_PWD_BTN),
                Enter.keyValues(EMAIL_VERIFY).into(EMAIL_RECOVERY_FIELD),
                Click.on(FORGET_PWD_SUBMIT_BTN),
                Verify.theTextIsEqual(FORGET_PWD_VERIFY,"Email đã được gửi, vui lòng kiểm tra hộp thư để cập nhật thông tin.")
        );
    }

    @Test
    public void Logout(){
        swagger.attemptsTo(
                Click.on(LOGIN_BTN),
                Login.theValidAccount(loginAccount),
                Click.on(AVATER_USER),
                Click.on(LOGOUT_BTN),
                Verify.theElementIsDisplayed(LOGIN_BTN)
        );
    }
}
