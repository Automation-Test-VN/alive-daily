package net.creqavn.ui.five88;

import net.serenitybdd.screenplay.targets.Target;

public class HomePageUI {

    // Label
    public static final String DEPOSIT = "NẠP TIỀN";
    public static final String PASSWORD = "Mật khẩu";
    public static final String USER_NAME = "Tên đăng nhập";
    public static final String PHONE_NUMBER = "Số điện thoại";

    // Locator
    public static final Target REGISTER_BUTTON = Target.the("register button").locatedBy("//a[@class='btn btn-default']");
    public static final Target REGISTER_FORM = Target.the("{0} filed").locatedBy("//form[@id='frmRegister']//label[text()='{0}']/following-sibling::div/input");
    public static final Target SUBMIT_BUTTON = Target.the("submit button").locatedBy("//button[@class='btn btn-default btn-submit']");
    public static final Target LOGOUT_BUTTON = Target.the("logout button").locatedBy("//div[@class='acc_logout pull-left']");
    public static final Target MENU_RAR = Target.the("{0} link").locatedBy("//li[@class='active']/a[contains(text(),'{0}')]");
    public static final Target ACTIVE_MENU = Target.the("active link").locatedBy("//ul[@class='panel-tabLink']//li[@class='active']/a");
    public static final Target ACCOUNT_NAME = Target.the("account name").locatedBy("//span[@class='acc_name']");


}
