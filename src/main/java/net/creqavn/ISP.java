package net.creqavn;

import net.creqavn.googleapi.CredentialManager;

public enum ISP {
//    VNPT(1, VNPT_TOKEN, CredentialManager.CREDENTIALS_VNPT, "81107888"),
//    FPT(2, FPT_TOKEN, CredentialManager.CREDENTIALS_FPT,"81105310"),
//    VIETTEL(3, VIETTEL_TOKEN, CredentialManager.CREDENTIALS_VIETTEL,"81106673"),
//    VIETTEL4G(4, VIETTEL4G_TOKEN, CredentialManager.CREDENTIALS_VIETTEL4G,"81110525"),
//    VINA(5, VINA4G_TOKEN, CredentialManager.CREDENTIALS_VINA4G,"21924584"),
//    MOBI(6, MOBI4G_TOKEN, CredentialManager.CREDENTIALS_MOBI4G,"81107047"),
//    VPN(7, VPN_TOKEN, CredentialManager.CREDENTIALS_VPN,"81102310");

    VNPT("!B2", CredentialManager.CREDENTIALS_VNPT, "81107888"),
    FPT("!C2", CredentialManager.CREDENTIALS_FPT, "81105310"),
    VIETTEL("!D2", CredentialManager.CREDENTIALS_VIETTEL, "81106673"),
    VIETTEL4G("!E2", CredentialManager.CREDENTIALS_VIETTEL4G, "81110525"),
    VINA("!F2", CredentialManager.CREDENTIALS_VINA4G, "21924584"),
    MOBI("!G2", CredentialManager.CREDENTIALS_MOBI4G, "81107047"),
    VPN("!H2", CredentialManager.CREDENTIALS_VPN, "81102310");

    private final String columnIndex;
    private final String credentials;
    private final String id;

    ISP(String columnIndex, String credentials, String id) {
        this.columnIndex = columnIndex;
        this.credentials = credentials;
        this.id = id;
    }

    public String getColumnIndex() {
        return columnIndex;
    }

    public String getCredentials() {
        return credentials;
    }

    public String getId() {
        return id;
    }
}
