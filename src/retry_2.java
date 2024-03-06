import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class retry_2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class retry_2 extends Actor
{
    /**
     * Act - do whatever the retry_2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("Încearcă din nou", 40, null, null));
    ///reincercam nivelul 2
        if(Greenfoot.mouseClicked(this)) 
        {
            Greenfoot.setWorld(new Level_2());
        }
    }    
}
