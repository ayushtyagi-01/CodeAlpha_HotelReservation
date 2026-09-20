import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HotelReservationSystem hotel =
                new HotelReservationSystem();

        int choice;

        do {

            System.out.println("\n==============================");
            System.out.println("   HOTEL RESERVATION SYSTEM");
            System.out.println("==============================");

            System.out.println("1. View All Rooms");
            System.out.println("2. Search Rooms");
            System.out.println("3. Book Room");
            System.out.println("4. View Bookings");
            System.out.println("5. Cancel Booking");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    hotel.displayAllRooms();

                    break;

                case 2:

                    System.out.print(
                            "Enter category (Standard/Deluxe/Suite): "
                    );

                    String category = scanner.nextLine();

                    hotel.searchRooms(category);

                    break;

                case 3:

                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();

                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();

                    hotel.bookRoom(
                            name,
                            phone,
                            roomNumber
                    );

                    break;

                case 4:

                    hotel.displayBookings();

                    break;

                case 5:

                    System.out.print("Enter Booking ID: ");

                    int bookingId = scanner.nextInt();

                    hotel.cancelBooking(bookingId);

                    break;

                case 6:

                    System.out.println(
                            "Thank you for using Hotel Reservation System!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }

        } while (choice != 6);

        scanner.close();
    }
}