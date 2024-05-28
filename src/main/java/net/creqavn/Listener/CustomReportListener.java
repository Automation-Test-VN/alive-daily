package net.creqavn.Listener;

import net.thucydides.core.steps.BaseStepListener;

import java.io.File;

import static net.creqavn.utilities.ReportUtils.writeReportToGoogleSheet;

public class CustomReportListener extends BaseStepListener {

    public CustomReportListener(File outputDirectory) {
        super(outputDirectory);
    }

    @Override
    public void testSuiteFinished() {
        super.testSuiteFinished();
        writeReportToGoogleSheet();
    }
}
