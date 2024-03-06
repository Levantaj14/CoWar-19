import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level_2 extends ScrollingWorld
{Firsty firsty= new Firsty();
    public int score =100;
    public Level_2() {
        super(1280, 720, 1);
        addObject(new Firsty_soapy(), 200, 450);
        show_score();
    }

    public void scoret()
    {//marim scorul si il aratam oe ecran
        if(score<250) score+=10;
        show_score();
    }
    
    public void show_score()
    {
        showText("Scor: "+score,70,100);
    }
    
    public int getScore()
    {
     return score;   
    }
}