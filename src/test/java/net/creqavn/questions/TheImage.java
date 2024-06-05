package net.creqavn.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Trả về danh sách các giá trị của thuộc tính src của các phần tử img có thuộc tính src.
 *
 * @return List<String> - Danh sách các giá trị của thuộc tính src
 */
public class TheImage implements Question<List<String>>{

    static Target imagesWithSrc = Target.the("image")
            .locatedBy("//img");

    public static Question<List<String>> srcAttributes() {
        return new TheImage();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        return imagesWithSrc.resolveAllFor(actor) .stream()
                .map(img -> img.getAttribute("srcset"))
                .collect(Collectors.toList());
    }
}
