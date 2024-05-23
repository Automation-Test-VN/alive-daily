package net.creqavn.utilities;

import net.creqavn.googleapi.sheets.GoogleSheetApi;
import net.thucydides.model.domain.TestOutcome;
import net.thucydides.model.reports.TestOutcomeLoader;
import net.thucydides.model.reports.TestOutcomes;

import java.io.File;
import java.io.IOException;

public class ReportUtils {
    public static void writeReportToGoogleSheet()  {
        File sourceDirectory = new File("target/site/serenity");
        TestOutcomes testOutcomes = null;
        try {
            testOutcomes = TestOutcomeLoader.testOutcomesIn(sourceDirectory);
            GoogleSheetApi sheet = new GoogleSheetApi();
            sheet.writeOutput(testOutcomes);
        } catch (Exception e) {
           e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        writeReportToGoogleSheet();
    }
}
