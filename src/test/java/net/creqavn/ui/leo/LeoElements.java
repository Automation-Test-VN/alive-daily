package net.creqavn.ui.leo;

import net.serenitybdd.screenplay.targets.Target;

public class LeoElements {
    public static final String DOMAIN = "https://leo88.top/en-TH";
    public static final String VALID_ACCOUNT = "atcacarry5";
    public static final String INVALID_ACCOUNT = "atcacarry1";
    public static final String EMAIL_VERIFY = "hello210524@yopmail.com";
    public static final Target LOGGED_USER = Target
            .the("logged user")
            .locatedBy(".truncate");
    public static final Target LOGOUT_BTN = Target
            .the("logout button")
            .locatedBy("//li[.='Logout']");
    public static final Target USER_INFO_BTN = Target
            .the("user info button")
            .locatedBy("//li[.='User Information']");
    public static final Target USER_INFO = Target
            .the("user infor")
            .locatedBy("//div[@class='flex items-center justify-center py-7 px-[25px]']");
    public static final Target BANK_DETAILS_BTN = Target
            .the("bank details button")
            .locatedBy("//span[contains(text(),'Bank Details')]");
    public static final Target BANK_DETAILS = Target
            .the("bank details")
            .locatedBy("//div[@class='w-full pl-3.5 space-y-[18px]']");
    public static final Target CHANGE_PWD_BTN = Target
            .the("change password button")
            .locatedBy("//span[.='Change Password']");
    public static final Target CHANGE_PWD = Target
            .the("change password")
            .locatedBy("//div[@class='flex flex-col items-center justify-center w-full space-y-8']");
    public static final Target PROMOTION_CASHBACK_BTN = Target
            .the("promotion and cashback button")
            .locatedBy("//span[.='Promotion & Bonus']");
    public static final Target PROMOTION_CASHBACK = Target
            .the("promotion and cashback")
            .locatedBy("//div[@class='py-6 px-9']");
    public static final Target VIP_PROGRAM_BTN = Target
            .the("vip program button")
            .locatedBy("//span[.='VIP Program']");
    public static final Target VIP_PROGRAM = Target
            .the("vip program")
            .locatedBy("//div[@class='px-9 pb-9 lg:px-4 md:px-4']");

    // SIGN UP SESSION
    public static final Target SIGN_UP_BTN = Target
            .the("sign up button")
            .locatedBy(".bg-btn-action > .w-full");
    public static final Target FORM_SIGN_UP = Target
            .the("form sign up {0} field")
            .locatedBy("//input[@id='{0}']");
    public static final Target SIGN_UP_USERNAME = FORM_SIGN_UP.of("username");
    public static final Target SIGN_UP_PWD = FORM_SIGN_UP.of("password");
    public static final Target SIGN_UP_RE_PWD = FORM_SIGN_UP.of("confirmPassword");
    public static final Target SIGN_UP_SUBMIT = Target
            .the("sign up submit")
            .locatedBy(".text-base > .w-full");
    public static final String PWD_RECOVERY_TEXT = "Recovery link will be sent to your registered Email by clicking on button";
    public static final Target PWD_RECOVERY_NOTY = Target
            .the("password recovery noty")
            .locatedBy("//span[@class='text-center text-white text-1xs mb-[61px] font-bold']");
    public static final Target FORGET_PWD_SUBMIT = Target
            .the("forget password submit")
            .locatedBy(".capitalize.font-bold > .w-full");

    // SIGN IN SESSION
    public static final Target SIGN_IN_BTN = Target
            .the("sign in button")
            .locatedBy(".bg-btn-action-yellow > .w-full");
    public static final Target FORM_SIGN_IN = Target
            .the("form sign in {0} field")
            .locatedBy("//input[@id='{0}']");
    public static final Target SIGN_IN_USERNAME = FORM_SIGN_IN.of("username");
    public static final Target SIGN_IN_PWD = FORM_SIGN_IN.of("password");
    public static final Target SIGN_IN_SUBMIT = Target
            .the("sign in submit")
            .locatedBy(".text-base > .w-full");
    public static final Target FORGET_PWD = Target
            .the("forget password")
            .locatedBy("//div[contains(text(),'Forgot password')]");

    // HOMEPAGE SESSION
    public static final Target HERO_BANNER = Target
            .the("hero banner")
            .locatedBy("//img[@alt='Live Casino']");
    public static final String CONTAINS_HERO_BANNER = "/promotion/live-casino-bonus";
    public static final Target SUB_BANNER = Target
            .the("sub banner")
            .locatedBy("[src='/_next/image?url=https%3A%2F%2Fadmin.leo88.com%2Fwp-content%2Fuploads%2F2024%2F01%2FCASHBACK-copy-2-1.png&w=3840&q=100']");
    public static final String CONTAIN_SUB_BANNER = "/promotion/special-unlimited-cashback";
    public static final Target MOST_POPULAR_BTN = Target
            .the("most popular button")
            .locatedBy("//img[@alt='local-active-3']");
    public static final Target MOST_COMMON_BTN = Target
            .the("most common button")
            .locatedBy("//*[@id=\"__next\"]/div/main/div/div[5]/div/div/div[2]/div[1]/div/div[3]/div/div[1]/div/div/div[1]/span/img");
    public static final Target GAME_CANVAS = Target
            .the("canvas")
            .locatedBy("//canvas[@id='GameCanvas']");
    public static final Target BEST_LIVE_CASINO = Target
            .the("best live casino")
            .locatedBy("//div[@class='swiper-slide swiper-slide-prev !w-80']//span[1]");
    public static final Target LIVE_CHAT_BTN = Target
            .the("live chat button")
            .locatedBy("//div[@id='chat-widget-container']");
    public static final Target LIVE_CHAT_IFRAME = Target
            .the("live chat iframe")
            .locatedBy("//iframe[@id='chat-widget']");
    public static final Target LIVE_CHAT_MINIMIZE_BTN = Target
            .the("live chat minimize button")
            .locatedBy("//div[@dir='ltr']/div[@role='main']/div[3]/button[2]");


    // IFRAME COLLECTION
    public static final Target K_SPORT_IFRAME = Target
            .the("sport k iframe")
            .locatedBy("//iframe[@id='kSport']");
    public static final Target A_SPORT_IFRAME = Target
            .the("sport a iframe")
            .locatedBy("//iframe[@id='aSport']");
    public static final Target SPORT_IFRAME = Target
            .the("sport iframe")
            .locatedBy("//*[@id=\"sportsFrame\"]");
    public static final Target BTI_IFRAME = Target
            .the("sport bti iframe")
            .locatedBy("//iframe[@id='bti']");
    public static final Target V_SPORT_IFRAME = Target
            .the("sport v iframe")
            .locatedBy("//iframe[@id='vSport']");
    public static final Target VIRTUAL_IFRAME = Target
            .the("virtual iframe")
            .locatedBy("//*[@id=\"virtualIframe\"]");
    public static final Target VIRTUAL_IFRAME_2 = Target
            .the("virtual iframe 2")
            .locatedBy("//div[@class='sr-entertainment-area']/iframe[@id=\"vsm-ea-iframe\"]");
    public static final Target ATHENA_SABA_IFRAME = Target
            .the("athena saba iframe")
            .locatedBy("//iframe[@id='Athena saba']");
    public static final Target SABA_IFRAME = Target
            .the("saba iframe")
            .locatedBy("//iframe[@id='saba']");
    public static final Target IM_IFRAME = Target
            .the("im iframe")
            .locatedBy("//iframe[@id='im']");
    public static final Target EVOLUTION_IFRAME = Target
            .the("evolution iframe")
            .locatedBy("//iframe[contains(@src,'https://skylinetechplayivo.evo-games.com/frontend/evo/r2/#provider=evolution')]");
    public static final Target GAME_IFRAME = Target
            .the("game iframe")
            .locatedBy("//iframe[@id='gameIframe']");
    public static final Target SLOT_CONTAINER_IFRAME = Target
            .the("slot container iframe")
            .locatedBy("//iframe[@id='slotContainer']");

    // SPORT SESSION
    public static final Target SPORTS_BTN = Target
            .the("sports button")
            .locatedBy("//nav[@class='h-full']//div[contains(text(),'Sports')]");
    public static final String CONTAINS_SPORTS = "/leosport";
    public static final Target SPORT_K_VERIFY = Target
            .the("sport k verify")
            .locatedBy("//div[@class='header-match color-header']");
    public static final Target SPORT_LEO = Target
            .the("sport leo")
            .locatedBy("[src='/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fleo-sport.008a9089.png&w=3840&q=100']");
    public static final Target SPORT_IBC = Target
            .the("sport ibc")
            .locatedBy("[src='/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fibc.bc3bf2ad.png&w=3840&q=100']");
    public static final Target SPORT_IBC_VERIFY = Target
            .the("sport ibc veriry")
            .locatedBy("//div[@class='c-odds-table__header']");
    public static final Target SPORT_BTI = Target
            .the("sport bti")
            .locatedBy("[src='/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fbti.c09e017f.png&w=3840&q=100']");
    public static final Target SPORT_BTI_VERIFY = Target
            .the("sport bti verify")
            .locatedBy("//div[@class='eventlist_asia_fe_sharedGrid_headersRow']");
    public static final Target SPORT_LEO_VIRTUAL = Target
            .the("sport leo virtual")
            .locatedBy("[src='/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fleo-vr.494ef44e.png&w=3840&q=100']");
    public static final Target SPORT_LEO_VIRTUAL_VERIFY = Target
            .the("sport leo virtual verify")
            .locatedBy("//div[@id=\"application_container\"]/gaming-vgpc-composition");
    public static final Target SPORT_SABA_VIRTUAL = Target
            .the("sport saba virtual")
            .locatedBy("[src='/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fsaba-vr.e1d9e09b.png&w=3840&q=100']");
    public static final Target SPORT_SABA_ESPORT = Target
            .the("sport saba esport")
            .locatedBy("[src='/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fsaba-esport.cb9b2160.png&w=3840&q=100']");
    public static final Target SPORT_SABA_ESPORT_VERIFY = Target
            .the("sport saba esport verify")
            .locatedBy("//div[@class=\"odds-table\"]");
    public static final Target SPORT_IM_ESPORT = Target
            .the("sport im esport")
            .locatedBy("[src='/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fim-esport.c870c2c0.png&w=3840&q=100']");
    public static final Target SPORT_IM_ESPORT_VERIFY = Target
            .the("sport im esport verify")
            .locatedBy("//div[@class='gameHall']");


    // LIVE CASINO SESSION
    public static final Target LIVE_CASINO_BTN = Target
            .the("live casino button")
            .locatedBy("//nav[@class='h-full']//div[contains(text(),'Live Casino')]");
    public static final String CONTAINS_LIVE_CASINO = "h/live-casino?provider=all&category=all";
    public static final Target LIVE_CASINO_INDEX_PLAY_BTN = Target
            .the("casino index {0} play button")
            .locatedBy(".grid-cols-6 > div:nth-of-type({0}) > div:nth-of-type(1) div:nth-of-type(1) > div:nth-of-type(1)");
    public static final Target LIVE_CASINO_SA_GAMING_VERIFY = Target
            .the("sa gaming casino verify")
            .locatedBy("//canvas[1]");
    public static final Target LIVE_CASINO_ALLBET_BTN = Target
            .the("allbet button")
            .locatedBy("[src='/_next/image?url=https%3A%2F%2Fadmin.leo88.com%2Fwp-content%2Fuploads%2F2024%2F05%2Fall-bet.png&w=3840&q=100']");
    public static final Target LIVE_CASINO_SAGAMING_BTN = Target
            .the("sa gaming button")
            .locatedBy("[src='/_next/image?url=https%3A%2F%2Fadmin.leo88.com%2Fwp-content%2Fuploads%2F2024%2F05%2Fsa-gaming.png&w=3840&q=100']");
    public static final Target LIVE_CASINO_EZUGI_BTN = Target
            .the("ezugi button")
            .locatedBy("[src='/_next/image?url=https%3A%2F%2Fadmin.leo88.com%2Fwp-content%2Fuploads%2F2024%2F05%2Fezugi.png&w=3840&q=100']");
    public static final Target LIVE_CASINO_EZUGI_VERIFY = Target
            .the("ezugi verify")
            .locatedBy("[label='Menu']");
    public static final Target LIVE_CASINO_EVOLUTION_BTN = Target
            .the("evolution button")
            .locatedBy("[src='/_next/image?url=https%3A%2F%2Fadmin.leo88.com%2Fwp-content%2Fuploads%2F2024%2F05%2Fevolution.png&w=3840&q=100']");
    public static final Target LIVE_CASINO_EVOLUTION_VERIFY = Target
            .the("evolution verify")
            .locatedBy("//div[@data-role='top-right-corner']/div/div/div[1]");
    public static final Target LIVE_CASINO_PRAGMATIC_BTN = Target
            .the("evolution button")
            .locatedBy("[src='/_next/image?url=https%3A%2F%2Fadmin.leo88.com%2Fwp-content%2Fuploads%2F2024%2F05%2Fpragmatic.png&w=3840&q=100']");
    public static final Target LIVE_CASINO_PRAGMATIC_VERIFY = Target
            .the("pragmatic verify")
            .locatedBy("#main_nav .desktop-menu");
    public static final Target LIVE_CASINO_MICROGAMING_BTN = Target
            .the("microgaming button")
            .locatedBy("[src='/_next/image?url=https%3A%2F%2Fadmin.leo88.com%2Fwp-content%2Fuploads%2F2024%2F05%2Fmicrogaming.png&w=3840&q=100']");
    public static final Target LIVE_CASINO_MICROGAMING_VERIFY = Target
            .the("microgaming verify")
            .locatedBy("//canvas[@id='render-canvas']");

    // CASINO SESSION
    public static final Target CASINO_BTN = Target
            .the("casino button")
            .locatedBy("ul > div:nth-of-type(3) > .group > .h-full");
    public static final Target CASINO_INDEX_PLAY_BTN = Target
            .the("casino index {0} play button")
            .locatedBy(".grid-cols-6 > div:nth-of-type({0}) > div:nth-of-type(1) div:nth-of-type(1) > div:nth-of-type(1)");
    public static final String CONTAINS_CASINO = "/casino?provider=all&category=all";
    public static final Target CASINO_FACHAI_BTN = Target
            .the("fachai button")
            .locatedBy("[src='/_next/image?url=https%3A%2F%2Fadmin.leo88.com%2Fwp-content%2Fuploads%2F2024%2F05%2Ffa-chai.png&w=3840&q=100']");
    public static final Target CASINO_ASKMEBET_BTN = Target
            .the("askmebet button")
            .locatedBy("[src='/_next/image?url=https%3A%2F%2Fadmin.leo88.com%2Fwp-content%2Fuploads%2F2024%2F05%2Faskmebet.png&w=3840&q=100']");
    public static final Target CASINO_EVOPLAY_BTN = Target
            .the("evoplay button")
            .locatedBy("[src='/_next/image?url=https%3A%2F%2Fadmin.leo88.com%2Fwp-content%2Fuploads%2F2024%2F05%2Fevo-play.png&w=3840&q=100']");
    public static final Target SLOT_CANVAS = Target
            .the("slot canvas")
            .locatedBy("//canvas[@id='slotCanvas']");
    public static final Target CASINO_MICROGAMING_BTN = Target
            .the("microgaming button")
            .locatedBy("[src='/_next/image?url=https%3A%2F%2Fadmin.leo88.com%2Fwp-content%2Fuploads%2F2024%2F05%2Fmicro-gaming.png&w=3840&q=100']");
    public static final Target CANVAS_VIEW = Target
            .the("canvas view")
            .locatedBy("//canvas[@id='canvasView']");
    public static final Target CASINO_PLAY_N_GO_BTN = Target
            .the("play'n go button")
            .locatedBy("[src='/_next/image?url=https%3A%2F%2Fadmin.leo88.com%2Fwp-content%2Fuploads%2F2024%2F05%2Fplayngo.png&w=3840&q=100']");
    public static final Target CANVAS_1 = Target
            .the("canvas 1")
            .locatedBy("//canvas[1]");
    public static final Target CASINO_NETENT_BTN = Target
            .the("netent button")
            .locatedBy("[src='/_next/image?url=https%3A%2F%2Fadmin.leo88.com%2Fwp-content%2Fuploads%2F2024%2F05%2Fnetent.png&w=3840&q=100']");
    public static final Target CASINO_PRAGMATIC_BTN = Target
            .the("pragmatic button")
            .locatedBy("[src='/_next/image?url=https%3A%2F%2Fadmin.leo88.com%2Fwp-content%2Fuploads%2F2024%2F05%2Fpragamatic-play.png&w=3840&q=100']");
    public static final Target CASINO_PRAGMATIC_VERIFY = Target
            .the("pragmatic verify")
            .locatedBy("[src='/_next/image?url=https%3A%2F%2Fadmin.leo88.com%2Fwp-content%2Fuploads%2F2024%2F05%2Fpragamatic-play.png&w=3840&q=100']");
    public static final Target CASINO_JILI_BTN = Target
            .the("jili button")
            .locatedBy("[src='/_next/image?url=https%3A%2F%2Fadmin.leo88.com%2Fwp-content%2Fuploads%2F2024%2F05%2Fjili.png&w=3840&q=100']");
    public static final Target CASINO_NETENT_IFRAME = Target
            .the("netent iframe")
            .locatedBy("//iframe[contains(@src, 'https://skylinetechplayivo.evo-games.com/frontend/evo/r2/#provider=netent')]");
    public static final Target CANVAS_ANIMATION_MANAGER = Target
            .the("canvas animation manager")
            .locatedBy("//canvas[@id='canvasAnimationManager']");
    public static final Target CASINO_JDB_BTN = Target
            .the("jdb button")
            .locatedBy("[src='/_next/image?url=https%3A%2F%2Fadmin.leo88.com%2Fwp-content%2Fuploads%2F2024%2F05%2Fjdb.png&w=3840&q=100']");
    public static final Target CASINO_JDB_VERIFY = Target
            .the("jdb verify")
            .locatedBy("//div[@class='player-info-section']");
    public static final Target CASINO_RED_TIGER_BTN = Target
            .the("red tiger button")
            .locatedBy("[src='/_next/image?url=https%3A%2F%2Fadmin.leo88.com%2Fwp-content%2Fuploads%2F2024%2F05%2Fred-tiger.png&w=3840&q=100']");
    public static final Target CASINO_RED_TIGER_IFRAME = Target
            .the("red tiger iframe")
            .locatedBy("//iframe[contains(@src, 'https://skylinetechplayivo.evo-games.com/frontend/evo/r2/#provider=redtiger')]");
    public static final Target CASINO_RED_TIGER_IFRAME_2 = Target
            .the("red tiger iframe 2")
            .locatedBy("//iframe[contains(@src, 'https://gserver-evo-spadetechplay001.m-gservices.com')]");
    public static final Target CASINO_RED_TIGER_VERIFY = Target
            .the("red tiger verify")
            .locatedBy("//div[@class='paytable-ui-controls']");
    public static final Target CASINO_BTG_BTN = Target
            .the("btg button")
            .locatedBy("[src='/_next/image?url=https%3A%2F%2Fadmin.leo88.com%2Fwp-content%2Fuploads%2F2024%2F05%2Fbt-gaming.png&w=3840&q=100']");
    public static final Target CASINO_BTG_IFRAME = Target
            .the("btg iframe")
            .locatedBy("//iframe[contains(@src, 'https://skylinetechplayivo.evo-games.com/frontend/evo/r2/#provider=btg')]");
    public static final Target CASINO_BTG_IFRAME_2 = Target
            .the("btg iframe 2")
            .locatedBy("//iframe[contains(@src, '/frontend/btg')]");
    public static final Target CASINO_NLC_BTN = Target
            .the("nlc button")
            .locatedBy("[src='/_next/image?url=https%3A%2F%2Fadmin.leo88.com%2Fwp-content%2Fuploads%2F2024%2F05%2Fnlc.png&w=3840&q=100']");
    public static final Target CASINO_NLC_IFRAME = Target
            .the("nlc iframe")
            .locatedBy("//iframe[contains(@src, 'https://skylinetechplayivo.evo-games.com/frontend/evo/r2/#provider=nlc')]");
    public static final Target CASINO_NLC_IFRAME_2 = Target
            .the("nlc iframe 2")
            .locatedBy("//iframe[contains(@src, 'https://prod.nlcasiacdn.net/loader/evo.html')]");


    // LOTTERY SESSION
    public static final Target LOTTERY_BTN = Target
            .the("lottery button")
            .locatedBy("//nav[@class='h-full']//div[contains(text(),'Lottery')]");
    public static final String CONTAINS_LOTTERY = "/lottery?provider=all&category=all";

    // SIAM GAMES SESSION
    public static final Target SIAM_GAMES_BTN = Target
            .the("siam games button")
            .locatedBy("//nav[@class='h-full']//div[contains(text(),'Siam Games')]");
    public static final String CONTAINS_SIAM_GAMES = "/siam-game?category=all";

    // FISHING SESSION
    public static final Target FISHING_BTN = Target
            .the("fishing button")
            .locatedBy("//nav[@class='h-full']//div[contains(text(),'Fishing')]");
    public static final String CONTAINS_FISHING = "/fishing?provider=all&tab=all";

    // FAST GAMES SESSION
    public static final Target FAST_GAMES_BTN = Target
            .the("fast game button")
            .locatedBy("//nav[@class='h-full']//div[contains(text(),'fast games')]");
    public static final String CONTAINS_FAST_GAMES = "/fast-game?tab=all";

    // COCK FIGHT SESSION
    public static final Target COCK_FIGHT_BTN = Target
            .the("cock fight button")
            .locatedBy("//nav[@class='h-full']//div[contains(text(),'cock fight')]");
    public static final Target COCK_FIGHT_GAME_BTN = Target
            .the("cock fight game button")
            .locatedBy("[src='/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fdigmaan.79dbb079.png&w=3840&q=100']");
    public static final String CONTAINS_COCK_FIGHT = "https://css4.1288128.net/Game/Lobby.aspx";

    // OTHERS SESSION
    public static final Target OTHERS_BTN = Target
            .the("others session")
            .locatedBy("//nav[@class='h-full']//div[contains(text(),'others')]");
    public static final Target VIP_BTN = Target
            .the("vip button")
            .locatedBy("[src='/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fvip.ead3ee5c.png&w=3840&q=100']");
    public static final String CONTAINS_VIP = "/vip";
    public static final Target PROMOTION_BTN = Target
            .the("promotion button")
            .locatedBy("[src='/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fpromotion.66f5f2eb.png&w=3840&q=100']");
    public static final String CONTAINS_PROMOTION = "/promotion";
}
