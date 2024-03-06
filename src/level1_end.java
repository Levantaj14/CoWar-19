import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class level1_end here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class level1_end extends Actor
{
    /**
     * Act - do whatever the level1_end wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        ///dupa un click trecem la nivelul urmator
        if(Greenfoot.mouseClicked(this)) 
        {
            
            Greenfoot.setWorld(new Level_2());
            
        }
    }    
}
