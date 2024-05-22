package net.creqavn.tasks;

import net.creqavn.models.LoginAccount;
import net.creqavn.questions.TheLoginState;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Login {
    public static Performable theValidAccount(LoginAccount loginAccount) {
        return Task.where("{0} login the account has balance", actor -> {
                    boolean loginState = TheLoginState.isElementPresent(loginAccount.getAVATAR_USER()).answeredBy(actor);
                    if (!loginState) {
                        actor.attemptsTo(
                                Enter.keyValues(loginAccount.getUserName()).into(loginAccount.getUserName_Field()),
                                Enter.keyValues(loginAccount.getPwd()).into(loginAccount.getPwd_Field()),
                                Click.on(loginAccount.getSubmit_BTN()),
                                Verify.theElementIsDisplayed(loginAccount.getAVATAR_USER())
                        );
                    }
                }
        );
    }

    public static Performable theInvalidAccount(LoginAccount loginAccount) {
        return Task.where("{0} login the account non balance", actor -> {
                    actor.attemptsTo(
                            Enter.keyValues(loginAccount.getUserName()).into(loginAccount.getUserName_Field()),
                            Enter.keyValues(loginAccount.getPwd()).into(loginAccount.getPwd_Field()),
                            Click.on(loginAccount.getSubmit_BTN()),
                            Verify.theElementIsDisplayed(loginAccount.getAVATAR_USER())
                    );
                }
        );
    }

    public static Performable theAccountJustRegistered(LoginAccount loginAccount) {
        return Task.where("{0} login the account using account registered", actor -> {
                    actor.attemptsTo(
                            Enter.keyValues(loginAccount.getUserName()).into(loginAccount.getUserName_Field()),
                            Enter.keyValues(loginAccount.getPwd()).into(loginAccount.getPwd_Field()),
                            Click.on(loginAccount.getSubmit_BTN()),
                            Verify.theElementIsDisplayed(loginAccount.getAVATAR_USER())
                    );
                }
        );
    }

    public static Performable theValidAccountOnPopup(LoginAccount loginAccount) {
        return Task.where("{0} login the account has balance on login popup", actor -> {
            actor.attemptsTo(
                    Enter.keyValues(loginAccount.getUserName()).into(loginAccount.getUserName_Field()),
                    Enter.keyValues(loginAccount.getPwd()).into(loginAccount.getPwd_Field()),
                    Click.on(loginAccount.getSubmit_BTN()),
                    Verify.theElementIsDisplayed(loginAccount.getAVATAR_USER())
            );
        });
    }

    public static Performable theAccountNonBalanceOnPopup(LoginAccount loginAccount) {
        return Task.where("{0} login the account non balance on login popup", actor -> {
            actor.attemptsTo(
                    Enter.keyValues(loginAccount.getUserName()).into(loginAccount.getUserName_Field()),
                    Enter.keyValues(loginAccount.getPwd()).into(loginAccount.getPwd_Field()),
                    Click.on(loginAccount.getSubmit_BTN()),
                    Verify.theElementIsDisplayed(loginAccount.getAVATAR_USER())
            );
        });
    }
}
