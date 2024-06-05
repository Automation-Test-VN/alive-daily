package net.creqavn.tasks;

import io.restassured.response.Response;
import net.creqavn.questions.TheImage;
import net.creqavn.questions.TheList;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.net.URLDecoder;

public class DataProcessor {
    public static List<String> processAttributes(List<String> dataSrc) {
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

    public static void sendRequests(List<String> urls) {
        String baseURI = "https://leo88.top/";
        for (String url : urls) {
            try {
                // Gửi yêu cầu HTTP GET và lưu lại phản hồi
                Response response = SerenityRest.given()
                        .baseUri(baseURI)
                        .when()
                        .get(url);
                // Lấy mã trạng thái từ phản hồi
                int statusCode = response.getStatusCode();

                // Kiểm tra mã trạng thái
                if (statusCode >= 400) {
                    System.out.println("Test failed: Status code: " + statusCode + "\nUrl: " + url);
                    // Ghi lại response vào báo cáo của Serenity
                    Serenity.recordReportData().withTitle("HTTP GET Response for " + url)
                            .andContents("Status Code: " + statusCode);
                    throw new AssertionError("Expected status code 200 but received " + statusCode);
                }
            } catch (AssertionError e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void performImageCheckOnSinglePage(Actor actor, String DOMAIN) {
//        actor.attemptsTo(
//                Open.url(DOMAIN),
//                SwipeTo.theMiddle(),
//                SwipeTo.theBottom()
//        );
//        System.out.println("Connected to the URL: " + DOMAIN);
//        List<String> srcAttributes = actor.asksFor(TheImage.srcAttributes());
//        if (srcAttributes != null && !srcAttributes.isEmpty()) {
//            List<String> filteredSrc = TheList.filteredAttributes(srcAttributes);
//            List<String> processedData = DataProcessor.processAttributes(filteredSrc);
        List<String> processedData = DataProcessor.getProcessedImageUrls(actor, DOMAIN);
        List<String> lastedData = DataProcessor.removeDuplicates(processedData);
        System.out.println("Total image URLs found: " + lastedData.size());
        DataProcessor.sendRequests(lastedData);

    }

    public static List<String> getProcessedImageUrls(Actor actor, String DOMAIN) {
        List<String> processedData = new ArrayList<>();
        actor.attemptsTo(
                Open.url(DOMAIN),
                SwipeTo.theMiddle(),
                SwipeTo.theBottom()
        );
        System.out.println("Connected to the URL: " + DOMAIN);
        List<String> srcAttributes = actor.asksFor(TheImage.srcAttributes());
        if (srcAttributes != null && !srcAttributes.isEmpty()) {
            List<String> filteredSrc = TheList.filteredAttributes(srcAttributes);
            processedData = DataProcessor.processAttributes(filteredSrc);
        } else {
            System.out.println("No image src attributes found for URL: " + DOMAIN);
        }
        return processedData;
    }


    public static List<String> removeDuplicates(List<String> list) {
        // Sử dụng LinkedHashSet để loại bỏ các phần tử trùng lặp và duy trì thứ tự
        Set<String> set = new LinkedHashSet<>(list);
        // Tạo một danh sách mới từ LinkedHashSet
        List<String> newList = new ArrayList<>(set);
        return newList;
    }
}

