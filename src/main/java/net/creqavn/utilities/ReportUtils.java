package net.creqavn.utilities;

import net.creqavn.*;
import net.creqavn.googleapi.drive.GoogleDriveService;
import net.creqavn.googleapi.sheets.GoogleSheetService;
import net.thucydides.model.domain.TestOutcome;
import net.thucydides.model.reports.TestOutcomeLoader;
import net.thucydides.model.reports.TestOutcomes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.creqavn.Baymax.deleteSessionShareFile;

public class ReportUtils {
    static GoogleDriveService drive;
    static GoogleSheetService sheet;
    public static final String NEW_TEST_FLAG = "0";
    static String folderId;
    static String spreadId;
    static String sheetName;
    public static void writeReportToGoogleSheet()  {
        File sourceDirectory = new File("target/site/serenity");
        TestOutcomes testOutcomes = null;
        deleteSessionShareFile();
        try {
            testOutcomes = TestOutcomeLoader.testOutcomesIn(sourceDirectory);
            String feature = testOutcomes.getOutcomes().getFirst().getUserStory().getName();;

            List<List<Object>> headers = List.of(
                    Arrays.asList(feature, ISP.VNPT.name(), ISP.FPT.name(), ISP.VIETTEL.name(),
                            ISP.VIETTEL4G.name(), ISP.VINA.name(), ISP.MOBI.name(), ISP.VPN.name()));

            setupEnvironment(headers);

            List<List<Object>> scenario = new ArrayList<>(List.of());
            List<List<Object>> result = new ArrayList<>(List.of());
            for (TestOutcome outcome : testOutcomes.getOutcomes()) {
                scenario.add(List.of(outcome.getTitle()));
                String res;
                if(outcome.getResult().name().equalsIgnoreCase("SUCCESS")){
                    res = "PASSED";
                } else{
                    res = "FAILED";
                }
                result.add(List.of(res));
            }
            GoogleSheetService sheet = new GoogleSheetService();
            sheet.writeOutput(spreadId,sheetName,scenario,result);
        } catch (Exception e) {
           e.printStackTrace();
        }

    }

    public static void setupEnvironment(List<List<Object>> header) {
        sheet = new GoogleSheetService();
        drive = new GoogleDriveService();

        try {
            if (Config.isNewTestExecution()) {
                final String _reportFolder = DateTimeUtils.setFolderName();

                String folderId = drive.createSubFolder(_reportFolder);

                sheet.storeTestId(NEW_TEST_FLAG);
                sheet.storeFolderName(_reportFolder);
                sheet.storeFolderId(folderId);
            }

            // get current test execution id
            if (isFpt()) {
                drive.synchronizeTestId();
            } else {
                // Make sure getCurrentSheetName !=0
                synchronizeTestSession();

                int timeout = 30;
                while (isNewTestId() && timeout != 0) {
                    TraceLog.info("Client: wait for synchronize new test execution Id");
                    drive.synchronizeTestId();
                    timeout--;
                }
            }

            folderId = Baymax.getCurrentTest().getFolderId();
            spreadId = Baymax.getCurrentTest().getSpreadId();

            if (isNewTestId()) {
                sheetName = DateTimeUtils.formatHH_MM_SS();
                sheet.addSheet(spreadId, sheetName);
                sheet.storeTestId(sheetName);
                sheet.updateValue(spreadId, sheetName + "!A1", header);

                drive.synchronizeTestId();
                folderId = Baymax.getCurrentTest().getFolderId();

            } else {
                sheetName = Baymax.getCurrentTest().getTestId();
                sheet.updateValue(spreadId, sheetName + "!A1:7", header);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isFpt() {
        return GlobalConstants.ISP_NAME.equalsIgnoreCase(ISP.FPT.name());
    }

    private static boolean isNewTestId() throws IOException {
        return NEW_TEST_FLAG.equals(Baymax.getCurrentTest().getTestId());
    }

    private static void synchronizeTestSession() throws IOException {
        try {
            Thread.sleep(1_000 * (long) 10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        drive.synchronizeTestId();
    }

    public static void main(String[] args) {
        writeReportToGoogleSheet();
    }
}
