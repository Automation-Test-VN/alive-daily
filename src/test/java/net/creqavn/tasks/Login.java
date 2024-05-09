package net.creqavn.tasks;

import net.creqavn.models.LoginAccount;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.creqavn.ui.Lucky88Elements.*;

public class Login {
    public static Performable theAccountHasBalance(LoginAccount loginAccount) {
        return Task.where("{0} login the account", actor -> {
            actor.attemptsTo(
                    Enter.keyValues(ACCOUNT_HAS_BALANCE).into(LOGIN_USERNAME),
                    Enter.keyValues(loginAccount.getPwd()).into(LOGIN_PWD),
                    Click.on(LOGIN_SUBMIT),
                    Ensure.thatTheCurrentPage().currentUrl().contains(CONTAINS_NOHU)
            );
        });
    }

    public static Performable theAccountNonBalance(LoginAccount loginAccount) {
        return Task.where("{0} login the account", actor -> {
            actor.attemptsTo(
                    Enter.keyValues(ACCOUNT_NON_BALANCE).into(LOGIN_USERNAME),
                    Enter.keyValues(loginAccount.getPwd()).into(LOGIN_PWD),
                    Click.on(LOGIN_SUBMIT),
                    Ensure.thatTheCurrentPage().currentUrl().contains(CONTAINS_DEPOSIT)
            );
        });
    }
}
