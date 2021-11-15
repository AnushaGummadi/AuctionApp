package main.rest.model;

public class IdentifiableMarks {
    private String side;
    private String location;
    private String mark;
    private String color;

    public String getSide() {
        return side;
    }

    public void setSide(final String side) {
        this.side = side;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(final String mark) {
        this.mark = mark;
    }

    public String getColor() {
        return color;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "IdentifiableMarks{" +
               "side='" + side + '\'' +
               ", location='" + location + '\'' +
               ", mark='" + mark + '\'' +
               ", color='" + color + '\'' +
               '}';
    }
}
