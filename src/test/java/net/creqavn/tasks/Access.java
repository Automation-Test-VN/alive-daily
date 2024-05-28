package net.creqavn.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.HoverOverElement;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.targets.Target;

import static net.creqavn.ui.leo.LeoElements.*;

public class Access {
    public static Performable theGameFrom(Target functionName, Target subFunction) {
        return Task.where("{0} access game from function", actor -> {
            actor.attemptsTo(
                    HoverOverElement.over(functionName),
                    Click.on(subFunction),
                    JavaScriptClick.on(CASINO_INDEX_PLAY_BTN.of("1"))
            );
        });
    }

    public static Performable theGameFrom(Target functionName) {
        return Task.where("{0} access game from function", actor -> {
            actor.attemptsTo(
                    Click.on(functionName),
                    JavaScriptClick.on(CASINO_INDEX_PLAY_BTN.of("1"))
            );
        });
    }

    public static Performable theFunctionFromMenu(Target mainFunction, Target subFunction) {
        return Task.where("{0} access sport ",actor -> {
            actor.attemptsTo(
                    HoverOverElement.over(mainFunction),
                    Click.on(subFunction)
            );
        });
    }
}
