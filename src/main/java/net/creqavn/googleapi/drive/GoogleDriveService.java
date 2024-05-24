package net.creqavn.googleapi.drive;

import com.google.api.client.http.FileContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import net.creqavn.Baymax;
import net.creqavn.Config;
import net.creqavn.googleapi.GoogleApiServices;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* class to use of Drive list API */
public class GoogleDriveService extends GoogleApiServices {
    private final Drive drive;
    public GoogleDriveService() {
        this.drive = getDriveService();
    }

    public Drive getDrive(){
        return this.drive;
    }

    public boolean isFolder(String folderName) throws IOException {

        FileList result = drive.files().list()
                .setQ("mimeType='application/vnd.google-apps.folder'")
                .setSpaces("drive")
                .setFields("nextPageToken, files(id, name)")
                .setPageSize(100)
                .execute();

        List<File> folders = result.getFiles();
        if (folders != null && !folders.isEmpty()) {
            for (File folder : folders) {
                if(folder.getName().equals(folderName)){
                    return true;
                }
            }
        }
        return false;
    }

    public String createFolder(String folderName) {
        File fileMetadata = new File();
        fileMetadata.setName(folderName);
        fileMetadata.setMimeType("application/vnd.google-apps.folder");

        File file = null;
        try {
            file = drive.files().create(fileMetadata)
                    .setFields("id")
                    .execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file.getId();
    }

    public String createSubFolder(String sub) throws IOException {
        String parentId = Config.getSpreadFolder();

        File fileMetadata = new File();
        fileMetadata.setName(sub);
        fileMetadata.setMimeType("application/vnd.google-apps.folder");
        List<String> parents = List.of(parentId);
        fileMetadata.setParents(parents);

        File file = null;
        try {
            file = drive.files().create(fileMetadata)
                    .setFields("id")
                    .execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file.getId();

    }

    public String findFolderId(String parentFolder) throws IOException {
        FileList result = drive.files().list()
                .setQ("mimeType='application/vnd.google-apps.folder'")
                .setSpaces("drive")
                .setFields("nextPageToken, files(id, name)")
                .setPageSize(500)
                .execute();
        List<File> files = result.getFiles();
        for (File file : files) {
            if (file.getName().equals(parentFolder)){
                return file.getId();
            }
        }
        return null;
    }

    public void synchronizeTestId() throws IOException {
        String spreadsheetId = Config.getSessionSpreadIdGlobal();

        // Sheet resource ID
        String sheetGid = Config.getSpreadId();

        String exportUrl = "https://docs.google.com/spreadsheets/d/" + spreadsheetId + "/export?format=csv&gid=" + sheetGid;

        // request HTTP GET
        HttpResponse httpResponse = drive.getRequestFactory()
                .buildGetRequest(new GenericUrl(exportUrl))
                .execute();

        try (FileOutputStream fileOutputStream = new FileOutputStream(Baymax.SESSION_SHARED)) {
            httpResponse.download(fileOutputStream);
        }
    }

    public void moveFileToFolder(String spreadID, String folderId) throws IOException {
        File file = drive.files().get(spreadID)
                .setFields("parents")
                .execute();

        StringBuilder previousParents = new StringBuilder();
        for (String parent : file.getParents()) {
            previousParents.append(parent);
            previousParents.append(',');
        }

        // Move the file to the new folder
        file = new File();
        drive.files().update(spreadID, file)
                .setAddParents(folderId)
                .setRemoveParents(previousParents.toString())
                .setFields("id, parents")
                .execute();
    }
}
