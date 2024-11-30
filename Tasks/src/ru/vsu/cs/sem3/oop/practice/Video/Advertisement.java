package ru.vsu.cs.sem3.oop.practice.Video;

public class Advertisement extends Video {
    long price = 0;

    public Advertisement(int length, Quality quality, String ownerName, boolean subs) {
        super(length, quality, ownerName, subs);
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void increasePrice(int a) {
        price += a;
    }

    @Override
    public String zoom(int a) {
        return null;
    }

    @Override
    public String decrease(int a) {
        return null;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "price=" + price +
                "length=" + getLength() +
                '}';
    }
}
