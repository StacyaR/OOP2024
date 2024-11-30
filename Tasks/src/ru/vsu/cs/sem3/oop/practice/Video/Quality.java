package ru.vsu.cs.sem3.oop.practice.Video;

public enum Quality {
    HD(1280, 720),
    FULL_HD(1920, 1080),
    UHD(3840, 2160);
    private final int column;
    private final int row;

    Quality(int column, int row) {
        this.column = column;
        this.row = row;
    }
    public long countPixels() {
        return row * (long) column;
    }
}
