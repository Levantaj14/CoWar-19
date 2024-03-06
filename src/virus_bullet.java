import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class virus_bullet extends Actor
{
    /**
     * Act - do whatever the bullet_left wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean touched=false;
    public void act() 
    {
       setLocation(getX() - speed, getY());
       if(!touched)checkBoundaries();
       
    }  
    public void checkBoundaries()
   {
       if(isAtEdge()) 
           {
               //verificam daca e la margine, daca da il scoatem din lume
               getWorld().removeObject(this);
               touched=true;
            }
       
   }
   
   
 
   private int speed = 20;//viteza proiectilului
}
