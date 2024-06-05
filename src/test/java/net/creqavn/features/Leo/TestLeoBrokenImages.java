package net.creqavn.features.Leo;


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
import java.util.List;


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

    @Test
    public void homepageBrokenImages() {
        String DOMAIN = "https://leo88.top";
        DataProcessor.performImageCheckOnSinglePage(swagger, DOMAIN);
    }

    @Test
    public void casinoTPBrokenImages() {
        String DOMAIN = "https://leo88.top/en-TH/casino?provider=techplay&category=all";
        DataProcessor.performImageCheckOnSinglePage(swagger, DOMAIN);
    }

    @Test
    public void casinoNextSpinBrokenImages() {
        String DOMAIN = "https://leo88.top/en-TH/casino?provider=nextspin&category=all";
        DataProcessor.performImageCheckOnSinglePage(swagger, DOMAIN);
    }

    @Test
    public void casinoJiliBrokenImages() {
        String DOMAIN = "https://leo88.top/en-TH/casino?provider=jili&category=all";
        DataProcessor.performImageCheckOnSinglePage(swagger, DOMAIN);
    }

    @Test
    public void casinoPGSoftBrokenImages() {
        String DOMAIN = "https://leo88.top/en-TH/casino?provider=pgsoft&category=all";
        DataProcessor.performImageCheckOnSinglePage(swagger, DOMAIN);
    }

    @Test
    public void casinoAMBBrokenImages() {
        String DOMAIN = "https://leo88.top/en-TH/casino?provider=amb&category=all";
        DataProcessor.performImageCheckOnSinglePage(swagger, DOMAIN);
    }

    @Test
    public void casinoPragmaticBrokenImages() {
        String DOMAIN = "https://leo88.top/en-TH/casino?provider=pragmatic&category=all";
        DataProcessor.performImageCheckOnSinglePage(swagger, DOMAIN);
    }

    @Test
    public void casinoEvoplayBrokenImages() {
        String DOMAIN = "https://leo88.top/en-TH/casino?provider=evoplay&category=all";
        DataProcessor.performImageCheckOnSinglePage(swagger, DOMAIN);
    }

    @Test
    public void casinoMicroGamingBrokenImages() {
        String DOMAIN = "https://leo88.top/en-TH/casino?provider=microgaming&category=all";
        DataProcessor.performImageCheckOnSinglePage(swagger, DOMAIN);
    }

    @Test
    public void casinoJDBBrokenImages() {
        String DOMAIN = "https://leo88.top/en-TH/casino?provider=jdb&category=all";
        DataProcessor.performImageCheckOnSinglePage(swagger, DOMAIN);
    }

    @Test
    public void casinoKingMakerBrokenImages() {
        String DOMAIN = "https://leo88.top/en-TH/casino?provider=kingmaker&category=all";
        DataProcessor.performImageCheckOnSinglePage(swagger, DOMAIN);
    }

    @Test
    public void casinoFaChaiBrokenImages() {
        String DOMAIN = "https://leo88.top/en-TH/casino?provider=fachai&category=all";
        DataProcessor.performImageCheckOnSinglePage(swagger, DOMAIN);
    }

    @Test
    public void casinoPlayNGoBrokenImages() {
        String DOMAIN = "https://leo88.top/en-TH/casino?provider=playngo&category=all";
        DataProcessor.performImageCheckOnSinglePage(swagger, DOMAIN);
    }

    @Test
    public void casinoBTGBrokenImages() {
        String DOMAIN = "https://leo88.top/en-TH/casino?provider=btg&category=all";
        DataProcessor.performImageCheckOnSinglePage(swagger, DOMAIN);
    }

    @Test
    public void casinoNetentBrokenImages() {
        String DOMAIN = "https://leo88.top/en-TH/casino?provider=netent&category=all";
        DataProcessor.performImageCheckOnSinglePage(swagger, DOMAIN);
    }

    @Test
    public void casinoRedTigerBrokenImages() {
        String DOMAIN = "https://leo88.top/en-TH/casino?provider=redtiger&category=all";
        DataProcessor.performImageCheckOnSinglePage(swagger, DOMAIN);
    }

    @Test
    public void casinoNLCBrokenImages() {
        String DOMAIN = "https://leo88.top/en-TH/casino?provider=nlc&category=all";
        DataProcessor.performImageCheckOnSinglePage(swagger, DOMAIN);
    }

    @Test
    public void lotteryBrokenImages() {
        String DOMAIN = "https://leo88.top/en-TH/lottery?provider=all&category=all";
        DataProcessor.performImageCheckOnSinglePage(swagger, DOMAIN);
    }

    @Test
    public void siamGamesBrokenImages() {
        String DOMAIN = "https://leo88.top/en-TH/siam-game?category=all";
        DataProcessor.performImageCheckOnSinglePage(swagger, DOMAIN);
    }

    @Test
    public void fishingBrokenImages() {
        String DOMAIN = "https://leo88.top/en-TH/fishing?provider=all&category=all&tab=all";
        DataProcessor.performImageCheckOnSinglePage(swagger, DOMAIN);
    }

    @Test
    public void fastGamesBrokenImages() {
        String DOMAIN = "https://leo88.top/en-TH/fast-game?tab=all";
        DataProcessor.performImageCheckOnSinglePage(swagger, DOMAIN);
    }

    @Test
    public void testBrokenImage() {
        List<String> lastedData = new ArrayList<>();
        List<String> processedData = new ArrayList<>();

        List<String> DOMAIN = new ArrayList<>();
        DOMAIN.add("https://leo88.top");
        DOMAIN.add("https://leo88.top/en-TH/casino?provider=techplay&category=all");
        DOMAIN.add("https://leo88.top/en-TH/casino?provider=nextspin&category=all");
        DOMAIN.add("https://leo88.top/en-TH/casino?provider=jili&category=all");
        DOMAIN.add("https://leo88.top/en-TH/casino?provider=pgsoft&category=all");
        DOMAIN.add("https://leo88.top/en-TH/casino?provider=amb&category=all");
        DOMAIN.add("https://leo88.top/en-TH/casino?provider=pragmatic&category=all");
        DOMAIN.add("https://leo88.top/en-TH/casino?provider=evoplay&category=all");
        DOMAIN.add("https://leo88.top/en-TH/casino?provider=microgaming&category=all");
        DOMAIN.add("https://leo88.top/en-TH/casino?provider=jdb&category=all");
        DOMAIN.add("https://leo88.top/en-TH/casino?provider=kingmaker&category=all");
        DOMAIN.add("https://leo88.top/en-TH/casino?provider=fachai&category=all");
        DOMAIN.add("https://leo88.top/en-TH/casino?provider=playngo&category=all");
        DOMAIN.add("https://leo88.top/en-TH/casino?provider=btg&category=all");
        DOMAIN.add("https://leo88.top/en-TH/casino?provider=netent&category=all");
        DOMAIN.add("https://leo88.top/en-TH/casino?provider=redtiger&category=all");
        DOMAIN.add("https://leo88.top/en-TH/casino?provider=nlc&category=all");
        DOMAIN.add("https://leo88.top/en-TH/lottery?provider=all&category=all");
        DOMAIN.add("https://leo88.top/en-TH/siam-game?category=all");
        DOMAIN.add("https://leo88.top/en-TH/fishing?provider=all&category=all&tab=all");
        DOMAIN.add("https://leo88.top/en-TH/fast-game?tab=all");
        for (String url : DOMAIN) {
            processedData = DataProcessor.getProcessedImageUrls(swagger, url);
            lastedData.addAll(processedData);
        }
        System.out.println("Total image URLs found: " + lastedData.size());
        lastedData = DataProcessor.removeDuplicates(processedData);
        System.out.println("Total image URLs after check duplicate: " + lastedData.size());
        DataProcessor.sendRequests(lastedData);
    }
}
