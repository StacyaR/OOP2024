package ru.vsu.cs.sem3.oop.practice;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private List<Bid> bidList = new ArrayList<>();

    public Playlist(ArrayList<Bid> bidList) {
        this.bidList = bidList;
    }

    public Playlist() {
    }

    //формирует плейлист из списка заявок, отфильтровывая нужные с помощью передаваемой функции suiteChecker
    public void makePlaylist(List<Bid> bidList, SuiteChecker suiteChecker) {
        for (Bid bid : bidList) {
            if (suiteChecker.suiteCheck(bid)) {
                bidList.add(bid);
            }
        }
    }

    public List<Bid> getList() {
        List<Bid> clonedList = new ArrayList<>(bidList.size());
        clonedList.addAll(bidList);
        return clonedList;
    }

    public void setList(List<Bid> bidList) {
        List<Bid> clonedList = new ArrayList<>(bidList.size());
        clonedList.addAll(bidList);
        this.bidList = clonedList;
    }
}
