package net.creqavn.Listener;

import net.thucydides.core.steps.BaseStepListener;

import java.io.File;

public class CustomReportListener extends BaseStepListener {

    public CustomReportListener(File outputDirectory) {
        super(outputDirectory);
    }

    @Override
    public void testSuiteFinished() {
        super.testSuiteFinished();
        // Custom logic after reports are generated
        writeReportToGoogleSheet();
    }

    private void writeReportToGoogleSheet() {
        // Your logic to read the report and write to Google Sheets
        // For example, reading from target/site/serenity/serenity.json
        File reportFile = new File("target/site/serenity/serenity.json");
        // Implement your Google Sheets API logic here
    }
}
