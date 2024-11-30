package ru.vsu.cs.sem3.oop.practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Random;

public class SponsorBid extends Bid {
    private static final Random rnd = new Random();
    private static final String[] bankAccounts = new String[]{"123455245", "254568263", "589614753"};
    private static final int levelCriteria = 1000;
    private static final String bankAccountNumber;
    private final int level;
    private int donat;
    private String question;



    static {
        if (LocalDate.now().get(ChronoField.MONTH_OF_YEAR) == 10) {
            bankAccountNumber = bankAccounts[0];
        } else {
            bankAccountNumber = bankAccounts[rnd.nextInt(bankAccounts.length)];
        }
        System.out.printf("Установлен банковский счет: %s\n", bankAccountNumber);
    }

   /* {
        Scanner sc = new Scanner(System.in);
        System.out.println("Какой вопрос ведущему?");
        if (sc.hasNext()) {
            question = sc.nextLine();
        }
    }
    */

    public SponsorBid(int id, String listenerName, LocalDateTime creationDate, Genre genre, int donat) {
        super(id, listenerName, creationDate, genre);
        this.donat = donat;
        level = donat / levelCriteria;
        System.out.printf("Спонсорский уровень: %d\n", level);
    }

    public SponsorBid(int id, String listenerName, LocalDateTime creationDate, Genre genre) {
        this(id, listenerName, creationDate, genre, 1000);
        System.out.println("Заявка создана со стандартным донатом");
    }

    public static void checkLoad() {
        System.out.println("Static-метод запущен");
    }


    public int getLevel() {
        return level;
    }

    public long getDonat() {
        return donat;
    }

    public void setDonat(int donat) {
        this.donat = donat;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }
}

