package net.creqavn;

import java.io.*;


public class TraceLog {

    public final static String TARGET_FOLDER = "target\\";
    public static final String LOG_DETAILS = GlobalConstants.ISP_NAME.toLowerCase()+"_details";
    public static final String INDEX_DOMAIN = "error_code";
    public static final String REPORT_BACKUP = GlobalConstants.ISP_NAME.toLowerCase()+"_report_backup";
    public static final String LOG_EXT = ".csv";


    public static void info(String pageSource) {
        writeLogLocal(pageSource, LOG_DETAILS);
    }

    public static void writeLogLocal(String pageSource, String fileLog){
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(TARGET_FOLDER+fileLog+ LOG_EXT, true));
            writer.write(pageSource);
            writer.write("\n");

        } catch (IOException e) {
            throw new RuntimeException(e);

        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void saveUserNameToFile(String userName) {
        String filePath = "usernames.txt";
        try {
            File file = new File(filePath);
            if (file.exists())
                file.delete();

            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(userName);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readUserNameFromFile() {
        String filePath = "usernames.txt";
        String userName = "unknown";

        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            userName = br.readLine().strip();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userName;
    }
}
