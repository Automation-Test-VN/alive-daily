package net.creqavn.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessManager {
    public static String getTestProcess() {

        String processName = "UpdatingReportByIPsNameTest";

        try {
            Process process = Runtime.getRuntime().exec("jps -m");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(processName)) {
                    return line;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error executing jps command: " + e.getMessage());
        }
        return processName + " this process not found";
    }
}
