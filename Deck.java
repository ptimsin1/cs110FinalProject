/**
@author Prakriti Timsina
CS 110
Assingmetn #10: Deck Class for War Game
Program Description: Creates the deck for war game
*/

//import what is needed
import java.util.ArrayList;
import java.util.Collections;

//name class
public class Deck
{
    /**
   ArrayList for deck that declare the number of ranks and suits 
   */
   private ArrayList<Card> deck = new ArrayList<Card>();
   //inialize rank and suit
   private final int RANK = 14;
   private final int SUIT = 4; 
   
    
   /**
   Deck contruction which has a regular 52 deck. Then shffles the deck using the collestion shuffle method
   */

   public Deck()
   {
      for(int i=0 ; i <SUIT; i++)
      {
         for(int m = 2; m < RANK+1; m++)
         {
            Card newCard = new Card(m,i);
            deck.add(newCard);
         }
      }
      
   }
   /**
   method deckSize is deck size
   @return of the ArrayList that is the Deck which will be to see if deck is empty for loss or winnter
   */
      public int deckSize()
   {
      return deck.size();
   }
   
   /**
    ArrayList<Card>getDeck sees if the value in the deck for comparison checks
   @return deck
   */
   public ArrayList<Card>getDeck()
   {
      return deck; 
   }
   
}




//complies
//finished :)