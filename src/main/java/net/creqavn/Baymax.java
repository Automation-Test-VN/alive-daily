package net.creqavn;

import au.com.bytecode.opencsv.CSVReader;
import net.creqavn.googleapi.sheets.SessionShare;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Baymax {

    public static final String WEBSITE_DOMAIN_CSV = "datatest/website-domain.csv";
    public static final String SESSION_SHARED = "datatest/session-shared.csv";
    public static final String DATA_GLOBAL = "Session";

    public static void openSite(String site) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        try {
            ProcessBuilder builder = new ProcessBuilder("cmd", "/c", "start", "/min", "open_browser.bat",
                    site, String.valueOf(screenSize.width / 2), String.valueOf(screenSize.height));

            builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cleanChromeCache() {
        String psScriptPath = "cleanCache.ps1";

        try {
            String command = "powershell.exe -File " + psScriptPath;
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", command);
            pb.redirectErrorStream(true);
            Process process = pb.start();
            int exitCode = process.waitFor();
            System.out.println("Exit Code: " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteSessionShareFile() {
        if (isSessionShareFile()) {
            deleteFileTmp(SESSION_SHARED);
        }
    }

    public static boolean isSessionShareFile() {
        File file = new File(SESSION_SHARED);
        return file.exists();
    }

    public static void deleteFileTmp(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
            TraceLog.info("File deleted successfully:" + fileName);
        }
    }



    public static void closeBrowser() {

        List.of("chrome", "firefox").forEach(browser -> {
            String psCommand = "powershell.exe -Command \"Get-Process -Name '"+browser+"' | Where-Object { $_.MainModule.FileName -notlike '*chromium*' } | Stop-Process -Force\"";
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c",psCommand );
            try {
                builder.start();
                Thread.sleep(1000);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }


    public static String getRawData(String pathFile) {
        String value;

        try {
            value = new String(
                    Files.readAllBytes(Paths.get(pathFile)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return value;
    }

    public static SessionShare getCurrentTest() throws IOException {
        String[] line;
        try (BufferedReader reader = new BufferedReader(new FileReader(Baymax.SESSION_SHARED))) {
            reader.readLine(); // remove the header
            line = reader.readLine().split(",");
        }

        return new SessionShare(line[0], line[1], line[2], line[3]);
    }


    public static List<String> convertFileToListByIndex(String fileName, int index) {
        List<String> domains = new ArrayList<>();

        if (new File(fileName).exists()) {
            try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
                String[] nextLine;
                while ((nextLine = reader.readNext()) != null) {

                    if (nextLine.length >= 1) {
                        String domain = nextLine[index];
                        domains.add(domain);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return domains;
    }

    public static List<String> convertFileToList(String fileName) {
        return convertFileToListByIndex(fileName, 0);
    }

}
