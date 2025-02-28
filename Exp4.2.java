Experiment 4.2: Card Collection System

Objective:
Develop a Java program that collects and stores playing cards to help users find all the cards of a given symbol (suit).
The program should utilize the Collection interface (such as ArrayList, HashSet, or HashMap) to manage the card data efficiently.

Understanding the Problem Statement

1. Card Structure:
Each card consists of a symbol (suit) and a value (rank).

Example card representations:
Ace of Spades
King of Hearts
10 of Diamonds
5 of Clubs

2. Operations Required:
Add Cards → Store card details in a collection.
Find Cards by Symbol (Suit) → Retrieve all cards belonging to a specific suit (e.g., all "Hearts").
Display All Cards → Show all stored cards.

3. Collections Usage:
ArrayList: To store cards in an ordered manner.
HashSet: To prevent duplicate cards.
HashMap<String, List<Card>>: To organize cards based on suits for faster lookup.


Test Cases

Test Case 1: No Cards Initially
Input:
Display All Cards
Expected Output:
No cards found.

Test Case 2: Adding Cards
Input:
Add Card: Ace of Spades
Add Card: King of Hearts
Add Card: 10 of Diamonds
Add Card: 5 of Clubs
Expected Output:
Card added: Ace of Spades
Card added: King of Hearts
Card added: 10 of Diamonds
Card added: 5 of Clubs

Test Case 3: Finding Cards by Suit
Input:
Find All Cards of Suit: Hearts
Expected Output:
King of Hearts

Test Case 4: Searching Suit with No Cards
Input:
Find All Cards of Suit: Diamonds
(If no Diamonds were added)
Expected Output:
No cards found for Diamonds.

Test Case 5: Displaying All Cards
Input:
Display All Cards
Expected Output:
Ace of Spades
King of Hearts
10 of Diamonds
5 of Clubs

Test Case 6: Preventing Duplicate Cards
Input:
Add Card: King of Hearts
Expected Output:
Error: Card "King of Hearts" already exists.

Test Case 7: Removing a Card
Input:
Remove Card: 10 of Diamonds
Expected Output:
Card removed: 10 of Diamonds

  CODE:
import java.util.ArrayList;
 import java.util.List;
 import java.util.Scanner;
 class Card
 { String
 symbol; String
 value;
 public Card(String symbol, String value)
 { this.symbol = symbol;
 this.value = value;
 }
 @Override
 public String toString() {
 return value + " of " + symbol;
 }
 }
 public class CardCollection {
 private static List<Card> deck = new ArrayList<>();
 private static Scanner scanner = new Scanner(System.in);

 public static void main(String[] args)
 { while (true) {
 System.out.println("\n1. Add Card 2. Find Cards 3. Exit");
 System.out.print("Enter your choice: ");
 int choice = scanner.nextInt();
 scanner.nextLine(); // Consume newline
 switch (choice)
 { case 1:
 addCard();
 break;
 case 2:
 findCards();
 break;
 case 3:
 System.out.println("Exiting...");
 return;
 default:
 System.out.println("Invalid choice! Please enter 1, 2, or 3.");
 }
 }
 }
 public static void addCard() {
 System.out.print("Enter Symbol (Hearts, Diamonds, etc.): ");
 String symbol = scanner.nextLine().trim();
 System.out.print("Enter Value (2, 3, King, etc.): ");
 String value = scanner.nextLine().trim();
 deck.add(new Card(symbol,value));
 System.out.println("Card Added!");
 }
 public static void findCards()
 { System.out.print("Enter Symbol to find: ");
 String symbolToFind = scanner.nextLine().trim();
 boolean found = false;
 System.out.println("\nCards with symbol " + symbolToFind + ":");
 for (Card card : deck) {
 if (card.symbol.equalsIgnoreCase(symbolToFind)) { // Case-insensitive comparison
 System.out.println(card);
 found = true;
 }
 }
 if (!found) {
 System.out.println("No cards found for this symbol!");
 }
 }
 }
