package net.creqavn.tasks;


import net.creqavn.googleapi.drive.GoogleDriveService;

import java.io.IOException;

public class ExportDomain {

    //#Task02 Export data and configuration before executing test
    public static void main(String[] args) throws IOException {

        GoogleDriveService driveService = new GoogleDriveService();
        driveService.synchronizeTestId();
    }
}
