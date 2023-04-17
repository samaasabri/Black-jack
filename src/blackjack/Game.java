/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

import java.util.Random;
public class Game {
    
    static int ValidHighScore;
    Player players[]=new Player[4];
    Card card_deck[]=new Card[52];
 
   
    public void GenerateCardDeck()
    {
         int index=0;
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<13;j++)
            {
                if(j<9)
                {
                    card_deck[index]=new Card(i,j,j+1);
                    index++;
                }
                else
                {
                    card_deck[index]=new Card(i,j,10);
                    index++;
                }
            }
        }
      
    }

    public Card RandomCardGenerator()
    {
        while(true)
        { 
            Random rand = new Random();
         int randomChoice= rand.nextInt(52);
         Card c=card_deck[randomChoice];
         card_deck[randomChoice]=null;
            if(c!=null)
            {
                return c;
            
            }
        }
    }
    
    public void SetPlayerInfo(String []name)
    {
        players[3]=new Player("Dealer");
        for(int i=0;i<3;i++)
        {
            players[i]=new Player(name[i]);
            players[i].AddPlayerCards(RandomCardGenerator());
              players[i].AddPlayerCards(RandomCardGenerator());
        }
         players[3].AddPlayerCards(RandomCardGenerator());
              players[3].AddPlayerCards(RandomCardGenerator());
    }
    
    public int UpadteGameMaxScore()
    {
        int max=0;
        for(int i=0;i<4;i++)
        {
            if(max<=players[i].getScore() && players[i].getScore() <=21)
                max=players[i].getScore();
        }
        return max;
        
    }
    
}
