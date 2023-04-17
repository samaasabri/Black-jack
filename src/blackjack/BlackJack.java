/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blackjack;


import java.util.Scanner;
public class BlackJack {

       static Game game ;
    public static void main(String[] args) {
        int max=0;
        boolean winner=false;
        boolean blackjack=false;
        boolean push=false;
        boolean pushBlackjack=false;
         game  = new Game(); 
        GUI gui=new GUI();
        game.GenerateCardDeck();
         
     
      String []names=new String[3];
         System.out.println("Enter the 3 names of the 3 players :");
       
       for(int i=0;i<3;i++)
     
       {
         
              Scanner in=new Scanner(System.in);
           names[i]=in.next();
    
       }
       
       
       
game.SetPlayerInfo(names);
gui.runGUI(game.card_deck, game.players[0].getCards_of_player(),game.players[1].getCards_of_player(), game.players[2].getCards_of_player(), game.players[3].getCards_of_player());

  
              for(int i=0;i<4;i++)
        {
            Scanner in=new Scanner(System.in);
            char choice;
           
             if(i!=3)
             {
                 
               
          do{
                System.out.println("Hit or Stand");
                choice=in.next().charAt(0);
               if(choice=='S'||choice=='s')
                    {
                        
                       break;
                    }
                else if (choice=='H'||choice=='h')
                  {
                  Card c=game.RandomCardGenerator();
                  game.players[i].AddPlayerCards(c);
                  gui.updatePlayerHand(c, i);
                   }
                  else
                  {
                      System.out.println("Invalid input");
                  }
               if(game.players[i].getScore()>=21)
               {
                   //status[i]="Busted";
                   //System.out.println("Busted");
                   break;
               }

       }while(!(choice=='s'||choice=='S'));
            
             }
             else
             {
                 while(true)
                 {
                     
                     Card c=game.RandomCardGenerator();
                  game.players[i].AddPlayerCards(c);
                  gui.updateDealerHand(c,game.card_deck);
                  if(game.players[i].getScore()>=game.UpadteGameMaxScore() ||game.players[i].getScore()==21)
                  {
                      break;
                  }
                  if(game.players[i].getScore()>21)
               {
                //    status[i]="Busted";
                  // System.out.println("Busted");
                   break;
               }
                 }
             }
            
   
     
    }
              int n=game.UpadteGameMaxScore();
              int noPlayer=-1;
    

    for(int i=0;i<4;i++)
    {
        if(game.players[i].getScore()==n &&n!=21)
        {
            winner=true;
            noPlayer=i;
        }
        if(game.players[i].getScore()==n &&n==21)
        {
            blackjack=true;
             noPlayer=i;
       
        }
    }
    

      
        for(int i=0;i<4;i++)
        {
         for(int j=0;j<4;j++)
         {
          if(game.players[i].getScore()==game.players[j].getScore() && i!=j &&game.UpadteGameMaxScore()<21)
            {
                if(game.players[i].getScore()==21)
                    pushBlackjack=true;
              push=true;
              break;
            }
         }
        }
        
        
        
        
         if(push && winner || push &&blackjack&&pushBlackjack)
         {
             System.out.println("It is a PUSH");
             
         } 
       if(winner&& (!push))
      {
          System.out.println("The winner is : "+game.players[noPlayer].getName());
      }
      
      
      if(blackjack&&(!pushBlackjack))
          System.out.println("Black jack for the player: "+game.players[noPlayer].getName());
     
    }
    
    
}
