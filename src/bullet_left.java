import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class bullet_left extends Actor
{
    /**
     * Act - do whatever the bullet_left wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean touched=false;
    public void act() 
    {
       setLocation(getX() - speed, getY());
       if(isTouching(virus_1.class) ) ((Level_1)getWorld()).scoret();  
       if(!touched)checkBoundaries();
       if(!touched)destroyEnemies();
    }  
    public void checkBoundaries()
   {
       ///verificam daca e la margine, daca da atunci dispare
       if(isAtEdge()) 
           {
               getWorld().removeObject(this);
               touched=true;
            }
       
   }
   //distrugem inamicii
   public void destroyEnemies()
   {
       //"Enemy" orice caracter(clasa) pe care vrei s-o distrugi. 
       Actor enemy = getOneIntersectingObject(virus_1.class);
       if(enemy != null) {
            getWorld().removeObject(enemy);
            getWorld().removeObject(this);
            touched=true;
       }
   }
 
   private int speed = 40;///viteza proiectilului
}
