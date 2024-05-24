package net.creqavn.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class Verify {
    // Default timeout value
    public static final int DEFAULT_TIMEOUT = 15;

    // Method with default timeout value
    public static Performable theElementIsDisplayed(Target element) {
        return theElementIsDisplayed(element, DEFAULT_TIMEOUT);
    }

    // Method with customizable timeout value
    public static Performable theElementIsDisplayed(Target element, int timeOut) {
        return Task.where("{0} verify the element", actor -> {
            actor.attemptsTo(
                    WaitUntil.the(element, isVisible()).forNoMoreThan(timeOut).seconds(),
                    Ensure.that(element).isDisplayed()
            );
        });
    }

//    public static Performable theElementIsDisplayed(Target element) {
//        return Task.where("{0} verify the element", actor -> {
//            actor.attemptsTo(
//                    WaitUntil.the(element, isVisible()).forNoMoreThan(20).seconds(),
//                    Ensure.that(element).isDisplayed()
//            );
//        });
//    }

    public static Performable theTextIsEqual(Target target, String compareString) {
        return Task.where("{0} compare the text of element", actor -> {
            actor.attemptsTo(
                    Ensure.that(target).text().isEqualTo(compareString)
            );
        });
    }

    public static Performable theValueIsNotEmpty(Target target1) {
        return Task.where("{0} verify the value is not empty", actor -> {
            actor.attemptsTo(
                    WaitUntil.the(target1,isNotEmpty())
            );
        });
    }
}
