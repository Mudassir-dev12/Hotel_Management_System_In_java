/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Munaf
 */
// Reservation.java
public class Reservation {
    private static int bookingCounter = 5001; // Auto-incrementing booking ID

    private int    bookingId;
    private Guest  guest;
    private Room   room;
    private int    checkInDay;   // simplified: just use day numbers (e.g. 1-30)
    private int    checkOutDay;
    private double totalBill;
    private boolean isActive;

    public Reservation(Guest guest, Room room, int checkInDay, int checkOutDay) {
        this.bookingId   = bookingCounter++;
        this.guest       = guest;
        this.room        = room;
        this.checkInDay  = checkInDay;
        this.checkOutDay = checkOutDay;
        this.isActive    = true;

        // Calculate bill: number of nights × price per night
        int nights   = checkOutDay - checkInDay;
        this.totalBill = nights * room.getPricePerNight();

        // Mark the room as occupied
        room.setAvailable(false);
    }

    // Cancel this reservation and free up the room
    public void cancel() {
        this.isActive = false;
        room.setAvailable(true);
        System.out.println("Reservation #" + bookingId + " cancelled. Room " + room.getRoomNumber() + " is now available.");
    }

    // Generate invoice on checkout
    public void generateInvoice() {
        int nights = checkOutDay - checkInDay;
        System.out.println("\n========== INVOICE ==========");
        System.out.println("Booking ID  : " + bookingId);
        System.out.println("Guest       : " + guest.getName());
        System.out.println("Room        : " + room.getRoomNumber() + " (" + room.getRoomType() + ")");
        System.out.println("Check-in    : Day " + checkInDay);
        System.out.println("Check-out   : Day " + checkOutDay);
        System.out.println("Nights      : " + nights);
        System.out.printf( "Rate        : Rs %.2f/night%n", room.getPricePerNight());
        System.out.println("-----------------------------");
        System.out.printf( "TOTAL BILL  : Rs %.2f%n", totalBill);
        System.out.println("=============================\n");

        // Free the room after checkout
        room.setAvailable(true);
        this.isActive = false;
    }

    // Getters
    public int     getBookingId()  { return bookingId; }
    public Guest   getGuest()      { return guest; }
    public Room    getRoom()       { return room; }
    public boolean isActive()      { return isActive; }
    public double  getTotalBill()  { return totalBill; }

    @Override
    public String toString() {
        return String.format("Booking #%d | %s | Room %d (%s) | Day %d → Day %d | Rs %.2f | %s",
                bookingId, guest.getName(), room.getRoomNumber(), room.getRoomType(),
                checkInDay, checkOutDay, totalBill,
                isActive ? "Active" : "Closed");
    }
}