package ru.vsu.cs.sem3.oop.practice.Video;


public class Clip extends Video {
    private String studio;
    private String trekName;
    private String singer;
    private int year;

    public Clip(int length, Quality quality, String ownerName, boolean subs, String studio, String trekName, String singer, int year) {
        super(length, quality, ownerName, subs);
        this.studio = studio;
        this.trekName = trekName;
        this.singer = singer;
        this.year = year;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getTrekName() {
        return trekName;
    }

    public void setTrekName(String trekName) {
        this.trekName = trekName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String zoom(int a) {
        return String.format("Клип (%s) увеличен на %d", this, a);
    }

    @Override
    public String decrease(int a) {
        return String.format("Клип (%s) уменьшен на %d", this, a);
    }

    @Override
    public String startPlaying() {
        return "Клип играет";
    }

    @Override
    public String finishPlaying() {
        return "Клип выключено";
    }

    @Override
    public String putPause() {
        return "Клип на паузе";
    }

    @Override
    public String toString() {
        return "Clip{" +
                "studio=" + studio +
                ", trekName=" + trekName +
                ", singer=" + singer +
                ", year=" + year +
                +'\'' +
                "} " + super.toString();
    }

}
