package com.mycompany.taller1.biblioteca.git;

import java.time.LocalDate;

public class Loan {
    private String id;
    private Client client;
    private Book book;
    private LocalDate date;
    private String status;

    public Loan(String id, Client client, Book book, LocalDate date) {
        this.id = id;
        this.client = client;
        this.book = book;
        this.date = date;
        this.status = "ACTIVE";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Loan ID: " + id + " | Client: " + client.getName() + " | Book: " + book.getTitle()
                + " | Date: " + date + " | Status: " + status;
    }
}