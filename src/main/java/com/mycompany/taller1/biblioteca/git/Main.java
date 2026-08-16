package com.mycompany.taller1.biblioteca.git;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Client> clients = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    }

    public static void createClient() {
        System.out.println("--- Create new client ---");
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        Client newClient = new Client(id, name, phone, email);
        clients.add(newClient);
        System.out.println("Client created successfully.");
    }

    public static void listClients() {
        System.out.println("--- Client list ---");
        if (clients.isEmpty()) {
            System.out.println("No clients registered.");
        } else {
            for (Client c : clients) {
                System.out.println(c);
            }
        }
    }

    public static Client searchClient(String id) {
        for (Client c : clients) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public static void updateClient() {
        System.out.print("Enter the ID of the client to update: ");
        String id = sc.nextLine();
        Client c = searchClient(id);
        if (c == null) {
            System.out.println("Client not found.");
            return;
        }
        System.out.print("New name (" + c.getName() + "): ");
        String name = sc.nextLine();
        System.out.print("New phone (" + c.getPhone() + "): ");
        String phone = sc.nextLine();
        System.out.print("New email (" + c.getEmail() + "): ");
        String email = sc.nextLine();
        c.setName(name);
        c.setPhone(phone);
        c.setEmail(email);
        System.out.println("Client updated successfully.");
    }

    public static void deleteClient() {
        System.out.print("Enter the ID of the client to delete: ");
        String id = sc.nextLine();
        Client c = searchClient(id);
        if (c == null) {
            System.out.println("Client not found.");
            return;
        }
        clients.remove(c);
        System.out.println("Client deleted successfully.");
    }

    public static void createBook() {
        System.out.println("--- Create new book ---");
        System.out.print("Code: ");
        String code = sc.nextLine();
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Year: ");
        int year = Integer.parseInt(sc.nextLine());
        System.out.print("Author: ");
        String author = sc.nextLine();
        Book newBook = new Book(code, title, year, author);
        books.add(newBook);
        System.out.println("Book created successfully.");
    }
    public static void listBooks() {
        System.out.println("--- Book list ---");
        if (books.isEmpty()) {
            System.out.println("No books registered.");
        } else {
            for (Book b : books) {
                System.out.println(b);
            }
        }
    }
    public static Book searchBook(String code) {
        for (Book b : books) {
            if (b.getCode().equals(code)) {
                return b;
            }
        }
        return null;
    }
    public static void updateBook() {
        System.out.print("Enter the code of the book to update: ");
        String code = sc.nextLine();
        Book b = searchBook(code);

        if (b == null) {
            System.out.println("Book not found.");
            return;
        }

        System.out.print("New title (" + b.getTitle() + "): ");
        String title = sc.nextLine();
        System.out.print("New year (" + b.getYear() + "): ");
        int year = Integer.parseInt(sc.nextLine());
        System.out.print("New author (" + b.getAuthor() + "): ");
        String author = sc.nextLine();

        b.setTitle(title);
        b.setYear(year);
        b.setAuthor(author);

        System.out.println("Book updated successfully.");
    }
}