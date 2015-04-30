/**
@author Prakriti Timsina
CS 110
Assingmetn #10: GUI class for War Game
Program Description: The GUI for the card game
*/

//import what is needed
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//name class
public class WarGUI extends JFrame
{
	
	//insalize 
   private WarGame war;
	private ImageIcon cardBackImage;
	private ImageIcon[][] cardImages = new ImageIcon[4][15];
	private JLabel playerHand;
   private JLabel playerPile;
   private JLabel computerPile;
   private JLabel computerHand;
   private JLabel statusMessage;
   private JPanel topPanel;
   private JPanel bottomPanel;
   private JButton nextStepButton;
   private JCheckBox userInput;
	private final int RANKS = 15;
	private final int SUITS = 4;
	private String rank;

   /**
   WarGUI constructor with fileNotFoundException 
   */
	public WarGUI() throws FileNotFoundException
	{
      //call WarGame class
		war = new WarGame();
		try
        {   //set the picture
            cardBackImage = new ImageIcon(ImageIO.read(new File("cardpics/back.jpg")));
        }
        catch (IOException ex)
        {
           //say image not found if pic not found 
            throw new FileNotFoundException("Card image: back.jpg not found.");
        }

        for(int i = 0; i < SUITS; i++)
		{
			for(int j = 2; j < RANKS; j++)
			{
				if(i == 0)
					rank = "s";
				else if (i == 1) 
					rank = "h";
				else if (i == 2)
					rank ="d";
				else if (i == 3)
					rank = "c";
				String fileName = "cardpics/"+j+rank+".jpg";
				try
                {
                    cardImages[i][j] = new ImageIcon(ImageIO.read(new File(fileName)));
                }
                catch (IOException ex)
                {
                    throw new FileNotFoundException("Card image: "+j+rank+".jpg not found.");
                }
				
			}
		}
        //set up the game
        playerHand = new JLabel(cardBackImage);
        computerHand = new JLabel(cardBackImage);
        playerPile = new JLabel();
        computerPile = new JLabel();

        setLayout(new GridLayout(2,1));
        topPanel = new JPanel(new GridLayout(1,4));
        topPanel.add(playerHand);
        topPanel.add(playerPile);
        topPanel.add(computerPile);
        topPanel.add(computerHand);
        bottomPanel = new JPanel(new GridLayout(2,1));
        statusMessage = new JLabel("Welcome to the war game!");
        nextStepButton = new JButton("Beginning the game");
        userInput = new JCheckBox("Would you like to play?");
        nextStepButton.addActionListener(new ButtonListener());

        bottomPanel.add(userInput);
        bottomPanel.add(statusMessage);
        bottomPanel.add(nextStepButton);

        this.add(topPanel);
        this.add(bottomPanel);
	}

	
   /**
   changeCardImage shows the card image depending on rank
   */
    private void changeCardImages()
    {
    	if(war.getHumanPlayer().getHumanDeck().size() != 0)
    			playerHand.setIcon(cardBackImage);
    		else
    			playerHand.setIcon(null);
    		playerHand.revalidate();
    		if(!war.getHumanPlayer().getHumanDeck().isEmpty())
    			playerPile.setIcon(cardImages[war.getHumanPlayer().getHumanDeck().get(0).getSuit()][war.getHumanPlayer().getHumanDeck().get(0).getRank()]);
    		else
    			playerPile.setIcon(null);
    		playerPile.revalidate();

    		if(war.getAIPlayer().getPlayerDeck().size() != 0)
    			computerHand.setIcon(cardBackImage);
    		else
    			computerHand.setIcon(null);
    		computerHand.revalidate();
    		if(!war.getAIPlayer().getPlayerDeck().isEmpty())
    			computerPile.setIcon(cardImages[war.getAIPlayer().getPlayerDeck().get(0).getSuit()][war.getAIPlayer().getPlayerDeck().get(0).getRank()]);
    		else
    			computerPile.setIcon(null);
    		computerPile.revalidate();
    }	

   /**
   changeStatusMessage shows which card it is for player and computer 
   */
    private void changeStatusMessage()
    {
    	String newMessage = "<html>"+war.getStatusMessage()+ "<br>Your hand size: " + war.getHumanPlayer().getHumanDeck().size()+ "<br>Computer's hand size: " + war.getAIPlayer().getPlayerDeck().size()+ "</html>";
    	try
    	{
    		statusMessage.setText(newMessage);
    
    	}
    	catch (NullPointerException ex)
    	{
    		return;
    	}
    }

   /**
   ButtonListener is to make the button work
   */
    private class ButtonListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent a)
    	{

    		nextStepButton.setText("Continue Game");
    		if(userInput.isSelected())
    		{
    			war.setResponse(true);
    			
    			
    			
    		}
    		else
    			war.setResponse(false);
    		updateCardImages(); 
    		updateStatusMessage();
    		war.step();
         	war.setResponse(false);
    		updateCardImages();
    		if (war.getGameState() != 0)
            {
            	// Figure out who won
	            if (war.getGameState() > 0)
	            {
	            	javax.swing.JOptionPane.showMessageDialog(null, "The computer won.");
	            }
	            else
	            {
	            	javax.swing.JOptionPane.showMessageDialog(null, "You win!");
	            }
	            // tells who wins
	            updateStatusMessage(); 
               //disable the button
	            nextStepButton.setEnabled(false); 
            }
    		
    		
    		
    	}
    }
    //main method
    public static void main(String[] args)
    {
        WarGUI wgui;
        try
        {
            wgui = new WarGUI();
        }
        catch (FileNotFoundException ex)
        {
            javax.swing.JOptionPane.showMessageDialog(null,ex.toString());
            return;
        }
        //make the gui work
        wgui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wgui.setSize(900,700);
        wgui.validate();
        wgui.setVisible(true);
    }
}

//complier
//finished :)