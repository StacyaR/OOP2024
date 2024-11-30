package ru.vsu.cs.sem3.oop.practice;

import ru.vsu.cs.sem3.oop.practice.Video.Advertisement;

public interface Advertising {
    void addAdvertisement(Advertisement add, int second);

    int countAllAddTime();

    float countRelativeAddTime();

    void showAdvertisement();
}
