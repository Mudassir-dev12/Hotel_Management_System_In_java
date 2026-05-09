/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Munaf
 */
// SingleRoom.java
public class Roomtypes {
    // This public class gives the file its name — nothing inside it
}

class SingleRoom extends Room {
    public SingleRoom(int roomNumber) {
        super(roomNumber, 3000.00, "Single");
    }

    @Override
    public String getAmenities() {
        return "1 Bed, TV, Wi-Fi, AC";
    }
}

class DoubleRoom extends Room {
    public DoubleRoom(int roomNumber) {
        super(roomNumber, 5500.00, "Double");
    }

    @Override
    public String getAmenities() {
        return "2 Beds, TV, Wi-Fi, AC, Mini Fridge";
    }
}

class SuiteRoom extends Room {
    public SuiteRoom(int roomNumber) {
        super(roomNumber, 12000.00, "Suite");
    }

    @Override
    public String getAmenities() {
        return "King Bed, 2 TVs, Wi-Fi, AC, Jacuzzi, Balcony, Room Service";
    }
}
