import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ajutor extends Actor
{
    /**
     * Act - do whatever the play wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("Ajutor", 40, null, null));
        ///la primul click ajungem la sectiunea ajutor
        if(Greenfoot.mouseClicked(this)) 
        {
            Greenfoot.setWorld(new help());
        }
    } 
    
}
