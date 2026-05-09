/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Munaf
 */
// Main.java - Entry point with menu-driven interface
import java.util.Scanner;

public class Main {
    static Scanner sc    = new Scanner(System.in);
    static Hotel   hotel = new Hotel("Grand Java Hotel");

    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("   Welcome to Grand Java Hotel System");
        System.out.println("============================================");

        boolean running = true;
        while (running) {
            printMenu();
            int choice = getIntInput("Enter choice: ");

            switch (choice) {
                case 1  -> hotel.showAllRooms();
                case 2  -> hotel.showAvailableRooms();
                case 3  -> registerGuest();
                case 4  -> hotel.showAllGuests();
                case 5  -> makeBooking();
                case 6  -> hotel.showAllReservations();
                case 7  -> cancelBooking();
                case 8  -> checkOutGuest();
                case 0  -> { System.out.println("Thank you! Goodbye."); running = false; }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }

    static void printMenu() {
        System.out.println("\n----------- MAIN MENU -----------");
        System.out.println(" 1. View all rooms");
        System.out.println(" 2. View available rooms");
        System.out.println(" 3. Register new guest");
        System.out.println(" 4. View all guests");
        System.out.println(" 5. Make a reservation");
        System.out.println(" 6. View all reservations");
        System.out.println(" 7. Cancel a reservation");
        System.out.println(" 8. Check out (generate invoice)");
        System.out.println(" 0. Exit");
        System.out.println("---------------------------------");
    }

    static void registerGuest() {
        System.out.println("\n--- Register New Guest ---");
        System.out.print("Name  : "); String name  = sc.nextLine();
        System.out.print("Phone : "); String phone = sc.nextLine();
        System.out.print("Email : "); String email = sc.nextLine();
        hotel.registerGuest(name, phone, email);
    }

    static void makeBooking() {
        System.out.println("\n--- Make a Reservation ---");
        hotel.showAllGuests();
        int guestId    = getIntInput("Enter Guest ID      : ");
        hotel.showAvailableRooms();
        int roomNumber = getIntInput("Enter Room Number   : ");
        int checkIn    = getIntInput("Check-in day (1-30) : ");
        int checkOut   = getIntInput("Check-out day       : ");
        hotel.bookRoom(guestId, roomNumber, checkIn, checkOut);
    }

    static void cancelBooking() {
        hotel.showAllReservations();
        int bookingId = getIntInput("Enter Booking ID to cancel: ");
        hotel.cancelReservation(bookingId);
    }

    static void checkOutGuest() {
        hotel.showAllReservations();
        int bookingId = getIntInput("Enter Booking ID to check out: ");
        hotel.checkOut(bookingId);
    }

    // Helper: reads an integer and handles bad input gracefully
    static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int val = Integer.parseInt(sc.nextLine().trim());
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}