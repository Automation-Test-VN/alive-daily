package net.creqavn.tasks;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.net.URLDecoder;

import static net.thucydides.model.domain.ReportData.withTitle;

public class DataProcessor {

    public static void processAndRequest(List<String> dataList) {
//        for (String data : dataList) {
//            // Xử lý và kiểm tra từng phần tử
//            List<String> processedData = processData(data);
//
//            // In ra các URL đã xử lý
//            processedData.forEach(url -> System.out.println(url));
//
//            // Thực hiện yêu cầu HTTP cho phần tử đã xử lý
//            processedData.forEach(url -> sendRequest(url));
////            sendRequest(processedData);
//        }
    }

    public static List<String> processData(List<String> dataSrc) {
        List<String> allProcessedUrls = new ArrayList<>();
        for (String data : dataSrc) {
            // Tách các URL dựa trên dấu phẩy và xử lý mỗi URL
            List<String> finalUrlsList = Arrays.stream(data.split(",\\s*"))
                    .map(url -> {
                        int indexOfLastSpace = url.lastIndexOf(' ');       // Tìm vị trí của dấu cách cuối cùng
                        if (indexOfLastSpace != -1) {
                            return url.substring(0, indexOfLastSpace).trim();  // Cắt chuỗi trước dấu cách cuối cùng
                        }
                        return url.trim();
                    })
                    .map(DataProcessor::decodeUrl)
                    .collect(Collectors.toList());  // Thu thập các URL đã xử lý vào danh sách
            // Trả về danh sách các URL đã xử lý
            allProcessedUrls.addAll(finalUrlsList);
        }
        return allProcessedUrls;
    }

    private static String decodeUrl(String url) {
        return URLDecoder.decode(url, StandardCharsets.UTF_8);
    }

    public static void sendRequest(List<String> urls) {
        String baseURI = "https://leo88.top/";
        for (String url : urls) {
            // Gửi yêu cầu HTTP GET và lưu lại phản hồi
            Response response = SerenityRest.given()
                    .baseUri(baseURI)
                    .when()
                    .get(url);
            System.out.println(baseURI + url);
            // Lấy mã trạng thái từ phản hồi
            int statusCode = response.getStatusCode();
            String responseBody = response.getBody().asString();

            // Ghi lại response vào báo cáo của Serenity
            Serenity.recordReportData().withTitle("HTTP GET Response for " + url)
                    .andContents("Status Code: " + statusCode + "\nResponse Body: " + responseBody);

            // Kiểm tra mã trạng thái
            if (statusCode >= 400) {
                System.out.println("Test failed: Received status code " + statusCode);
                throw new AssertionError("Expected status code 200 but received " + statusCode);
            } else {
                System.out.println("200: " + url);
                // Optional: Ghi lại mã trạng thái cho các yêu cầu thành công (nếu cần)
                Serenity.recordReportData().withTitle("HTTP GET Status for " + url)
                        .andContents("Status Code: " + statusCode);
            }
        }
    }
}

