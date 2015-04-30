/**
@author Prakriti Timsina
CS 110
Last Assignemnt #5:Card class and Card demo
Currect Assingmetn #10: Card Class for War Game
Program Description: This program implements a Card class that represents a single playing card from a standard 52 card deck. 
Each card has a rank and a suit. A Card object is created with a rank and suit and it cannot be modified after creation. 
For this design, two cards are equal if they contain the same rank.
*/

//name class
public class Card 
{  
   //insalize
    private final int rank;
    private final int suit;

    // Kinds of suits
    public final static int DIAMONDS = 0;
    public final static int CLUBS    = 1;
    public final static int HEARTS   = 2;
    public final static int SPADES   = 3;

   //Kinds of ranks 
    public final static int ACE   = 14;
    public final static int TWO   = 2;
    public final static int THREE = 3;
    public final static int FOUR  = 4;
    public final static int FIVE  = 5;
    public final static int SIX   = 6;
    public final static int SEVEN = 7;
    public final static int EIGHT = 8;
    public final static int NINE  = 9;
    public final static int TEN   = 10;
    public final static int JACK  = 11;
    public final static int QUEEN = 12;
    public final static int KING  = 13;
   /**
   Method: Card
   @param rank are numbers 1-13
   @param suit suits are diamond, clubs, spades, hearts
   */
    public Card(int rank, int suit)
     {
        this.rank = rank;
        this.suit = suit;
    }
    
    /**
    method: getSuit
    @return suits;     
    */
    public int getSuit() 
    {
        return this.suit;
    }
    
     /**
    method: getSuit
    @return ranks;     
    */
    public int getRank() 
    {
        return this.rank;
    }
     /**
      @return String rankToString return the ranks;     
    
     */
      public String rankToString() 
    {
        switch (rank) 
        {
        case ACE:
            return "Ace"; 
        case TWO:
            return "Two";
        case THREE:
            return "Three";
        case FOUR:
            return "Four";
        case FIVE:
            return "Five";
        case SIX:
            return "Six";
        case SEVEN:
            return "Seven";
        case EIGHT:
            return "Eight";
        case NINE:
            return "Nine";
        case TEN:
            return "Ten";
        case JACK:
            return "Jack";
        case QUEEN:
            return "Queen";
        case KING:
            return "King";       
        default:
            return "no specified rank"; 

        }    
    }
    
    /**
    toStirng method turns suits into string
    */
    public String suitToString() 
    {
        switch (suit) 
        {
        case 0:
            return "Diamonds";
        case 1:
            return "Clubs";
        case 2:
            return "Hearts";
        case 3:
            return "Spades";
        default:
            return "no specified suit";
        }    
    }
   
   /**
   equals method 
   @param other another card object
   @return compares rank and suit 
   */
   public boolean equals(Object other)
   {   
    	Card otherCard = (Card)other;
    	return this.suit == otherCard.suit && this.rank == otherCard.rank;
   }
    
    /**
    method: toString
    @return rankToSuit and suitToSuit
    */
    public String toString()
    {
    	return rankToString() + " of " + suitToString();  
    }
    
   
}

//complies and works
//finished :)

