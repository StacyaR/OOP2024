package ru.vsu.cs.sem3.oop.practice.labs;

import ru.vsu.cs.sem3.oop.practice.Bid;
import ru.vsu.cs.sem3.oop.practice.Genre;
import ru.vsu.cs.sem3.oop.practice.Video.*;
import ru.vsu.cs.sem3.oop.practice.exceptions.MyNullPointerVideoException;

import java.time.LocalDateTime;

public class Lab6 {
    public static void main(String[] args) {
        //Перечисление Quality используется как поле класса Video
        //Quality хранит информацию о названии стандарта качества, количество пикселей по горизонтали и вертикали
        //и имеет метод, высчитываемый количество пикселей в общей площади
        Video clip = new Clip(12, Quality.HD, "FAUN", false,
                "JETZT BESTELLEN", "Rosenrot", "FAUN", 2019);
        System.out.println("Кол-во пикселей: " + clip.getQuality().countPixels());

        //метод playBidVideo() класса Bid выбрасывает исключение MyNullPointerVideoException в том случае, если
        //поле video класса Bid не проинициализировано
        Bid bid1 = new Bid(235, "Anastasia", LocalDateTime.now(),
                new Genre("фолк", "Германия"));
        try {
            bid1.playBidVideo();
        } catch (MyNullPointerVideoException e) {
            System.err.println(e.getMessage());
        }

        //метод addAdvertisement() класса Broadcast выбрасывает исключение ListenerRuleViolationException в том случае,
        //если длительность рекламного ролика больше, чем оставшееся время трансляции
        Broadcast broadcast = new Broadcast(4, Quality.HD, "Oleg", true);
        broadcast.addAdvertisement(new Advertisement(20, Quality.HD, "ddd", false), 150);
    }
}
