import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ember_h here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ember_h extends Actor
{
    /**
     * Act - do whatever the ember_h wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    ///animatia caracterului de pe main_menu
    public int counter=0,i=1;
    public void act() 
    {
        
        if(i<100)
        {
            ///animatie
            setLocation(getX()-3, getY()-9/10);
            i++;
                counter++;
                GreenfootImage img=new GreenfootImage("player_inv.png");
                int w=img.getWidth(),h=img.getHeight();
                img.scale(w-i*3,h-i*6);
                setImage(img); 
                if(counter==15) 
                {
                    Greenfoot.playSound("footstep02.wav");
                }
                if(counter==30) 
                {
                    Greenfoot.playSound("footstep01.wav");
                    counter=0;
                }
            
        }
        else 
        {
            
            ///sunete
            Greenfoot.delay(50);
            Greenfoot.playSound("doorOpen_2.wav");
            Greenfoot.delay(100);
            Greenfoot.setWorld(new Level_1());
        }
     
    }
   
}
