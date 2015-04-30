//this is based on what we learned in class during lecture

import java.awt.*;
import javax.swing.*;
import java.awt.Button;
import java.awt.event.*;


public class GUIPractice extends JFrame
{

   private ImageIcon front,back;
   private JButton button;
   private JLabel pic;
   private JPanel p;
   
   private ImageIcon  front2, back2,front3,back3;
  // private JButton button2;
   private JLabel pic2,pic3;

   public GUIPractice (String s)
   {
      super(s);
      p = new JPanel(new GridLayout(4,4));

      setLayout(new FlowLayout());
      // button = new JButton("flip");
//       ButtonListener e = new ButtonListener();
//       
//       button.addActionListener(e);
//       add(button);
      
      
      back = new ImageIcon("back.jpg");
      front = new ImageIcon("aces.jpg");
      pic = new JLabel(front);
      add(pic);
      
      button = new JButton("flip");
      ButtonListener e = new ButtonListener();
      
      button.addActionListener(e);
      add(button);


      //button2 = new JButton("flip2");
      //ButtonListener e = new ButtonListener();
      
      //button.addActionListener(e);//remeber the 2
      //add(button2);
      
      back2 = new ImageIcon("back.jpg");
      front2 = new ImageIcon("acec.jpg");
      
      pic2 = new JLabel(front2);
      add(pic2);
      
      
      back3 = new ImageIcon("back.jpg");
      front3 = new ImageIcon("2c.jpg");
      
      pic3 = new JLabel(front3);
      add(pic3);
      
   
   }
  
   class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
                   
         if(pic.getIcon() == back && pic2.getIcon()==back2)
         {
            pic.setIcon(front);
            pic2.setIcon(front2);
         }
         else
         {
               pic.setIcon(front3);
               pic2.setIcon(front);;
            
               //else
               // {
//                   pic.setIcon(back); 
//                   pic2.setIcon(back2); 
//                }
         }
      }
   }
   
    // class ButtonListener2 implements ActionListener
//    {
//       public void actionPerformed(ActionEvent e2)
//       {
//                    
//          if(pic2.getIcon() == back2)
//             pic2.setIcon(front2);
//          else
//             pic2.setIcon(back2);  
//       }
//    }
// 
   
  
   
      public static void main(String[] args)
      {
         GUIPractice gui = new GUIPractice("War Cards Game");
         gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         gui.setVisible(true);
         gui.pack();

      
      }
   
   
   
   
   }

  



//finished :)