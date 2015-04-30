/**
@author Prakriti Timsina
CS 110
Assingmetn #10: WarGame Class for War Game
Program Description: Creates the war game
*/
//import what is needed
import java.util.Scanner;
import java.util.ArrayList;
public class WarGame
{
     
   //inialitize the different ArrayList
   private ArrayList<Card>faceDownCard = new ArrayList<Card>();
   private ArrayList<Card>humanWar = new ArrayList<Card>();
   private ArrayList<Card>computerWar = new ArrayList<Card>();
   private ArrayList<Card>humanDeck = new ArrayList<Card>();
   private ArrayList<Card>computerDeck = new ArrayList<Card>(); 
   
   private HumanPlayer human;
   private Player computer; 
   private String answer; 
   private int turns = 0;
   
   /**
   WarGame constructor creates the game and players
   */
   
   public WarGame()
   {
      //let user know we are playing game
      System.out.println("Let's play the game of war!");
      //Create Scanner object
      Scanner keyboard = new Scanner(System.in);
      //Call Deck object
      Deck deck = new Deck();
      boolean win = false; 
      
      //seperate deck of card by 2
      for(int i = 0; i < deck.deckSize()/2; i++)
      {
         humanDeck.add(deck.getDeck().get(i)); 
      }
      
      for(int i = deck.deckSize()/2; i<deck.deckSize(); i++)
      {
         computerDeck.add(deck.getDeck().get(i)); 
      }
      
      //Polymorphism 
      computer = new Player(computerDeck); 
      human = new HumanPlayer(humanDeck);
      
      //ask user to take turn and read next line
      System.out.println("Take turn? (Y OR N): "); 
      answer = keyboard.nextLine(); 
      //Take turn and tell user the number of cards that user has
      while(human.takeTurn(answer) != -1 && computer.takeTurn()!= -1)
      {
         System.out.println("Player card: " + human.getHumanDeck().get(0)); //player card
         System.out.println("Computer card: "+ computer.getPlayerDeck().get(0)); //computer card
         
         if(human.getHumanDeck().get(0).getRank()> computer.getPlayerDeck().get(0).getRank()) 
         {
            //add the computer's card to human deck
            human.countWin(computer.getPlayerDeck().get(0)); 
            //add the human card to the bottom of human deck
            human.countWin(human.getHumanDeck().get(0));
            //remove the top card of the human deck after it was added to the bottom 
            human.takeAwayLoss(); 
            //remove the top fo the computer deck after it was added to the bottom
            computer.takeAwayLoss(); 
            System.out.println("Player 1 wins"); 
         }
         else if(human.getHumanDeck().get(0).getRank() < computer.getPlayerDeck().get(0).getRank())
         {
            //addds to human card to computer deck
            computer.countWin(human.getHumanDeck().get(0)); 
            //adds the computer to computer deck
            computer.countWin(computer.getPlayerDeck().get(0)); 
            //remove the top card to computer deck after adding it to the bottom
            computer.takeAwayLoss(); 
            //remove the top card to human deck after it is added to bottom
            human.takeAwayLoss(); 
            //tells computer wins
            System.out.println("Computer wins"); 
               
         }          
         
         else//if there is a tie of two cards
         {
         
           win = warGames(human, computer);//boolean equals to return of warGames
            if(win)
            {
               while(!humanWar.isEmpty())
               {
                  human.countWin(humanWar.get(0)); 
                  humanWar.remove(0); 
               }
               while(!faceDownCard.isEmpty())
               {
                  human.countWin(faceDownCard.get(0)); 
                  faceDownCard.remove(0); 
               }
               while(!computerWar.isEmpty())
               {
                  human.countWin(computerWar.get(0));
                  computerWar.remove(0); 
               }
            }
            else
            {
               while(!computerWar.isEmpty())
               {
                  computer.countWin(computerWar.get(0));
                  computerWar.remove(0); 
               }
               while(!faceDownCard.isEmpty())
               {
                  computer.countWin(faceDownCard.get(0));
                  faceDownCard.remove(0);
               }
               while(!humanWar.isEmpty())
               {
                  computer.countWin(humanWar.get(0)); 
                  humanWar.remove(0); 
               }
            }
          }
       
            //add up turns 
            turns++;
            //ask user if they want to take turn 
            System.out.println("Take turn? (y or n)");
            answer = keyboard.nextLine(); 
        }
        //tell user how long the war took to end
         System.out.println("The war took: "+ turns + " turns to end");
         //tell user who won
         if(human.getHumanDeck().size()>computer.getPlayerDeck().size())
         {
            System.out.println("Player 1 wins the war"); 
         }
         else if(human.getHumanDeck().size()> computer.getPlayerDeck().size())
         {
            System.out.println("Computer wins the game");
         }
         else
         {
            System.out.println("There is no ties in win");
         }
                    
       
      
     }
      /**
      WarGame method
      @param hum human player
      @param comp cmp player
      @return winner tells who wins
      */
      
      public boolean warGames(HumanPlayer hum, Player comp)
      {
         boolean winner = false;
         if(hum.getHumanDeck().size()> 1 && comp.getPlayerDeck().size()> 1)
         {
         //add or remove from deck
            humanWar.add(human.getHumanDeck().get(0));
            human.takeAwayLoss();
            computerWar.add(comp.getPlayerDeck().get(0));
            computer.takeAwayLoss();
            System.out.println("One face down card");
            
            //add or remove from deck
            faceDownCard.add(hum.getHumanDeck().get(0)); 
            human.takeAwayLoss();
            faceDownCard.add(comp.getPlayerDeck().get(0));
            computer.takeAwayLoss();
            //tells player card and computer card
            System.out.println("Player card: "+ hum.getHumanDeck().get(0));
            System.out.println("Computer card: "+ comp.getPlayerDeck().get(0)); 
            
            //adds or remove from deck 
            humanWar.add(hum.getHumanDeck().get(0));
            human.takeAwayLoss();
            computerWar.add(comp.getPlayerDeck().get(0));
            computer.takeAwayLoss();
            
            //this huge if tels who wins
            if(hum.getHumanDeck().get(0).getRank()== computer.getPlayerDeck().get(0).getRank())
            {
               warGames(human, computer);
            } 
            else if(hum.getHumanDeck().get(0).getRank() > comp.getPlayerDeck().get(0).getRank())
            {
               System.out.println("Player 1 wins");
               winner = true;
            
            }
            else
            {
               System.out.println("Computer wins");
               winner = false; 
            }
         }
         else if(comp.getPlayerDeck().size()==1)
         {
            System.out.println("Computer wins.Game over");
            winner = false;
         }
         else if(comp.getPlayerDeck().size()==1)
         {
            System.out.println("Player 1 wins.Game over");
            winner= true;
         }
         return winner; 
      }
     
   
  
}

   
//}

//complies
//finished :)