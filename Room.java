/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Munaf
 */
// Room.java - Base class for all room types
public abstract class Room {
    private int roomNumber;
    private double pricePerNight;
    private boolean isAvailable;
    private String roomType;

    public Room(int roomNumber, double pricePerNight, String roomType) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.roomType = roomType;
        this.isAvailable = true;
    }

    // Abstract method - each room type describes its own amenities
    public abstract String getAmenities();

    // Getters
    public int getRoomNumber()       { return roomNumber; }
    public double getPricePerNight() { return pricePerNight; }
    public boolean isAvailable()     { return isAvailable; }
    public String getRoomType()      { return roomType; }

    // Setters
    public void setAvailable(boolean available) { this.isAvailable = available; }

    @Override
    public String toString() {
        return String.format("Room %d [%s] - Rs %.2f/night | %s | %s",
                roomNumber, roomType, pricePerNight,
                isAvailable ? "Available" : "Occupied",
                getAmenities());
    }
}

