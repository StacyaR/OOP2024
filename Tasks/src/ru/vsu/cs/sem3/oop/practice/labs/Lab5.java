package ru.vsu.cs.sem3.oop.practice.labs;

import ru.vsu.cs.sem3.oop.practice.Video.Broadcast;
import ru.vsu.cs.sem3.oop.practice.Video.Advertisement;
import ru.vsu.cs.sem3.oop.practice.Genre;
import ru.vsu.cs.sem3.oop.practice.Bid;
import ru.vsu.cs.sem3.oop.practice.Playlist;
import ru.vsu.cs.sem3.oop.practice.Video.Quality;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Lab5 {
    public static void main(String[] args) {
        //демонстрация работы интерфейса Advertising, реализуемый классом Broadcast
        Broadcast broadcast = new Broadcast(4, Quality.HD, "Oleg", true);
        broadcast.addAdvertisement(new Advertisement(2, Quality.FULL_HD, "ddd", false), 20);
        broadcast.addAdvertisement(new Advertisement(1, Quality.UHD, "ddd", false), 100);
        broadcast.showAdvertisement();
        System.out.println("Рекламное время в трансляции: " + broadcast.countAllAddTime() + " минуты");
        System.out.println("Относительное рекламное время в трансляции: " +
                Math.round(broadcast.countRelativeAddTime() * 100) + "%");

        //демонстрация работы функционального интерфейса SuiteChecker,
        //экземпляр реализации которого использует метод
        //makePlaylist(List<Bid> bidList, SuiteChecker suiteChecker) класса Playlist
        Genre folk = new Genre("фолк", "Германия");
        Bid bid1 = new Bid(235, "Anastasia", LocalDateTime.now(), folk);
        Bid bid2 = new Bid(225, "Anastasia", LocalDateTime.now(), folk);
        Bid bid3 = new Bid(225, "Anastasia", LocalDateTime.now(), folk);
        Playlist playlist = new Playlist();
        List<Bid> bidList = new ArrayList<>();
        bidList.add(bid1);
        bidList.add(bid2);
        bidList.add(bid3);
        playlist.makePlaylist(bidList, (bid) ->
                bid.getId() > 255 && bid.getStatus() != Bid.Status.STORING);
    }
}
