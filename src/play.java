import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class play extends Actor
{
    /**
     * Act - do whatever the play wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("Joacă", 40, null, null));
    
        if(Greenfoot.mouseClicked(this)) 
        {
            ///dupa un click pornim jocul
            Greenfoot.setWorld(new enter());
            
        }
    } 
    
}
