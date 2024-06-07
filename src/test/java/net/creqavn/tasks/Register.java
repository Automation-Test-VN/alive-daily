package net.creqavn.tasks;

import net.creqavn.models.RegisterAccount;
import net.creqavn.ui.convoi.ConvoiElements;
import net.creqavn.ui.leo.LeoElements;
import net.creqavn.ui.mayman.Lucky88Elements;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;


public class Register {
    public static Performable theUserMayMan(RegisterAccount registerAccount) {
        return Task.where("{0} register a new user", actor -> {

            actor.attemptsTo(
                    Click.on(Lucky88Elements.REGISTER_BTN),
                    Enter.keyValues(registerAccount.getUserName())
                            .into(Lucky88Elements.REGISTER_USERNAME),
                    Enter.keyValues(registerAccount.getPwd())
                            .into(Lucky88Elements.REGISTER_PWD),
                    Enter.keyValues(registerAccount.getPhoneNumber())
                            .into(Lucky88Elements.REGISTER_PHONE_NUMBER),
                    Click.on(Lucky88Elements.REGISTER_SUBMIT),
                    Click.on(Lucky88Elements.LUCKY_NUMBER),
                    Click.on(Lucky88Elements.LUCKY_NUMBER_SUBMIT)
            );
        });
    }

    public static Performable theUserConvoi(RegisterAccount registerAccount) {
        return Task.where("{0} register a new user", actor -> {
            actor.attemptsTo(
                    Enter.keyValues(registerAccount.getUserName())
                            .into(ConvoiElements.REGISTER_USERNAME),
                    Enter.keyValues(registerAccount.getPwd())
                            .into(ConvoiElements.REGISTER_PWD),
                    Enter.keyValues(registerAccount.getPhoneNumber())
                            .into(ConvoiElements.REGISTER_PHONE_NUMBER),
                    Click.on(ConvoiElements.REGISTER_SUBMIT)
            );
        });
    }

    public static Performable theUserLeo(RegisterAccount registerAccount) {
        return Task.where("{0} register a new user", actor -> {
            actor.attemptsTo(
                    Enter.keyValues(registerAccount.getUserName())
                            .into(LeoElements.SIGN_UP_USERNAME),
                    Enter.keyValues(registerAccount.getPwd())
                            .into(LeoElements.SIGN_UP_PWD),
                    Enter.keyValues(registerAccount.getPhoneNumber())
                            .into(LeoElements.SIGN_UP_PHONE),
                    Click.on(LeoElements.SIGN_UP_SUBMIT)
            );
        });
    }
}
