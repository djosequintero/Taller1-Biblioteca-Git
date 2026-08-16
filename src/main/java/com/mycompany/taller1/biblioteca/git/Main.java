package com.mycompany.taller1.biblioteca.git;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Client> clients = new ArrayList<>();
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
}