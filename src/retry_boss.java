import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class retry_3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class retry_boss extends Actor
{
    /**
     * Act - do whatever the retry_3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       setImage(new GreenfootImage("Încearcă din nou", 40, null, null));
    ///reincercam ultimul nivel
        if(Greenfoot.mouseClicked(this)) 
        {
            Greenfoot.setWorld(new Boss_fight());
        }
    }    
}
