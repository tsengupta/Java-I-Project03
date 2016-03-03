import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat; 

/**
 * The purpose of this program is to accept coded
 * ticket information as input that includes the
 * ticket information including the actual cost, which
 * is the price with discount applied, including a 
 * random raffle number.
 * Project 03.
 * 
 * @author Trisha Sengupta - section 001
 * @version 9/16/2015
 */
 
public class TicketInfo {
   static final int MIN_LENGTH = 27;
   static final double STUDENT_DISCOUNT = .80;
   static final double FACULTY_STAFF_DISCOUNT = .20;
  /**
    * Uses user's ticket number and displays ticket
    * information.
    *
    * @param args Command line arguments (not used).
   */
   public static void main(String[] args) {
   
      
      Scanner userInput = new Scanner(System.in);
      String ticketCode = "";
      String type = "";
      int section = 0;
      int row = 0;
      int seat = 0;
      double price = 0.0;
      
      // Asks user for ticket code:
      System.out.print("Enter your ticket code: ");
      ticketCode = userInput.nextLine();
      
      ticketCode.trim();
      
      // Determines whether ticket is valid length:
      if (ticketCode.length() < MIN_LENGTH) {
         System.out.println("Invalid Ticket Code.\nTicket code" 
            + " must have at least 27 characters.");
      }
      else {
         System.out.print("\nEvent: " 
            + ticketCode.substring(26, ticketCode.length()));
         System.out.print("\tDate: " + ticketCode.substring(14, 16) + "/" 
            + ticketCode.substring(16, 18) + "/" 
            + ticketCode.substring(18, 22));
         System.out.print("   Time: " + ticketCode.substring(22, 24)
            + ":" + ticketCode.substring(24, 26));
         
         // Decimal format for section, row, and seat:
         DecimalFormat dFmt = new DecimalFormat("#0");
         
         // Pulls section out of inputed string and prints:
         section = Integer.parseInt(ticketCode.substring(3, 5));
         System.out.print("\nSection: " + dFmt.format(section));
         
         // Pulls row out of inputed string and prints:
         row = Integer.parseInt(ticketCode.substring(5, 7));
         System.out.print("   Row: " + dFmt.format(row));
         
         // Pulls seat out of inputed string and prints:
         seat = Integer.parseInt(ticketCode.substring(7, 9));
         System.out.print("\tSeat: " + dFmt.format(seat));
         
         // Decimal format for price: 
         DecimalFormat dFmt2 = new DecimalFormat("$000.00");
         
         // Pulls price out of inputed string and prints:
         price = Double.parseDouble(ticketCode.substring(9, 14));
         System.out.print("\nPrice: " + dFmt2.format(price));
         
         // Pulls ticket code type of inputed string and prints:
         type = ticketCode.substring(0, 3);
         System.out.print("\t Ticket Type: " + type);
         
         // Determines type of ticket for discount:
         if (type.equals("F/S")) {
            System.out.print("    Cost: " + dFmt2.format(price 
               - price * FACULTY_STAFF_DISCOUNT));
         }
         else if (type.equals("STU")) {
         
            System.out.print("\tCost: " + dFmt2.format(price 
               - price * STUDENT_DISCOUNT));
         }
         
         else {
            System.out.print("\tCost: " + dFmt2.format(price));
         }
         
         // Generates random number between 1 to 99999:
         Random randNum = new Random();
         int randInt = randNum.nextInt(100000);
         DecimalFormat dFmt3 = new DecimalFormat("00000");
         
         // Prints random raffle ticket number:
         System.out.print("\nRaffle Number: " + dFmt3.format(randInt));
         
         
      }
   }
}