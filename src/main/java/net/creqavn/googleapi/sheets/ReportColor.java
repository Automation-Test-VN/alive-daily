package net.creqavn.googleapi.sheets;

public class ReportColor {

    private float red;
    private float green;
    private float blue;

    public ReportColor(float red, float green, float blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public float getRed() {
        return red;
    }

    public float getGreen() {
        return green;
    }

    public float getBlue() {
        return blue;
    }

    public boolean isWhite() {
        return Float.compare(this.red, CellColor.WHITE.getRed()) == 0 &&
                Float.compare(this.green, CellColor.WHITE.getGreen()) == 0 &&
                Float.compare(this.blue, CellColor.WHITE.getBlue()) == 0;
    }

    @Override
    public String toString() {
        return "ReportColor{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }
}
