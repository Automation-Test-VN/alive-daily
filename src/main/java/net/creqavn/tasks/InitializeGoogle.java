package net.creqavn.tasks;

import net.creqavn.Config;
import net.creqavn.googleapi.drive.GoogleDriveService;
import net.creqavn.googleapi.sheets.GoogleSheetService;
import net.creqavn.utilities.DateTimeUtils;


import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import static net.creqavn.Baymax.DATA_GLOBAL;

public class InitializeGoogle {
    private static final Logger LOGGER = Logger.getLogger(InitializeGoogle.class.getName());
    public static final String SHEET_TITLE_DEFAULT = "Sheet1";

    static GoogleDriveService driveService;
    static GoogleSheetService sheetService;
    public static void main(String[] args) throws IOException {
            LOGGER.info("Initialize Google: Create Spread and folder");

            driveService = new GoogleDriveService();
            sheetService = new GoogleSheetService();

            //#Task01. Create new spread and move to folder
            String reportFolder = DateTimeUtils.setFolderName();

            String folderImageId = driveService.createSubFolder(reportFolder);
            String folderId = Config.getSpreadFolder();
            String spreadID = sheetService.createSpreadSheet(reportFolder);
            sheetService.renameSheetTitle(spreadID, SHEET_TITLE_DEFAULT, DATA_GLOBAL);
            driveService.moveFileToFolder(spreadID, folderId);
            // end Task01

            LOGGER.info("Initialize Google: Update configuration to online sheet to share with others pc");
            sheetService.updateValue(Config.getSessionSpreadIdGlobal(), DATA_GLOBAL +"!A1:4",
                    List.of(
                            List.of("Spread ID", "Folder", "Current Sheet", "Report ID"),
                            List.of(spreadID, reportFolder, "no", folderImageId)
                    ));
            LOGGER.info("Initialize Google: [Spread ID:"+spreadID +"], [Folder:"+reportFolder + "], [Folder Id:" +folderImageId+"]");
    }
}
