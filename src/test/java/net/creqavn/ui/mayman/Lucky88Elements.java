package net.creqavn.ui.mayman;

import net.serenitybdd.screenplay.targets.Target;
import org.checkerframework.checker.index.qual.PolyUpperBound;


public class Lucky88Elements {
    public static final String DOMAIN="https://lucky88.vip/";
    public static final String ACCOUNT_HAS_BALANCE="atcasea10";
    public static final String ACCOUNT_NON_BALANCE="xczx2131";
    public static final Target AVATAR_USER=Target.the("avatar user").locatedBy("//div[@class='avatar user-login-information__avatar']");
    public static final Target LOGOUT_BTN=Target.the("logout button").locatedBy("//span[.='Đăng xuất']");

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

    public static final Target FORGET_PWD_BTN=Target.the("forget password button").locatedBy("//img[@class='user-not-login__forgot-password']");
    public static final Target EMAIL_RESTORE_FIELD=Target.the("email restore field").locatedBy("//input[@name='email']");
    public static final Target EMAIL_RESTORE_BTN=Target.the("email restore button").locatedBy("//form[@class='form-forgot-password user-not-login__form']//button");
    public static final String VERIFIED_EMAIL="titss222@yopmail.com";
    public static final Target RESTORE_NOTIFY=Target.the("restore notify").locatedBy("//div[@class='swal2-html-container']");

    public static final Target FIRST_SWIPER_PAGINATION = Target.the("first swiper pagination").locatedBy(".swiper-pagination > span:nth-of-type(1)");
    public static final Target FIRST_HERO_BANNER = Target.the("first hero banner").locatedBy("//img[@alt='Thuong 30']");
    public static final String CONTAINS_HERO_BANNER="saleoff/detail/saleoff-30";
    public static final Target BALANCE_NUMBER=Target.the("balance number").locatedBy("//span[@class='total-balance__number']");

    public static final Target FIRST_HOMEPAGE_CASINO=Target.the("first homepage casino").locatedBy("//div[@class='game-provider']/div[1]");
    public static final String CONTAINS_EZUGI_CASINO="play.livetables.io";

    public static final Target HOT_NEWS=Target.the("hot news").locatedBy("//div[@class='news-category__hot col-4']/a");
    public static final String CONTAINS_NEWS="/news/detail";
    public static final Target ABOUT_US = Target.the("about us").locatedBy("//a[contains(.,'Giới thiệu')]");
    public static final String CONTAINS_ABOUT_US="/about-us";

    public static final Target SU_KIEN_HOT_BTN = Target.the("su kien hot button").locatedBy("//p[@class='text']");
    public static final Target SIEU_PHAM_HOI_TU_BTN = Target.the("sieu pham hoi tu").locatedBy("//p[.='Siêu phẩm hội tụ']");
    public static final String CONTAINS_SIEU_PHAM_HOI_TU = "/event-puzzle";

    public static final Target TY_LE_KEO_BTN=Target.the("ty le keo button").locatedBy("//a[contains(.,'Tỷ lệ kèo')]");
    public static final String CONTAINS_TY_LE_KEO="/ty-le-keo";

    public static final Target TERMS_BTN=Target.the("terms button").locatedBy("//a[contains(.,'Điều khoản & Điều kiện')]");
    public static final String CONTAINS_TERMS="/terms-conditions";

    public static final Target PRIVACY_POLICY_BTN=Target.the("privacy policy button").locatedBy("//a[contains(.,'Chính sách bảo  mật')]");
    public static final String CONTAINS_PRIVACY_POLICY="/privacy-policy";

    public static final Target QUESTION_BTN=Target.the("target button").locatedBy("//div[@class='top']/a[contains(.,'Câu hỏi thường gặp')]");
    public static final String CONTAINS_QUESTION="/help/question";
    public static final Target FIRST_QUESTION=Target.the("first question").locatedBy("[aria-controls='question-1'] span:nth-of-type(1)");
    public static final Target FIRST_ANSWER=Target.the("first answer").locatedBy(".show.popular-question__description > .popular-question__description--content");

    public static final Target PROMOTION_INFOR_BTN=Target.the("promotion infor button").locatedBy("//a[contains(.,'Tin Khuyến mãi')]");
    public static final String CONTAINS_PROMOTION_INFO="/saleoff";

    public static final Target CONTACT_BTN=Target.the("contact button").locatedBy("//a[contains(.,'Liên hệ')]");
    public static final String CONTAINS_CONTACT="/contact-us";

    public static final Target JACKPOT_FORM=Target.the("jackpot form").locatedBy("//section[@class='jackpot-home']/div[@class='container-custom']");
    public static final Target JACKPOT_NUMBER = Target.the("jackpot number").locatedBy(".jackpot-home__left--amount > .animation-number");
    public static final Target JACKPOT_RECENT = Target.the("jackpot recent").locatedBy(".jackpot-home__center--recent > .value");
    public static final Target JACKPOT_MONTH=Target.the("jackpot month").locatedBy(".jackpot-home__center--month > .value");
    public static final Target JACKPOT_FISH=Target.the("jackpot fish").locatedBy(".jackpot-home__center--top-hu > .label");
    public static final Target JACKPOT_FIRST_GAME=Target.the("jackpot first game").locatedBy("//div[@class='game-item swiper-slide swiper-slide-active']");
}
