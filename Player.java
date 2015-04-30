/**
@author Prakriti Timsina
CS 110
Assingmetn #10: Payer Class for War Game
Program Description: Creates the player for war game
*/

//import what is needed
import java.util.ArrayList;
import java.util.Collections;

//name class
public class Player
{
   /**
   Create ArrayList 
   */
   private ArrayList<Card> playerOne = new ArrayList<Card>();
   
   
   /**
   Player constructor which shuffles the deck again 
   @param half passes constructor an ArrayList
   */
   public Player(ArrayList<Card> half)
   {
      for(int i=0; i<half.size(); i++)
      {
         playerOne.add(half.get(i));
      }
      Collections.shuffle(playerOne);
   }
   
   
   /**
   @return player one
   */
   public ArrayList<Card> getPlayerDeck()
   {
      return playerOne;
   }
   
   
   /**
   takeTurn method
   @return the card to see if the game contunies 
   */
   public int takeTurn()
   {
      if(playerOne.isEmpty())
      {
         int card = -1;
      }
      int card = playerOne.get(0).getRank();
      return card;
   }  
   
   
   /**
   method countwin adds the card to the player deck
   @param c card
   
   */
   public void countWin(Card c)
   {
      playerOne.add(c); 
   }  
   
   
   /**
   takeAwayLoss method removes the top card from player deck
   */
   public void takeAwayLoss()
   {
      playerOne.remove(0); 
   }
}
//complies
//finsihed :)