package net.creqavn.ui.convoi;

import net.serenitybdd.screenplay.targets.Target;

public class ConvoiElements {
    public static final String DOMAIN = "https://11bet.uk/";
    public static final String ACCOUNT_HAS_BALANCE = "cq4atsea01";
    public static final String ACCOUNT_NON_BALANCE = "atcasea1";
    public static final Target LOGOUT_BTN = Target
            .the("logout button")
            .locatedBy("//span[.='Đăng xuất']");
    public static final String EMAIL_VERIFY = "hello210524@yopmail.com";
    public static final Target FORGET_PWD_BTN = Target
            .the("forget password button")
            .locatedBy("//span[.='Khôi phục mật khẩu?']");
    public static final Target EMAIL_RECOVERY_FIELD = Target
            .the("email recovery field")
            .locatedBy("//input[@name='email']");
    public static final Target FORGET_PWD_SUBMIT_BTN = Target
            .the("forget password submit button")
            .locatedBy(".form-forgot-password__submit");
    public static final Target FORGET_PWD_VERIFY = Target
            .the("forget password verify")
            .locatedBy("//div[@class='swal2-content']");
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

    // LOGIN SESSION
    public static final Target LOGIN_BTN = Target
            .the("login button")
            .locatedBy(".btn--home-login");
    public static final Target FORM_LOGIN = Target
            .the("form {0} field")
            .locatedBy("//form[@id='formLogin']//input[@name='{0}']");
    public static final Target FORM_USER_NAME = FORM_LOGIN.of("username");
    public static final Target FORM_PWD = FORM_LOGIN.of("password");
    public static final Target FORM_LOGIN_SUBMIT_BTN = Target
            .the("form login submit button")
            .locatedBy("//form[@id='formLogin']/button[@class='base-button btn base-button form-login__btn base-button--bg-green']");
    public static final String CONTAINS_DEPOSIT = "/?account=deposit&tab=codepay";

    //NO HU SESSION
    public static final Target NO_HU_BTN = Target
            .the("no hu buttton")
            .locatedBy("//p[contains(.,'NỔ HŨ')]");
    public static final String CONTAINS_NO_HU = "/lobby?game=no-hu";
    public static final Target NO_HU_INDEX_PLAY_BTN = Target
            .the("no hu index {0} play btn")
            .locatedBy(".game-list__content > div:nth-of-type(1) button");

}
