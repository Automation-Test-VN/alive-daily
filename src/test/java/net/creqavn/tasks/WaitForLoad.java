package net.creqavn.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.TheSize;
import net.serenitybdd.screenplay.targets.Target;


public class WaitForLoad {
    public static Performable thePage(Target element) {
        return Task.where("{0} wait for element loaded on the page", actor -> {
            BrowseTheWeb.as(actor).evaluateJavascript("return document.readyState=='complete'");
            Ensure.that(TheSize.of(element).asInteger()).isGreaterThan(1);
        });
    }

    public static Performable thePage(String element) {
        return Task.where("{0} wait for element loaded on the page", actor -> {
            BrowseTheWeb.as(actor).evaluateJavascript("return document.readyState=='complete'");
            Ensure.that(TheSize.of(element).asInteger()).isGreaterThan(1);
        });
    }

    public static Performable thePage() {
        return Task.where("{0} wait for element loaded on the page", actor -> {
            BrowseTheWeb.as(actor).evaluateJavascript("return document.readyState=='complete'");
        });
    }

    public static Performable theURL(String url) {
        return Task.where("{0} wait for page url loaded ", actor -> {
            BrowseTheWeb.as(actor).evaluateJavascript("return document.readyState=='complete'");
            Ensure.thatTheCurrentPage().currentUrl().hasValue().contains(url);
        });
    }

    public static Performable thePageInFewSeconds(int seconds) {
        return Task.where("{0} waits for #seconds seconds",
                actor -> {
                    try {
                        Thread.sleep(seconds * 1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
    }
}
