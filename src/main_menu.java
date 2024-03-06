import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class main_menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class main_menu extends Actor
{
    /**
     * Act - do whatever the main_menu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("Meniul principal", 40, null, null));
        ///dupa un click trecem la meniul principal
        if(Greenfoot.mouseClicked(this)) 
        {
            Greenfoot.setWorld(new home());
        }
    } 
    
}
