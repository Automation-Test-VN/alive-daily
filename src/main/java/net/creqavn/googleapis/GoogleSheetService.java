package net.creqavn.googleapis;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class GoogleSheetService extends GoogleApiServices {
    private static final Logger LOGGER = Logger.getLogger(GoogleSheetService.class.getName());
    public static final String NO_DATA_FOUND = "No data found";
    private final Sheets sheet;

    public GoogleSheetService() {
        this.sheet = getSheetsService();
    }

    public String createSpreadSheet(String sheetTitle) throws IOException {

            Sheets service = getSheetsService();
            Spreadsheet spreadsheet = new Spreadsheet()
                    .setProperties(new SpreadsheetProperties()
                            .setTitle(sheetTitle));
            spreadsheet = service
                    .spreadsheets()
                    .create(spreadsheet)
                    .setFields("spreadsheetId")
                    .execute();
            return spreadsheet.getSpreadsheetId();
    }

   public ValueRange getValues(String spreadsheetId, String range) throws IOException {

       return sheet
                .spreadsheets()
                .values()
                .get(spreadsheetId, range)
                .execute();

    }

    public List<List<Object>> getValuesByTable(String spreadsheetId, String range) throws IOException {
        return getValues(spreadsheetId, range).getValues();
    }

    public void updateValue(String spreadsheetId, String range, List<List<Object>> newValues) throws IOException {
        // Create the ValueRange object
        ValueRange body = new ValueRange().setValues(newValues);

        // Update the values in the sheet
        sheet.spreadsheets().values()
                .update(spreadsheetId, range, body)
                .setValueInputOption("RAW")
                .execute();

        LOGGER.info("Data successfully update value to "+spreadsheetId+" in range "+ range);
    }

    public List<String> getAllSheetName(String spreadsheetId) throws IOException {
        // Get the spreadsheet metadata
        Spreadsheet spreadsheet = sheet.spreadsheets().get(spreadsheetId).execute();

        // Extract sheet names
        List<String> sheetNames = new ArrayList<>();
        for (Sheet sheet : spreadsheet.getSheets()) {
            sheetNames.add(sheet.getProperties().getTitle());
        }
        return sheetNames;
    }

    public void addSheet(String spreadsheetId, String sheetName) throws IOException {

        AddSheetRequest addSheetRequest = new AddSheetRequest()
                .setProperties(new SheetProperties().setTitle(sheetName));

        BatchUpdateSpreadsheetRequest batchUpdateRequest = new BatchUpdateSpreadsheetRequest()
                .setRequests(Collections.singletonList(new Request().setAddSheet(addSheetRequest)));

        sheet.spreadsheets().batchUpdate(spreadsheetId, batchUpdateRequest).execute();
    }

    public boolean isSheet(String spreadsheetId, String sheetName) throws IOException {
        List<String> sheets = getAllSheetName(spreadsheetId);
        return sheets.contains(sheetName);
    }

   public int getSheetId(String spreadsheetId, String sheetName) throws IOException {

        Spreadsheet spreadsheet = sheet.spreadsheets().get(spreadsheetId).execute();
        for (Sheet sheet : spreadsheet.getSheets()) {
            if (sheet.getProperties().getTitle().equals(sheetName)) {
                return sheet.getProperties().getSheetId();
            }
        }
        throw new IllegalArgumentException("Sheet name not found" + sheetName);
    }


    public void setTextValueOfCellByIndex(String spreadsheetId, String sheetName, int row, int col, String textValue) throws IOException {

        ValueRange valueRange = new ValueRange();
        valueRange.setValues(List.of(
                Collections.singletonList(textValue)));
        try {
            sheet.spreadsheets().values()
                    .update(spreadsheetId,
                            sheetName + "!" + getCellAddress(row, col),
                            valueRange)
                    .setValueInputOption("RAW")
                    .execute();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getTextValueOfCellByIndex(String spreadsheetId, String sheetName, int row, int col) {

       try {
           ValueRange response = sheet.spreadsheets().values()
                    .get(spreadsheetId,
                            sheetName + "!" + getCellAddress(row, col))
                    .execute();
           List<List<Object>> values = response.getValues();
           if (values != null && !values.isEmpty()) {
               return values.getFirst().getFirst().toString();
           } else {
               return NO_DATA_FOUND;
           }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getCellAddress(int row, int col) {
        String colLetter = String.valueOf((char)('A' + col));
        return colLetter + (row + 1);
    }

    public void renameSheetTitle(String spreadsheetId, String title, String newTitle) throws IOException {

        if(!isSheet(spreadsheetId, title)){
            LOGGER.info("Sheet name not found " + title);
            return;
        }

        int sheetId = getSheetId(spreadsheetId, title);
        LOGGER.info("Renaming sheet. Sheet ID: " + sheetId);
        // Create the request.
        Request request = new Request()
        .setUpdateSheetProperties(new UpdateSheetPropertiesRequest()
                .setProperties(new SheetProperties()
                        .setSheetId(sheetId)
                        .setTitle(newTitle))
                .setFields("title"));

        // Prepare the batch update.
        BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest()
                .setRequests(Collections.singletonList(request));

        // Execute the request.
        sheet.spreadsheets().batchUpdate(spreadsheetId, body).execute();
    }

}
