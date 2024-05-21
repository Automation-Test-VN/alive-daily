package net.creqavn.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class SwipeTo {
    public static Performable theBottom() {
        return Task.where("", actor -> {
            BrowseTheWeb.as(actor).evaluateJavascript("window.scrollTo(0, document.body.scrollHeight)");
        });
    }

    public static Performable theMiddle() {
        return Task.where("", actor -> {
            BrowseTheWeb.as(actor).evaluateJavascript("window.scrollTo(0, document.body.scrollHeight/2)");
        });
    }
}
