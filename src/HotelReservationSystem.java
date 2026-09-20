import java.util.ArrayList;

public class HotelReservationSystem {

    private ArrayList<Room> rooms;
    private ArrayList<Booking> bookings;
    private int nextBookingId;

    public HotelReservationSystem() {

        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
        nextBookingId = 1001;

        // Standard Rooms
        rooms.add(new Room(101, "Standard", 1500));
        rooms.add(new Room(102, "Standard", 1500));

        // Deluxe Rooms
        rooms.add(new Room(201, "Deluxe", 2500));
        rooms.add(new Room(202, "Deluxe", 2500));

        // Suite Rooms
        rooms.add(new Room(301, "Suite", 4000));
        rooms.add(new Room(302, "Suite", 4000));
    }

    // Display all rooms
    public void displayAllRooms() {

        System.out.println("\n===== ALL ROOMS =====");

        for (Room room : rooms) {
            room.displayRoom();
        }
    }

    // Search available rooms by category
    public void searchRooms(String category) {

        System.out.println("\n===== SEARCH RESULTS =====");

        boolean found = false;

        for (Room room : rooms) {

            if (room.getCategory().equalsIgnoreCase(category)
                    && room.isAvailable()) {

                room.displayRoom();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No available rooms found in this category.");
        }
    }

    // Book a room
    public void bookRoom(String customerName, String phone, int roomNumber) {

        for (Room room : rooms) {

            if (room.getRoomNumber() == roomNumber) {

                if (!room.isAvailable()) {
                    System.out.println("Sorry, this room is already booked.");
                    return;
                }

                Customer customer = new Customer(customerName, phone);

                Booking booking =
                        new Booking(nextBookingId, customer, room);

                bookings.add(booking);

                room.setAvailable(false);

                System.out.println("\nRoom booked successfully!");
                System.out.println("Your Booking ID: " + nextBookingId);

                nextBookingId++;

                return;
            }
        }

        System.out.println("Room not found.");
    }

    // Display all bookings
    public void displayBookings() {

        System.out.println("\n===== ALL BOOKINGS =====");

        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }

        for (Booking booking : bookings) {
            booking.displayBooking();
        }
    }

    // Cancel booking
    public void cancelBooking(int bookingId) {

        for (Booking booking : bookings) {

            if (booking.getBookingId() == bookingId) {

                booking.getRoom().setAvailable(true);

                bookings.remove(booking);

                System.out.println("Booking cancelled successfully.");

                return;
            }
        }

        System.out.println("Booking ID not found.");
    }
}