package net.creqavn.features.convoi;

import net.creqavn.tasks.*;
import net.creqavn.models.LoginAccount;
import net.creqavn.models.RegisterAccount;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
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
    static LoginAccount loginAccount = new LoginAccount();

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
}
