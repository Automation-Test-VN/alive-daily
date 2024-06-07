package net.creqavn.tasks;

import com.google.common.base.Splitter;
import io.restassured.response.Response;
import net.creqavn.models.UrlStatus;
import net.creqavn.questions.TheImage;
import net.creqavn.questions.TheList;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.net.URLDecoder;

public class DataProcessor {
    /**
     * Phương thức để xử lý các thuộc tính từ danh sách đầu vào.
     * Mỗi chuỗi trong danh sách sẽ được tách thành các URL, cắt bỏ khoảng trắng không cần thiết, giải mã và thu thập vào danh sách kết quả.
     *
     * @param dataSrc Danh sách các chuỗi cần xử lý
     * @return Danh sách các URL đã xử lý
     */
    public static List<String> processAttributes(List<String> dataSrc) {
        List<String> allProcessedUrls = new ArrayList<>();
        for (String data : dataSrc) {
            List<String> finalUrlsList = processUrls(data);
            allProcessedUrls.addAll(finalUrlsList);
        }
        return allProcessedUrls;
    }

    /**
     * Phương thức để xử lý một chuỗi, tách nó thành các URL, cắt bỏ khoảng trắng không cần thiết và giải mã.
     *
     * @param data Chuỗi chứa các URL cần xử lý
     * @return Danh sách các URL đã xử lý
     */
    private static List<String> processUrls(String data) {
        return Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .splitToList(data)
                .stream()
                .map(DataProcessor::trimLastSpace)
                .map(DataProcessor::decodeUrl)
                .collect(Collectors.toList());
    }

    /**
     * Phương thức để tìm và cắt bỏ khoảng trắng cuối cùng trong một chuỗi.
     * Nếu không có khoảng trắng, trả về chuỗi đã cắt bỏ khoảng trắng ở đầu và cuối.
     *
     * @param url Chuỗi cần xử lý
     * @return Chuỗi đã được cắt bỏ khoảng trắng cuối cùng
     */
    private static String trimLastSpace(String url) {
        int indexOfLastSpace = url.lastIndexOf(' ');
        if (indexOfLastSpace != -1) {
            return url.substring(0, indexOfLastSpace).trim();
        }
        return url.trim();
    }

    /**
     * Phương thức để giải mã một URL mã hóa theo chuẩn UTF-8.
     *
     * @param url URL mã hóa cần giải mã
     * @return URL đã được giải mã
     */
    private static String decodeUrl(String url) {
        return URLDecoder.decode(url, StandardCharsets.UTF_8);
    }

    /**
     * Phương thức để gửi các yêu cầu HTTP GET đến danh sách các URL và ghi lại các URL
     * có mã trạng thái không phải là 200.
     *
     * @param urls Danh sách các URL để gửi yêu cầu
     * @return Danh sách các UrlStatus chứa các URL và mã trạng thái không phải là 200
     */
    public static List<UrlStatus> sendRequests(List<String> urls) {
        String baseURI = "https://leo88.top/";
        List<UrlStatus> failedUrls = new ArrayList<>();
        for (String url : urls) {
            try {
                Response response = SerenityRest.given()
                        .baseUri(baseURI)
                        .when()
                        .get(url);
                int statusCode = response.getStatusCode();
                if (statusCode != 200) {
                    failedUrls.add(new UrlStatus(url, statusCode));
                    throw new AssertionError("Expected status code 200 but received " + statusCode);
                }
            } catch (AssertionError e) {
                System.err.println(e.getMessage());
            }
        }
        return failedUrls;
    }

    public static void getAndCheckDataSource(Actor actor, String DOMAIN) {
        List<String> processedData = DataProcessor.getProcessedImageUrls(actor, DOMAIN);
        List<String> lastedData = DataProcessor.removeDuplicates(processedData);
        System.out.println("Total image URLs found: " + lastedData.size());
        sendRequests(lastedData);
    }

    /**
     * Phương thức để lấy và xử lý các URL hình ảnh từ một trang web được cung cấp bởi DOMAIN.
     * Phương thức này yêu cầu một đối tượng Actor thực hiện các thao tác để truy cập trang web,
     * cuộn trang xuống giữa và đáy, sau đó lấy các thuộc tính src của các hình ảnh.
     *
     * @param actor Đối tượng Actor thực hiện các thao tác trên trang web
     * @param DOMAIN URL của trang web cần xử lý
     * @return Danh sách các URL hình ảnh đã được xử lý
     */
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

    /**
     * Phương thức để loại bỏ các phần tử trùng lặp từ danh sách và duy trì thứ tự ban đầu.
     *
     * @param list Danh sách ban đầu có thể chứa các phần tử trùng lặp
     * @return Danh sách mới không chứa các phần tử trùng lặp và duy trì thứ tự ban đầu
     */
    public static List<String> removeDuplicates(List<String> list) {
        Set<String> set = new LinkedHashSet<>(list);
        List<String> newList = new ArrayList<>(set);
        return newList;
    }
}

