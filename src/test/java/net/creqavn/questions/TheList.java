package net.creqavn.questions;

import java.util.List;
import java.util.stream.Collectors;

public class TheList {
    // Biến tĩnh chứa danh sách từ khóa mặc định
    private static final List<String> DEFAULT_KEYWORDS = List.of(".png", ".jpg");
    /**
     * Phương thức để lọc danh sách chuỗi và giữ lại các chuỗi chứa bất kỳ từ khóa nào trong danh sách từ khóa.
     *
     * @param strings Danh sách chuỗi ban đầu
     * @param keywords Danh sách từ khóa để lọc
     * @return Danh sách mới chứa các chuỗi đáp ứng điều kiện
     */
    public static List<String> filteredAttributes(List<String> strings, List<String> keywords) {
        return strings.stream()
                .filter(s -> keywords.stream().anyMatch(keyword -> s.contains(keyword)))
                .collect(Collectors.toList());
    }

    /**
     * Phương thức để lọc danh sách chuỗi sử dụng từ khóa mặc định.
     *
     * @param strings Danh sách chuỗi ban đầu
     * @return Danh sách mới chứa các chuỗi đáp ứng điều kiện với từ khóa mặc định
     */
    public static List<String> filteredAttributes(List<String> strings) {
        return filteredAttributes(strings, DEFAULT_KEYWORDS);
    }
}
