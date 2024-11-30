package ru.vsu.cs.sem3.oop.practice.Video;

import ru.vsu.cs.sem3.oop.practice.Playable;

import java.util.Objects;

public abstract class Video implements Playable {
    private int length;
    private Quality quality;
    private String ownerName;
    private boolean subs;

    public Video(int length, Quality quality, String ownerName, boolean subs) {
        this.length = length;
        this.quality = quality;
        this.ownerName = ownerName;
        this.subs = subs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return length == video.length && subs == video.subs && Objects.equals(quality, video.quality) && Objects.equals(ownerName, video.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, quality, ownerName, subs, this.getClass());
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public boolean isSubs() {
        return subs;
    }

    public void setSubs(boolean subs) {
        this.subs = subs;
    }

    public abstract String zoom(int a);

    public abstract String decrease(int a);

    public String turnOffSubs() {
        setSubs(false);
        return "Cубтитры  выключены";
    }

    public String turnOnSubs() {
        setSubs(true);
        return "Cубтитры (%s) включены";
    }

    @Override
    public String startPlaying() {
        return "Видео играет";
    }

    @Override
    public String finishPlaying() {
        return "Видео выключено";
    }

    @Override
    public String putPause() {
        return "Видео на паузе";
    }

}
