package net.creqavn.features.Leo;

import com.opencsv.CSVWriter;
import net.creqavn.tasks.DataProcessor;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.model.util.EnvironmentVariables;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestGetAllImageLink {
    private String theRestApiBaseUrl;
    private EnvironmentVariables environmentVariables;
    static Actor swagger = Actor.named("Swagger");
    private String DOMAIN = "https://leo88.top";

    //    clearCookies = ClearCookiesPolicy.BeforeEachTest
    @Managed(uniqueSession = true)
    public static WebDriver mightyBrowser;

    @BeforeClass
    public static void setUp() {
        swagger.can(BrowseTheWeb.with(mightyBrowser));
    }

    @Test
    public void testBrokenImage() throws IOException {
        List<String> listDOMAIN = new ArrayList<>();
        listDOMAIN.add("https://leo88.top");
        listDOMAIN.add("https://leo88.top/en-TH/casino?provider=techplay&category=all");
        // (Add other domains as necessary)

        List<String> lastedData = new ArrayList<>();
        List<String> processedData;
        Map<String, String> imageToDomainMap = new HashMap<>();

        for (String url : listDOMAIN) {
            try {
                processedData = DataProcessor.getProcessedImageUrls(swagger, url);
                lastedData.addAll(processedData);
                for (String imageUrl : processedData) {
                    imageToDomainMap.put(imageUrl, url);
                }
            } catch (AssertionError e) {
                System.err.println("AssertionError: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Exception: " + e.getMessage());
            }
        }
        // Call the function to store the data in CSV format
        storeToCSV(imageToDomainMap);
    }

    public void storeToCSV(Map<String, String> imageToDomainMap) throws IOException {
        String csvFile = "datatest/urls.csv";
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile),
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END)) {
            // Write header
            writer.writeNext(new String[]{"domain", "imgURL"});

            // Write data
            for (Map.Entry<String, String> entry : imageToDomainMap.entrySet()) {
                writer.writeNext(new String[]{entry.getValue(), entry.getKey()});
            }
        }
    }
}
