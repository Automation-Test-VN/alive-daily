package net.creqavn.googleapi.sheets;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.*;
import net.creqavn.Config;
import net.creqavn.GlobalConstants;
import net.creqavn.googleapi.GoogleApiServices;
import net.creqavn.googleapi.drive.GoogleDriveService;
import net.creqavn.utilities.DateTimeUtils;
import net.thucydides.model.domain.TestOutcome;
import net.thucydides.model.reports.TestOutcomeLoader;
import net.thucydides.model.reports.TestOutcomes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GoogleSheetApi extends GoogleApiServices {
    private final Sheets sheet;
    public static final String NO_DATA_FOUND = "No data found";

    public GoogleSheetApi() {
        this.sheet = GoogleApiServices.getSheetsService();
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

    public List<CellPosition> findsCellPosition(String spreadsheetId, String sheetName, String value) throws IOException {
        List<List<Object>> values = getValuesByTable(spreadsheetId, sheetName + "!A1:M");
        List<CellPosition> cellsPosition = new ArrayList<>();
        for (int row = 0; row < values.size(); row++) {
            List<Object> rowValues = values.get(row);
            for (int col = 0; col < rowValues.size(); col++) {
                if (rowValues.get(col).equals(value)) {
                    cellsPosition.add(new CellPosition(row, col));
                }
            }
        }
        return cellsPosition;
    }

    public void setBackgroundColorOfCellByIndex(String spreadsheetId, String sheetName, int row, int col, CellColor color) {

        CellFormat cellFormat = new CellFormat()
                .setBackgroundColor(new Color()
                        .setRed(color.getRed())
                        .setGreen(color.getGreen())
                        .setBlue(color.getBlue())
                        .setAlpha(color.getAlpha()));

        try {
            RepeatCellRequest repeatCellRequest = new RepeatCellRequest()
                    .setRange(new GridRange().setSheetId(getSheetId(spreadsheetId, sheetName))
                            .setStartRowIndex(row)
                            .setEndRowIndex(row + 1)
                            .setStartColumnIndex(col)
                            .setEndColumnIndex(col + 1))
                    .setCell(new CellData().setUserEnteredFormat(cellFormat))
                    .setFields("userEnteredFormat.backgroundColor");

            BatchUpdateSpreadsheetRequest batchUpdateRequest = new BatchUpdateSpreadsheetRequest()
                    .setRequests(Collections.singletonList(new Request().setRepeatCell(repeatCellRequest)));

            sheet.spreadsheets().batchUpdate(spreadsheetId, batchUpdateRequest).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeOutput(TestOutcomes outcomes) throws IOException {
        String sheetName = DateTimeUtils.setFolderName();
        String spreadsheetId = Config.getSessionSpreadIdGlobal();
        addSheet(spreadsheetId,sheetName);
        int row = 1;
        List<List<Object>> title = List.of(List.of("scenario","vnpt"));
        List<List<Object>> scenario = new ArrayList<>(List.of());
        List<List<Object>> result = new ArrayList<>(List.of());;
        for (TestOutcome outcome : outcomes.getOutcomes()){
            //scenario.getFirst().add(outcome.getTitle());
            scenario.add(List.of(outcome.getTitle()));
            result.add(List.of(outcome.getResult().name()));
        }
        String range = sheetName + "!A1";
        updateValue(spreadsheetId,range,title);
        updateValue(spreadsheetId,sheetName + "!A2",scenario);
        updateValue(spreadsheetId,sheetName + "!B2",result);
    }

    private List<CellPosition> getPositions(String spreadsheetId, String sheetName, String domain) throws IOException {
        return getCellPositions(spreadsheetId, sheetName, domain);
    }

    private List<CellPosition> getCellPositions(String spreadsheetId, String sheetName, String domain) throws IOException {
        return findsCellPosition(spreadsheetId, sheetName, domain);
    }

    public ReportColor getColorValueOfCellByIndex(String spreadsheetId, String sheetName, int row, int col) {
        Color bgColor;
        try {
            Sheets.Spreadsheets.Get request = sheet.spreadsheets().get(spreadsheetId);
            request.setRanges(List.of(sheetName + "!" + getCellAddress(row, col)));

            request.setFields("sheets(data(rowData(values(effectiveFormat(backgroundColor))))),spreadsheetId");
            Spreadsheet response = request.execute();

            bgColor = response.getSheets()
                    .getFirst().getData()
                    .getFirst().getRowData()
                    .getFirst().getValues()
                    .getFirst().getEffectiveFormat().getBackgroundColor();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ReportColor(bgColor.getRed(), bgColor.getGreen(), bgColor.getBlue());
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
        String colLetter = String.valueOf((char) ('A' + col));
        return colLetter + (row + 1);
    }

    public void renameSheetTitle(String spreadsheetId, String title, String newTitle) throws IOException {

        if (!isSheet(spreadsheetId, title)) {
            return;
        }

        int sheetId = getSheetId(spreadsheetId, title);
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

    public void storeTestId(String sheetId) throws IOException {
        String CellOfCurrentExecution = GlobalConstants.DATA_GLOBAL + "!C2";
        updateValue(Config.getSessionSpreadIdGlobal(), CellOfCurrentExecution, List.of(List.of(sheetId)));
    }

    public void storeFolderName(String value) throws IOException {
        String CellOfCurrentExecution = GlobalConstants.DATA_GLOBAL + "!B2";
        updateValue(Config.getSessionSpreadIdGlobal(), CellOfCurrentExecution, List.of(List.of(value)));
    }

    public void storeFolderId(String folderId) throws IOException {
        String CellOfCurrentExecution = GlobalConstants.DATA_GLOBAL + "!D2";
        updateValue(Config.getSessionSpreadIdGlobal(), CellOfCurrentExecution, List.of(List.of(folderId)));
    }
}
