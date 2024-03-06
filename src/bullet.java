import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class bullet extends Actor
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
       Actor big = getOneIntersectingObject(boss.class);
       if(enemy != null || big!= null) {
            getWorld().removeObject(enemy);
            if (big !=null){
                getWorld().removeObject(big);
                Greenfoot.playSound("au_boss.wav");
            }
            getWorld().removeObject(this);
            touched=true;
       }
   }
   
 
   
   private int speed = 40;///viteza proiectilului
}
