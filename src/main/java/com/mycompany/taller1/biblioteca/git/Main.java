package com.mycompany.taller1.biblioteca.git;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    static ArrayList<Client> clients = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Loan> loans = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) {
        int option;
        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Create client");
            System.out.println("2. List clients");
            System.out.println("3. Update client");
            System.out.println("4. Delete client");
            System.out.println("5. Create book");
            System.out.println("6. List books");
            System.out.println("7. Update book");
            System.out.println("8. Delete book");
            System.out.println("9. Register loan");
            System.out.println("10. Return loan");
            System.out.println("11. List active loans");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1 -> createClient();
                case 2 -> listClients();
                case 3 -> updateClient();
                case 4 -> deleteClient();
                case 5 -> createBook();
                case 6 -> listBooks();
                case 7 -> updateBook();
                case 8 -> deleteBook();
                case 9 -> createLoan();
                case 10 -> returnLoan();
                case 11 -> listLoans();
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option.");
            }
        } while (option != 0);
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
    public static void deleteBook() {
        System.out.print("Enter the code of the book to delete: ");
        String code = sc.nextLine();
        Book b = searchBook(code);

        if (b == null) {
            System.out.println("Book not found.");
            return;
        }

        books.remove(b);
        System.out.println("Book deleted successfully.");
    }
        public static void createLoan() {
        System.out.println("--- Register new loan ---");
        System.out.print("Loan ID: ");
        String id = sc.nextLine();
        System.out.print("Client ID: ");
        String clientId = sc.nextLine();
        Client c = searchClient(clientId);

        if (c == null) {
            System.out.println("Client not found.");
            return;
        }

        System.out.print("Book code: ");
        String bookCode = sc.nextLine();
        Book b = searchBook(bookCode);

        if (b == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!b.isAvailable()) {
            System.out.println("Book is not available.");
            return;
        }

        Loan newLoan = new Loan(id, c, b, LocalDate.now());
        loans.add(newLoan);
        b.setAvailable(false);

        System.out.println("Loan registered successfully.");
    }
            public static void returnLoan() {
        System.out.print("Enter the loan ID to return: ");
        String id = sc.nextLine();

        for (Loan l : loans) {
            if (l.getId().equals(id)) {
                if (l.getStatus().equals("RETURNED")) {
                    System.out.println("This loan was already returned.");
                    return;
                }
                l.setStatus("RETURNED");
                l.getBook().setAvailable(true);
                System.out.println("Loan returned successfully.");
                return;
            }
        }

        System.out.println("Loan not found.");
    }
      public static void listLoans() {
        System.out.println("--- Active loans ---");
        boolean hasActive = false;
        for (Loan l : loans) {
            if (l.getStatus().equals("ACTIVE")) {
                System.out.println(l);
                hasActive = true;
            }
        }
        if (!hasActive) {
            System.out.println("No active loans.");
        }
    }
}