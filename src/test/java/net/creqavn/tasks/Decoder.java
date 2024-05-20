package net.creqavn.tasks;

import com.google.zxing.EncodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static net.creqavn.models.QRCodeChecker.readQR;

public class Decoder {
    public static Performable theQRImage() {
        return Task.where("{0} decode the QR image",actor -> {
            // Path where the QR code is saved
            String filePath = "images/bank.jpg";
            // Encoding charset
            String charset = "UTF-8";

            Map<EncodeHintType, ErrorCorrectionLevel> hashMap
                    = new HashMap<EncodeHintType,
                    ErrorCorrectionLevel>();

            hashMap.put(EncodeHintType.ERROR_CORRECTION,
                    ErrorCorrectionLevel.L);

            try {
                // Đọc mã QR và lưu kết quả vào một biến
                String decodedQR = readQR(filePath, charset, hashMap);
                System.out.println("QRCode output: " + decodedQR);

                // So sánh kết quả với một giá trị cụ thể
                String expectedValue = "LMARY9887116304B40D";
                if (decodedQR.contains(expectedValue)) {
                    System.out.println("QR code matches the expected value.");
                } else {
                    System.out.println("QR code does not match the expected value.");
                }
            } catch (IOException | NotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
