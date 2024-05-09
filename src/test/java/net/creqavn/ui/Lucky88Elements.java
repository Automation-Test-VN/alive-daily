package net.creqavn.ui;

import net.serenitybdd.screenplay.targets.Target;


public class Lucky88Elements {
    public static final String DOMAIN="https://lucky88.vip/";
    public static final String ACCOUNT_HAS_BALANCE="atcasea10";
    public static final String ACCOUNT_NON_BALANCE="xczx2131";

    // REGISTER FORM
    public static final Target REGISTER_FORM =Target.the("{0} field").locatedBy(" //form[@class='form-register register__form']//input[@placeholder='{0}']");
    public static final Target REGISTER_USERNAME = REGISTER_FORM.of("Nhập tên đăng nhập");
    public static final Target REGISTER_PWD = REGISTER_FORM.of("Nhập mật khẩu");
    public static final Target REGISTER_PHONE_NUMBER = REGISTER_FORM.of("Nhập số điện thoại");
    public static final Target REGISTER_BTN = Target.the("register button").locatedBy(".base-button--bg-green");
    public static final Target REGISTER_SUBMIT = Target.the("register submit").locatedBy(".base-button--full");
    public static final Target WELCOME_POPUP = Target.the("welcome screen").locatedBy("//div[@class='welcome']");
    public static final Target LUCKY_NUMBER = Target.the("lucky number").locatedBy("//div[@class='lucky-content__item'][1]");
    public static final Target LUCKY_NUMBER_SUBMIT = Target.the("lucky number submit button").locatedBy(".lucky-content__btn");

    //LOGIN FIELD
    public static final Target LOGIN_FIELD = Target.the("{0} field").locatedBy("//input[@name='{0}']");
    public static final Target LOGIN_USERNAME=LOGIN_FIELD.of("username");
    public static final Target LOGIN_PWD=LOGIN_FIELD.of("password");
    public static final Target LOGIN_SUBMIT=Target.the("login submit button").locatedBy("//button[contains(@class,'btn--home-login')]");
    public static final String CONTAINS_NOHU="type=no-hu"; //Verify user has balance login success
    public static final String CONTAINS_DEPOSIT="account/deposit"; //Verify user non balance login success


    public static final Target GAME_BAI_BTN=Target.the("game bai button").locatedBy("//span[.='Game bài']");
    public static final Target GAME_BAI_TLMN=Target.the("game tien len mien nam").locatedBy("//div[@class='lobby-game-list game-bai']/div[1]//a[@href='javascript:void(0)']");
    public static final String CONTAINS_GAME_BAI="/game-bai";

    //LOGIN FORM
    public static final Target LOGIN_FORM=Target.the("{0} field").locatedBy("//form[@class='form-login user-not-login__form']//input[@name='{0}']");
    public static final Target FORM_LOGIN_USERNAME=LOGIN_FORM.of("username");
    public static final Target FORM_LOGIN_PWD=LOGIN_FORM.of("password");
    public static final Target FORM_LOGIN_SUBMIT_BTN=Target.the("form login submit button").locatedBy(".form-login__btn");
    public static final Target POPUP_DEPOSIT=Target.the("popup deposit").locatedBy("//div[@class='modal-deposit']");


}
