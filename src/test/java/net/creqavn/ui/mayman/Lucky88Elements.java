package net.creqavn.ui.mayman;

import net.serenitybdd.screenplay.targets.Target;


public class Lucky88Elements {
    public static final String DOMAIN = "https://lucky88.vip/";
    public static final String ACCOUNT_HAS_BALANCE = "atcasea10";
    public static final String ACCOUNT_NON_BALANCE = "xczx2131";
    public static final String EMAIL_VERIFY = "titss222@yopmail.com";
    public static final Target AVATAR_USER = Target
            .the("avatar user")
            .locatedBy("//div[@class='avatar user-login-information__avatar']");
    public static final Target LOGOUT_BTN = Target
            .the("logout button")
            .locatedBy("//span[.='Đăng xuất']");
    public static final Target BALANCE_NUMBER = Target
            .the("balance number")
            .locatedBy("//span[@class='total-balance__number']");

    //BANK ACCOUNT
    public static final Target BANK_BTN = Target
            .the("bank account")
            .locatedBy("//span[.='ngân hàng']");
    public static final Target ADD_BANK_ACCOUNT_BTN = Target
            .the("add bank account button")
            .locatedBy("//div[@class='button-wrapper']");
    public static final Target FORM_BANK_ACCOUNT = Target
            .the("form bank account")
            .locatedBy("//p[.='Thông tin ngân hàng']");

    public static final Target BONUS_BTN = Target
            .the("bonus button")
            .locatedBy("//span[.='Thưởng']");
    public static final Target BONUS_INFO = Target
            .the("bonus info")
            .locatedBy("//div[@class='information__center']");

    // REGISTER FORM
    public static final Target REGISTER_BTN = Target
            .the("register button")
            .locatedBy(".base-button--bg-green");
    public static final Target REGISTER_FORM = Target
            .the("{0} field")
            .locatedBy("//form[@class='form-register register__form']//input[@name='{0}']");
    public static final Target REGISTER_USERNAME = REGISTER_FORM.of("username");
    public static final Target REGISTER_PWD = REGISTER_FORM.of("password");
    public static final Target REGISTER_PHONE_NUMBER = REGISTER_FORM.of("phone");
    public static final Target REGISTER_SUBMIT = Target
            .the("register submit")
            .locatedBy("//button[contains(text(), 'Tiếp tục')]");
    public static final Target WELCOME_POPUP = Target
            .the("welcome screen")
            .locatedBy("//div[@class='welcome']");
    public static final Target LUCKY_NUMBER = Target
            .the("lucky number")
            .locatedBy("//div[@class='lucky-content__items']/div[contains(.,'0')]");
    public static final Target LUCKY_NUMBER_SUBMIT = Target
            .the("lucky number submit button")
            .locatedBy(".lucky-content__btn");

    //LOGIN FIELD
    public static final Target LOGIN_FIELD = Target
            .the("{0} field")
            .locatedBy("//input[@name='{0}']");
    public static final Target LOGIN_USERNAME = LOGIN_FIELD.of("username");
    public static final Target LOGIN_PWD = LOGIN_FIELD.of("password");
    public static final Target LOGIN_SUBMIT = Target
            .the("login submit button")
            .locatedBy(".base-button--bg-yellow");
    public static final String CONTAINS_DEPOSIT = "account/deposit"; //Verify user non balance login success


    public static final Target GAME_BAI_BTN = Target
            .the("game bai button")
            .locatedBy("//span[.='Game bài']");
    public static final Target INDEX_GAME_PLAY_BTN = Target
            .the("game {0} play button")
            .locatedBy(".lobby-game-list > div:nth-of-type({0}) .game-item__link");
    public static final String CONTAINS_GAME_BAI = "/game-bai";
    public static final Target GAME_BAI_RIK = INDEX_GAME_PLAY_BTN.of("1");
    public static final Target GAME_BAI_GO = INDEX_GAME_PLAY_BTN.of("2");


    //LOGIN FORM
    public static final Target LOGIN_FORM = Target
            .the("{0} field")
            .locatedBy(".form-login [name='{0}']");
    public static final Target FORM_LOGIN_USERNAME = LOGIN_FORM.of("username");
    public static final Target FORM_LOGIN_PWD = LOGIN_FORM.of("password");
    public static final Target FORM_LOGIN_SUBMIT_BTN = Target
            .the("form login submit button")
            .locatedBy(".form-login__btn");
    public static final Target POPUP_DEPOSIT = Target
            .the("popup deposit")
            .locatedBy("//span[.='Nạp ngay']");

    //FORGET PWD
    public static final Target FORGET_PWD_BTN = Target
            .the("forget password button")
            .locatedBy("//img[@class='user-not-login__forgot-password']");
    public static final Target EMAIL_RESTORE_FIELD = Target
            .the("email restore field")
            .locatedBy("//input[@name='email']");
    public static final Target EMAIL_RESTORE_BTN = Target
            .the("email restore button")
            .locatedBy("//button[contains(text(), 'Khôi phục mật khẩu')]");
    public static final Target RESTORE_NOTIFY = Target
            .the("restore notify")
            .locatedBy("//div[@class='swal2-html-container']");

    public static final Target FIRST_SWIPER_PAGINATION = Target
            .the("first swiper pagination")
            .locatedBy(".swiper-pagination > span:nth-of-type(1)");
    public static final Target FIRST_HERO_BANNER = Target
            .the("first hero banner")
            .locatedBy("//img[@alt='Thuong 30']");
    public static final String CONTAINS_HERO_BANNER = "saleoff/detail/saleoff-30";

    public static final Target FIRST_HOMEPAGE_CASINO = Target
            .the("first homepage casino")
            .locatedBy("//div[@class='game-provider']/div[1]/img[@class='live-casino-img']");

    //FOOTER
    public static final Target HOT_NEWS = Target
            .the("hot news")
            .locatedBy("//div[@class='news-category__hot col-4']/a");
    public static final String CONTAINS_NEWS = "/news/detail";
    public static final Target ABOUT_US = Target
            .the("about us")
            .locatedBy("//a[contains(.,'Giới thiệu')]");
    public static final String CONTAINS_ABOUT_US = "/about-us";
    public static final Target SU_KIEN_HOT_BTN = Target
            .the("su kien hot button")
            .locatedBy("//p[@class='text']");
    public static final Target SIEU_PHAM_HOI_TU_BTN = Target
            .the("sieu pham hoi tu")
            .locatedBy("//p[.='Siêu phẩm hội tụ']");
    public static final String CONTAINS_SIEU_PHAM_HOI_TU = "/event-puzzle";
    public static final Target TY_LE_KEO_BTN = Target
            .the("ty le keo button")
            .locatedBy("//a[contains(.,'Tỷ lệ kèo')]");
    public static final String CONTAINS_TY_LE_KEO = "/ty-le-keo";
    public static final Target TERMS_BTN = Target
            .the("terms button")
            .locatedBy("//a[contains(.,'Điều khoản & Điều kiện')]");
    public static final String CONTAINS_TERMS = "/terms-conditions";
    public static final Target PRIVACY_POLICY_BTN = Target
            .the("privacy policy button")
            .locatedBy("//a[contains(.,'Chính sách bảo  mật')]");
    public static final String CONTAINS_PRIVACY_POLICY = "/privacy-policy";
    public static final Target QUESTION_BTN = Target
            .the("target button")
            .locatedBy("//div[@class='top']/a[contains(.,'Câu hỏi thường gặp')]");
    public static final String CONTAINS_QUESTION = "/help/question";
    public static final Target FIRST_QUESTION = Target
            .the("first question")
            .locatedBy("[aria-controls='question-1'] span:nth-of-type(1)");
    public static final Target FIRST_ANSWER = Target
            .the("first answer")
            .locatedBy(".show.popular-question__description > .popular-question__description--content");
    public static final Target PROMOTION_INFOR_BTN = Target
            .the("promotion infor button")
            .locatedBy("//a[contains(.,'Tin Khuyến mãi')]");
    public static final String CONTAINS_PROMOTION_INFO = "/saleoff";
    public static final Target CONTACT_BTN = Target
            .the("contact button")
            .locatedBy("//a[contains(.,'Liên hệ')]");
    public static final String CONTAINS_CONTACT = "/contact-us";

    //JACKPOT FORM
    public static final Target JACKPOT_AREA = Target
            .the("jackpot form")
            .locatedBy("//section[@class='jackpot-home']/div[@class='container-custom']");
    public static final Target JACKPOT_NUMBER = Target
            .the("jackpot number")
            .locatedBy(".jackpot-home__left--amount > .animation-number");
    public static final Target JACKPOT_RECENT = Target
            .the("jackpot recent")
            .locatedBy(".jackpot-home__center--recent > .value");
    public static final Target JACKPOT_MONTH = Target
            .the("jackpot month")
            .locatedBy(".jackpot-home__center--month > .value");
    public static final Target JACKPOT_FISH = Target
            .the("jackpot fish")
            .locatedBy(".jackpot-home__center--top-hu > .value");
    public static final Target JACKPOT_FIRST_GAME = Target
            .the("jackpot first game")
            .locatedBy("//div[@class='game-item swiper-slide swiper-slide-active']");

    //PROFILE FORM
    public static final Target FORM_PROFILE_INFO = Target
            .the("field {0}")
            .locatedBy("//div[@class='info-form']/div[{0}]//input[1]");
    public static final Target PROFILE_USERNAME = FORM_PROFILE_INFO.of("1");
    public static final Target PROFILE_PWD = FORM_PROFILE_INFO.of("2");
    public static final Target PROFILE_DISPLAY_NAME = FORM_PROFILE_INFO.of("3");
    public static final Target PROFILE_EMAIL = FORM_PROFILE_INFO.of("5");
    public static final Target VERIFY_EMAIL_BTN = Target
            .the("verify email button")
            .locatedBy("//div[@class='info-form']/div[5]//span[.='Xác thực']");
    public static final String CONTAINS_PROFILE = "/account/user/profile";
    public static final Target EMAIL_CONFIRM_NOTIFICATION = Target
            .the("email confirm notification")
            .locatedBy("//div[@class='swal2-html-container']");

    //CHANGE PWD FORM
    public static final Target CHANGE_PWD_BTN = Target
            .the("change password button")
            .locatedBy("//span[.='Thay đổi']");
    public static final Target FORM_CHANGE_PWD = Target
            .the("field {0}")
            .locatedBy("[placeholder='{0}']");
    public static final Target CURRENT_PWD_FIELD = FORM_CHANGE_PWD.of("Nhập mật khẩu hiện tại");
    public static final Target NEW_PWD_FIELD = FORM_CHANGE_PWD.of("Nhập mật khẩu mới");
    public static final Target CONFIRM_NEW_PWD_FIELD = FORM_CHANGE_PWD.of("Xác nhận mật khẩu mới");
    public static final Target CHANGE_PWD_SUBMIT_BTN = Target
            .the("change password submit butotn")
            .locatedBy("//button[@class='base-button btn base-button base-button-custom base-button--full']");

    public static final Target VERIFY_PHONE_NUMBER_BTN = Target
            .the("verify phone number button")
            .locatedBy("//div[@id='phone']//span[.='Xác thực']");
    public static final Target VERIFY_PHONE_NUMBER_NOW_BTN = Target
            .the("verify phone number now button")
            .locatedBy("//div[@class='StepProgress-item__button']");

    // HOT MATCH SESSION
    public static final Target LEFT_FOOTBALL_TEAM = Target
            .the("left football team")
            .locatedBy(".swiper-slide-visible .hot-match-item__left > .hot-match-item__name");
    public static final Target RIGHT_FOOTBAL_TEAM = Target
            .the("right football team")
            .locatedBy(".swiper-slide-visible .hot-match-item__right > .hot-match-item__name");
    public static final Target HOT_MATCH_BET_BTN = Target
            .the("hot match bet button")
            .locatedBy(".swiper-slide-visible .btn-asport > span");
    public static final Target HOT_MATCH_LEFT_TEAM = Target
            .the("hot match left team")
            .locatedBy("//*[@class=\"wrapper-match-component \"]//div[1]/div[@class='row-team-name']");
    public static final Target HOT_MATCH_RIGHT_TEAM = Target
            .the("hot match right team")
            .locatedBy("//*[@class=\"wrapper-match-component \"]//div[2]/div[@class='row-team-name']");
    public static final String FIRST_IFRAME = "my-frame";
    public static final String SPORT_IFRAME = "sportsFrame";
    public static final Target GAME_IFRAME = Target
            .the("game iframe")
            .locatedBy("//iframe[@id='frmGame']");

    // SPORT SESSION
    public static final Target SPORT_BTN = Target
            .the("sport button")
            .locatedBy("//span[.='THỂ THAO']");
    public static final Target SPORT_K_BTN = Target
            .the("sport k button")
            .locatedBy("//img[@alt='thể thao ksport']");
    public static final Target SPORT_K_VERIFY = Target
            .the("sport k verify")
            .locatedBy(".wrapper-match-live > .handicap-match-header");
    public static final Target SPORT_I_BTN = Target
            .the("sport i button")
            .locatedBy("//img[@alt='thể thao i-sports']");
    public static final Target SPORT_I_VERIFY = Target
            .the("sport i verify")
            .locatedBy("//*[@id=\"rc_streamer_frame\"]");
    public static final Target SPORT_A_BTN = Target
            .the("sport a button")
            .locatedBy("//img[@alt='thể thao asports']");
    public static final Target SPORT_A_VERIFY = Target
            .the("sport a verify")
            .locatedBy("//*[@id=\"mainArea\"]//div[@class='c-odds-table__header']");
    public static final Target SPORT_C_BTN = Target
            .the("sport c button")
            .locatedBy("//img[@alt='thể thao csport']");
    public static final Target SPORT_C_VERIFY = Target
            .the("sport c verify")
            .locatedBy("//*[@id=\"isEventPage\"]//header[@class='eventlist_asia_fe_Header_header']");
    public static final Target SPORT_M_BTN = Target
            .the("sport m button")
            .locatedBy("//img[@alt='thể thao msport']");
    public static final Target SPORT_M_VERIFY = Target
            .the("sport m verify")
            .locatedBy("handicap-ou-component > [data-radium='true'] > div:nth-of-type(1) > div");
    public static final Target SPORT_HOT_DEAL_BTN = Target
            .the("sport hot deal button")
            .locatedBy("//span[@class='sub-title sub-title--hot']");
    public static final Target SPORT_HOT_DEAL_VERIFY = Target
            .the("sport hot deal verify")
            .locatedBy("//div[@class='league__matchs']");
    public static final Target SPORT_VIRTUAL_BTN = Target
            .the("sport virtual button")
            .locatedBy("//div[@class='sub-menu sports']//span[contains(.,'Thể Thao Ảo')]");
    public static final Target SPORT_VIRTUAL_VERIFY = Target
            .the("sport virtual verify")
            .locatedBy("//*[@id=\"mainArea\"]//div[@title='Trận Đấu']");
    public static final Target SPORT_E_SPORT_BTN = Target
            .the("sport e-sport button")
            .locatedBy("//span[contains(.,'Thể thao điện tử')]");
    public static final Target SPORT_E_SPORT_VERIFY = Target
            .the("sport e-sport verify")
            .locatedBy("//div[@class='odds-table']");
    public static final Target SPORT_HORSE_RACING_BTN = Target
            .the("sport horse racing button")
            .locatedBy("//a[contains(.,'Đua Ngựa 3D')]");
    public static final String CONTAINS_HORSE_RACING = "https://games.mt-sta.com/kts6998";

    // CASINO SESSION
    public static final Target LIVE_CASINO_BTN = Target
            .the("casino button")
            .locatedBy("//span[.='casino']");
    public static final Target FIRST_TABLE_PLAY_BTN = INDEX_GAME_PLAY_BTN.of("1");
    public static final Target VIVO_CASINO_BTN = Target
            .the("vivo casino button")
            .locatedBy("//a[contains(.,'Vivo gaming')]");
    public static final Target VIVO_CASINO_VERIFY = Target
            .the("vivo casino verify")
            .locatedBy("//div[@class='center cell']");
    public static final Target MG_CASINO_BTN = Target
            .the("mg casino button")
            .locatedBy("//a[contains(.,'MG live')]");
    public static final Target MG_CASINO_VERIFY = Target
            .the("mg casino verify")
            .locatedBy("//canvas[@id='render-canvas']");
    public static final String CONTAINS_MG_CASINO = "https://contapp8895.agconth5.com/";
    public static final Target EZUGI_CASINO_BTN = Target
            .the("ezugi casino button")
            .locatedBy("//a[contains(.,'Ezugi')]");
    public static final Target EZUGI_CASINO_VERIFY = Target
            .the("ezugi casino verify")
            .locatedBy("//*[@id=\"scroller\"]/div[1]/div[3]/div/div[2]/div[*]");
    public static final String CONTAINS_EZUGI_CASINO = "https://play.livetables.io/";
    public static final Target EVOLUTION_CASINO_BTN = Target
            .the("evolution casino button")
            .locatedBy("//a[contains(.,'evolution gaming')]");
    public static final Target EVOLUTION_CASINO_IFRAME = Target
            .the("evolution casino iframe")
            .locatedBy("//iframe[@src]");
    public static final Target EVOLUTION_CASINO_VERIFY = Target
            .the("evolution casino verify")
            .locatedBy("//*[@id=\"lobby-root\"]//ul[@data-role='category-navigator']");

    // LO DE SESSION
    public static final Target LO_DE_BTN = Target
            .the("lo de button")
            .locatedBy("//a[@class='menu__link']//span[.='Lô Đề']");
    public static final Target LO_DE_3_MIEN_BTN = Target
            .the("lo de 3 mien button")
            .locatedBy("//span[contains(.,'Lô đề 3 miền')]");
    public static final Target LO_DE_3_MIEN_VERIFY = Target
            .the("lo de 3 mien verify")
            .locatedBy("//div[@class='danhlo']");
    public static final Target LO_DE_KENO_VIETLOT_BTN = INDEX_GAME_PLAY_BTN.of("2");
    public static final Target LO_DE_KENO_VIETLOT_VERIFY = Target
            .the("keno vietlot verify")
            .locatedBy(".tab-choose .tabs");
    public static final Target LO_DE_SIEU_TOC_BTN = Target
            .the("lo de sieu toc button")
            .locatedBy("//a[contains(.,'Lô đề siêu tốc')]");
    public static final Target LO_DE_SIEU_TOC_VERIFY = Target
            .the("lo de sieu toc verify")
            .locatedBy("//table[@class='danhlo-table']");

    // NO HU SESSION
    public static final Target NO_HU_BTN = Target
            .the("no hu button")
            .locatedBy("//a[contains(.,'NỔ HŨ')]");
    public static final Target NO_HU_GAME_PLAY_BTN = INDEX_GAME_PLAY_BTN.of("1");
    public static final String CONTAINS_NO_HU_GAME = "https://games.mt-sta.com/kts";
    public static final Target NO_HU_GAME_MONEY = Target
            .the("no hu game money")
            .locatedBy("//div[@class='lobby-game-list']/div[1]//div[@class='jackpot']/span");

    // TABLE GAME SESSION
    public static final Target TABLE_GAME_BTN = Target
            .the("table game button")
            .locatedBy("//a[contains(.,'Table Games')]");
    public static final Target TABLE_GAME_RIK = INDEX_GAME_PLAY_BTN.of("2");
    public static final Target TABLE_GAME_GO = INDEX_GAME_PLAY_BTN.of("1");
    public static final Target TABLE_GAME_TP = INDEX_GAME_PLAY_BTN.of("10");
    public static final Target TABLE_GAME_B52 = INDEX_GAME_PLAY_BTN.of("24");
    public static final Target GO_SUPPLIER_VERIFY = Target
            .the("game bai go verify")
            .locatedBy("//canvas[@id='GameCanvas']");
    public static final Target TP_SUPPLIER_VERIFY = Target
            .the("tp supplier verify")
            .locatedBy("//canvas[@id='GameCanvas']");
    public static final Target RIK_SUPPLIER_VERIFY = Target
            .the("game bai rik verify")
            .locatedBy("//canvas[@id='GameCanvas']");
    public static final Target B52_SUPPLIER_VERIFY = Target
            .the("game bai rik verify")
            .locatedBy("//canvas[@id='GameCanvas']");

    // BAN CA SESSION
    public static final Target BAN_CA_BTN = Target
            .the("ban ca button")
            .locatedBy("//a[contains(.,'Bắn cá')]");
    public static final Target BAN_CA_TP = INDEX_GAME_PLAY_BTN.of("1");
    public static final Target BAN_CA_CQ9 = INDEX_GAME_PLAY_BTN.of("6");
    public static final Target BAN_CA_QTECH = INDEX_GAME_PLAY_BTN.of("9");
    public static final Target QTECH_SUPPLIER_IFRAME = Target
            .the("qtech supplier iframe")
            .locatedBy("//iframe[@id='gameIframe']");
    public static final Target QTECH_SUPPLIER_VERIFY = Target
            .the("qtech supplier verify")
            .locatedBy("//canvas[@id='GameCanvas']");
    public static final Target CQ9_SUPPLIER_VERIFY = Target
            .the("cq9 supplier verify")
            .locatedBy("//canvas[@id='gameCanvas']");

    // KENO SESSION
    public static final Target KENO_BTN = Target
            .the("keno button")
            .locatedBy("//span[.='Keno']");
    public static final Target KENO_PLAY_BTN = INDEX_GAME_PLAY_BTN.of("1");

    // QUAY SO SESSION
    public static final Target QUAY_SO_BTN = Target
            .the("quay so button")
            .locatedBy("//span[.='Quay Số']");
    public static final Target QUAY_SO_PLAY_BTN = INDEX_GAME_PLAY_BTN.of("1");
    public static final Target QUAY_SO_VERIFY = Target
            .the("quay so verify")
            .locatedBy("//div[@class='c-numbergaming']");

    // XEM THEM SESSION
    public static final Target XEM_THEM_BTN = Target
            .the("xem them button")
            .locatedBy("//span[.='Xem Thêm']");
    public static final Target GAME_NHANH_BTN = Target
            .the("game nhanh button")
            .locatedBy("//span[contains(.,'Game Nhanh')]");
    public static final Target CO_UP_BTN = Target
            .the("co up button")
            .locatedBy("//span[contains(.,'Cờ Úp')]");
    public static final Target GAME_KHAC_BTN = Target
            .the("game khac button")
            .locatedBy("//span[contains(.,'Game Khác')]");
    public static final Target XEM_THEM_PLAY_BTN = INDEX_GAME_PLAY_BTN.of("1");
}
