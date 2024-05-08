package net.creqavn.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerifyElement implements Question<Boolean> {

    private WebElementFacade element;

    public VerifyElement(WebElementFacade element) {
        this.element = element;
    }

    public static VerifyElement isVisible(WebElementFacade element) {
        return new VerifyElement(element);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        // Kiểm tra xem phần tử có hiển thị không
        return element.isVisible();
    }
}
