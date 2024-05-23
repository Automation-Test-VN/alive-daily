package net.creqavn.googleapi.sheets;

/**
 * Represents the position (row and column indices) of a cell in a Google Sheet.
 */
public class CellPosition {
    private int row;
    private int col;
    public CellPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
}
