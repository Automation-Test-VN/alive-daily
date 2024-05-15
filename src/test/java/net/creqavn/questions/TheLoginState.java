package net.creqavn.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;


public class TheLoginState {

    public static Question<Boolean> isElementPresent(Target element) {
//        return actor -> numberOfTodoItems(element).answeredBy(actor) > 0;
        return actor -> !BrowseTheWeb.as(actor).findAll(element).isEmpty();
    }
}
