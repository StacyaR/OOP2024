package ru.vsu.cs.sem3.oop.practice;

import java.util.Arrays;
import java.time.LocalDateTime;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        //L1
        /*
        Genre folk = new Genre("фолк", "Германия");
        Video clip = new Clip(12, "HD", "FAUN", false, "JETZT BESTELLEN", "Rosenrot", "FAUN", 2019);
        List<String> guests = new ArrayList<>();
        guests.add("Emma Stone");
        guests.add("Willem Dafoe");
        Video broadcast = new Broadcast(15, "SD", "Chupacabra", true, "Ellen", "Ellen", guests, 4, 12);
        Bid bid1 = new Bid(235, "Anastasia", LocalDateTime.now(), folk);
        Bid bid2 = new Bid(225, "Anastasia", LocalDateTime.now(), folk);
        Bid bid3 = new Bid(225, "Anastasia", LocalDateTime.now(), folk);

        System.out.println(bid1);
        System.out.println(bid2);
        System.out.println(bid3);

        System.out.println(bid1.playBid());
        System.out.println(bid1.playBidVideo());

        System.out.println(bid1.addVideo(clip));
        System.out.println(bid1.playBid()+"\n");

        System.out.println(bid1.addVideo(broadcast));
        bid1.deleteVideo();
        System.out.println(bid1.addVideo(broadcast));
        System.out.println(bid1.playBid());

        System.out.println(folk.toString());
        System.out.println(clip.toString());
        System.out.println(broadcast.toString());
        System.out.println(bid1.toString());*/


        //L2
        /*
        Genre folk = new Genre("фолк", "Германия");
        //SponsorBid.checkLoad();
        SponsorBid spBid = new SponsorBid(235, "Anastasia", LocalDateTime.now(), folk);
        System.out.println("---------second-------------");
        SponsorBid spBid2 = new SponsorBid(235, "Anastasia", LocalDateTime.now(), folk);
*/

        //L3

/*
        List<Video> list = new ArrayList<>();
        list.add(new Clip(12, "HD", "FAUN", false, "JETZT BESTELLEN", "Rosenrot", "FAUN", 2019));
        List<String> guests = new ArrayList<>();
        guests.add("Emma Stone");
        guests.add("Willem Dafoe");
        list.add(new Broadcast(15, "SD", "Chupacabra", true, "Ellen", "Ellen", guests, 4, 12));
        list.add(new Clip(12, "HD", "FAUN", false, "JETZT BESTELLEN", "Rosenrot", "FAUN", 2019));
        for (Video v : list) {
            System.out.println(v.startPlaying());
            System.out.println(v.zoom(19));
            System.out.println(v.putPause());
            if (v instanceof Broadcast br) {
                System.out.println(br.save());
            }
            System.out.println("----------");
        }
        */
        int[] arr1 = new int[]{2, 4, 3};
        int[] arr2 = new int[]{2, 4, 3};
        System.out.println(arr1.equals(arr2));
        System.out.println(Objects.equals(arr1, arr2));
        System.out.println(Objects.deepEquals(arr1, arr2));
        System.out.println(Arrays.equals(arr1, arr2));

        Genre genre = new Genre("фолк", "Германия");
        System.out.println(genre.hashCode());
        genre.setCountry("Finland");
        System.out.println(genre.hashCode());
        genre.setCountry("Германия");
        System.out.println(genre.hashCode());

        Bid bid1 = new Bid(235, "Anastasia", LocalDateTime.now(), genre);
        SponsorBid Sbid1 = new SponsorBid(235, "Anastasia", LocalDateTime.now(), genre);
        //Sbid1.setQuestion("rtyghjgj");
        Bid bid2 = Sbid1;
        System.out.println(bid1.hashCode());
        System.out.println(Sbid1.hashCode());
        System.out.println(bid1.equals(Sbid1));
        System.out.println(bid1.equals(bid2));

        Genre genre1 = new Genre("Электрик", "Германия");
        Genre genre2 = new Genre("Электрик", "Китай");
        System.out.println(genre1.hashCode());
        System.out.println(genre2.hashCode());
        System.out.println(genre2.equals(genre1));
    }
}
