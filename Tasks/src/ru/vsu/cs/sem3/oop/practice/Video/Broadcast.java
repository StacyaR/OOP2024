package ru.vsu.cs.sem3.oop.practice.Video;


import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeMap;
import ru.vsu.cs.sem3.oop.practice.Advertising;
import ru.vsu.cs.sem3.oop.practice.exceptions.ListenerRuleViolationException;

import java.util.List;
import java.util.Objects;

import com.google.common.collect.RangeMap;

public class Broadcast extends Video implements Advertising {
    private int addCost = 10;
    private String name;
    private String host;
    private List<String> guests;
    private int season;
    private int episodeNumber;
    private RangeMap<Integer, Advertisement> advertisements = TreeRangeMap.create();

    public Broadcast(int length, Quality quality, String ownerName, boolean subs, String name, String host, List<String> guests, int season, int episodeNumber) {
        super(length, quality, ownerName, subs);
        this.name = name;
        this.host = host;
        this.guests = guests;
        this.season = season;
        this.episodeNumber = episodeNumber;
    }

    public Broadcast(int length, Quality quality, String ownerName, boolean subs) {
        super(length, quality, ownerName, subs);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public List<String> getGuests() {
        return guests;
    }

    public void setGuests(List<String> guests) {
        this.guests = guests;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String save() {
        return "Трансляция сохранена";
    }

    //добавление рекламы в трансляцию так, что
    //первый эпизод - праздничный, без рекламы
    //если длительность рекламы больше, чем осталось до конца трансляции, то рекламу добавлять нельзя
    //если в начальную секунду уже есть реклама, то она заменяется
    //при добавлении рекламы увеличивается её цена на значение addCost
    //при добавлении рекламы увеличивается длина видео-трансляции
    @Override
    public void addAdvertisement(Advertisement ad, int second) {
        if (episodeNumber == 1) {
            return;
        }
        if (second + ad.getLength() * 60 > getLength() * 60) {
            throw new ListenerRuleViolationException("Слишком длинно!");
        } else {
            if (Objects.nonNull(advertisements.getEntry(second))) {
                Advertisement prevAd = advertisements.getEntry(second).getValue();
                setLength(getLength() - prevAd.getLength());
                prevAd.increasePrice(-addCost);
            }
            advertisements.put(Range.closedOpen(second, second + ad.getLength()), ad);
            setLength(getLength() + ad.getLength());
            ad.increasePrice(addCost);
        }
    }

    @Override
    public int countAllAddTime() {
        int sum = 0;
        for (Advertisement ad : advertisements.asMapOfRanges().values()) {
            sum += ad.getLength();
        }
        return sum;
    }

    @Override
    public float countRelativeAddTime() {
        return (float) countAllAddTime() / getLength();
    }

    @Override
    public void showAdvertisement() {
        for (Advertisement ad : advertisements.asMapOfRanges().values()) {
            System.out.println(ad.toString());
        }
    }

    @Override
    public String startPlaying() {
        return "Трансляция играет";
    }

    @Override
    public String zoom(int a) {
        return String.format("Трансляция (%s) увеличена на %d", this, a);
    }

    @Override
    public String decrease(int a) {
        return String.format("Трансляция (%s) уменьшена на %d", this, a);
    }


    @Override
    public String finishPlaying() {
        return "Трансляция выключена";
    }

    @Override
    public String putPause() {
        return "Трансляция на паузе";
    }

    @Override
    public String toString() {
        String g = "";
        for (String s : guests) {
            g = g + s + ',';
        }
        return "Broadcast{" +
                "name=" + name +
                ", host=" + host +
                " season=" + season +
                ", episodeNumber=" + episodeNumber +
                +'\n' +
                "} " + super.toString();
    }


}
