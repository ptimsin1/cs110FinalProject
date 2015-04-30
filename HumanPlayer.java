/**
@authorPrakriti Timsina
CS 110
Assingmetn #10: HumanPlayer Class for War Game
Program Description: Creates the HumanPlayer for war game
*/

//import what is needd
import java.util.ArrayList;
import java.util.Collection; 

//name class that extend Player
public class HumanPlayer extends Player
{
   //inaslizes
   private ArrayList<Card> human = new ArrayList<Card>();
   
   /**
   HumanPlayer constructor calls HumanPlayer with half of the deck
   @param half passes it to ArrayList
   */
   public HumanPlayer(ArrayList<Card> half)
   {
      super(half);
      human = super.getPlayerDeck();
   }   
   
   
   /**
   takeTurn method sees if user want to contunie 
   @param answer is user's answer
   @return card if they want to contunie
   */
   public int takeTurn(String answer)
   {
      int card = -1;
      if(answer.equalsIgnoreCase("y"))
      {
         if(human.isEmpty())
         {
            card = -1;
         }
         card = human.get(0).getRank();
      }
      
       
       else if(answer.equalsIgnoreCase("n"))
       {
          card = -1;
       }
       return card;
      
      
      
   }
   
   
   /** 
   @return human 
   */
   public ArrayList<Card> getHumanDeck()
   {
      return human;
   }
   
   
   /** 
   method countWin
   
   */   
   public void countWin(Card c)
   {
      human.add(c);
   }
   
   /**
   takeAwayLoss method
   */
   public void takeAwayLoss()
   {
      human.remove(0);
   }
}

//complies
//finished :)