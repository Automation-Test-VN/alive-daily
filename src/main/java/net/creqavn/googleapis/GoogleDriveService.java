package net.creqavn.googleapis;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

import java.io.IOException;
import java.util.List;

/* class to use of Drive list API */
public class GoogleDriveService extends GoogleApiServices {
    private final Drive drive;
    public GoogleDriveService() {
        this.drive = getDriveService();
    }

/*    public List<File> getAllFiles(int limit) throws IOException {

        // Print the names and IDs for up to 10 files.
        FileList result = drive.files().list()
                .setPageSize(limit)
                .setFields("nextPageToken, files(id, name)")
                .execute();
        return result.getFiles();
    }*/

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


}
