package net.creqavn.tasks;

import net.creqavn.models.RegisterAccount;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.creqavn.ui.Lucky88Elements.*;

public class Register {
    public static Performable theUser(RegisterAccount registerAccount) {
        return Task.where("{0} register a new user", actor -> {

            actor.attemptsTo(
                    Click.on(REGISTER_BTN),
                    Enter.keyValues(registerAccount.getUserName()).into(REGISTER_USERNAME),
                    Enter.keyValues(registerAccount.getPwd()).into(REGISTER_PWD),
                    Enter.keyValues(registerAccount.getPhoneNumber()).into(REGISTER_PHONE_NUMBER),
                    Click.on(REGISTER_SUBMIT),
                    Click.on(LUCKY_NUMBER),
                    Click.on(LUCKY_NUMBER_SUBMIT)
            );
        });
    }
}
