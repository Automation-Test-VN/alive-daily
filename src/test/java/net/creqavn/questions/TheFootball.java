package net.creqavn.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import net.serenitybdd.screenplay.targets.Target;


public class TheFootball {

    public static Question<String> name(Target element) {
        return Question.about("the football name").answeredBy(
                actor -> Text.of(element).answeredBy(actor)

        );
    }
}
