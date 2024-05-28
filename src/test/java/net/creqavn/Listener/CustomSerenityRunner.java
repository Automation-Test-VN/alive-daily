package net.creqavn.Listener;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.steps.StepEventBus;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

import java.io.File;

public class CustomSerenityRunner extends SerenityRunner {

    public CustomSerenityRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    public void run(RunNotifier notifier) {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        File outputDirectory = new File(environmentVariables.getProperty("serenity.outputDirectory", "target/site/serenity"));
        CustomReportListener listener = new CustomReportListener(outputDirectory);
        StepEventBus.getEventBus().registerListener(listener);

        super.run(notifier);
    }
}
