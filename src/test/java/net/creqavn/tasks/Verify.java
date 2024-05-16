package net.creqavn.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.creqavn.ui.mayman.Lucky88Elements.JACKPOT_NUMBER;


public class Verify {
    public static Performable theElementIsDisplayed(Target element) {
        return Task.where("{0} verify the element", actor -> {
            actor.attemptsTo(
                    WaitUntil.the(element, WebElementStateMatchers.isVisible()),
                    Ensure.that(element).isDisplayed()
            );
        });
    }

    public static Performable theTextIsEqual(Target target1, String target2) {
        return Task.where("{0} compare the text of element", actor -> {
            actor.attemptsTo(
                    Ensure.that(target1).text().isEqualTo(target2)
            );
        });
    }

    public static Performable theValueIsNotEmpty(Target target1) {
        return Task.where("{0} verify the value is not empty", actor -> {
            actor.attemptsTo(
                    WaitUntil.the(JACKPOT_NUMBER,WebElementStateMatchers.isNotEmpty())
            );
        });
    }
}
