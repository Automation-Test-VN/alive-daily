package net.creqavn.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import net.serenitybdd.screenplay.targets.Target;


public class ElementUtils {

    public static Question<String> textOfElement(Target element) {
        return Question.about("the football textOfElement").answeredBy(
                actor -> Text.of(element).answeredBy(actor)
        );
    }

    public static Question<Integer> lengthOfElements(Target element) {
        return Question.about("the length of element").answeredBy(
                actor -> element.resolveAllFor(actor).size()
        );
    }
}
