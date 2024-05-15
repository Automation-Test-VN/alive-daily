package net.creqavn.tasks;

import net.creqavn.models.LoginAccount;
import net.creqavn.questions.TheLoginState;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.creqavn.ui.mayman.Lucky88Elements.*;

public class Login {
    public static Performable theAccountHasBalance(LoginAccount loginAccount) {
        return Task.where("{0} login the account has balance", actor -> {
                    boolean loginState = TheLoginState.isElementPresent(AVATAR_USER).answeredBy(actor);
                    if (!loginState) {
                        actor.attemptsTo(
                                Enter.keyValues(ACCOUNT_HAS_BALANCE).into(LOGIN_USERNAME),
                                Enter.keyValues(loginAccount.getPwd()).into(LOGIN_PWD),
                                Click.on(LOGIN_SUBMIT)
                        );
                    }
                }
        );
    }

    public static Performable theAccountNonBalance(LoginAccount loginAccount) {
        return Task.where("{0} login the account non balance", actor -> {
                        actor.attemptsTo(
                                Enter.keyValues(ACCOUNT_NON_BALANCE).into(LOGIN_USERNAME),
                                Enter.keyValues(loginAccount.getPwd()).into(LOGIN_PWD),
                                Click.on(LOGIN_SUBMIT)
                        );
                }
        );
    }

    public static Performable theAccountJustRegistered(LoginAccount loginAccount) {
        return Task.where("{0} login the account using account registered", actor -> {
                    actor.attemptsTo(
                            Enter.keyValues(loginAccount.getUserName()).into(LOGIN_USERNAME),
                            Enter.keyValues(loginAccount.getPwd()).into(LOGIN_PWD),
                            Click.on(LOGIN_SUBMIT)
                    );
                }
        );
    }

    public static Performable theAccountHasBalanceOnPopup(LoginAccount loginAccount) {
        return Task.where("{0} login the account has balance on login popup", actor -> {
            actor.attemptsTo(
                    Enter.keyValues(ACCOUNT_HAS_BALANCE).into(FORM_LOGIN_USERNAME),
                    Enter.keyValues(loginAccount.getPwd()).into(FORM_LOGIN_PWD),
                    Click.on(FORM_LOGIN_SUBMIT_BTN)
            );
        });
    }

    public static Performable theAccountNonBalanceOnPopup(LoginAccount loginAccount) {
        return Task.where("{0} login the account non balance on login popup", actor -> {
            actor.attemptsTo(
                    Enter.keyValues(ACCOUNT_NON_BALANCE).into(FORM_LOGIN_USERNAME),
                    Enter.keyValues(loginAccount.getPwd()).into(FORM_LOGIN_PWD),
                    Click.on(FORM_LOGIN_SUBMIT_BTN)
            );
        });
    }
}
