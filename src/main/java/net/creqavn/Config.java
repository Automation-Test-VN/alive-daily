package net.creqavn;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class Config {

    static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

    public static String getSessionSpreadIdGlobal() {
        return EnvironmentSpecificConfiguration.from(variables).getProperty("google.spread.id");
    }

    public static String getSpreadId() {
        return EnvironmentSpecificConfiguration.from(variables).getProperty("google.spread.session");
    }

    public static String getSpreadFolder() {
        return EnvironmentSpecificConfiguration.from(variables).getProperty("google.spread.parent_folder");
    }

    public static String getTelegramGroupId() {
        return EnvironmentSpecificConfiguration.from(variables).getProperty("telegram.groupId");
    }

    public static boolean isNewTestExecution() {
        return EnvironmentSpecificConfiguration.from(variables)
                .getProperty("cycle").equalsIgnoreCase("true");
    }
}
