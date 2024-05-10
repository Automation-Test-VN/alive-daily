package net.creqavn.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.AlertAction;
import net.serenitybdd.screenplay.actions.DriverTask;
import net.serenitybdd.screenplay.actions.SwitchToNewWindow;
import net.serenitybdd.screenplay.actions.SwitchToWindowTitle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.util.Set;

public class Switcher {
    public Switcher() {
    }
    public static Performable toNewWindow() {
        return Tasks.instrumented(SwitchToNewWindow.class, new Object[0]);
    }

    public static Performable closeCurrentWindowsAndSwitchBackToRemainingWindows() {
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
