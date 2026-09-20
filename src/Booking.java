public class Booking {

    private int bookingId;
    private Customer customer;
    private Room room;

    public Booking(int bookingId, Customer customer, Room room) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.room = room;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public void displayBooking() {
        System.out.println("\n--- Booking Details ---");
        System.out.println("Booking ID: " + bookingId);
        customer.displayCustomer();
        System.out.println("Room Number: " + room.getRoomNumber());
        System.out.println("Room Category: " + room.getCategory());
        System.out.println("Room Price: ₹" + room.getPrice());
    }
}