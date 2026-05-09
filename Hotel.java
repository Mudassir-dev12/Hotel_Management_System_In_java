/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Munaf
 */
// Hotel.java - Core manager class
import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Room>        rooms;
    private ArrayList<Guest>       guests;
    private ArrayList<Reservation> reservations;

    public Hotel(String name) {
        this.name         = name;
        this.rooms        = new ArrayList<>();
        this.guests       = new ArrayList<>();
        this.reservations = new ArrayList<>();
        initializeRooms();
    }

    // Pre-populate rooms when the hotel starts
    private void initializeRooms() {
        // Single rooms: 101-104
        for (int i = 101; i <= 104; i++) rooms.add(new SingleRoom(i));
        // Double rooms: 201-203
        for (int i = 201; i <= 203; i++) rooms.add(new DoubleRoom(i));
        // Suites: 301-302
        for (int i = 301; i <= 302; i++) rooms.add(new SuiteRoom(i));
    }

    // ─── ROOM OPERATIONS ────────────────────────────────────────

    public void showAllRooms() {
        System.out.println("\n===== ALL ROOMS IN " + name.toUpperCase() + " =====");
        for (Room r : rooms) System.out.println(r);
    }

    public void showAvailableRooms() {
        System.out.println("\n===== AVAILABLE ROOMS =====");
        boolean found = false;
        for (Room r : rooms) {
            if (r.isAvailable()) {
                System.out.println(r);
                found = true;
            }
        }
        if (!found) System.out.println("No rooms available at the moment.");
    }

    // Find a room by its number; returns null if not found
    public Room findRoom(int roomNumber) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber) return r;
        }
        return null;
    }

    // ─── GUEST OPERATIONS ───────────────────────────────────────

    public Guest registerGuest(String name, String phone, String email) {
        Guest g = new Guest(name, phone, email);
        guests.add(g);
        System.out.println("Guest registered: " + g);
        return g;
    }

    public void showAllGuests() {
        System.out.println("\n===== REGISTERED GUESTS =====");
        if (guests.isEmpty()) { System.out.println("No guests registered yet."); return; }
        for (Guest g : guests) System.out.println(g);
    }

    // Find a guest by their ID
    public Guest findGuest(int guestId) {
        for (Guest g : guests) {
            if (g.getGuestId() == guestId) return g;
        }
        return null;
    }

    // ─── RESERVATION OPERATIONS ─────────────────────────────────

    public Reservation bookRoom(int guestId, int roomNumber, int checkIn, int checkOut) {
        // Validate inputs
        if (checkOut <= checkIn) {
            System.out.println("Error: Check-out day must be after check-in day.");
            return null;
        }

        Guest guest = findGuest(guestId);
        if (guest == null) {
            System.out.println("Error: Guest ID " + guestId + " not found.");
            return null;
        }

        Room room = findRoom(roomNumber);
        if (room == null) {
            System.out.println("Error: Room " + roomNumber + " does not exist.");
            return null;
        }

        if (!room.isAvailable()) {
            System.out.println("Error: Room " + roomNumber + " is currently occupied.");
            return null;
        }

        Reservation res = new Reservation(guest, room, checkIn, checkOut);
        reservations.add(res);
        System.out.println("Booking confirmed! " + res);
        return res;
    }

    public void cancelReservation(int bookingId) {
        Reservation res = findReservation(bookingId);
        if (res == null) {
            System.out.println("Error: Booking #" + bookingId + " not found.");
            return;
        }
        if (!res.isActive()) {
            System.out.println("Error: Booking #" + bookingId + " is already closed.");
            return;
        }
        res.cancel();
    }

    public void checkOut(int bookingId) {
        Reservation res = findReservation(bookingId);
        if (res == null) {
            System.out.println("Error: Booking #" + bookingId + " not found.");
            return;
        }
        if (!res.isActive()) {
            System.out.println("Error: Booking #" + bookingId + " is already closed.");
            return;
        }
        res.generateInvoice();
    }

    public void showAllReservations() {
        System.out.println("\n===== ALL RESERVATIONS =====");
        if (reservations.isEmpty()) { System.out.println("No reservations yet."); return; }
        for (Reservation r : reservations) System.out.println(r);
    }

    // Find a reservation by booking ID
    public Reservation findReservation(int bookingId) {
        for (Reservation r : reservations) {
            if (r.getBookingId() == bookingId) return r;
        }
        return null;
    }
}
