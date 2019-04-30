package com.jbrary.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

public class Order {
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private int id;
    private User user;
    private Book book;
    private LocalDate orderDate;
    private LocalDate dueDate;
    private boolean fulfilled;
    final float FINE_PER_DAY = 1.50f;

    public Order(int id, User user, Book book, LocalDate orderDate, LocalDate dueDate, boolean fulfilled) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.orderDate = orderDate;
        this.dueDate = dueDate;
        this.fulfilled = fulfilled;
    }

    public Order(int id, User user, Book book, String orderDate, String dueDate, String fulfilled) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.orderDate = LocalDate.parse(orderDate, dateTimeFormatter);
        this.dueDate = LocalDate.parse(dueDate, dateTimeFormatter);
        this.fulfilled = Boolean.parseBoolean(fulfilled);
    }

    public Order(User user, Book book, LocalDate orderDate, LocalDate dueDate, boolean fulfilled) {
        this.user = user;
        this.book = book;
        this.orderDate = orderDate;
        this.dueDate = dueDate;
        this.fulfilled = fulfilled;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getOrderDateString() {
        return dateTimeFormatter.format(orderDate);
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getDueDateString() {
        return dateTimeFormatter.format(dueDate);
    }

    public boolean isFulfilled() {
        return fulfilled;
    }

    public String getFullfilled() {
        return Boolean.toString(fulfilled);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setFulfilled(boolean fulfilled) {
        this.fulfilled = fulfilled;
    }
    public double getFine(){
        long daysBetween = DAYS.between(dueDate, LocalDate.now());
        double fine = daysBetween * FINE_PER_DAY;
        System.out.println(daysBetween);
        if(fine < 0)
            return 0;

        else {
            return fine ;
        }

    }
}
