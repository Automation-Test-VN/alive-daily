package net.creqavn.ui.convoi;

import net.serenitybdd.screenplay.targets.Target;

public class ConvoiElements {
    public static final String DOMAIN = "https://11bet.uk/";
    public static final Target AVATER_USER = Target
            .the("avater user")
            .locatedBy("//img[@alt='avatar']");

    // REGISTER SESSION
    public static final Target REGISTER_BTN = Target
            .the("register button")
            .locatedBy(".btn--home-register");
    public static final Target REGISTER_FORM = Target
            .the("{0} field")
            .locatedBy("//input[@name='{0}']");
    public static final Target REGISTER_USERNAME = REGISTER_FORM.of("username");
    public static final Target REGISTER_PWD = REGISTER_FORM.of("password");
    public static final Target REGISTER_PHONE_NUMBER = REGISTER_FORM.of("phone");
    public static final Target REGISTER_SUBMIT = Target
            .the("register submit button")
            .locatedBy(".base-button--full");
}
