package net.creqavn.tasks;

import net.creqavn.questions.TheLoginState;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.creqavn.ui.leo.LeoElements.*;

public class Logout {
    public static Performable theLeoAccount() {
        return Task.where("{0} perform logout", actor -> {
            actor.attemptsTo(
                    Click.on(LOGGED_USER),
                    Click.on(LOGOUT_BTN),
                    Verify.theElementIsDisplayed(SIGN_IN_BTN)
            );
        });
    }
}
