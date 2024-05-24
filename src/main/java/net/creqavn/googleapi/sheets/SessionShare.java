package net.creqavn.googleapi.sheets;

public class SessionShare {

    private String spreadId;
    private String folderName;
    private String currentCycle;
    private String folderNameId;

    public SessionShare(String spreadId, String folderName, String currentCycle, String folderNameId) {
        this.spreadId = spreadId;
        this.folderName = folderName;
        this.currentCycle = currentCycle;
        this.folderNameId = folderNameId;
    }
    public String getTestId() {
        return currentCycle;
    }
    public String getSpreadId() {
        return spreadId;
    }
    public String getFolderName() {
        return folderName;
    }
    public String getFolderId() {
        return folderNameId;
    }
}
