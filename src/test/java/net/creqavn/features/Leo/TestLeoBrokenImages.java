package net.creqavn.features.Leo;

import net.creqavn.models.UrlStatus;
import net.creqavn.tasks.DataProcessor;
import net.serenitybdd.annotations.ClearCookiesPolicy;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLeoBrokenImages {
    static Actor swagger = Actor.named("Swagger");

    @Managed(uniqueSession = true, clearCookies = ClearCookiesPolicy.BeforeEachTest)
    public static WebDriver mightyBrowser;

    @BeforeClass
    public static void setUp() {
        swagger.can(BrowseTheWeb.with(mightyBrowser));
    }

//    @Test
//    public void homepageBrokenImages() {
//        String DOMAIN = "https://leo88.top";
//        DataProcessor.getAndCheckDataSource(swagger, DOMAIN);
//    }
//
//    @Test
//    public void casinoTPBrokenImages() {
//        String DOMAIN = "https://leo88.top/en-TH/casino?provider=techplay&category=all";
//        DataProcessor.getAndCheckDataSource(swagger, DOMAIN);
//    }
//
//    @Test
//    public void casinoNextSpinBrokenImages() {
//        String DOMAIN = "https://leo88.top/en-TH/casino?provider=nextspin&category=all";
//        DataProcessor.getAndCheckDataSource(swagger, DOMAIN);
//    }
//
//    @Test
//    public void casinoJiliBrokenImages() {
//        String DOMAIN = "https://leo88.top/en-TH/casino?provider=jili&category=all";
//        DataProcessor.getAndCheckDataSource(swagger, DOMAIN);
//    }
//
//    @Test
//    public void casinoPGSoftBrokenImages() {
//        String DOMAIN = "https://leo88.top/en-TH/casino?provider=pgsoft&category=all";
//        DataProcessor.getAndCheckDataSource(swagger, DOMAIN);
//    }
//
//    @Test
//    public void casinoAMBBrokenImages() {
//        String DOMAIN = "https://leo88.top/en-TH/casino?provider=amb&category=all";
//        DataProcessor.getAndCheckDataSource(swagger, DOMAIN);
//    }
//
//    @Test
//    public void casinoPragmaticBrokenImages() {
//        String DOMAIN = "https://leo88.top/en-TH/casino?provider=pragmatic&category=all";
//        DataProcessor.getAndCheckDataSource(swagger, DOMAIN);
//    }
//
//    @Test
//    public void casinoEvoplayBrokenImages() {
//        String DOMAIN = "https://leo88.top/en-TH/casino?provider=evoplay&category=all";
//        DataProcessor.getAndCheckDataSource(swagger, DOMAIN);
//    }
//
//    @Test
//    public void casinoMicroGamingBrokenImages() {
//        String DOMAIN = "https://leo88.top/en-TH/casino?provider=microgaming&category=all";
//        DataProcessor.getAndCheckDataSource(swagger, DOMAIN);
//    }
//
//    @Test
//    public void casinoJDBBrokenImages() {
//        String DOMAIN = "https://leo88.top/en-TH/casino?provider=jdb&category=all";
//        DataProcessor.getAndCheckDataSource(swagger, DOMAIN);
//    }
//
//    @Test
//    public void casinoKingMakerBrokenImages() {
//        String DOMAIN = "https://leo88.top/en-TH/casino?provider=kingmaker&category=all";
//        DataProcessor.getAndCheckDataSource(swagger, DOMAIN);
//    }
//
//    @Test
//    public void casinoFaChaiBrokenImages() {
//        String DOMAIN = "https://leo88.top/en-TH/casino?provider=fachai&category=all";
//        DataProcessor.getAndCheckDataSource(swagger, DOMAIN);
//    }
//
//    @Test
//    public void casinoPlayNGoBrokenImages() {
//        String DOMAIN = "https://leo88.top/en-TH/casino?provider=playngo&category=all";
//        DataProcessor.getAndCheckDataSource(swagger, DOMAIN);
//    }
//
//    @Test
//    public void casinoBTGBrokenImages() {
//        String DOMAIN = "https://leo88.top/en-TH/casino?provider=btg&category=all";
//        DataProcessor.getAndCheckDataSource(swagger, DOMAIN);
//    }
//
//    @Test
//    public void casinoNetentBrokenImages() {
//        String DOMAIN = "https://leo88.top/en-TH/casino?provider=netent&category=all";
//        DataProcessor.getAndCheckDataSource(swagger, DOMAIN);
//    }
//
//    @Test
//    public void casinoRedTigerBrokenImages() {
//        String DOMAIN = "https://leo88.top/en-TH/casino?provider=redtiger&category=all";
//        DataProcessor.getAndCheckDataSource(swagger, DOMAIN);
//    }
//
//    @Test
//    public void casinoNLCBrokenImages() {
//        String DOMAIN = "https://leo88.top/en-TH/casino?provider=nlc&category=all";
//        DataProcessor.getAndCheckDataSource(swagger, DOMAIN);
//    }
//
//    @Test
//    public void lotteryBrokenImages() {
//        String DOMAIN = "https://leo88.top/en-TH/lottery?provider=all&category=all";
//        DataProcessor.getAndCheckDataSource(swagger, DOMAIN);
//    }
//
//    @Test
//    public void siamGamesBrokenImages() {
//        String DOMAIN = "https://leo88.top/en-TH/siam-game?category=all";
//        DataProcessor.getAndCheckDataSource(swagger, DOMAIN);
//    }
//
//    @Test
//    public void fishingBrokenImages() {
//        String DOMAIN = "https://leo88.top/en-TH/fishing?provider=all&category=all&tab=all";
//        DataProcessor.getAndCheckDataSource(swagger, DOMAIN);
//    }
//
//    @Test
//    public void fastGamesBrokenImages() {
//        String DOMAIN = "https://leo88.top/en-TH/fast-game?tab=all";
//        DataProcessor.getAndCheckDataSource(swagger, DOMAIN);
//    }

    @Test
    public void testBrokenImage() {
        List<String> lastedData = new ArrayList<>();
        List<String> processedData;
        Map<String, String> imageToDomainMap = new HashMap<>();

        List<String> listDOMAIN = new ArrayList<>();
        listDOMAIN.add("https://leo88.top");
        listDOMAIN.add("https://leo88.top/en-TH/casino?provider=techplay&category=all");
        listDOMAIN.add("https://leo88.top/en-TH/casino?provider=nextspin&category=all");
        listDOMAIN.add("https://leo88.top/en-TH/casino?provider=jili&category=all");
        listDOMAIN.add("https://leo88.top/en-TH/casino?provider=pgsoft&category=all");
        listDOMAIN.add("https://leo88.top/en-TH/casino?provider=amb&category=all");
        listDOMAIN.add("https://leo88.top/en-TH/casino?provider=pragmatic&category=all");
        listDOMAIN.add("https://leo88.top/en-TH/casino?provider=evoplay&category=all");
        listDOMAIN.add("https://leo88.top/en-TH/casino?provider=microgaming&category=all");
        listDOMAIN.add("https://leo88.top/en-TH/casino?provider=jdb&category=all");
        listDOMAIN.add("https://leo88.top/en-TH/casino?provider=kingmaker&category=all");
        listDOMAIN.add("https://leo88.top/en-TH/casino?provider=fachai&category=all");
        listDOMAIN.add("https://leo88.top/en-TH/casino?provider=playngo&category=all");
        listDOMAIN.add("https://leo88.top/en-TH/casino?provider=btg&category=all");
        listDOMAIN.add("https://leo88.top/en-TH/casino?provider=netent&category=all");
        listDOMAIN.add("https://leo88.top/en-TH/casino?provider=redtiger&category=all");
        listDOMAIN.add("https://leo88.top/en-TH/casino?provider=nlc&category=all");
        listDOMAIN.add("https://leo88.top/en-TH/lottery?provider=all&category=all");
        listDOMAIN.add("https://leo88.top/en-TH/siam-game?category=all");
        listDOMAIN.add("https://leo88.top/en-TH/fishing?provider=all&category=all&tab=all");
        listDOMAIN.add("https://leo88.top/en-TH/fast-game?tab=all");

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
        System.out.println("Total image URLs found: " + lastedData.size());
        lastedData = DataProcessor.removeDuplicates(lastedData);
        System.out.println("Total image URLs after check duplicate: " + lastedData.size());

        // Danh sách các UrlStatus chứa các URL và mã trạng thái
        List<UrlStatus> brokenImageUrls = DataProcessor.sendRequests(lastedData);

        StringBuilder logBuilder = new StringBuilder();
        for (UrlStatus brokenImageUrl : brokenImageUrls) {

            String domain = imageToDomainMap.get(brokenImageUrl.getUrl()); // Lấy domain từ map
            int statusCode = brokenImageUrl.getStatusCode(); // Lấy mã trạng thái
            String imageUrl = brokenImageUrl.getUrl(); // Lấy URL hỏng

            logBuilder.append(domain).append(" ").append(statusCode).append("-").append(imageUrl).append("\n");
//            System.out.println(logBuilder); //https://leo88.top 200-/_next/image?url=/_next/static/media/age.04319df5.png&w=640&q=75

        }
    }
}
