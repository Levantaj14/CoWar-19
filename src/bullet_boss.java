import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class bullet_boss extends Actor
{
    /**
     * Act - do whatever the bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean touched=false;
    
    public int health=7;
    public void act() 
    {
       setLocation(getX() + speed, getY());  
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
       
       Actor big = getOneIntersectingObject(boss.class);
       if( big!= null) {
            
            if (big !=null){
                getWorld().removeObject(big);
                Greenfoot.playSound("au_boss.wav");
                
            }getWorld().addObject(new vaccine(),1200,360);
            getWorld().removeObject(this);
            touched=true;
            
            
       }
   }

   
   private int speed = 20;///viteza proiectilului
}
