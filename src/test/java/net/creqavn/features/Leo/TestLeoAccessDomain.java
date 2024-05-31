package net.creqavn.features.Leo;


import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import net.serenitybdd.rest.SerenityRest;

import static net.creqavn.ui.leo.LeoElements.*;
import static net.thucydides.model.domain.ReportData.withTitle;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLeoAccessDomain {
    @Step("Send GET request to {0} and check if status is 200")
    public void sendRequestAndCheckStatus(String url) {
        SerenityRest.given()
                .when()
                .get(url)
                .then()
                .statusCode(200);

        // Ghi lại response vào báo cáo của Serenity
        Response response = SerenityRest.given()
                .when()
                .get(url);

        int statusCode = response.getStatusCode();

        // Ghi lại status code vào báo cáo của Serenity
        withTitle("HTTP Status Code").andContents(String.valueOf(statusCode));

        // Kiểm tra mã trạng thái
        if (statusCode >= 400) {
            System.out.println("Test failed: Received status code " + statusCode);
            throw new AssertionError("Expected status code 200 but received " + statusCode);
        }
    }

    @Test
    @Title("Test if homepage is accessible and returns status 200")
    public void testHomepage() {
        String homepageUrl = "https://leo88.top/";  // Thay thế bằng URL của trang chủ
        sendRequestAndCheckStatus(homepageUrl);
    }
}
