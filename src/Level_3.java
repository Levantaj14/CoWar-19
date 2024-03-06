import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level_3 extends ScrollingWorld
{
    public int score =250;
    public Level_3() {
        super(1280, 720, 1);
        addObject(new Firsty_glo(), 200, 450);
        show_score();
    }

    public void scoret()
    {//marim scorul si il aratam oe ecran
       if(score<500) score+=10;
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
