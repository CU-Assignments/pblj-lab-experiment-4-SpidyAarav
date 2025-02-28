Experiment 4.3: Ticket Booking System

This program simulates a ticket booking system where multiple users (threads) try to book seats at the same time. The key challenges addressed are:

1) Avoiding Double Booking → Using synchronized methods to ensure no two users book the same seat.
2) Prioritizing VIP Customers → Using thread priorities so VIP users' bookings are processed before regular users.

📌 Core Concepts Used
️1 Synchronized Booking Method
The method bookSeat() is marked as synchronized, ensuring that only one thread can access it at a time.
This prevents race conditions, where two threads might try to book the same seat simultaneously.
  
️2 Thread Priorities for VIP Customers
Threads representing VIP users are assigned Thread.MAX_PRIORITY so they execute first.
Regular users have Thread.NORM_PRIORITY or Thread.MIN_PRIORITY, making them process later.

3 Handling Multiple Users
Each user trying to book a seat is represented by a thread.
Users can select a seat, and if it’s already booked, they receive an error message.


Step-by-Step Execution
1 Initialize the TicketBookingSystem → Allows booking of N seats.
2 Create Multiple Booking Threads → Each user (VIP or Regular) is assigned a thread.

  CODE:

3 Start All Threads → Threads compete for booking, with VIPs processed first.
4 Ensure No Double Booking → synchronized method prevents duplicate seat allocation.
5 Threads Finish Execution & Display Booking Status.


🔹 Why Use Synchronization?
Without synchronized, two threads might book the same seat simultaneously, causing double booking issues. Using synchronized, only one thread at a time can modify the seat booking data.

🔹 Why Use Thread Priorities?
Setting higher priority for VIP users ensures their bookings are processed first, simulating real-world priority-based bookings.

Test Cases

Test Case 1: No Seats Available Initially
Input:
System starts with 5 seats.
No users attempt to book.
Expected Output:
No bookings yet.

Test Case 2: Successful Booking
Input:
Anish (VIP) books Seat 1.
Bobby (Regular) books Seat 2.
Charlie (VIP) books Seat 3.
Expected Output:
Anish (VIP) booked seat 1
Bobby (Regular) booked seat 2
Charlie (VIP) booked seat 3

Test Case 3: Thread Priorities (VIP First)
Input:
Bobby (Regular) books Seat 4 (low priority).
Anish (VIP) books Seat 4 (high priority).
Expected Output:
Anish (VIP) booked seat 4
Bobby (Regular): Seat 4 is already booked!

Test Case 4: Preventing Double Booking
Input:
Anish (VIP) books Seat 1.
Bobby (Regular) tries to book Seat 1 again.
Expected Output:
Anish (VIP) booked seat 1
Bobby (Regular): Seat 1 is already booked!

Test Case 5: Booking After All Seats Are Taken
Input:
All 5 seats are booked.
A new user (Regular) tries to book Seat 3.
Expected Output:
Error: Seat 3 is already booked!

Test Case 6: Invalid Seat Selection
Input:
User tries to book Seat 0 (out of range).
User tries to book Seat 6 (beyond available seats).
Expected Output:
Invalid seat number!

Test Case 7: Simultaneous Bookings (Concurrency Test)
Input:

  CODE:
import java.util.Scanner;
 import java.util.concurrent.locks.Lock;
 import java.util.concurrent.locks.ReentrantLock;
 class TicketBooking extends Thread {

 private static final Lock lock = new ReentrantLock();
 private static boolean[] seats = new boolean[5]; // 5 seats for simplicity
 private int seatNumber;
 private String customerName;
 public TicketBooking(String customerName, int seatNumber, int priority)
 { this.customerName = customerName;
 this.seatNumber = seatNumber;
 this.setPriority(priority);
 }
 @Override
 public void run()
 { lock.lock();
 try {
 if (!seats[seatNumber])
 { seats[seatNumber] =true;
 System.out.println(customerName + " successfully booked seat " + seatNumber);
 } else {
 System.out.println(customerName + " failed to book seat " + seatNumber + " (Already
 booked)");
 }
 } finally
 { lock.unlock();
 }
 }
 }
 public class TicketBookingSystem
 { public static void main(String[] args)
 {

 Scanner scanner = new Scanner(System.in);
 TicketBooking[] bookings = new TicketBooking[5];
 System.out.println("Welcome to the Ticket Booking System (Seats: 0-4)");
 for (int i = 0; i < 5; i++) {
 System.out.print("\nEnter Customer Name: ");
 String name = scanner.next();
 System.out.print("Enter Seat Number (0-4): ");
 int seatNumber = scanner.nextInt();
 if (seatNumber < 0 || seatNumber >= 5)
 { System.out.println("Invalid seat number! Try
 again."); i--;
 continue;
 }
 System.out.print("Enter Priority (1 for VIP, 2 for Regular): ");
 int priority = scanner.nextInt();
 int threadPriority = (priority == 1) ? Thread.MAX_PRIORITY :
 Thread.MIN_PRIORITY;
 bookings[i] = new TicketBooking(name, seatNumber, threadPriority);
 }
 System.out.println("\nProcessing Bookings...\n");
 for (TicketBooking booking : bookings) {
 if (booking != null)
 { booking.start();
 }
 }
 scanner.close();
 }
 }
10 users try booking at the same time for 5 seats.
Expected Output:
5 users successfully book seats.
5 users receive error messages for already booked seats.
