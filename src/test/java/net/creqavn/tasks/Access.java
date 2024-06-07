package net.creqavn.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.HoverOverElement;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.targets.Target;

import static net.creqavn.ui.leo.LeoElements.*;

public class Access {
    public static final String DEFAULT_INDEX = "1";
    public static Performable theGameFrom(Target functionName, Target subFunction) {
        return Task.where("{0} access game from function", actor -> {
            actor.attemptsTo(
                    HoverOverElement.over(functionName),
                    Click.on(subFunction),
                    WaitForLoad.thePageInFewSeconds(2),
                    JavaScriptClick.on(GAME_INDEX_PLAY_BTN.of("1"))
            );
        });
    }

    public static Performable theGameFrom(Target functionName) {
        return theGameFrom(functionName, DEFAULT_INDEX);
    }

    public static Performable theGameFrom(Target functionName, String index) {
        return Task.where("{0} access game from function", actor -> {
            actor.attemptsTo(
                    Click.on(functionName),
                    JavaScriptClick.on(GAME_INDEX_PLAY_BTN.of(index))
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
