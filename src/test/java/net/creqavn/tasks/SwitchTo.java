package net.creqavn.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.DriverTask;
import net.serenitybdd.screenplay.actions.SwitchToNewWindow;


import java.util.Set;

public class SwitchTo {
    public SwitchTo() {
    }

    public static Performable newWindow() {
        return Tasks.instrumented(SwitchToNewWindow.class);
    }

    public static Performable mainWindowAfterCloseCurrentWindow() {
        return new DriverTask((driver) -> {
            String currentWindow = driver.getWindowHandle();
            Set<String> windowHandles = driver.getWindowHandles();

            // Close the current window and switch to the remaining window
            windowHandles.remove(currentWindow);
            if (!windowHandles.isEmpty()) {
                String remainingWindow = windowHandles.iterator().next();
                driver.close();
                driver.switchTo().window(remainingWindow);
            }
        });
    }
}
