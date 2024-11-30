package ru.vsu.cs.sem3.oop.practice;

import ru.vsu.cs.sem3.oop.practice.Video.Video;
import ru.vsu.cs.sem3.oop.practice.exceptions.MyNullPointerVideoException;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Objects;

public class Bid implements Playable {
    private static final int maxBidTime = 20;
    private static final int luckyNum = 0;
    private static int amount = 0;
    private final int number = ++amount;
    private int id;
    private String listenerName;
    private LocalDateTime creationDate;
    private Genre genre;
    private LocalDateTime playDate;
    private Video video;
    private Status status = Status.WAITING;

    /*
        static {
            LocalDate now = LocalDate.now();
            if (now.get(ChronoField.MONTH_OF_YEAR) == 5) {
                luckyNum = Math.abs(now.get(ChronoField.MONTH_OF_YEAR) - now.get(ChronoField.DAY_OF_MONTH)) * 3;
            } else {
                luckyNum = now.get(ChronoField.MONTH_OF_YEAR) + now.get(ChronoField.DAY_OF_MONTH);
            }
            System.out.printf("Удачный номер сегодня: %d\n", luckyNum);
        }
    */
/*
    {
        if (number == luckyNum) {
            System.out.println("Выиграли бонус");
        }
        System.out.println("Не выиграли бонус");
    }
*/
    public Bid(int id, String listenerName, LocalDateTime creationDate, Genre genre) {
        this.id = id;
        this.listenerName = listenerName;
        this.creationDate = creationDate;
        this.genre = genre;
        //System.out.println("Бесплатная заявка создана");
    }

    public Bid(int id, String listenerName, LocalDateTime creationDate) {
        this.id = id;
        this.listenerName = listenerName;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getListenerName() {
        return listenerName;
    }

    public void setListenerName(String listenerName) {
        this.listenerName = listenerName;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public LocalDateTime getPlayDate() {
        return playDate;
    }

    public void setPlayDate(LocalDateTime playDate) {
        this.playDate = playDate;
    }

    public Video getVideo() {
        return video;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public static int getAmount() {
        return amount;
    }

    public static void setAmount(int amount) {
        Bid.amount = amount;
    }

    public int getNumber() {
        return number;
    }

    public int getMaxBidTime() {
        return maxBidTime;
    }

    public String playBidVideo() {
        if (Objects.nonNull(video)) {
            return video.startPlaying();
        } else {
            throw new MyNullPointerVideoException("Видео не существует! :(");
        }
    }

    public String addVideo(Video video) {
        if (this.video != null) {
            return "Нельзя добавить два видео к одной заявке! Удалите видео!";
        }
        if (video.getLength() > maxBidTime) {
            return "Длительность добавляемого видео превышает разрешенную!";
        }
        this.video = video;
        return String.format("Видео добавлено к заявке № %d", this.id);
    }

    public void deleteVideo() {
        this.video = null;
    }


    public long calcAge() {
        if (this.status != Status.WAITING) {
            return -1;
        }
        return Duration.between(creationDate, LocalDateTime.now()).toHours();
    }

    @Override
    public String startPlaying() {
        String s = playBidVideo();
        status = Status.PLAYING;
        playDate = LocalDateTime.now();
        return "Заявка запущена! " + s;
    }

    @Override
    public String finishPlaying() {
        this.status = Status.STORING;
        return "Заявка выключена и отправлена в архив";

    }

    @Override
    public String putPause() {
        this.status = Status.WAITING;
        return "Заявка приостановлена";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bid bid = (Bid) o; //Downcasting
        return id == bid.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, this.getClass());
    }

    public enum Status {
        WAITING(2),
        PLAYING(9),
        STORING(7);

        Status(int i) {
        }
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id=" + id +
                "number=" + number +
                ", listenerName=" + listenerName +
                ", creationDate=" + creationDate +
                ", playingDate=" + playDate +
                ", genre=" + genre +
                ", video=" + video +
                ", status=" + status +
                '}';
    }

}
