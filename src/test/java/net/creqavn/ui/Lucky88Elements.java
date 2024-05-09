package net.creqavn.ui;

import net.serenitybdd.screenplay.ensure.web.PageObjectEnsure;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Lucky88Elements {
    public static final String ACCOUNT_HAS_BALANCE="atcasea10";
    public static final String ACCOUNT_NON_BALANCE="xczx2131";
    public static final Target REGISTER_BTN = Target.the("register button").locatedBy(".base-button--bg-green");
    public static final Target REGISTER_SUBMIT = Target.the("register submit").locatedBy(".base-button--full");
    public static final Target WELCOME_POPUP = Target.the("welcome screen").locatedBy("//div[@class='welcome']");
    public static final Target REGISTER_USERNAME = Target.the("register username").locatedBy(".form-register [name='username']");
    public static final Target REGISTER_PWD = Target.the("register pwd").locatedBy("//div[@class='base-input base-input--password']//input[@name='password']");
    public static final Target REGISTER_PHONE_NUMBER = Target.the("phone number").locatedBy(".form-register [name='phone']");
    public static final Target LUCKY_NUMBER = Target.the("lucky number").locatedBy("//div[@class='lucky-content__item'][1]");
    public static final Target LUCKY_NUMBER_SUBMIT = Target.the("lucky number submit button").locatedBy(".lucky-content__btn");
    public static final Target LOGIN_USERNAME=Target.the("login username").locatedBy("//input[@name='username']");
    public static final Target LOGIN_PWD=Target.the("login pwd").locatedBy("//input[@name='password']");
    public static final Target LOGIN_SUBMIT=Target.the("login submit button").locatedBy("//button[contains(@class,'btn--home-login')]");
    public static final String CONTAINS_NOHU="type=no-hu";
    public static final String CONTAINS_DEPOSIT="account/deposit";
    public static final Target GAME_BAI_BTN=Target.the("game bai button").locatedBy("//span[.='Game bài']");
    public static final Target GAME_BAI_TLMN=Target.the("game tien len mien nam").locatedBy("//img[@alt='Tiến Lên Miền Nam']");
}
