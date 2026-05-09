// Guest.java
public class Guest {
    private static int idCounter = 1001; // Auto-incrementing guest ID

    private int guestId;
    private String name;
    private String phone;
    private String email;

    public Guest(String name, String phone, String email) {
        this.guestId = idCounter++;
        this.name    = name;
        this.phone   = phone;
        this.email   = email;
    }

    // Getters
    public int    getGuestId() { return guestId; }
    public String getName()    { return name; }
    public String getPhone()   { return phone; }
    public String getEmail()   { return email; }

    @Override
    public String toString() {
        return String.format("Guest #%d | %s | %s | %s", guestId, name, phone, email);
    }
}
