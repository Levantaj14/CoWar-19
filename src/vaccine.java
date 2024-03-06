import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class vaccine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class vaccine extends Actor
{
    /**
     * Act - do whatever the vaccine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean touched=false;
    public void act() 
    {
        Actor emb = getOneIntersectingObject(emb_boss.class);
        if(emb!=null)
        {
            ///daca se atinge caracterul cu vaccinul trecem la meniul victoriei
           if(touched==false) Greenfoot.playSound("applause4.wav");
           touched=true;
           Greenfoot.setWorld(new end_screen());
        }
    }    
}
